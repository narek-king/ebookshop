<%--
  Created by IntelliJ IDEA.
  User: King
  Date: 12/2/2015
  Time: 4:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!-- Slider -->





<!-- End Slider -->
<!-- Main -->
<div id="main" class="shell">
  <!-- Sidebar -->
  <div id="sidebar">
    <ul class="categories">
      <li>
        <h4>Categories</h4>
        <ul>
          <c:forEach items="${categories}" var="curr">
            <li><a href="welcome?page=category&category=${curr.category}">${curr.category}</a></li>
          </c:forEach>

        </ul>
      </li>
      <li>
        <h4>Authors</h4>
        <ul>
          <c:forEach items="${authors}" var="curr">

            <li><a href="welcome?page=author&author=${curr.author}">${curr.author}</a></li>

          </c:forEach>

        </ul>
      </li>
    </ul>
  </div>
  <!-- End Sidebar -->
  <!-- Content -->
  <div id="content">
