package com.kodnest.learnsphere.service;

import java.util.List;

import com.kodnest.learnsphere.entity.Course;
import com.kodnest.learnsphere.entity.Lesson;

public interface TrainerService {

	public String addCourse(Course course);
	List<Course> fetchAllCourse();
	public String addLesson(Lesson lesson);
	String saveCourse(Course course);
	
}
