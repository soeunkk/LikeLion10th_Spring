package com.sparta.week02;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.sparta.week02.domain.Course;
import com.sparta.week02.domain.CourseRepository;
import com.sparta.week02.service.CourseService;

@EnableJpaAuditing
@SpringBootApplication
public class Week02Application {

	public static void main(String[] args) {
		SpringApplication.run(Week02Application.class, args);
	}

	@Bean
	public CommandLineRunner demo(CourseRepository repository, CourseService service) {
		return (args) -> {
			// 데이터 저장하기
			repository.save(new Course("프론트엔드의 꽃, 리액트", "임민영"));

			// 데이터 전부 조회하기
			List<Course> courseList = repository.findAll();
			for (int i=0; i<courseList.size(); i++) {
				Course courseItem = courseList.get(i);
				System.out.println(courseItem.getId());
				System.out.println(courseItem.getTitle());
				System.out.println(courseItem.getTutor());
			}

			// 데이터 하나 조회하기
			Course course = repository.findById(1L).orElseThrow(
					() -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
			);

			// 데이터 갱신하기
			Course new_course = new Course("프론트엔드의 꽃, 리액트", "임민영");
			service.update(1L, new_course);
			courseList = repository.findAll();
			for (int i=0; i<courseList.size(); i++) {
				Course courseItem = courseList.get(i);
				System.out.println(courseItem.getId());
				System.out.println(courseItem.getTitle());
				System.out.println(courseItem.getTutor());
			}

			// 데이터 삭제하기
			repository.deleteAll();
			System.out.println("course 개수 = " + repository.count());
		};
	}
}
