package com.sparta.week03.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sparta.week03.domain.Memo;
import com.sparta.week03.domain.MemoRepository;
import com.sparta.week03.dto.MemoRequestDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemoService {

	private final MemoRepository memoRepository;

	@Transactional
	public Long update(long id, MemoRequestDto requestDto) {
		Memo memo = memoRepository.findById(id).orElseThrow(
				() -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
		);
		memo.update(requestDto);
		return memo.getId();
	}
}
