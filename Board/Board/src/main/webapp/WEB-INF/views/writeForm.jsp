<%--
  Created by IntelliJ IDEA.
  User: 채수현
  Date: 2022-04-26
  Time: 오후 4:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시글 작성</title>
</head>
<body>
    <h1>게시글 작성 폼</h1>

    <form action = "writeAction" method="post">

        <table width="500" cellpadding="0" border="1">

            <tr>
                <td>이름</td>
                <td><input type="text" name="boardName" value="" size="50"></td>
            </tr>

            <tr>
                <td>제목</td>
                <td><input type="text" name="boardTitle" value="" size="50"></td>
            </tr>

            <tr>
                <td>내용</td>
                <td>
                    <textarea rows="10" cols="80" name="boardContent"></textarea>
                </td>
            </tr>

            <tr>
                <td colspan="2">
                    <input type="submit" value="글쓰기"> &nbsp;&nbsp;
                    <a href="listForm"><input type="button" value="목록보기"></a>
                </td>

            </tr>

        </table>
    </form>
</body>
</html>
