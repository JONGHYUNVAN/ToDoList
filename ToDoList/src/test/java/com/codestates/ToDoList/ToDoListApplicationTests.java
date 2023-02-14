package com.codestates.ToDoList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ToDoListApplicationTests {

	@Autowired //  속성에 객체를 주입하는 방식
	private  ToDoRepository toDoRepository;

	@Test
	void testJpa() {
		ToDoEntity todo1 = new ToDoEntity();
		todo1.setTitle("content1Testdata");
		todo1.setCompleted(Boolean.TRUE);
		this.toDoRepository.save(todo1);

		ToDoEntity todo2 = new ToDoEntity();
		todo2.setTitle("content2Testdata");
		todo2.setCompleted(Boolean.FALSE);
		this.toDoRepository.save(todo2);
	}

}
