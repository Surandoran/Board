<%@ page import="com.example.dto.MemberDTO" %><%--
  Created by IntelliJ IDEA.
  User: 손필욱
  Date: 2022-07-06
  Time: 오후 12:38
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
    <%
        MemberDTO dto = (MemberDTO) request.getAttribute("dto");
//            String email = (String) request.getAttribute("email");
//            String addr1 = (String) request.getAttribute("addr1");
//            String addr2 = (String) request.getAttribute("addr2");
    %>
    <div id="maincontents" style="border: 1px solid gray; margin-top: 15px">
        <form action="/MemberUpdate.do" method="post">
            <table class="table w-75 table-striped" style="margin:100px auto">
                <caption>회원 정보</caption>
                <tr>
                    <td>Email</td>
                    <td><input name="email" value="<%=dto.getEmail()%>" disabled></td>
                </tr>
                <tr>
                    <td>Addr1</td>
                    <td><input name="addr1" value="<%=dto.getAddr1()%>"></td>
                </tr>
                <tr>
                    <td>Addr2</td>
                    <td><input name="addr2" value="<%=dto.getAddr2()%>"></td>
                </tr>
                <tr>
                    <td>password</td>
                    <td><input name="pwd" type="password" value="<%=dto.getPwd()%>"></td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="정보수정" class="btn btn-primary w-50">
                    </td>
                    <td>
                        <a class="btn btn-secondary w-50">메인이동</a>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <%--    Footer--%>
</div>
</body>
</html>
