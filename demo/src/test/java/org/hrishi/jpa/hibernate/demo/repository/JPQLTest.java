package org.hrishi.jpa.hibernate.demo.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hrishi.jpa.hibernate.demo.DemoApplication;
import org.hrishi.jpa.hibernate.demo.entity.Course;
import org.hrishi.jpa.hibernate.demo.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class JPQLTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;
	@Test
	public void jpql_basic() {
		Query query = em.createNamedQuery("query_get_all_courses");
		List resultList = query.getResultList();
		logger.info("Select c From Course c -> {}" , resultList);
	}
	
	@Test
	public void jpql_typed() {
		TypedQuery<Course> query = em.createNamedQuery("query_get_all_courses", Course.class);
		List<Course> resultList = query.getResultList();
		logger.info("Select c From Course c -> {}" , resultList);
	}
	
	@Test
	public void jpql_where() {
		TypedQuery<Course> query = em.createNamedQuery("query_courses_with_name_services", Course.class);
		List<Course> resultList = query.getResultList();
		logger.info("Select c From Course c where name like'%Services'-> {}" , resultList);
	}
	
	@Test
	public void jpql_courses_without_students() {
		TypedQuery<Course> query = em.createQuery("Select c from Course c where c.students is empty", Course.class);
		List<Course> resultList = query.getResultList();
		logger.info("Results -> {}" , resultList);
	}
	
	@Test
	public void jpql_courses_with_atleast2_students() {
		TypedQuery<Course> query = em.createQuery("Select c from Course c where size(c.students)>=2", Course.class);
		List<Course> resultList = query.getResultList();
		logger.info("Results -> {}" , resultList);
	}
	
	@Test
	public void jpql_courses_order_by_students() {
		TypedQuery<Course> query = em.createQuery("Select c from Course c order by size(c.students) desc", Course.class);
		List<Course> resultList = query.getResultList();
		logger.info("Order -> {}" , resultList);
	}
	
	@Test
	public void jpql_students_with_passport_in_certain_pattern() {
		TypedQuery<Student> query = em.createQuery("Select s from Student s where s.passport.number like '%1234%'", Student.class);
		List<Student> resultList = query.getResultList();
		logger.info("Passport in certain order -> {}" , resultList);
	}
	
	
	//join => Select c,s from Course c JOIN c.students s
	//Left join => Select c,s from Course c LEFT JOIN c.students s
	//Outer join => Select c,s from Course c, students s
	
	@Test
	public void join() {
		Query query = em.createQuery("Select c,s from Course c JOIN c.students s");
		List<Object[]> resultList = query.getResultList();
		logger.info("Join ->{}" , resultList.size());
		for(Object[] result: resultList) {
			logger.info("Join courses -> {} students -> {}" , result[0], result[1]);
		}
	}
	
	@Test
	public void leftJoin() {
		Query query = em.createQuery("Select c,s from Course c LEFT JOIN c.students s");
		List<Object[]> resultList = query.getResultList();
		logger.info("Join ->{}" , resultList.size());
		for(Object[] result: resultList) {
			logger.info("Join courses -> {} students -> {}" , result[0], result[1]);
		}
	}
	
	@Test
	public void crossJoin() {
		Query query = em.createQuery("Select c,s from Course c, Student s");
		List<Object[]> resultList = query.getResultList();
		logger.info("Join ->{}" , resultList.size());
		for(Object[] result: resultList) {
			logger.info("Join courses -> {} students -> {}" , result[0], result[1]);
		}
	}

}