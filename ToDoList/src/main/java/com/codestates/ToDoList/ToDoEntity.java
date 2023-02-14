package com.codestates.ToDoList;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity

public class ToDoEntity {


    @Id // 기본키로 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  /* 데이터를 저장할 때 해당 속성에 따로 값을 세팅하지 않아도 1씩 자동으로 증가
     strategy 는 고유 번호를 생성하는 옵션
     GenerationType.IDENTITY 는 해당 컬럼만의 독립적인 시퀀스를 생성하여
     번호를 증가시킬 때 사용 */
    private Integer id;

    private Integer todo_order;

    @Column(length=200) // Column 의 세부 설정을 위해 사용
    private String title;

    @Column
    @NotNull
    private Boolean completed;
}
