package com.test.book.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest
public class HelloControllerTest {

    @Autowired
    //이 클래스를 통해 HTTP,GET,POST등 웹 API를 테스트할 수 있다.
    private MockMvc mvc;

    @Test
    public void hello리턴()throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello")) //hello 주소로 HTTP GET요청
                .andExpect(status().isOk())     //mvc.perform 결과 검증, HTTP 헤더 status검증, OK는 200인지 확인
                .andExpect(content().string(hello)); //응답 본문의 내용을 검증,hello리턴 값 확인
    }


    @Test
    public void helloDto리턴()throws Exception{
        String name = "test";
        int amount = 10000;

        mvc.perform(get("/hello/dto").param("name",name).param("amount",String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(name))
                .andExpect(jsonPath("$.amount").value(amount));
        //jsonPath : JSON응답값을 필드별로 검증
        //$기준으로 필드명을 명시
    }
}
