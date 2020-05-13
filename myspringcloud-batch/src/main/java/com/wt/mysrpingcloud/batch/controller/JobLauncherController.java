package com.wt.mysrpingcloud.batch.controller;

import com.wt.myspringcloud.common.core.BaseController;
import com.wt.myspringcloud.common.core.JsonResult;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 文通
 * @since 2019/12/30
 */
@RestController
public class JobLauncherController extends BaseController {
    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job importUserJob;

    @PostMapping("/importUserJob")
    public JsonResult<Void> importUserJob() throws Exception{
        jobLauncher.run(importUserJob, new JobParameters());
        return renderSuccess();
    }
}
