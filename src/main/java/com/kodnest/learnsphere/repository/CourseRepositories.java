package com.kodnest.learnsphere.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodnest.learnsphere.entity.Course;

public interface CourseRepositories extends JpaRepository<Course, Integer>{
	
	Course findByCourseId(int courseId);

	List<Course> findAll();
	
}
