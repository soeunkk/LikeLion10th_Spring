package com.sparta.week03.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sparta.week03.domain.Memo;
import com.sparta.week03.domain.MemoRepository;
import com.sparta.week03.dto.MemoRequestDto;
import com.sparta.week03.service.MemoService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class MemoController {

	private final MemoRepository memoRepository;
	private final MemoService memoService;

	@PostMapping("/api/memos")
	public Memo createMemo(@RequestBody MemoRequestDto requestDto) {
		Memo memo = new Memo(requestDto);
		return memoRepository.save(memo);
	}

	@GetMapping("/api/memos")
	public List<Memo> getMemos() {
		return memoRepository.findAllByOrderByModifiedAtDesc();
	}

	@PutMapping("/api/memos/{id}")
	public Long updateMemo(@PathVariable long id, @RequestBody MemoRequestDto requestDto) {
		return memoService.update(id, requestDto);
	}

	@DeleteMapping("/api/memos/{id}")
	public Long deleteMemo(@PathVariable long id) {
		memoRepository.deleteById(id);
		return id;
	}
}
