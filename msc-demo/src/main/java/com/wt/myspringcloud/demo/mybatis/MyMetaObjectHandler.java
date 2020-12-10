package com.wt.myspringcloud.demo.mybatis;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 自动填充策略
 *
 * @author 文通
 * @since 2020/9/8
 */
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "createDatetime", LocalDateTime::now, LocalDateTime.class);
        this.strictUpdateFill(metaObject, "createDate", LocalDate::now, LocalDate.class);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "updateDatetime", LocalDateTime::now, LocalDateTime.class);
        this.strictUpdateFill(metaObject, "updateDate", LocalDate::now, LocalDate.class);
    }

}