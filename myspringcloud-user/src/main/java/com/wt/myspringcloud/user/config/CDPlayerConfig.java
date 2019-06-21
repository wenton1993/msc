package com.wt.myspringcloud.user.config;

import com.wt.myspringcloud.user.pojo.test.MagicBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author 文通
 * @since 2019/6/20
 */
@Profile("dev")
@Configuration
public class CDPlayerConfig {

    @Conditional(MagicExsitCondition.class)
    @Bean
    public MagicBean magicBean() {
        return new MagicBean();
    }
}
