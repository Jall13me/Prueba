package com.example.prueba.mapper;

import com.example.prueba.persistence.entity.TaskStatus;
import com.example.prueba.service.dto.TaskinDTO;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TaskinDTOtoTask implements IMapper<TaskinDTO, Task> {


    @Override
    public Task map(TaskinDTO in) {
        Task task = new Task();
        task.set(in.getTitle());
        task.setDescription(in.getDescription());
        task.setEta(in.getEta());
        task.setCreatedDate(LocalDateTime.now());
        task.setFinished(false);
        task.setTaskStatus(TaskStatus.ON_TIME);
        return task;
    }
}
