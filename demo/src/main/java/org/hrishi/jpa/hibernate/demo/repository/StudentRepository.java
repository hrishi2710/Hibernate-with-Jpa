package org.hrishi.jpa.hibernate.demo.repository;

import javax.persistence.EntityManager;

import org.hrishi.jpa.hibernate.demo.entity.Course;
import org.hrishi.jpa.hibernate.demo.entity.Passport;
import org.hrishi.jpa.hibernate.demo.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.bytebuddy.asm.Advice.This;

@Repository
@Transactional
public class StudentRepository {
	
	@Autowired
	EntityManager em;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//findById
	public Student findById(Long id) {
		return em.find(Student.class, id);
	}
	
	//updateStudent
	public Student save(Student student) {
		if(student.getId() == null) {
			em.persist(student);
		}
		else {
			em.merge(student);
		}
		return student;
	}
	
	//deleteById
	public void deleteById(Long id) {
		Student student = findById(id);
		em.remove(student);
	}
	
	public void saveStudentWithPassport() {
		Passport passport = new Passport("Z123456");
		em.persist(passport);
		Student student = new Student("Manu");
		student.setPassport(passport);
		em.persist(student);
		em.flush();
	}
	
	public void insertHardCodedStudentAndCourse() {
		Student student = new Student("Gondji");
		Course course = new Course("Microservices in 100 days");
		em.persist(student);
		em.persist(course);
		
		student.addCourse(course);
		course.addStudent(student);
		
		em.persist(student);
	}
	
	public void insertStudentAndCourse(Student student, Course course) {
		
		student.addCourse(course);
		course.addStudent(student);
		
		em.persist(student);

		em.persist(course);
	}

}
