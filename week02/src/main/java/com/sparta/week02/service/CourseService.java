package com.sparta.week02.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sparta.week02.domain.Course;
import com.sparta.week02.domain.CourseRepository;
import com.sparta.week02.models.CourseRequestDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CourseService {

	// final: 서비스에게 꼭 필요한 녀석임을 명시
	private final CourseRepository courseRepository;

	// 생성자를 통해 Service 클래스를 만들 때 꼭 Repository를 넣어주도록 스프링에게 알려줌
	// cf) DI 방법 1) Field Injection(변수 위에 Autowired) 2) Setter Injection 3) Constructor Injection
	// Field Injection은 단일 책임 원칙을 위반함 -> XX
	// Setter Injection은 주입되지 않아도 객체 생성이 가능하므로 NullPointerException 발생 가능성이 있음 -> XX
	// Constructor Injection은 필수적으로 사용해야 하는 의존성 없이는 인스턴스를 만들지 못하도록 강제 가능, final 예약어 사용 가능
	// final 사용이 좋은 이유? 객체가 불변하도록 하므로 누군가가 Service 내부에서 Repository 객체를 바꿔치기 할 수 없음
	/*public CourseService(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}*/

	@Transactional // SQL 쿼리가 일어나야 함을 스프링에게 알려줌
	public Long update(Long id, CourseRequestDto courseDto) {
		Course course1 = courseRepository.findById(id).orElseThrow(
			() -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
		);
		course1.update(courseDto);
		return course1.getId();
	}

}
