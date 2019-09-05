package org.hrishi.jpa.hibernate.demo;

import java.util.ArrayList;
import java.util.List;

import org.hrishi.jpa.hibernate.demo.entity.Review;
import org.hrishi.jpa.hibernate.demo.repository.CourseRepository;
import org.hrishi.jpa.hibernate.demo.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemoApplication implements CommandLineRunner{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//studentRepository.saveStudentWithPassport();
		//repository.playWithEntityManager();
		//courseRepository.addHardCodedReviewsForCourse();
		
		
		List<Review> reviews = new ArrayList<Review>();
		Review review1 = new Review("5", "Greate hand-on stuff");
		Review review2 = new Review("5", "Hats off");
		reviews.add(review1);
		reviews.add(review2);
		
		courseRepository.addReviewsForCourse(10003L, reviews );
	}

}
