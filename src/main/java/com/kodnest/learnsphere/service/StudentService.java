package com.kodnest.learnsphere.service;

import java.util.List;

import com.kodnest.learnsphere.entity.Course;
import com.kodnest.learnsphere.entity.Lesson;

public interface StudentService {

	List<Course> fetchCourseList();
	Course fetchCourse(int courseId);


	Lesson getLesson(int lessonId);
	
}
