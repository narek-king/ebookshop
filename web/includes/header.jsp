<%--
  Created by IntelliJ IDEA.
  User: King
  Date: 11/27/2015
  Time: 1:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en-US" xmlns="http://www.w3.org/1999/xhtml" dir="ltr">
<head>
  <title>CSS Free Templates with jQuery Slider</title>
  <meta http-equiv="Content-type" content="text/html; charset=utf-8" />
  <link rel="shortcut icon" href="css/images/favicon.ico" />
  <link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
  <script type="text/javascript" src="http://localhost:8080/js/jquery-1.6.2.min.js"></script>
  <script type="text/javascript" src="http://localhost:8080/js/jquery.jcarousel.min.js"></script>
  <!--[if IE 6]>
  <script type="text/javascript" src="http://localhost:8080/js/png-fix.js"></script>
  <![endif]-->
  <script type="text/javascript" src="http://localhost:8080/js/functions.js"></script>
</head>
<body>
<!-- Header -->
<div id="header" class="shell">
  <div id="logo"><h1><a href="/welcome?page=main">BookShop BestSeller</a></h1><span><a href="#">free css template</a></span></div>
  <!-- Navigation -->
  <div id="navigation">
    <ul>
      <li><a href="/welcome?page=main" class="active">Home</a></li>
      <li><a href="#">Products</a></li>
      <li><a href="#">Promotions</a></li>
      <li><a href="#">Profile</a></li>
      <li><a href="#">About Us</a></li>
      <li><a href="#">Contacts</a></li>
    </ul>
  </div>
  <!-- End Navigation -->
  <div class="cl">&nbsp;</div>
  <!-- Login-details -->
  <div id="login-details">
    <c:choose>
      <c:when test="${empty user}">
        <p><a href = "welcome?page=register">Register </a> or <a href="welcome?page=login" id="login">Login</a></p>
      </c:when>
      <c:when test="${not empty user}">
        <p>Welcome, <a href="#" id="user">${user}</a> | <a href="/LogoutServlet">Log out</a></p>
      </c:when>
    </c:choose>
   <p><a href="#" class="cart" ><img src="css/images/cart-icon.png" alt="" /><a href="/welcome?page=cart">Shopping Cart</a> (${qty}) <a href="#" class="sum">$${price}</a></p>
  </div>
  <!-- End Login-details -->
</div>




<!-- End Header -->
