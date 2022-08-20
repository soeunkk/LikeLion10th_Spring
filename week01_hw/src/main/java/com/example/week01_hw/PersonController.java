package com.example.week01_hw;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

	@GetMapping("/myinfo")
	public Person getPersonInfo() {
		Person person = Person.builder()
				.name("김소은")
				.age(24)
				.gender(Gender.WOMAN)
				.build();
		return person;
	}
}
