package org.hrishi.jpa.hibernate.demo.repository;

import org.hrishi.jpa.hibernate.demo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseSpringDataRepository extends JpaRepository<Course, Long>{
	
	
	
}