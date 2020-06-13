package com.test.book.springboot.web;

import com.test.book.springboot.domain.posts.Posts;
import com.test.book.springboot.domain.posts.PostsRepository;
import com.test.book.springboot.web.dto.PostsSaveRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostsApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PostsRepository repository;

    @After
    public void cleanup(){
        repository.deleteAll();
    }

    @Test
    public void 저장() throws Exception{
        String title= "title";
        String content = "content";

        PostsSaveRequestDto requestDto = PostsSaveRequestDto.builder()
                .content(content)
                .title(title)
                .author("tester")
                .build();

        String url = "http://localhost:"+port+"/api/v1/posts";

        ResponseEntity<Long> entity = restTemplate.postForEntity(url,requestDto,Long.class);

        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);

        List<Posts> list = repository.findAll();

        assertThat(list.get(0).getContent()).isEqualTo(content);

    }
}
