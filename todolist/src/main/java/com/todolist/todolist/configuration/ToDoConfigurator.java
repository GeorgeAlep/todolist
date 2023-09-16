package com.todolist.todolist.configuration;

import com.todolist.todolist.model.ToDo;
import com.todolist.todolist.repository.ToDoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ToDoConfigurator {

    @Bean
    CommandLineRunner commandLineRunner(ToDoRepository toDoRepository) {
        return args -> {
            ToDo todoOne = new ToDo(
                    "do something",
                    true
            );

            ToDo todoTwo = new ToDo(
                    "do another thing",
                    false
            );

            toDoRepository.saveAll(List.of(todoOne, todoTwo));
        };
    }
}
