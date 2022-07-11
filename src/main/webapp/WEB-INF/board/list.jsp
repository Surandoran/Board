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
<div class="container-md" id="wrapper" style="width: 80%; margin: 100px auto;">
    <%--    TopMenu--%>
    <%@include file="/resources/includes/TopMenu.jsp" %>
    <%--    NAV--%>
    <%@include file="/resources/includes/nav.jsp" %>
    <%--    MainContents--%>
    <div id="maincontents" style="margin-top: 15px">
<%--        PagePath--%>
        <div>
            <nav style="--bs-breadcrumb-divider: '>';" aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="#">Home</a></li>
                    <li class="breadcrumb-item active" aria-current="page">Board</li>
                </ol>
            </nav>
        </div>
        <h1>자유 게시판</h1>
        <table class="table">
            <tr>
                <td style="border: 0px">1/100 Page</td>
                <td style="border: 0px; text-align: right">
                    <button class="btn btn-secondary">처음으로</button>
                    <button class="btn btn-secondary">글쓰기</button>
                </td>
            </tr>
        </table>

        <table class="table">
            <tr>
                <th>No</th>
                <th>TITLE</th>
                <th>WRITER</th>
                <th>RegDate</th>
                <th>Count</th>
            </tr>

            <%@page import="java.util.*, com.example.dto.*" %>
            <%
                ArrayList<BoardDTO>list = (ArrayList<BoardDTO>) request.getAttribute("list");
                for (int i = 0; i < list.size(); i++) {


            %>
            <tr>
                <td><%=list.get(i).getNo()%></td>
                <td><%=list.get(i).getTitle()%>></td>
                <td><%=list.get(i).getWriter()%></td>
                <td><%=list.get(i).getRegdate()%>></td>
                <td><%=list.get(i).getCount()%></td>
            </tr>
            <%
                }
            %>
            <tr>
                <td>2</td>
                <td>글제목2</td>
                <td>작성자2</td>
                <td>2022-07-11</td>
                <td>1</td>
            </tr>
            <tr>
                <td>3</td>
                <td>글제목3</td>
                <td>작성자3</td>
                <td>2022-07-11</td>
                <td>1</td>
            </tr>
            <tr>
<%--                페이지네이션--%>
                <td colspan="5">
                    <nav aria-label="Page navigation example">
                        <ul class="pagination">
                            <li class="page-item">
                                <a class="page-link" href="#" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                            <li class="page-item"><a class="page-link" href="#">1</a></li>
                            <li class="page-item"><a class="page-link" href="#">2</a></li>
                            <li class="page-item"><a class="page-link" href="#">3</a></li>
                            <li class="page-item">
                                <a class="page-link" href="#" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </ul>
                    </nav>
                </td>
            </tr>
        </table>
        <a href="/Board/post.do">글쓰기</a>
    </div>
    <%--    Footer--%>
</div>
</body>
</html>
