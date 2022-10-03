package com.sparta.week04.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sparta.week04.domain.Product;
import com.sparta.week04.domain.ProductRepository;
import com.sparta.week04.dto.ProductMypriceRequestDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductService {

	private final ProductRepository productRepository;

	@Transactional
	public Long update(long id, ProductMypriceRequestDto requestDto) {
		Product product = productRepository.findById(id).orElseThrow(
				() -> new NullPointerException("해당 아이디가 존재하지 않습니다.")
		);
		product.updateMyprice(requestDto);
		return id;
	}
}
