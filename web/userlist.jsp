<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/7
  Time: 9:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h2>This is SpringMVC demo page</h2>
  <c:forEach items="${users}">
       <c:out value="${user.username}"/><br/>
       <c:out value="${user.age}"/><br/>
  </c:forEach>
  </body>
</html>
