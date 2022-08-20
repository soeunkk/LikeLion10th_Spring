package com.sparta.week01.prac;

import java.util.ArrayList;
import java.util.List;

public class Prac {
	public static void main(String[] args) {
		System.out.println("안녕, 스파르타!");

		String myName = "soeun";

		int a = 1;
		float b = 1.2f;

		System.out.println("a = " + a);
		System.out.println("b = " + b);

		float c = a + b;

		System.out.println("c = " + c);

		// int d = a + b;	// 오류!

		String e = "자바 스프링, 5주 안에 끝낸다!";

		int age = 20;
		boolean isAdult = age > 19;
		boolean isKid = age <= 19;

		// 같은지는 == 으로 확인, 다른지는 != 으로 확인
		boolean isEq = 20 == 20;
		boolean isDiff = 20 != 20;


		// List - add, get, remove
		List<String> newList = new ArrayList<>();
		newList.add("웹개발의 봄 Spring");
		newList.add("프론트엔드의 꽃 Reacr");
		System.out.println("newList = " + newList);
		System.out.println("newList.get(0) = " + newList.get(0));
		System.out.println("newList.get(1) = " + newList.get(1));
		newList.remove(0);
		System.out.println("newList = " + newList);

		// 선언
		String c1 = "웹개발 종합반";
		String c2 = "엡개발 종합반";
		List<String> courseList = new ArrayList<>();
		// 삽입
		courseList.add(c1);
		courseList.add(c2);
		// 확인
		System.out.println("courseList = " + courseList);

		printInfo();


		// 연습퀴즈 - 메소드
		int result = sub(3,1);
		System.out.println(result);


		// 반복문
		List<String> fruits = new ArrayList<>();
		fruits.add("포도");
		fruits.add("바나나");
		fruits.add("사과");
		fruits.add("감");
		fruits.add("딸기");
		fruits.add("오렌지");
		fruits.add("복숭아");

		// 과일 목록 차례대로 인쇄하기
		for (int i = 0; i < fruits.size(); i++) {
			String fruit = fruits.get(i);
			System.out.println("fruit = " + fruit);
		}


		// 연습퀴즈 - 반복문
		List<String> celebs = new ArrayList<>();
		celebs.add("아이유");
		celebs.add("유재석");
		celebs.add("차은우");
		celebs.add("서강준");
		celebs.add("강동원");
		celebs.add("한지민");

		for (String celeb : celebs) {
			System.out.println("celeb = " + celeb);
		}


		// 조건문
		// 미성년자 여부 판단하기
		if (age > 19) {
			System.out.println("성인입니다");
		} else {
			System.out.println("미성년자입니다.");
		}

		// "감" 개수 세는 반복문
		int count = 0;
		for (int i = 0 ; i < fruits.size(); i++) {
			String fruit = fruits.get(i);
			if (fruit == "감") {
				count += 1;
			}
		}
		System.out.println("감 개수: " + count);

		// cf) string 비교 (== vs. equals)
		String s1 = "abcd";
		String s2 = new String("abcd");
		// ==: 주소 값이 같은지 검사 (=동일한 객체를 참조하는가?)
		if (s1 == s2) {
			System.out.println("== 비교 성공");		// 출력되지 않음
		}
		// equals: 데이터 값이 같은지 검사
		if (s1.equals(s2)) {
			System.out.println("equals() 비교 성공");	// 출력됨
		}


		// 연습퀴즈 - 조건문 + 반복문
		countFruit("감");


		// 클래스
		// 생성자 사용하기
		Course course = new Course();
		System.out.println("couese.title = " + course.getTitle());
		System.out.println("course.tutor = " + course.getTutor());
		System.out.println("course.days = " + course.getDays());

		Course course2 = new Course("웹개발의 봄 스프링", "남병관", 35);
		System.out.println("course2.title = " + course2.getTitle());
		System.out.println("course2.tutor = " + course2.getTutor());
		System.out.println("course2.days = " + course2.getDays());

		// getter, setter 사용하기
		course2.setTitle("Spring 공부중");
		course2.setTutor("김소은");
		course2.setDays(10);

		System.out.println("course2.title = " + course2.getTitle());
		System.out.println("course2.tutor = " + course2.getTutor());
		System.out.println("course2.days = " + course2.getDays());
	}

	public static void printInfo() {
		String title = "웹개발의 봄 Spring";
		String tutor = "남병관";
		int weeks = 5;
		float ratings = 5.0f;

		System.out.println("제목: " + title);
		System.out.println("튜터: " + tutor);
		System.out.println("주차: " + weeks);
		System.out.println("별점: " + ratings);
	}

	// 파라미터 X, 반환값 X
	public void simplePrint() {
		System.out.println("파라미터도 없고, 반환값도 없어요!");
	}

	// 파라미터 O, 반환값 X
	public void simpleSum(int num1, int num2) {
		System.out.println("num1: " + num1 + ", num2:" + num2);
	}

	// 파라미터 X, 반환값 O
	public int simpleReturn() {
		return 3;
	}

	// 파라미터 O, 반환값 O
	public int sum(int num1, int num2) {
		return num1 + num2;
	}

	// 연습퀴즈 - 메소드
	public static int sub(int num1, int num2) {
		return num1 - num2;
	}

	// 연습퀴즈 - 조건문 + 반복문
	// 주어진 과일의 개수를 세고 반환하는 메소드
	public static int countFruit(String given) {
		List<String> fruits = new ArrayList<>();
		fruits.add("감");
		fruits.add("배");
		fruits.add("감");
		fruits.add("딸기");
		fruits.add("수박");
		fruits.add("메론");
		fruits.add("수박");
		fruits.add("딸기");
		fruits.add("메론");
		fruits.add("수박");
		fruits.add("메론");
		fruits.add("수박");
		fruits.add("감");

		int count = 0;
		for (String fruit: fruits) {
			if (fruit.equals(given)) count++;
		}
		return count;
	}
}
