package com.board.dao;

import com.board.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper // MyBatis와 인터페이스 함수를 연결
public interface IBoardDao {
    public List<BoardDto> list();
    public int write(String boardName, String boardTitle, String boardContent );
}
