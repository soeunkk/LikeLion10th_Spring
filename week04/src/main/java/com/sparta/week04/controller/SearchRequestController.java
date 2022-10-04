package com.sparta.week04.controller;

import java.security.InvalidParameterException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sparta.week04.dto.ItemDto;
import com.sparta.week04.utils.NaverShopSearch;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class SearchRequestController {

	private final NaverShopSearch naverShopSearch;

	@GetMapping("/api/search")
	public List<ItemDto> searchItems(@RequestParam String query, @RequestParam(required = false) String sort) {
		if (sort == null || sort.equals("sim")) {
			return naverShopSearch.searchOrderedByAccuracy(query);
		} else if (sort.equals("date")) {
			return naverShopSearch.searchOrderedByDate(query);
		} else if (sort.equals("asc")) {
			return naverShopSearch.searchOrderedByPriceAsc(query);
		} else if (sort.equals("dsc")) {
			return naverShopSearch.searchOrderedByPriceDsc(query);
		}

		throw new InvalidParameterException("sort 파라미터에 읽을 수 없는 값이 들어왔습니다.");
	}
}
