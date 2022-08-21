package com.example.week02_hw.dto;

import com.example.week02_hw.domain.Gender;

import lombok.Getter;

@Getter
// NoArgsConstructor은 Bean일때만 의무적으로 필요
public class PersonRequestDto {
	private String name;
	private int age;
	private Gender gender;
}
