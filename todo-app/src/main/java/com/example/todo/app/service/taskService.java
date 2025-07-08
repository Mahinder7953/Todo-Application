package com.example.todo.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todo.app.entity.task;
import com.example.todo.app.repository.taskRepository;

@Service
public class taskService {
    @Autowired
    private taskRepository Repo;

    public List<task> getTasks() {
        return Repo.findAll();
    }

    public void addTask(task entity) {
        Repo.save(entity);
    }

    public void deleteTask(Long id) {
        Repo.deleteById(id);
    }

    public void updateTask(task entity, Long id) {
        task t = Repo.findById(id).get();
        t.setName(entity.getName());
        Repo.save(t);
    }

    public task updateTaskPage(Long id) {
        return Repo.findById(id).get();
    }

}
