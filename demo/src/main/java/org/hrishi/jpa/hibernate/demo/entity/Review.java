package org.hrishi.jpa.hibernate.demo.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Review {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String rating;
	
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Course course;

	
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	protected Review() {
		
	}
	
	public Review(String rating, String description) {
		this.rating = rating;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return String.format("Review[%s %s]",rating, description);
	}

	
}
