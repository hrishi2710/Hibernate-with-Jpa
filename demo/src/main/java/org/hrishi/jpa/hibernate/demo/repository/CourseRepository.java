package org.hrishi.jpa.hibernate.demo.repository;

import javax.persistence.EntityManager;

import org.hrishi.jpa.hibernate.demo.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CourseRepository {
	
	@Autowired
	EntityManager em;
	
	//findById
	public Course findById(Long id) {
		return em.find(Course.class, id);
	}
	
	//updateCourse
	
	//deleteById

}
