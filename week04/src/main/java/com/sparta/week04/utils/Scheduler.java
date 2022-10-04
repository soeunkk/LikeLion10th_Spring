package com.sparta.week04.utils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sparta.week04.domain.Product;
import com.sparta.week04.domain.ProductRepository;
import com.sparta.week04.dto.ItemDto;
import com.sparta.week04.service.ProductService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class Scheduler {

	private final ProductRepository productRepository;
	private final ProductService productService;
	private final NaverShopSearch naverShopSearch;

	// 초, 분, 시, 일, 월, 주 순서
	@Scheduled(cron="0 0 1 * * *")
	public void updatePrice() throws InterruptedException {
		System.out.println("가격 업데이트 실행");
		// 저장된 모든 관심상품 조회
		List<Product> productList = productRepository.findAll();
		for (int i = 0; i < productList.size(); i++) {
			TimeUnit.SECONDS.sleep(1);	// 1초에 한 상품씩 조회 (naver 제한)

			Product p = productList.get(i);

			String title = p.getTitle();
			List<ItemDto> itemDtoList = naverShopSearch.searchOrderedByAccuracy(title);
			ItemDto itemDto = itemDtoList.get(0);	// 첫 번째 결과만 꺼내기

			long id = p.getId();
			productService.updateByService(id, itemDto);
		}
	}

}
