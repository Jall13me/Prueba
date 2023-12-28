package com.example.prueba.controller;

import com.example.prueba.persistence.entity.TaskStatus;
import com.example.prueba.service.TaskService;
import com.example.prueba.service.dto.TaskinDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }
    @PostMapping
    public Task createTask(@RequestBody TaskinDTO taskinDTO){
        return this.taskService.createTask(taskinDTO);
    }

   @GetMapping
   public List<Task> findAll(){
        return this.taskService.findAll();
   }
    @GetMapping("/status/{status}")
    public List<Task> findAllbystatus(@PathVariable("status")TaskStatus){
        return this.taskService.findALLByTaskStatus(status);
    }

    @PatchMapping("/mark_as_finished/{id}")
    public ResponseEntity<Void> markAsFinished(@PathVariable("id")Long id){
        this.taskService.updateTaskAsFinished(id);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/id")
    public ResponseEntity<Void> delete(@PathVariable("id")Long id){
        this.taskService.deleteByid(id);
        return ResponseEntity.noContent().build();
    }

}
