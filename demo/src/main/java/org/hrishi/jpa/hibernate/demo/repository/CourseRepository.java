package org.hrishi.jpa.hibernate.demo.repository;

import javax.persistence.EntityManager;

import org.hrishi.jpa.hibernate.demo.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

}
