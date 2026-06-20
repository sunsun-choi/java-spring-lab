package com.kh.code.lab.board.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.kh.code.lab.board.dto.BoardListItemDto;
import com.kh.code.lab.board.dto.BoardListResponseDto;
import com.kh.code.lab.board.dto.BoardSearchCondition;
import com.kh.code.lab.board.mapper.BoardMapper;

@ExtendWith(MockitoExtension.class)
class BoardServiceTest {

    
    @Mock // 실제 DB에 가지 않도록 가짜 Mapper 생성
    private BoardMapper bm;

    
    @InjectMocks // 가짜 Mapper를 서비스에 주입
    private BoardService boardService;

    @Test
    void 게시글목록을_조회하면_닉네임이_마스킹된다() {

        // given
        int cpage = 1;
        Integer categoryNo = 1;

        BoardListItemDto item = mock(BoardListItemDto.class);

        when(item.getNickName())
                .thenReturn("개발하는감자");

        when(bm.selectBoardCount(categoryNo))
                .thenReturn(1);

        when(bm.selectBoardList(any(BoardSearchCondition.class)))
                .thenReturn(List.of(item));

        // when
        BoardListResponseDto result
                = boardService.selectBoardList(cpage, categoryNo);

        // then
        verify(item).setNickName("개발하***");

        assertNotNull(result);
    }
}
