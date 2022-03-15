package com.api.app.controller;

import com.api.app.persistence.entity.Task;
import com.api.app.persistence.entity.TaskStatus;
import com.api.app.service.TaskService;
import com.api.app.service.dto.TaskInDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task createTask(@RequestBody TaskInDTO taskInDTO){

       return this.taskService.createTask(taskInDTO);
    }

    @GetMapping
    public List<Task> findALL(){
        return  this.taskService.findAll();
    }

    @GetMapping("/status/{status}")
    public List<Task> findALLbyStatus(@PathVariable("status") TaskStatus status){
        return  this.taskService.findAllByTaskStatus(status);
    }

    @PatchMapping("/mark_as_finished/{id}")
    public ResponseEntity<Void> markAsFiniched(@PathVariable("id") Long id){
        this.taskService.updateTaskAsFinished(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        this.taskService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
