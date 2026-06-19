package com.kh.code.lab.common.pagination;


public final class Pagination {
	
	// static 전용 클래스는 private 생성자로 자바의 자동 객체 생성을 막는다.
	private Pagination() {}
	
	// ================================= [Pagination] ====
	//  common.pagination
	//	├─ PageQuery      	: DB 조회 범위
	//  ├─ PaginationPolicy	: 페이징 계산 규칙(enum)
	//	├─ PageCondition  	: 페이징 계산 입력값
	//	├─ PageInfo       	: 화면 반환값
	//	└─ Pagination     	: 계산 담당
	//  ===================================================
	
	public static PageQuery createPageQuery(int currentPage, int boardLimit) {
		
		int startRow = (currentPage - 1) * boardLimit + 1;
        int endRow = startRow + boardLimit - 1;
          
        PageQuery page = PageQuery.builder()
    							  .startRow(startRow)
    							  .endRow(endRow)
    							  .build();

        return page;
	}

		
	public static PageInfo createPageInfo(PageCondition pageCondition) {
		
		
	    int maxPage = (int) Math.ceil(
	            (double) pageCondition.getListCount()
	                    / pageCondition.getPageSize()
	    );

	    int startPage =
	            ((pageCondition.getCurrentPage() - 1)
	               / pageCondition.getPageBarSize())
	            * pageCondition.getPageBarSize() + 1;

	    int endPage = Math.min(startPage + pageCondition.getPageBarSize() - 1
				             , maxPage);
	    
		  
	    PageInfo pageInfo = PageInfo.builder()
							        .currentPage(pageCondition.getCurrentPage())
							        .listCount(pageCondition.getListCount())
							        .pageBarSize(pageCondition.getPageBarSize())
							        .pageSize(pageCondition.getPageSize())
							        .maxPage(maxPage)
							        .startPage(startPage)
							        .endPage(endPage)
							        .build();

        return pageInfo;

	}

}
