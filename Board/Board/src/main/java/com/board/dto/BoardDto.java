package com.board.dto;

import lombok.Data;

import java.time.LocalDate;

@Data // lombok 연결
public class BoardDto {

    private int boardId;
    private String boardName;
    private String boardTitle;
    private String boardContent;
    private LocalDate boardDate;
    private int boardHit;

    public BoardDto() { //생성자

    }

    public BoardDto(int boardId, String boardName, String boardTitle, String boardContent, LocalDate boardDate, int boardHit) {
        this.boardId = boardId;
        this.boardName = boardName;
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.boardDate = boardDate;
        this.boardHit = boardHit;
    }
}
