package com.kodnest.learnsphere.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kodnest.learnsphere.entity.Course;
import com.kodnest.learnsphere.entity.Users;
import com.kodnest.learnsphere.service.StudentService;
import com.kodnest.learnsphere.service.TrainerService;
import com.kodnest.learnsphere.service.UserService;

import jakarta.persistence.criteria.Order;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@Controller
public class OrderCreation {

	@Autowired
	UserService uservice;
	@Autowired
	StudentService sservice;

	@Autowired
	TrainerService tservice;

	@PostMapping("/takeOrder")
	@ResponseBody
	public String takeOrder(@RequestParam int amount, @RequestParam String email, @RequestParam int courseId) {

		mapCourseAndUser(email, courseId);
		int amount1 = 9;
		Order order = null;
		try {
			RazorpayClient razorpay = new RazorpayClient("rzp_test_rR6SQ7nuu0cq8g", "nHPhbRY9sG0zDCaHZkekFyNO");
			JSONObject orderRequest = new JSONObject();
			orderRequest.put("amount", amount1 * 100); // amount in the smallest currency unit
			orderRequest.put("currency", "INR");
			orderRequest.put("receipt", "order_rcptid_11");

			order = (jakarta.persistence.criteria.Order) razorpay.orders.create(orderRequest);
		} catch (RazorpayException e) {
			// Handle Exception
			System.out.println(e.getMessage());
		}

		return order.toString();

	}

	public void mapCourseAndUser(String email, int courseId) {

		Users user = uservice.findUserByEmail(email);
		Course course = sservice.fetchCourse(courseId);

		user.getCourseList().add(course);
		course.getUserList().add(user);

		tservice.saveCourse(course);
		uservice.saveUsers(user);
	}

}