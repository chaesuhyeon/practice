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
    @ResponseBody  // String을 return 값으로 주기 위해 사용
    public String writeAction(@RequestParam("boardName") String boardName,
                              @RequestParam("boardTitle") String boardTitle,
                              @RequestParam("boardContent") String boardContent) {
        int result = boardDao.write(boardName, boardTitle, boardContent);

        if (result == 1) {
//            System.out.println("글쓰기 성공!");
            return "<script>alert('글쓰기 성공!'); location.href='/listForm'; </script>";
        } else {
//            System.out.println("글쓰기 실패!");
            return "<script>alert('글쓰기 실패!'); location.href='/writeForm'; </script>";
        }
//        return "redirect:/listForm"; // 글 생성하면 게시글 list로 redirect
    }


    @RequestMapping("/contentForm")
    public String contentForm(@RequestParam("boardId") String boardId,
                              Model model) {
        BoardDto dto = boardDao.viewDto(boardId);
        model.addAttribute("dto", dto);
        System.out.println(dto);
        return "contentForm"; // contentForm.jsp 디스패치
    }

    @RequestMapping("/updateAction")
    @ResponseBody
    public String updateAction(@RequestParam("boardId") String boardId,
                               @RequestParam("boardName") String boardName,
                               @RequestParam("boardTitle") String boardTitle,
                               @RequestParam("boardContent") String boardContent) {
        int result = boardDao.updateDto(boardId, boardName, boardTitle, boardContent);

        if (result == 1) {
            System.out.println("수정 성공!");
            return "<script>alert('수정 성공!'); location.href='/listForm'; </script>";
//            return "redirect:/listForm";
        } else {
            System.out.println("수정 실패!");
            return "<script>alert('수정 실패!'); location.href='/contentForm?boardId= "+ boardId + " '; </script>";
//            return "redirect:/contentForm?boardId=" + boardId;
        }
//        return "redirect:/listForm"; // 글 생성하면 게시글 list로 redirect
    }

    @RequestMapping("/deleteAction")
    @ResponseBody
    public String deleteAction(@RequestParam("boardId") String boardId){

        int result = boardDao.deleteDto(boardId);

        if (result == 1) {
            System.out.println("삭제 성공!");
            return "<script>alert('삭제 성공!'); location.href='/listForm'; </script>";

//            return "redirect:/listForm";
        } else {
            System.out.println("삭제 실패!");
            return "<script>alert('삭제 실패!'); location.href='/contentForm?boardId= "+ boardId + " '; </script>";
//            return "redirect:/contentForm?boardId=" + boardId;
        }
    }

}
