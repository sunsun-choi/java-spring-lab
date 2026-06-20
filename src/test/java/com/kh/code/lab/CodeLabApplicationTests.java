package com.kh.code.lab;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.code.lab.board.controller.BoardController;
import com.kh.code.lab.board.dto.BoardListItemDto;
import com.kh.code.lab.board.dto.BoardListResponseDto;
import com.kh.code.lab.board.service.BoardService;

@SpringBootTest
class CodeLabApplicationTests {

	@Autowired
	BoardService bs;
	@Autowired
	BoardController bc;
	
	
	
	@Test
    void 게시글목록조회_테스트() {

        BoardListResponseDto result
                = bs.selectBoardList(1, null);
        
        
        System.out.println("result null 여부: " + (result == null));
        System.out.println("게시글 개수: " + result.getBoardListItem().size());

        for (BoardListItemDto d : result.getBoardListItem()) {
            System.out.println("닉네임: " + d.getNickName());
        }
        
    }
	
	
	
	
	@Test
	void contextLoads() {
		
		
	
		
		
	}
	
	

}
