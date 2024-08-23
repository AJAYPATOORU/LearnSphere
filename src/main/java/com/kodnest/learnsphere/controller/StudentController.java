package com.kodnest.learnsphere.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kodnest.learnsphere.entity.Course;
import com.kodnest.learnsphere.entity.Lesson;
import com.kodnest.learnsphere.entity.Users;
import com.kodnest.learnsphere.service.StudentService;
import com.kodnest.learnsphere.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class StudentController {
	
	@Autowired
	StudentService sservice;
	
	@Autowired
	UserService uservice;
	
	@GetMapping("/purchase")
	public String purchase(Model model) {
		//fetch all course LIst
		List<Course> courseList=sservice.fetchCourseList();
		//add list of model object
		model.addAttribute("courseList",courseList);
		return "purchaseCourse";
	}
	
	
	@GetMapping("/myCourses")
public String myCourses(Model model,HttpSession session) {
		Users loggedUser=(Users) session.getAttribute("loggedInUser");
		String email=loggedUser.getEmail();
		
		Users user=uservice.findUserByEmail(email);
		List<Course> courseList=user.getCourseList();
		model.addAttribute("courseList",courseList);
		return "myCourses";
		
	}
	
	@GetMapping("/viewLesson")
	public String viewLesson(@RequestParam("lessonId")int lessonId,
			Model model,HttpSession session) {
		
		Lesson lesson = sservice.getLesson(lessonId);
		// Extract the YouTube video id from the URL
	    String youtubeUrl = lesson.getLessonLink();
	    
	    String videoId = youtubeUrl.substring(youtubeUrl.indexOf("=") + 1);
	    lesson.setLessonLink(videoId);
		
		
		model.addAttribute("lesson",lesson);
		
				return "myLesson";
	}
	

}
