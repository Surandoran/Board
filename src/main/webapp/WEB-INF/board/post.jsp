<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/resources/includes/link.jsp" %>
    <link rel="stylesheet" href="/resources/css/common.css">
</head>
<body>
<div class="contanier-md" id="wrapper" style="margin:100px auto;">
    <!-- TopMenu -->
    <%@include file="/resources/includes/topmenu.jsp" %>
    <!-- Nav -->
    <%@include file="/resources/includes/nav.jsp" %>
    <!-- MainContents -->
    <div id="maincontents" style="margin-top:15px;">
        <nav style="--bs-breadcrumb-divider: '>';" aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="#">Home</a></li>
                <li class="breadcrumb-item active"><a href="#">board</a></li>
                <li class="breadcrumb-item active" aria-current="page">Post</li>
            </ol>
        </nav>
    </div>
    <h1>글쓰기</h1>
    <form action="/Board/post.do" method ="post" enctype = "multipart/form-data">
        <input name = title class = "form-control mb-3 w-50" placeholder="Title">
        <textarea name = "content"  class = "form-control mb-3 w-50" style= "height:500px;"></textarea>
        <input type = password name = pwd class = "form-control mb-3 w-50" placeholder="Enter Password">
        <input type=file name =files multiple/ class = "form-control mb-3 w-50">
        <input type = submit name ="글쓰기" class = "btn btn-primary">
        <input type="hidden" name="flag" value="true">
        <a href="" class = "btn btn-primary">처음으로</a>
    </form>
    <!-- Footer -->
</div>

</body>
</html>
