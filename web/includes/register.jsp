<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%--
  Created by IntelliJ IDEA.
  User: King
  Date: 12/2/2015
  Time: 1:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:import url="includes/sidebar.jsp"></c:import>
<div id="register">
  <h3>Registration is not avilabale yet</h3>
  <form action="/register" method="post">

    Username: <input type="text" name="user">
    <br>
    Password: <input type="password" name="pwd">
    <br>
    <input type="submit" value="Login">

  </form>
</div>