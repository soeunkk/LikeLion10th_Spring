package com.example.week02_hw.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.week02_hw.domain.Person;
import com.example.week02_hw.domain.PersonRepository;
import com.example.week02_hw.dto.PersonRequestDto;
import com.example.week02_hw.service.PersonService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class PersonController {

	private final PersonRepository personRepository;
	private final PersonService personService;

	// 친구 목록 조회
	@GetMapping("/api/persons")
	public List<Person> getPersonList() {
		return personRepository.findAll();
	}

	// 친구 생성
	@PostMapping("/api/persons")
	public Person savePerson(@RequestBody PersonRequestDto requestDto) {
		Person person = new Person(requestDto);
		return personRepository.save(person);
	}

	// 친구 정보 변경
	@PutMapping("/api/persons/{id}")
	public Person updatePerson(@PathVariable long id, @RequestBody PersonRequestDto requestDto) {
		return personService.update(id, requestDto);
	}

	// 친구 정보 삭제
	@DeleteMapping("/api/persons/{id}")
	public long deletePerson(@PathVariable long id) {
		personRepository.deleteById(id);
		return id;
	}
}
