package com.sparta.week03.domain;

import java.time.LocalDateTime;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;

@Getter	// for JSON 변환
@MappedSuperclass	// Entity가 자동으로 컬럼으로 인식
@EntityListeners(AuditingEntityListener.class)	// 생성/변경 시간을 자동으로 업데이트
public abstract class Timestamped {	// 직접 사용할 일이 없으므로 추상 클래스(abstract)로 만들기

	@CreatedDate
	private LocalDateTime createdAt;

	@LastModifiedDate
	private LocalDateTime modifiedAt;
}
