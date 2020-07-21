package com.ggs.generator;

import org.apache.ibatis.io.Resources;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *  @author: Starbug
 *  @date: 2020-06-26 17:02
 *
 *  如果工程不是maven工程, 需要转换成maven工程
 *  使用步骤(main方法执行):
 *  1.修改generator-config.properties,指定数据库相关信息
 *  2.修改generatorConfig.xml,指定需要反转的表的名字(指定domain名(可选)),例如:<table tableName="t_user" domainObjectName="User"/>
 *  3.运行main方法,获取
 */
public class MybatisGenerator {
    public static void main(String[] args) {
        try {
            generate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void generate() throws Exception {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(Resources.getResourceAsStream("generatorConfig.xml"));
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
        for (String warning : warnings) {
            System.out.println(warning);
        }
    }
}
