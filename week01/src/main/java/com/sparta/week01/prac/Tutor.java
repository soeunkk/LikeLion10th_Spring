package com.sparta.week01.prac;

// 연습퀴즈 - 클래스 & 메소드
public class Tutor {
	private String name;
	private String bio;

	// 기본생성자
	public Tutor() {}

	// 생성자
	public Tutor(String name, String bio) {
		this.name = name;
		this.bio = bio;
	}

	// Getter
	public String getName() {
		return name;
	}

	public String getBio() {
		return bio;
	}

	// Setter
	public void setName(String name) {
		this.name = name;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}
}
