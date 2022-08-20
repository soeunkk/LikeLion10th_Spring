package com.sparta.week02.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sparta.week02.domain.Course;
import com.sparta.week02.domain.CourseRepository;
import com.sparta.week02.models.CourseRequestDto;
import com.sparta.week02.service.CourseService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class CourseController {

	private final CourseRepository courseRepository;
	private final CourseService courseService;

	@GetMapping("/api/courses")
	public List<Course> getCourses() {
		return courseRepository.findAll();
	}

	// PostMapping을 통해서, 같은 주소라도 방식이 다름을 구분
	@PostMapping("/api/courses")
	public Course createCourse(@RequestBody CourseRequestDto requestDto) {
		Course course = new Course(requestDto);
		return courseRepository.save(course);	// JPA를 이용하여 DB에 저장하고, 그 결과를 반환
	}

	@PutMapping("/api/courses/{id}")
	public Long updateCourse(@PathVariable Long id, @RequestBody CourseRequestDto requestDto) {
		return courseService.update(id, requestDto);
	}

	@DeleteMapping("/api/courses/{id}")
	public Long deleteCourse(@PathVariable Long id) {
		courseRepository.deleteById(id);
		return id;
	}
}
