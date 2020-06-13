package com.test.book.springboot.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsResponseDto {
    private String title;
    private String content;
    private String author;
    private Long id;

    public PostsResponseDto(String title, String content, String author, Long id) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.id = id;
    }
}
