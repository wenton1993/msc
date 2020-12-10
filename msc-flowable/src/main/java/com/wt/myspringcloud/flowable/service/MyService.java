package com.wt.myspringcloud.flowable.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wt.myspringcloud.flowable.mapper.PersonMapper;
import com.wt.myspringcloud.flowable.pojo.entity.Person;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 文通
 * @since 2020/6/9
 */
@Service
public class MyService {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Resource
    private PersonMapper personMapper;

    @Transactional
    public void startProcess(String assignee) {
        Person person = personMapper.selectOne(new QueryWrapper<Person>().eq("name", assignee));
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("person", person);
        runtimeService.startProcessInstanceByKey("oneTaskProcess", variables);
    }

    @Transactional
    public List<Task> getTasks(String assignee) {
        return taskService.createTaskQuery().taskAssignee(assignee).list();
    }

}
