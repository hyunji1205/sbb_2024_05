package com.sbs.sbb;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity // answer 테이블
public class Answer {
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Integer id;

    @Column(columnDefinition = "TEXT") // text
    private String content;

    private LocalDateTime createDate;


    // Many = Answer, One = Question
    // @ManyToOne 필수
    @ManyToOne
    private Question question;
    // private Integer questionId;

    // mappedBy Answer 클래스의 question 변수 이름을 적어야 한다.
    // CascadeType.REMOVE를 하면 Question을 삭제할 때 답변도 함께 삭제된다.
    // OneToMany는 테이블의 컬럼으로 생성되지 않는다.
    // @OneToMany 선택
    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answerList;
}