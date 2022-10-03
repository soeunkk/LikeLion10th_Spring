package com.sparta.week04.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sparta.week04.dto.ProductMypriceRequestDto;
import com.sparta.week04.dto.ProductRequestDto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Product extends Timestamped {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable = false)
	private String title;

	@Column(nullable = false)
	private String link;

	@Column(nullable = false)
	private String image;

	@Column(nullable = false)
	private int lprice;

	// TODO: 고민. 이 값을 필수로 받아야 하는가? 아니라면 null이 가능하도록 Integer로 바꿀 것인가, 초기값을 -1로 설정할 것인가?
	// -> 스파르타 코딩에선 후자를 택함. default 0으로 생성자에서 넣음
	@Column(nullable = false)
	private int myprice;

	public Product(ProductRequestDto requestDto) {
		this.title = requestDto.getTitle();
		this.image = requestDto.getImage();
		this.link = requestDto.getLink();
		this.lprice = requestDto.getLprice();
		this.myprice = 0;
	}

	// 관심 가격 변경
	public void updateMyprice(ProductMypriceRequestDto requestDto) {
		this.myprice = requestDto.getMyprice();
	}
}
