package com.test.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

//Posts클래스로 Database를 접근하게 해줄 JpaRepository
//JpaRepository<Entity클래스,Pk타입>
//기본적인 CRUD메소드가 자동으로 생성
//Entity클래스와 함께 위치해야한다
public interface PostsRepository extends JpaRepository<Posts,Long> {
}
