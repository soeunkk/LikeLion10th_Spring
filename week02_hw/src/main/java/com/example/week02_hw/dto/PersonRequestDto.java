package com.example.week02_hw.dto;

import com.example.week02_hw.domain.Gender;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PersonRequestDto {
	private String name;

	private int age;

	private Gender gender;
}
