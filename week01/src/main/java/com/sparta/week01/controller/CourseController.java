package com.sparta.week01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sparta.week01.prac.Course;

// RestController: 서버의 응답이 JSON 형식인 컨트롤러
@RestController
public class CourseController {

	@GetMapping("/course")	// 스프링 주소(http://localhost:8080) 뒤의 주소가 /courses 이고, GET 방식으로 요청이 올 경우 하단 메소드를 실행
	public Course getCourses() {
		Course course = new Course();
		course.setTitle("웹개발의 봄 스프링");
		course.setDays(35);
		course.setTutor("남병관");
		return course;
	}
}
