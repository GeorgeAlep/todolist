package com.todolist.todolist.service;

import com.todolist.todolist.exeptions.IllegalTaskException;
import com.todolist.todolist.model.ToDo;
import com.todolist.todolist.repository.ToDoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {

    private final ToDoRepository toDoRepository;

    @Autowired
    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public void addToDo(ToDo toDo) throws IllegalTaskException {
        Optional<ToDo> toDoOptional = toDoRepository.findByTaskIgnoreCase(toDo.getTask());

        if (toDoOptional.isPresent()) {
            throw new IllegalTaskException("Task already exists.");
        }
        toDoRepository.save(toDo);
    }

    public List<ToDo> getToDo() {
        return toDoRepository.findAll();
    }

    @Transactional
    public void updateToDo(Long taskId, String task, boolean completed) throws IllegalTaskException {
        ToDo toDo = toDoRepository.findById(taskId)
                .orElseThrow(() -> new IllegalTaskException("Can't find task."));

        if (task != null && !task.isEmpty()) {
            if (toDoRepository.existsByTaskIgnoreCase(task)) {
                throw new IllegalTaskException("Task already exists.");
            }
            toDo.setTask(task);
        }

        if (completed != toDo.isCompleted()) {
            toDo.setCompleted(completed);
        }
    }

    public void deleteToDo(Long id) throws IllegalTaskException {
        boolean taskExists = toDoRepository.existsById(id);
        if (!taskExists) {
            throw new IllegalTaskException("Task does not exist.");
        }

        toDoRepository.deleteById(id);
    }
}
