package com.sparta.week02.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * extends JpaRepository<Entity, PK>
 *
 * @Repository 생략 가능
 * save(S): 새로운 엔티티 저장(insert), 이미 있는 엔티티라면 병합(update)
 * delete(T): 삭제
 * findById(id): id를 통해 엔티티 조회
 * getOne(id): 엔티티를 프록시로 조회
 * findAll(..): 모든 엔티티 조회 (paging, sorting 가능)
 * count(): 엔티티 개수
  */
public interface CourseRepository extends JpaRepository<Course,Long> {
}
