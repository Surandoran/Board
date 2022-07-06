<%--
  Created by IntelliJ IDEA.
  User: 손필욱
  Date: 2022-07-06
  Time: 오전 9:30
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
    <div id="maincontents" style="border: 1px solid gray; margin-top: 15px">

    </div>
    <%--    Footer--%>
</div>
</body>
</html>
