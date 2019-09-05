package org.hrishi.jpa.hibernate.demo.repository;

import javax.persistence.EntityManager;

import org.hrishi.jpa.hibernate.demo.DemoApplication;
import org.hrishi.jpa.hibernate.demo.entity.Passport;
import org.hrishi.jpa.hibernate.demo.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class StudentRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	StudentRepository repository;
	@Autowired
	EntityManager em;
	
	@Test
	@Transactional
	public void retrievePassportAndStudentDetails() {
		Passport passport = em.find(Passport.class, 40001L);
		logger.info("Passport ->{}", passport);
		logger.info("Passport which is associated to student ->{}", passport.getStudent());
	}
	
	
	@Test
	@Transactional
	public void retrieveStudentAndPassportDetails() {
		Student student = em.find(Student.class, 20001L);
		logger.info("student->{}", student);
		logger.info("student passport -> {}" , student.getPassport());
	}
	
	@Test
	@Transactional
	public void retrieveStudentAndCoursed() {
		Student student = em.find(Student.class, 20001L);
		logger.info("student -> {}" , student);
		logger.info("courses -> {}", student.getCourses());
	}
	

}