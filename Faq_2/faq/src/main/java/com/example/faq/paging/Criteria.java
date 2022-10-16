package com.example.faq.paging;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * packageName : com.example.dongsungsi.paging
 * fileName : Criteria
 * author : ds
 * date : 2022-06-13
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-06-13         ds          최초 생성
 */
@Setter
@Getter
@ToString
public class Criteria {

    private Integer page;
    private Integer size;

    private Integer totalItems;

    private Integer totalPages;

    private String  title;

    private String id;

    public Criteria() {
        this.page = 0;
        this.size = 3;
    }
}










