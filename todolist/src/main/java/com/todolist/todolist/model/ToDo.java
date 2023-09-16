package com.todolist.todolist.model;

import jakarta.persistence.*;
import org.springframework.data.jpa.repository.JpaRepository;

@Entity
@Table(
        name = "todo"
)  // Define ToDo as both an Entity as well as a table within the data base
public class ToDo {
    @Id
    @SequenceGenerator(
            name = "todo_sequence",
            sequenceName = "todo_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "todo_sequence"
    )
    private Long id;    // Id is generated automatically in increments of 1
    private String task;    // Task to be completed
    private boolean completed;  // Status of the respective task

    // Constructors
    public ToDo() {

    }

    public ToDo(String task, boolean completed){
        this.task = task;
        this.completed = completed;
    }

    public ToDo(Long id, String task, boolean completed){
        this.id = id;
        this.task = task;
        this.completed = completed;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    // toString method
    @Override
    public String toString() {
        return "ToDo{" +
                "id=" + id +
                ", task='" + task + '\'' +
                ", completed=" + completed +
                '}';
    }
}
