package com.example.week02_hw.domain;

public enum Gender {
	WOMAN("여자"),
	MAN("남자");

	private final String value;

	Gender(String value) {
		this.value = value;
	}

	public String getValue() { return value; }
}
