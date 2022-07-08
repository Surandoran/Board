<%@ page import="com.example.dto.MemberDTO" %><%--
  Created by IntelliJ IDEA.
  User: 손필욱
  Date: 2022-07-07
  Time: 오전 10:21
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
        String MSG = (String) request.getAttribute("MSG");
        if (MSG != null) {
    %>
    <script>
        alert("<%=MSG%>")
    </script>
    <%
        }

    %>
    <%
        MemberDTO dto = (MemberDTO) request.getAttribute("dto");
//            String email = (String) request.getAttribute("email");
//            String addr1 = (String) request.getAttribute("addr1");
//            String addr2 = (String) request.getAttribute("addr2");
    %>
    <div id="maincontents" style="border: 1px solid gray; margin-top: 15px">
        <form action="/MemberUpdate.do" method="post">
            <table class="table w-75 table-striped" style="margin:100px auto">
                <tr>
                    <td><input type="password" name="pwd" class="form-control"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="확인" class="btn btn-primary"></td>
                </tr>
            </table>
            <input type="hidden" name="flag" value="true">
            <input type="hidden" name="addr1" value="<%=request.getParameter("addr1")%>">
            <input type="hidden" name="addr2" value="<%=request.getParameter("addr2")%>">
            <input type="hidden" name="newpwd" value="<%=request.getParameter("pwd")%>">
        </form>
    </div>
    <%--    Footer--%>
</div>
</body>
</html>
