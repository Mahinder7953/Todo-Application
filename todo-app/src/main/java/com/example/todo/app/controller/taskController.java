package com.example.todo.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.example.todo.app.entity.task;
import com.example.todo.app.service.taskService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class taskController {
    @Autowired
    private taskService taskServ;
    //MAIN PAGE
    @GetMapping("/")
    public String getTasks(Model model) {
        model.addAttribute("tasks", taskServ.getTasks());
        return "index";
    }

    //ADD PAGE
    @GetMapping("/todo/add")
    public String addTaskPage() {
        return "addTask";
    }
    
    //ADD TASK
    @PostMapping("/todo/add")
    public String addTask(@ModelAttribute("task") task entity) {
        taskServ.addTask(entity);
        return "redirect:/";
    }
    
    //DELETE
    @GetMapping("/todo/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskServ.deleteTask(id);
        return "redirect:/";
    }

    //UPDATE PAGE
    @GetMapping("/todo/update/{id}")
    public String updateTaskPage(@PathVariable Long id,Model model) {
        model.addAttribute("task", taskServ.updateTaskPage(id));        
        return "updateTask";
    }
    

    //UPDATE TASK
    @PostMapping("/todo/update/{id}")
    public String updateTask(@ModelAttribute("task") task entity,@PathVariable Long id) {
        taskServ.updateTask(entity,id);
        return "redirect:/";
    }
    
    
}
