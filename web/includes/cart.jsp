<%--
  Created by IntelliJ IDEA.
  User: King
  Date: 12/1/2015
  Time: 10:55 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<c:import url="includes/sidebar.jsp"></c:import>
<!-- Products -->
<div class="products">
  <h3>Dear ${user} Here is Your Shopping Cart</h3>
  <ul>
    <c:forEach items="${cart}" var="current">
      <li>
        <div class="product">
          <a href="#" class="info">
								<span class="holder">
									<img src="css/images/${current.image}" alt="" />
									<span class="book-name">${current.title}</span>
									<span class="author">${current.author}</span>
									<span class="description">Quantity we have <br />${current.qty}</span>
								</span>
          </a>
          <form method="post" action="/delete">
            <input type="hidden" name="book_id" value="${current.id}">
            <a href="#" class="buy-btn"><input type="submit" value="DELETE">!<span class="price"><span class="low">$</span>${current.price}<span class="high"></span></span></a></form>
        </div>
      </li>
    </c:forEach>
  </ul>
  <div style="clear: both"></div>

  <c:if test="${qty > 0}">
  <div>


    <p>
      <h4>Total Price: $${price}</h4>
      <h4>Total books: ${qty}</h4>
    </p>
    <p>  &nbsp; <br></p>
    <form method="post" action="/order">
      <input type="hidden" name="user" value="${user}">
      <input style="width: 100px; height: 30px;" type="submit" value="ORDER">
    </form>

  </div>
  </c:if>
  <!-- End Products -->
</div>

