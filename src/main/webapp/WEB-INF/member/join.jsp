<%--
  Created by IntelliJ IDEA.
  User: 손필욱
  Date: 2022-07-05
  Time: 오후 12:11
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
  <div class="container-md" style="width: 60%; margin:100px auto; text-align: center">
    <h1 class="mb-5">회원가입</h1>
    <form action="/MemberJoin.do" method="post">
      <input type="email" name="email" placeholder="example@example.com" class="form-control m-3">
      <input type="password" name="pwd" placeholder="Enter Password" class="form-control m-2">
      <input name="addr1" placeholder="Enter Address1" class="form-control m-2">
      <input type="addr2" placeholder="Enter Address2" class="form-control m-2">
      <input type="submit" value="가입하기" class="btn btn-primary w-100 m-2">
      <input type="reset" value="RESET" class="btn btn-primary w-100 m-2">
      <a href="/" class="btn btn-primary w-100 m-2">이전으로</a>
      <input type="hidden" name="flag" value=true>
    </form>
  </div>
</body>
</html>
