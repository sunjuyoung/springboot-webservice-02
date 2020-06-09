package com.test.book.springboot.web.dto;


import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void 롭목테스트(){
        String name = "test";
        int amount = 10000;

        HelloResponseDto dto = new HelloResponseDto(name,amount);

        //assertThat: 테스트 검증 라이브러리 검증 메소드
        //isEqualTo : assertj의 동등 비교 메소드, assertThat에 있는 값과 비교해서 같은 때만 성공
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
