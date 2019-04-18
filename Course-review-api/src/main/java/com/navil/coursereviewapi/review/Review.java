package com.navil.coursereviewapi.review;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import com.navil.coursereviewapi.core.BaseEntity;
import com.navil.coursereviewapi.course.Course;

@Entity
public class Review extends BaseEntity{

	
	private int rating;
	private String description;
	@ManyToOne
	private Course course;
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	protected Review()
	{
		super();
	}
	public Review(int rating, String description) {
		//super();
		this.rating = rating;
		this.description = description;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
