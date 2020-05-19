package com.wt.myspringcloud.common.component.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 获取Application的启动参数
 *
 * @author 文通
 * @since 2020/5/19
 */
@Component
public class ApplicationArgumentAccess {

    @Autowired
    public ApplicationArgumentAccess(ApplicationArguments args) {
        boolean debug = args.containsOption("debug");
        List<String> files = args.getNonOptionArgs();
        // if run with "--debug logfile.txt" debug=true, files=["logfile.txt"]
        System.out.println("==== MyBean End ====");
    }
}
