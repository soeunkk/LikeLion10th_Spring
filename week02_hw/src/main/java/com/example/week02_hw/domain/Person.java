package com.example.week02_hw.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.week02_hw.dto.PersonRequestDto;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable = false)
	private String name;

	private int age;

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
