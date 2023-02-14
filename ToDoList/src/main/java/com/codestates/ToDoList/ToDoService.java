package com.codestates.ToDoList;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ToDoService {
    private final ToDoRepository toDoRepository;

    public List<ToDoEntity> getList(){
        return this.toDoRepository.findAll();
    }

    public void create(String title){
        ToDoEntity toDoEntity = new ToDoEntity();
        toDoEntity.setTitle(title);
        toDoEntity.setCompleted(false);
        this.toDoRepository.save(toDoEntity);
    }

    @Transactional
    public void delete(Integer id){
        ToDoEntity toDoEntity = toDoRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Item not found. id="+id));
        this.toDoRepository.delete(toDoEntity);
    }

    @Transactional
    public void update(Integer id, String title){
        ToDoEntity toDoEntity = toDoRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Item not found. id="+id));
        toDoEntity.setTitle(title);
        this.toDoRepository.save(toDoEntity);
    }

    @Transactional
    public void done(Integer id, Boolean completed){
        ToDoEntity toDoEntity = toDoRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Item not found. id="+id));
        toDoEntity.setCompleted(true);
        this.toDoRepository.save(toDoEntity);
    }
}
