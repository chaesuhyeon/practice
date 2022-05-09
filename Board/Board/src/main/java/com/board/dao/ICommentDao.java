package com.board.dao;

import com.board.dto.CommentDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ICommentDao {
    public List<CommentDto> comment_list(String commentBoardId);

    public int comment_write(String commentContent, String commentName, String commentBoardId);

    public int comment_deleteDto(String commentId, String boardId);
}
