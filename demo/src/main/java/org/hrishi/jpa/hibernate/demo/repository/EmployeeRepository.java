package org.hrishi.jpa.hibernate.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.hrishi.jpa.hibernate.demo.entity.Course;
import org.hrishi.jpa.hibernate.demo.entity.Employee;
import org.hrishi.jpa.hibernate.demo.entity.FullTimeEmployee;
import org.hrishi.jpa.hibernate.demo.entity.PartTimeEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class EmployeeRepository {
	


	
	@Autowired
	EntityManager em;
	
	//findById
	public Course findById(Long id) {
		return em.find(Course.class, id);
	}
	
	public void insert(Employee employee) {
		em.persist(employee);
	}
	
	/*public List<Employee> retrieveAllEmployees(){
		return em.createQuery("select e from Employee e", Employee.class).getResultList();
	}*/
	public List<PartTimeEmployee> retrieveAllPartTimeEmployees(){
		return em.createQuery("select e from PartTimeEmployee e", PartTimeEmployee.class).getResultList();
	}
	public List<FullTimeEmployee> retrieveAllFullTimeEmployees(){
		return em.createQuery("select e from FullTimeEmployee e", FullTimeEmployee.class).getResultList();
	}

}
