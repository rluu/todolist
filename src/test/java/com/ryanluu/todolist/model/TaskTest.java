package com.ryanluu.todolist.model;

import java.util.Calendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ryanluu.todolist.model.Task.TaskState;


public class TaskTest {
    static final Logger logger = LoggerFactory.getLogger(TaskTest.class);
     

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
	logger.trace("Building Hibernate SesssionFactory...");
	
        Configuration configuration = 
        	new Configuration().configure("/META-INF/hibernate.cfg.xml");
        
        StandardServiceRegistryBuilder builder = 
        	new StandardServiceRegistryBuilder().
        	applySettings(configuration.getProperties());
        
        SessionFactory factory = configuration.buildSessionFactory(builder.build());
        
	logger.trace("Done building Hibernate SesssionFactory.");	
        return factory;
    }

    @BeforeClass
    public static void setUpSessionFactory() {
	logger.trace("Inside @BeforeClass setUpSessionFactory for TaskTest.");
    }
    
    @AfterClass
    public static void tearDown() {
	logger.trace("Inside @AfterClass tearDown for TaskTest.");
	
    }
    
    @Test
    public void testCreate() {
	logger.trace("Inside testCreateRetrieve.");
	
	
	Task task = new Task();
	task.setName("My new task");
	task.setDescription("This is a description");
	task.setTaskState(TaskState.INCOMPLETE);
	task.setCreationDate(Calendar.getInstance().getTime());
	

	Session session = sessionFactory.getCurrentSession();
	session.getTransaction().begin();
	session.persist(task);
	session.getTransaction().commit();
	

	logger.debug("Task ID is: " + task.getId());
	
	
    }
    
    // TODO:  add tests to create, and see if we can retrieve.  Then create a few and retrieve a list.  Then create and update.  Then create and delete.
}
