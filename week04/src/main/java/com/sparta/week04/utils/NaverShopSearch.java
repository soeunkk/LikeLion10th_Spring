package com.sparta.week04.utils;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.sparta.week04.dto.ItemDto;

// Naver shop API reference: https://developers.naver.com/docs/serviceapi/search/shopping/shopping.md#쇼핑-검색-결과-조회
@Component
public class NaverShopSearch {

	private RestTemplate rest;
	private HttpEntity<String> requestEntity;

	public NaverShopSearch() {
		rest = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		// TODO: api key 다시 생성하고 .gitignore에 넣어서 관리하기
		headers.add("X-Naver-Client-Id", "GvI2Iwmtu8Fs5oeESZWa");
		headers.add("X-Naver-Client-Secret", "4kFAhjeecf");
		String body = "";

		requestEntity = new HttpEntity<>(body, headers);
	}

	public List<ItemDto> searchOrderedByAccuracy(String query) {
		ResponseEntity<String> responseEntity = rest.exchange(
				"https://openapi.naver.com/v1/search/shop.json?query=" + query + "&sort=sim",
				HttpMethod.GET,
				requestEntity,
				String.class);

		String resultString = handleResponseResult(responseEntity);
		return fromJSONtoItems(resultString);
	}

	public List<ItemDto> searchOrderedByDate(String query) {
		ResponseEntity<String> responseEntity = rest.exchange(
				"https://openapi.naver.com/v1/search/shop.json?query=" + query + "&sort=date",
				HttpMethod.GET,
				requestEntity,
				String.class);

		String resultString = handleResponseResult(responseEntity);
		return fromJSONtoItems(resultString);
	}

	public List<ItemDto> searchOrderedByPriceAsc(String query) {
		ResponseEntity<String> responseEntity = rest.exchange(
				"https://openapi.naver.com/v1/search/shop.json?query=" + query + "&sort=asc",
				HttpMethod.GET,
				requestEntity,
				String.class);

		String resultString = handleResponseResult(responseEntity);
		return fromJSONtoItems(resultString);
	}

	public List<ItemDto> searchOrderedByPriceDsc(String query) {
		ResponseEntity<String> responseEntity = rest.exchange(
				"https://openapi.naver.com/v1/search/shop.json?query=" + query + "&sort=dsc",
				HttpMethod.GET,
				requestEntity,
				String.class);

		String resultString = handleResponseResult(responseEntity);
		return fromJSONtoItems(resultString);
	}

	public String handleResponseResult(ResponseEntity<String> responseEntity) {
		HttpStatus httpStatus = responseEntity.getStatusCode();
		int status = httpStatus.value();
		String response = responseEntity.getBody();

		if (status == HttpStatus.OK.value()) {
			return response;
		} else if (status == HttpStatus.BAD_REQUEST.value()) {
			throw new IllegalArgumentException("요청 값이 부적절합니다.");
		} else if (status == HttpStatus.NOT_FOUND.value()) {
			throw new NullPointerException("검색 데이터가 존재하지 않습니다.");
		} else {
			throw new RuntimeException();
		}
	}

	public List<ItemDto> fromJSONtoItems(String result) {
		JSONObject resultJson = new JSONObject(result);
		JSONArray items = resultJson.getJSONArray("items");

		List<ItemDto> resultItemDtoList = new ArrayList<>();
		for (int i = 0; i < items.length(); i++) {
			JSONObject itemJson = items.getJSONObject(i);
			System.out.println(itemJson);
			ItemDto itemDto = new ItemDto(itemJson);
			resultItemDtoList.add(itemDto);
		}

		return resultItemDtoList;
	}
}
