package com.sparta.week03.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sparta.week03.dto.MemoRequestDto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Memo extends Timestamped {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;	// id는 null일 수 없으므로, Long 대신 long으로 씀

	@Column(nullable = false)
	private String username;

	@Column(nullable = false)
	private String contents;

	public Memo(String username, String contents) {
		this.username = username;
		this.contents = contents;
	}

	public Memo(MemoRequestDto requestDto) {
		this.username = requestDto.getUsername();
		this.contents = requestDto.getContents();
	}

	public void update(MemoRequestDto requestDto) {
		this.username = requestDto.getUsername();
		this.contents = requestDto.getContents();
	}
}
