package com.ggs.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @Author Starbug
 * @Date 2020/7/25 14:18
 */
public class CodeGenerator {
    @Test
    public void test1(){
        //生成代码生成器对象
        AutoGenerator mpg = new AutoGenerator();

        //设置模板引擎
        mpg.setTemplateEngine(new VelocityTemplateEngine());

        //全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        System.out.println("projectPath:"+projectPath);
        gc.setOutputDir(projectPath+"/src/main/java");
        gc.setAuthor("Starbug");
        gc.setOpen(false);//是否打开资源管理器, false
        gc.setSwagger2(true);//实体类属性添加Swagger2注解
        gc.setFileOverride(false);//是否覆盖
        gc.setServiceName("%sService"); //去除Service的I前缀
        gc.setIdType(IdType.ASSIGN_ID);//id生成策略,使用雪花算法自动生成全局唯一ID
        gc.setDateType(DateType.ONLY_DATE); //设置日期类型, 仅仅是日期类型
        gc.setSwagger2(true);
        mpg.setGlobalConfig(gc);

        //2.设置数据源
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/mybatis_plus?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&serverTimezone=GMT%2B8");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);

        //3.包的配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName("blog");
        pc.setParent("com.ggs");
        pc.setEntity("entity");
        pc.setService("service");
        pc.setController("controller");
        pc.setMapper("mapper");
        mpg.setPackageInfo(pc);

        //4.策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setInclude("user"); //指定要映射的表名
        strategy.setNaming(NamingStrategy.underline_to_camel); //包命名规则驼峰命名
        strategy.setColumnNaming(NamingStrategy.underline_to_camel); //列名字驼峰命名
        strategy.setEntityLombokModel(true);    //自动lombok
        strategy.setLogicDeleteFieldName("deleted");    // 设置逻辑删除的字段
        //自动填充配置
        TableFill createTime = new TableFill("create_time", FieldFill.INSERT);
        TableFill updateTime = new TableFill("update_time", FieldFill.INSERT_UPDATE);
        strategy.setTableFillList(Arrays.asList(createTime,updateTime));

        strategy.setVersionFieldName("version");//乐观锁配置
        strategy.setRestControllerStyle(true); // 设置restful风格的controller
        strategy.setControllerMappingHyphenStyle(true); // localhost:8080/hello_2_1 设置这种格式的映射
        mpg.setStrategy(strategy);

        //执行
        mpg.execute();

    }

}
