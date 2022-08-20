package com.sparta.week02;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.sparta.week02.domain.Course;
import com.sparta.week02.domain.CourseRepository;

@EnableJpaAuditing
@SpringBootApplication
public class Week02Application {

	public static void main(String[] args) {
		SpringApplication.run(Week02Application.class, args);
	}

	@Bean
	public CommandLineRunner demo(CourseRepository repository) {
		return (args) -> {
			repository.findAll();
			System.out.println("기존 저장 인쇄\n");

			Course course = new Course("웹개발의 봄, Spring", "남병관");
			repository.save(course);

			System.out.println("새 저장 인쇄");
			List<Course> courses = repository.findAll();
			for (Course item: courses) {
				System.out.println(item.getTitle());
				System.out.println(item.getTutor());
			}
		};
	}
}
