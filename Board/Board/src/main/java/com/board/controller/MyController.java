package com.board.controller;

import com.board.dao.ICommentDao;
import com.board.dto.CommentDto;
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


    @Autowired
    ICommentDao commentDao;

    // 홈페이지 (게시글 목록으로 리다이렉트)
    @RequestMapping("/")
    public String root() {
        return "redirect:/listForm";
    }


    // 게시글 목록 폼
    @RequestMapping("/listForm")
    public String listForm(Model model) {
        List<BoardDto> list = boardDao.list();
        model.addAttribute("list", list);
        return "listForm"; // listForm.jsp 디스패치 해줌
    }

    // 게시글 작성 폼
    @RequestMapping("/writeForm")
    public String writeForm() {
        return "writeForm"; // writeForm.jsp 디스패치
    }

    // 게시글 작성
    @RequestMapping("/writeAction")
    @ResponseBody  // String을 return 값으로 주기 위해 사용
    public String writeAction(@RequestParam("boardName") String boardName,
                              @RequestParam("boardTitle") String boardTitle,
                              @RequestParam("boardContent") String boardContent) {
        int result = boardDao.write(boardName, boardTitle, boardContent);

        if (result == 1) {
//            System.out.println("글쓰기 성공!");
            return "<script>alert('글쓰기 성공!'); location.href='/listForm'; </script>"; // 성공시 alert창으로 성공 메세지 띄우고 게시글 리스트로 리다이렉트 함
        } else {
//            System.out.println("글쓰기 실패!");
            return "<script>alert('글쓰기 실패!'); location.href='/writeForm'; </script>"; // 실패시 alert창으로 실패 메세지 띄우고 게시글 리스트로 리다이렉트 함
        }
//        return "redirect:/listForm"; // 글 생성하면 게시글 list로 redirect
    }

    // 댓글 작성    
    @RequestMapping("/writeCommentAction")
    @ResponseBody  // String을 return 값으로 주기 위해 사용
    public String writeCommentAction(@RequestParam("commentContent") String commentContent,
                              @RequestParam("commentName") String commentName,
                              @RequestParam("commentBoardId") String commentBoardId) {
        int result = commentDao.comment_write(commentContent, commentName, commentBoardId);

        if (result == 1) {
//            System.out.println("글쓰기 성공!");
//            return "<script>alert('댓글 작성 성공!'); location.href='/listForm'; </script>"; // 성공시 alert창으로 성공 메세지 띄우고 게시글 리스트로 리다이렉트 함
            return "<script>alert('댓글 작성 성공!'); location.href='/contentForm?boardId= "+ commentBoardId + " '; </script>";
        } else {
//            System.out.println("글쓰기 실패!");
            return "<script>alert('댓글 작성 실패!'); location.href='/contentForm?boardId= "+ commentBoardId + " '; </script>"; // 실패시 alert창으로 실패 메세지 띄우고 게시글 리스트로 리다이렉트 함
        }
//        return "redirect:/listForm"; // 글 생성하면 게시글 list로 redirect
    }

    // 게시글 상세 내용 보기
    @RequestMapping("/contentForm")
    public String contentForm(@RequestParam("boardId") String boardId,
                              Model model) {

        boardDao.hit(boardId); // 조회수 증가
        
        // 게시글 보기
        BoardDto dto = boardDao.viewDto(boardId);
        model.addAttribute("dto", dto);

        // 댓글 보기
        List<CommentDto> comment_list = commentDao.comment_list(boardId);
        model.addAttribute("comment_list", comment_list);


        return "contentForm"; // contentForm.jsp 디스패치
    }

    // 게시글 수정
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

    // 게시글 삭제 
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

    // 댓글 삭제
    @RequestMapping("/deleteCommentAction")
    @ResponseBody
    public String deleteCommentAction(@RequestParam("commentId") String commentId,
                                      @RequestParam("boardId") String boardId){

        int result = commentDao.comment_deleteDto(commentId, boardId);

        if (result == 1) {
            System.out.println("댓글 삭제 성공!");
            return "<script>alert('댓글 삭제 성공!'); location.href='/contentForm?boardId= "+ boardId + " '; </script>";

//            return "redirect:/listForm";
        } else {
            System.out.println("댓글 삭제 실패!");
            return "<script>alert('댓글 삭제 실패!'); location.href='/contentForm?boardId= "+ boardId + " '; </script>";
//            return "redirect:/contentForm?boardId=" + boardId;
        }
    }

}
