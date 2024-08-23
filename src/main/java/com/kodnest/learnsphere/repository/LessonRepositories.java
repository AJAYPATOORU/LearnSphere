package com.kodnest.learnsphere.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodnest.learnsphere.entity.Lesson;

public interface LessonRepositories extends JpaRepository<Lesson, Integer>{

	Lesson findByLessonId(int lessonId);
	
}
