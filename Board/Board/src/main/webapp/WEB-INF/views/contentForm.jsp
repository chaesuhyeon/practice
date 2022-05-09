<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>글 내용</title>
</head>
<body>

<h2>글 내용</h2>

<form action = "updateAction" method="post">
    <table width="500" cellpadding="0" border="1">

        <input type="hidden" name="boardId" value="${dto.boardId}"/>

    <%--        <input type="hidden" name="boardName" value="${dto.boardName}"/>--%>

        <tr>
            <td>번호</td>
            <td>${dto.boardId}</td>
        </tr>

        <tr>
            <td>조회수</td>
            <td>${dto.boardHit}</td>
        </tr>

        <tr>
            <td>이름</td>
            <td><input type="text" name="boardName" value="${dto.boardName}" size="50"></td>
        </tr>

        <tr>
            <td>제목</td>
            <td><input type="text" name="boardTitle" value="${dto.boardTitle}" size="50"></td>
        </tr>

        <tr>
            <td>내용</td>
            <td>
                <textarea rows="10" cols="50" name="boardContent">${dto.boardContent}</textarea>
            </td>
        </tr>

        <tr>
            <td colspan="2">
                <input type="submit" value="수정하기"> &nbsp;&nbsp;
                <a href="listForm"><input type="button" value="목록보기"></a> &nbsp; &nbsp;
                <a href="deleteAction?boardId=${dto.boardId}"><input type="button" value="삭제하기"></a> &nbsp; &nbsp;
            </td>

        </tr>

    </table>
</form>

    <br>

<form action="writeCommentAction" method="post">
    <table width="500" cellpadding="0" cellspacing="0" border="1">
        <tr>
            <td colspan="2">
                <%-- 무슨 글의 댓글인지 게시글 index hidden으로 넘겨줌 --%>
                <input type="hidden" name="commentBoardId" value="${dto.boardId}">
                <label>댓글</label><textarea rows="2" cols="50" name="commentContent"></textarea><br>
                <label>별명</label><input type="text" name="commentName" value="">
                <input type="submit" value="댓글달기">
            </td>
        </tr>
    </table>

</form>

    <br>

    <table width="500" cellpadding="0" cellspacing="0" border="1">
        <tr>
            <th>별명</th>
            <th>내용</th>
            <th>날짜</th>
            <th>삭제</th>
        </tr>

        <c:forEach var="comment_dto" items="${comment_list}">
        <tr>
            <th>${comment_dto.commentName}</th>
            <th>${comment_dto.commentContent}</th>
            <th>${comment_dto.commentDate}</th>
            <td><a href="deleteCommentAction?commentId=${comment_dto.commentId}&boardId=${dto.boardId}"><button>삭제</button></a></td>
        </tr>
        </c:forEach>
    </table>


<script>
    <%--alert("${dto.boardContent}");--%>
</script>
</body>
</html>

