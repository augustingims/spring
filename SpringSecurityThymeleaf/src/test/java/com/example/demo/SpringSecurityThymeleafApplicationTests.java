package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entities.Task;
import com.example.demo.entities.User;
import com.example.demo.services.TaskService;
import com.example.demo.services.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringSecurityThymeleafApplicationTests {
    @Autowired
    private UserService userService;
    
    @Autowired
    private TaskService taskService;
    
    @Before
    public void initDB() {
    	{
    		User user = new User("testUser@gmail.com","testUser","12345");
    		userService.createUser(user);
    	}
    	
    	{
    		User user = new User("testAdmin@gmail.com","testAdmin","12345");
    		userService.createAdmin(user);
    	}
    	Task task = new Task("03/07/2018", "00:11", "11:00", "You need to work today");
    	User user = userService.findOne("testUser@gmail.com");
    	taskService.addTask(task, user);
    	
    }
    
	@Test
	public void testUser() {
		User user = userService.findOne("testUser@gmail.com");
		assertNotNull(user);
		User admin = userService.findOne("testAdmin@gmail.com");
		assertEquals(admin.getEmail(), "testAdmin@gmail.com");
	}
	
	@Test
	public void testAdmin() {
		User user = userService.findOne("testUser@gmail.com");
		List<Task> tasks = taskService.findTaskUser(user);
		assertNotNull(tasks);
	}

}
