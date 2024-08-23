package com.kodnest.learnsphere.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.learnsphere.entity.Course;
import com.kodnest.learnsphere.entity.Lesson;
import com.kodnest.learnsphere.repository.CourseRepositories;
import com.kodnest.learnsphere.repository.LessonRepositories;
import com.kodnest.learnsphere.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	CourseRepositories repo;

	@Autowired
	LessonRepositories lrepo;

	@Override
	public java.util.List<Course> fetchCourseList() {
		return repo.findAll();
	}

	@Override
	public Course fetchCourse(int courseId) {
		return repo.findByCourseId(courseId);
	}

	@Override
	public Lesson getLesson(int lessonId) {
		return lrepo.findByLessonId(lessonId);
	}

}
