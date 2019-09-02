package org.hrishi.jpa.hibernate.demo.repository;

import static org.junit.Assert.assertEquals;

import org.hrishi.jpa.hibernate.demo.DemoApplication;
import org.hrishi.jpa.hibernate.demo.entity.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class CourseRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseRepository repository;
	@Test
	public void findById_basic() {
		Course course = repository.findById(10001L);
		assertEquals("JPA",course.getName());
	}

}