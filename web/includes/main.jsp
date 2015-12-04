<%--
  Created by IntelliJ IDEA.
  User: King
  Date: 11/27/2015
  Time: 1:52 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<c:import url="includes/slider.jsp"></c:import>
<c:import url="includes/sidebar.jsp"></c:import>
          <!-- Products -->
          <div class="products">
            <h3>Featured Products ${page}</h3>
            <ul>
              <c:forEach items="${book}" var="current">
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
                      <form method="post" action="/welcome">
                          <input type="hidden" name="book_id" value="${current.id}">
                    <a href="#" class="buy-btn"><input type="submit" value="BUY NOW">!<span class="price"><span class="low">
                        $</span>${current.price}<span class="high"></span></span></a></form>
                  </div>
                </li>
              </c:forEach>
           </ul>
            <!-- End Products -->
          </div>
