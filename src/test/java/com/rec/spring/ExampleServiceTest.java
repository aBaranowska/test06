package com.rec.spring;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class ExampleServiceTest {

	private static final String HELLO_WORLD = "Hello world!";

	private ApplicationContext context;

	@Before
	public void setUp() {
		context = new AnnotationConfigApplicationContext(AppConfig.class);
	}

	@After
	public void tearDown() {
		((AbstractApplicationContext) context).close();
	}

	@Test
	public void getBean01() {
		Service bean = context.getBean(Service.class);
		assertEquals(HELLO_WORLD, bean.getMessage());
	}

	@Test
	public void getBean02() {
		Service bean = context.getBean("exampleServiceBean", Service.class);
		assertEquals(HELLO_WORLD, bean.getMessage());
	}

}
