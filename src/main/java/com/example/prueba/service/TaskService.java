package com.example.prueba.service;

import com.example.prueba.exception.toDoExceptions;
import com.example.prueba.mapper.TaskinDTOtoTask;
import com.example.prueba.persistence.entity.TaskStatus;
import com.example.prueba.persistence.repository.TaskRepository;
import com.example.prueba.service.dto.TaskinDTO;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository repository;
    private final TaskinDTOtoTask mapper;

    public TaskService(TaskRepository repository, TaskinDTOtoTask mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Task createTask(TaskinDTO taskinDTO){
        Task task = mapper.map(taskinDTO);
        return this.repository.save(task);
    }

    public List<Task> findAll{
        return this.repository.findAll();
    }

    public List<Task> findALLByTaskStatus(TaskStatus status){
        return this.repository.findAllByTaskStatus(status);
    }
@Transactional
    public void updateTaskAsFinished(Long id){
    Optional<Task> optionalTask this.repository.findById(id);
    if (optionalTask.isEmpty()){
        throw new toDoExceptions("Task not found", HttpStatus.NOT_FOUND);
    }
        this.repository.markTaskAsFinished(id);
    }
    public void deleteByid(Long id){
        Optional<Task> optionalTask this.repository.findById(id);
        if (optionalTask.isEmpty()){
            throw new toDoExceptions("Task not found", HttpStatus.NOT_FOUND);
        }
        this.repository.deleteById(id);
    }
}


