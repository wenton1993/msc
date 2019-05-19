package com.wt.myspringcloud.common.annotation;

import java.lang.annotation.Documented;

/**
 * @author 文通
 * @since 2019/5/19
 */
@Documented
public @interface ClassPreamble {

    String author();
    String date();
    int currentRevision() default 1;
    String lastModified() default "N/A";
    String lastModifiedBy() default "N/A";
    String[] reviewers();

}
