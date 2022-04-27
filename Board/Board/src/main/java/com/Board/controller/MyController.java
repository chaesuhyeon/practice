package com.board.controller;

import com.board.dao.IBoardDao;
import com.board.dto.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    IBoardDao boardDao;

    @RequestMapping("/")
    public String root() {
        return "redirect:/listForm";
    }


    @RequestMapping("/listForm")
    public String listForm(Model model) {
        List<BoardDto> list = boardDao.list();
        model.addAttribute("list", list);
        return "listForm"; // listForm.jsp 디스패치 해줌
    }

    @RequestMapping("/writeForm")
    public String writeForm() {
        return "writeForm"; // writeForm.jsp 디스패치
    }

    @RequestMapping("/writeAction")
    public String writeAction(@RequestParam("boardName") String boardName,
                              @RequestParam("boardTitle") String boardTitle,
                              @RequestParam("boardContent") String boardContent)

    {
        int result = boardDao.write(boardName,boardTitle, boardContent );

        if (result ==1) {
            System.out.println("글쓰기 성공!");
        } else {
            System.out.println("글쓰기 실패!");
        }
        return "redirect:/listForm"; // 글 생성하면 게시글 list로 redirect
    }

} 
