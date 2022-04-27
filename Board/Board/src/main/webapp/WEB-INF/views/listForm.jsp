<%--
  Created by IntelliJ IDEA.
  User: 채수현
  Date: 2022-04-26
  Time: 오전 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>

    <style>
         * {
            margin : 0 auto;,
            padding: 0 auto;,
            overflow: hidden;

         }

         td,h2 {
             text-align: center;
         }
    </style>
</head>
<body>
    <h2>게시글 목록</h2>
    <table width = "500" cellpadding="0" border="1">
        <tr>
            <th>번호</th>
            <th>이름</th>
            <th>제목</th>
            <th>날짜</th>
            <th>조회수</th>
        </tr>


        <c:forEach var="dto" items="${list}">
            <tr>
                <td>${dto.boardId}</td>
                <td>${dto.boardName}</td>

                <td>
                    <a href="contentForm?boardId=${dto.boardId}" > ${dto.boardTitle} </a>

                </td>

                <td>
                        ${dto.boardDate}
<%--                    <c:set var= 'dateVar' value="${dto.boardDate}" />--%>
<%--                    <fmt:formatDate value="${dateVar}" pattern="yyyy-MM-dd HH:mm:ss"/>--%>
                </td>

                <td>${dto.boardHit}</td>
            </tr>
        </c:forEach>

        <tr>
            <td colspan="5"> <a href="writeForm">글 작성</a></td>
        </tr>
    </table>
</body>
</html>
