package com.test.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//실제 DB테이블과 매칭될 클래스,Entity 클래스
//Entity클래스는 Setter메서드를 만들지않는다
//필드의 값 변경이 필요하면 그 목적과 의도를 나타내는 메소드를 추가한다
@Getter
@NoArgsConstructor  //기본 생성자
@Entity
public class Posts {

    @Id  //PK필드 명시
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    private Long id;

    //테이블 컬럼,굳이 선언하지 않더라도 해당 클래스 모든 필드는 컬럼이 된다
    @Column(columnDefinition = "TEXT",length = 500,nullable = false)
    private String content;


    private String author;

    @Column(length = 50,nullable = false)
    private String title;

    @Builder
    public Posts(String title,String author ,String content){
        this.title=title;
        this.content=content;
        this.author=author;
    }
    //생성자 대신 Builder를 사용



    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

}
