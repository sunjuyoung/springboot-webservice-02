package com.test.book.springboot.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository repository;

    @After
    public void cleanup(){
        repository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기(){
        String title="테스트 제목";
        String content = "테스트 내용";

        //insert or update 쿼리를 실행
        //id값이 없다면 insert
        repository.save(Posts.builder().title(title).content(content)
        .author("tester").build());


        List<Posts> list = repository.findAll(); //테이블 posts에있는 모든 테이블 조회메소드

        Posts posts = list.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);


    }
}
