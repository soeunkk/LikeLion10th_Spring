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

	// DB에 갔다오려면 @Transactional 필수!
	@Transactional
	public Person update(long id, PersonRequestDto requestDto) {
		Person person = personRepository.findById(id).orElseThrow(
				// 예외를 발생시켰을 때 원인도 써주기!
				() -> new IllegalArgumentException("해당 id가 존재하지 않습니다.")
		);
		person.update(requestDto);
		personRepository.save(person);
		return person;
	}
}
