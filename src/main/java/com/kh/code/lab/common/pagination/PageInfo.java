package com.kh.code.lab.common.pagination;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
public class PageInfo {

	private int listCount;
    private int currentPage;
    private int pageBarSize;	// 화면 하단 페이지 번호 개수
    private int pageSize;		// 한 페이지의 데이터 개수
    private int maxPage;
    private int startPage;
    private int endPage;

}
