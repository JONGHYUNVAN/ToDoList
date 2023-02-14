package com.codestates.ToDoList;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor // ToDoRepository 속성을 포함하는 생성자를 자동으로 생성
@Controller
public class ToDoController {

    private final ToDoService toDoService;
    //Read
    @RequestMapping("/")
    public String list(Model model){
        List<ToDoEntity> toDoEntityList = this.toDoService.getList();
        model.addAttribute("toDoEntityList",toDoEntityList);
        return "todolist";
    }
    //Create
    @PostMapping("/")
    public String todoCreate(@RequestParam String title){
        // Create method
        this.toDoService.create(title);
        // redirect
        return "redirect:/";
    }
    //Delete
    @DeleteMapping("/{id}")
    public String todoDelete(@PathVariable Integer id){
        this.toDoService.delete(id);
        return "redirect:/";
    }
    //Update
    @PutMapping("/{id}")
    public String todoUpdate(@RequestBody String title, @PathVariable Integer id){
        this.toDoService.update(id, title);
        return "redirect:/";
    }
    //Done
    @PutMapping("/done/{id}")
    public String todoDone(@PathVariable Boolean completed, @PathVariable Integer id){
        this.toDoService.done(id,completed);
        return "redirect:/";
    }
}