package com.example.faq.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Faq {

    private Long id;

    private String title;

    private String content;

    private String writer;

    private String deleteYn;

    private String insertTime;

    private String updateTime;

    private String deleteTime;

}
