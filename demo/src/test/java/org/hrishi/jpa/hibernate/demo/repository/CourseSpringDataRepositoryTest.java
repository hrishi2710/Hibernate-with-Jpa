package org.hrishi.jpa.hibernate.demo.repository;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.hrishi.jpa.hibernate.demo.DemoApplication;
import org.hrishi.jpa.hibernate.demo.entity.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class CourseSpringDataRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseSpringDataRepository repository;
	
	@Test
	public void findById_CoursePresent() {
		Optional<Course> courseOptional = repository.findById(10001L);
		assertTrue(courseOptional.isPresent());
	}
	
	@Test
	public void findById_CourseNotPresent() {
		Optional<Course> courseOptional = repository.findById(20001L);
		assertFalse(courseOptional.isPresent());
	}
	
	@Test
	public void playingAroundWihtSpringDataRepository() {
		Course course = new Course("microservices in 100 days");
		repository.save(course);
		course.setName("Microservices in 100 days updated");
		repository.save(course);
		
		logger.info("Courses -> {}", repository.findAll());
		logger.info("Courses -> {}", repository.count());
		
	}
	
	@Test
	public void sort() {
		/*Course course = new Course("microservices in 100 days");
		repository.save(course);
		course.setName("Microservices in 100 days updated");
		repository.save(course);*/
		Sort sort = new Sort(Sort.Direction.DESC , "name");
		logger.info("Courses -> {}", repository.findAll(sort));
		logger.info("Courses -> {}", repository.count());
		
	}
	
	@Test
	public void pagination() {
		/*Course course = new Course("microservices in 100 days");
		repository.save(course);
		course.setName("Microservices in 100 days updated");
		repository.save(course);*/
		PageRequest pageRequest = PageRequest.of(0, 3);
		
		Page<Course> firstPage = repository.findAll(pageRequest);
		logger.info("First Page -> {}", firstPage.getContent());
		
		Pageable secondPageable = firstPage.nextPageable();
		Page<Course> secondPage = repository.findAll(secondPageable);

		logger.info("Second Page -> {}", secondPage.getContent());
	}
	
	@Test
	public void findCourses() {
		logger.info("Courses with name -> {}", repository.findByName("JPA in 50 days"));
	}
	

}