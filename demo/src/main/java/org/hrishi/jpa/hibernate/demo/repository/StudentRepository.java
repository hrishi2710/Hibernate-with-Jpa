package org.hrishi.jpa.hibernate.demo.repository;

import javax.persistence.EntityManager;

import org.hrishi.jpa.hibernate.demo.entity.Passport;
import org.hrishi.jpa.hibernate.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class StudentRepository {
	
	@Autowired
	EntityManager em;
	
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

}
