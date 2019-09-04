package org.hrishi.jpa.hibernate.demo.repository;

import javax.persistence.EntityManager;

import org.apache.catalina.startup.WebAnnotationSet;
import org.hrishi.jpa.hibernate.demo.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javassist.expr.NewArray;

@Repository
@Transactional
public class CourseRepository {
	
	@Autowired
	EntityManager em;
	
	//findById
	public Course findById(Long id) {
		return em.find(Course.class, id);
	}
	
	//updateCourse
	public Course save(Course course) {
		if(course.getId() == null) {
			em.persist(course);
		}
		else {
			em.merge(course);
		}
		return course;
	}
	
	//deleteById
	public void deleteById(Long id) {
		Course course = findById(id);
		em.remove(course);
	}
	
	public void playWithEntityManager() {
		Course course1 = new Course("Web Services");
		em.persist(course1);
		em.flush();
		
		Course course2 = findById(10001L);
		course2.setName("JPA updated");
	}

}
