package com.sparta.week02.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
public class Course extends Timestamped {
	@Id	// PK로 사용하겠다는 의미
	@GeneratedValue(strategy = GenerationType.AUTO)	// id 값 자동으로 증가
	private Long id;

	//기본적으로 @Entity의 멤버 변수는 @Column으로 설정됨 (=별다른 조건 없으면 생략 가능)
	@Column(nullable = false)	// 반드시 값이 존재해야 함
	private String title;

	@Column(nullable = false)
	private String tutor;

	public Course(String title, String tutor) {
		this.title = title;
		this.tutor = tutor;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getTutor() {
		return tutor;
	}

	public void update(Course course) {
		this.title = course.title;
		this.tutor = course.tutor;
	}
}
