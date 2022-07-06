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
    <% MemberDTO dto = new MemberDTO(); %>
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
            String email = (String) request.getAttribute("email");
            String addr1 = (String) request.getAttribute("addr1");
            String addr2 = (String) request.getAttribute("addr2");
        %>
    <div id="maincontents" style="border: 1px solid gray; margin-top: 15px">
        <table class="table w-75 table-striped" style="margin:100px auto">
            <caption>회원 정보</caption>
            <tr>
                <td>Email</td>
                <td><%=email%></td>
            </tr>
            <tr>
                <td>Addr1</td>
                <td><%=addr1%>></td>
            </tr>
            <tr>
                <td>Addr2</td>
                <td><%=addr2%></td>
            </tr>
            <tr>
                <td>
                    <button type="submit" class="btn btn-primary w-50">정보수정</button>
                </td>
                <td>
                    <button type="button" class="btn btn-secondary w-50">메인이동</button>
                </td>
            </tr>
        </table>
    </div>
    <%--    Footer--%>
</div>
</body>
</html>
