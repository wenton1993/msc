package annotation;

import java.lang.annotation.*;

/**
 * @author 文通
 * @since 2019/5/19
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitProvider {

    // 供应商编号
    int id() default -1;

    // 供应商名称
    String name() default "";

    // 供应商地址
    String address() default "";
}
