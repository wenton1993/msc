package com.wt.myspringcloud.data.config;

import com.wt.myspringcloud.data.pojo.entity.Person;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 *
 * @author 文通
 * @since 2020/8/9
 */
@Configuration
public class PersonValidatorConfig implements RepositoryRestConfigurer {

    @Override
    public void configureValidatingRepositoryEventListener(ValidatingRepositoryEventListener validatingListener) {
        validatingListener.addValidator("beforeCreate", new BeforeCreatePersonValidator());
    }

    // 自动注册不生效
    /*@Bean
    public BeforeCreatePersonValidator beforeCreatePersonValidator() {
        return new BeforeCreatePersonValidator();
    }*/

    /**
     * 验证器 - 在保存之前验证
     */
    public static class BeforeCreatePersonValidator implements Validator {

        @Override
        public boolean supports(Class<?> clazz) {
            return Person.class.equals(clazz);
        }

        @Override
        public void validate(Object target, Errors errors) {
            Person t = (Person) target;
            if (StringUtils.isBlank(t.getLastName())) {
                errors.rejectValue("lastName", "参数校验不通过");
            }
        }
    }
}