package com.todolist.todolist.controller;

import com.todolist.todolist.model.ToDo;
import com.todolist.todolist.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/todolist")
public class ToDoController {

    private final ToDoService toDoService;

    @Autowired
    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @PostMapping    // Create operation
    public void addToDo(@RequestBody ToDo toDo) {
        toDoService.addToDo(toDo);
    }

    @GetMapping // Receive operation
    public List<ToDo> getToDo() {
        return toDoService.getToDo();
    }

    @PutMapping(path = "{taskId}")  // Update operation
    public void updateToDo(@PathVariable Long taskId,
                           @RequestBody ToDo toDo) {
        toDoService.updateToDo(taskId, toDo.getTask(), toDo.isCompleted());
    }

    @DeleteMapping(path = "{taskId}")   // Delete operation
    public void deleteToDo(@PathVariable Long taskId) {
        toDoService.deleteToDo(taskId);
    }
}
