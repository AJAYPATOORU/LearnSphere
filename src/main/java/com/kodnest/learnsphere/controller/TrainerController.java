package com.kodnest.learnsphere.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kodnest.learnsphere.entity.Course;
import com.kodnest.learnsphere.entity.Lesson;
import com.kodnest.learnsphere.service.TrainerService;
import com.kodnest.tunehub.entity.User;

import org.springframework.ui.Model;

@Controller
public class TrainerController {
	@Autowired
	TrainerService tservice;

	@PostMapping("/addCourse")
	public String addCourse(@ModelAttribute Course course) {

		tservice.addCourse(course);
		return "redirect:/trainerHome";

	}

	@GetMapping("/viewCourses")
	public String viewCourse(Model m) {

		List<Course> clist = tservice.fetchAllCourse();
		m.addAttribute("clist", clist);
		return "courses";

	}

	@PostMapping("/addLesson")
	public String addLesson(@ModelAttribute Lesson lesson) {
		tservice.addLesson(lesson);
		Course course = lesson.getCourse();
		course.getLessonList().add(lesson);
		tservice.saveCourse(course);
		return "redirect:/trainerHome";

	}
	
	 @GetMapping("/trainerHome")
	    public String getTrainerHome(Model model) {
	        // Fetch user details or other necessary data here and add to the model
	        // For example:
	        User user = getAuthenticatedUser(); // Assuming you have this method
	        model.addAttribute("user", user);
	        return "trainerHome";
	    }

	    private User getAuthenticatedUser() {
	        // Logic to get the authenticated user
	        // Example:
	        // Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        // return (User) authentication.getPrincipal();
	        return new User(); // Placeholder, implement actual logic
	    }
}