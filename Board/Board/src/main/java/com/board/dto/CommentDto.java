package com.board.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CommentDto {

    private int commentId;

    private String commentName;

    private String commentContent;

    private LocalDate commentDate;

    private int commentBoardId;

    public CommentDto() {

    }

    public CommentDto(int commentId, String commentName, String commentContent, LocalDate commentDate, int commentBoardId) {
        this.commentId = commentId;
        this.commentName = commentName;
        this.commentContent = commentContent;
        this.commentDate = commentDate;
        this.commentBoardId = commentBoardId;
    }
}
