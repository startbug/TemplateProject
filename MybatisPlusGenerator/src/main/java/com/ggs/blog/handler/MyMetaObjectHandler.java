package com.ggs.blog.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author Starbug
 * @Date 2020/7/25 15:58
 *
 * 自动填充插件
 * 新添数据时,自动添加新增时间和更新时间
 * 修改数据时,自动修改更新时间
 */
@Component
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("插入数据,添加新增时间....");
        log.info("插入数据,添加更新时间....");
        this.setFieldValByName("createTime",new Date(),metaObject);
        this.setFieldValByName("updateTime",new Date(),metaObject);

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("插入数据,修改更新时间....");
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }
}
