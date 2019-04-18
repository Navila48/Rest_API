package com.navil.coursereviewapi.core;

import java.util.ArrayList;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.navil.coursereviewapi.course.Course;
import com.navil.coursereviewapi.course.CourseRepository;
import com.navil.coursereviewapi.review.Review;

@Component
public class DatabaseLoade implements ApplicationRunner {
	private final CourseRepository courses;
	@Autowired
	DatabaseLoade(CourseRepository courses)
	{
		this.courses=courses;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub

		Course course=new Course("java Basic","https://Coursera.com/java basic");
		course.addReviews(new Review(3,"Good"));
		courses.save(course);
		String[]templates= {
				"%s basics",
				"%s for beginners",
				"Complete guide for %s"
		};
		String []buzzword= {
				"Spring",
				"Scala",
				"Hibernate"
		};
		ArrayList<Course>bunchOfCourses=new ArrayList<>();
		IntStream.range(0, 50).
		forEach(i->{
			String template=templates[i%templates.length];
			String buzz=buzzword[i%buzzword.length];
			String title=String.format(template,buzz);
			Course c=new Course(title,"http://course.com");
			c.addReviews(new Review(i%5,String.format("Moar %s please",buzz)));
			bunchOfCourses.add(c);	
		});
		courses.saveAll(bunchOfCourses);
	}

}
