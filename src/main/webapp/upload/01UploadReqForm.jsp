<%--
  Created by IntelliJ IDEA.
  User: 손필욱
  Date: 2022-07-13
  Time: 오후 12:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
    Multipart
    클라이언트에서 서버로 페이지 요청시 업로드 파일을 포함하는 경우에
    Post방식으로 body에 파일들을 나누어서 처리해야 한다
    이때 여러 request에 나눠진 body들을 서버로 전달되기 위해서
    multipart/form-data 옵션을 적용한다
--%>

<form action="/upload1" method="post" enctype="multipart/form-data">
    Upload's file : <input type="file" name="test">
    <input type="submit" value="upload">
</form>

</body>
</html>
