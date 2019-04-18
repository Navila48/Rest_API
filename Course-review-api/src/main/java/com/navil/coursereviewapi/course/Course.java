package com.navil.coursereviewapi.course;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.navil.coursereviewapi.core.BaseEntity;
import com.navil.coursereviewapi.review.Review;

@Entity
public class Course extends BaseEntity{

	
	private String title;
	private String url;
	@OneToMany(mappedBy="course",cascade=CascadeType.ALL)
	private List<Review>reviews;
	protected Course()
	{
		super();
		reviews=new ArrayList<>();
	}
		
	public Course(String title, String url) {
		//super();
		this();
		this.title = title;
		this.url = url;
	}
	public List<Review> getReviews() {
		return reviews;
	}

	public void addReviews(Review review)
	{
		review.setCourse(this);
		reviews.add(review);
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
