package com.darksouls.service.Impl;

import com.darksouls.dao.TaskMapper;
import com.darksouls.entity.task;
import com.darksouls.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskMapper taskMapper;
    public int tast_insert(task task) {
        return taskMapper.tast_insert(task);
    }

}
