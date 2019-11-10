package com.darksouls.dao;

import com.darksouls.entity.task;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskMapper {
         int tast_insert(task order);
}
