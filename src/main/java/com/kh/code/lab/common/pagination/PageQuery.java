package com.kh.code.lab.common.pagination;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PageQuery {
	
	private int startRow;
    private int endRow;
    
}
