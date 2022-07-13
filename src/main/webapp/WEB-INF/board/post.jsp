<%--
  Created by IntelliJ IDEA.
  User: 손필욱
  Date: 2022-07-08
  Time: 오전 9:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <%@include file="/resources/includes/link.jsp" %>
    <link rel="stylesheet" href="resources/css/common.css">

</head>
<body>
<div class="container-md" id="wrapper" style="margin: 100px auto;">
    <%--    TopMenu--%>
    <%@include file="/resources/includes/TopMenu.jsp" %>
    <%--    NAV--%>
    <%@include file="/resources/includes/nav.jsp" %>
    <%--    MainContents--%>
    <div id="maincontents" style=" margin-top: 15px">
        <h1>자유게시판 글쓰기</h1>

        <!-- MainContents -->
        <div>
            <!-- PagePath -->
                <nav style="--bs-breadcrumb-divider: '>';" aria-label="breadcrumb">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="#">Home</a></li>
                        <li class="breadcrumb-item"><a href="#">Board</a></li>
                        <li class="breadcrumb-item active" aria-current="page">Post</li>
                    </ol>
                </nav>
            <h1>글쓰기</h1>
            <form action="/Board/post.do" method="post">
                <input name="title" class="form-control mb-3 w-50" placeholder="글제목">
                <textarea name="content" class="form-control mb-3 w-50" style="height: 500px;"></textarea>
                <input type="password" name="pwd" class="form-control mb-3 w-50" placeholder="패스워드">
                <input type="file" name="files" class="form-control mb-3 w-50" multiple/>
                <input type="submit" value="글쓰기" class="btn btn-primary">
                <input type="hidden" name="flag" value="true">
                <a href="#" class="btn btn-primary">처음으로</a>
            </form>
        </div>

    </div>
    <%--    Footer--%>
</div>
</body>
</html>
