package com.example.todo.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.todo.app.entity.task;

@Repository
public interface taskRepository extends JpaRepository<task,Long>{

}
