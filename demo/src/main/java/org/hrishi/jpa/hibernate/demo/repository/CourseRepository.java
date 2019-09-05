package org.hrishi.jpa.hibernate.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.catalina.startup.WebAnnotationSet;
import org.hrishi.jpa.hibernate.demo.entity.Course;
import org.hrishi.jpa.hibernate.demo.entity.Review;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javassist.expr.NewArray;

@Repository
@Transactional
public class CourseRepository {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	
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
	
	public void addHardCodedReviewsForCourse() {
		//get the course 10003
		Course course = findById(10003L);
		logger.info("course.getReviews(); -> {}", course.getReviews());
		//add 2 reviews to it
		Review review1 = new Review("5", "Greate hand-on stuff");
		Review review2 = new Review("5", "Hats off");
		course.addReview(review1);
		review1.setCourse(course);
		course.addReview(review2);
		review2.setCourse(course);
		//save it to the database
		em.persist(review1);
		em.persist(review2);
	}
	
	public void addReviewsForCourse(Long courseId, List<Review> reviews) {
		//get the course 10003
		Course course = findById(courseId);
		logger.info("course.getReviews(); -> {}", course.getReviews());
		//add 2 reviews to it
		
		for(Review review : reviews) {
			course.addReview(review);
			review.setCourse(course);
			em.persist(review);
		}
	}

}
