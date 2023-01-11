package com.mind_map.interceptor;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class DateInterceptor implements MetaObjectHandler {
    /**
     * 使用mp做添加操作时候，这个方法执行
     *
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill....");
        //设置属性值
        this.setFieldValByName("createTime", new Date(), metaObject);
        this.setFieldValByName("updateTime", new Date(), metaObject);
        //添加逻辑删除的默认值0
        this.setFieldValByName("deleted",0,metaObject);
    }

    /**
     * 使用mp做修改操作时候，这个方法执行
     *
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill....");
        this.setFieldValByName("updateTime", new Date(), metaObject);
    }

}
