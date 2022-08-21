package com.example.week02_hw.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.week02_hw.dto.PersonRequestDto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter	// 중요) Getter가 있어야지 Controller에서 JSON으로 만들 수 있음!
@NoArgsConstructor
@Entity
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable = false)
	private String name;

	private int age;

	// Enum형으로 Column을 지정하기 위한 설정
	@Enumerated(EnumType.STRING)
	private Gender gender;

	public Person(PersonRequestDto requestDto) {
		this.name = requestDto.getName();
		this.age = requestDto.getAge();
		this.gender = requestDto.getGender();
	}

	public void update(PersonRequestDto requestDto) {
		this.name = requestDto.getName();
		this.age = requestDto.getAge();
		this.gender = requestDto.getGender();
	}
}
