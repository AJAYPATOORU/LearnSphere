package com.kodnest.learnsphere.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.learnsphere.entity.Course;
import com.kodnest.learnsphere.entity.Lesson;
import com.kodnest.learnsphere.repository.CourseRepositories;
import com.kodnest.learnsphere.repository.LessonRepositories;
import com.kodnest.learnsphere.service.TrainerService;


@Service
public class TrainerServiceImpl implements TrainerService{

	@Autowired
	CourseRepositories repo;
	@Autowired
	LessonRepositories lrepo;
		@Override
		public String addCourse(Course course) {
			repo.save(course);
			return "Course added";
		}
		@Override
		public java.util.List<Course> fetchAllCourse() {
			return repo.findAll();
		}
		@Override
		public String addLesson(Lesson lesson) {
			lrepo.save(lesson);
			return "Lesson added";
		}
		@Override
		public String saveCourse(Course course) {
		repo.save(course);
			return "course updated";
		}
		
		
	
}
