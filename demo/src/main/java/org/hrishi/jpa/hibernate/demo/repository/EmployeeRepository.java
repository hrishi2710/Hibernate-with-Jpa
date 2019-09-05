package org.hrishi.jpa.hibernate.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.catalina.startup.WebAnnotationSet;
import org.hrishi.jpa.hibernate.demo.entity.Course;
import org.hrishi.jpa.hibernate.demo.entity.Employee;
import org.hrishi.jpa.hibernate.demo.entity.Review;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javassist.expr.NewArray;

@Repository
@Transactional
public class EmployeeRepository {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	
	@Autowired
	EntityManager em;
	
	//findById
	public Course findById(Long id) {
		return em.find(Course.class, id);
	}
	
	public void insert(Employee employee) {
		em.persist(employee);
	}
	
	public List<Employee> retrieveAllEmployees(){
		return em.createQuery("select e from Emplyee e", Employee.class).getResultList();
	}

}
