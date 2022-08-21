package com.example.week02_hw.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.week02_hw.domain.Person;
import com.example.week02_hw.domain.PersonRepository;
import com.example.week02_hw.dto.PersonRequestDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PersonService {

	private final PersonRepository personRepository;
	
	public Person update(long id, PersonRequestDto requestDto) {
		Person person = personRepository.findById(id).orElseThrow(
				IllegalArgumentException::new
		);
		person.update(requestDto);
		personRepository.save(person);
		return person;
	}
}
