<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<c:import url="includes/sidebar.jsp"></c:import>
<div class="products">
<c:if test="${param.result == 'fail'}">
    <p style="color:red;">Either user name or password is wrong.</p>
    <p>Tray again or <a href="welcome?page=register">Register</a></p>
</c:if>
<form action="LoginServlet" method="post">

    Username: <input type="text" name="user">
    <br>
    Password: <input type="password" name="pwd">
    <br>
    <input type="submit" value="Login">

    </form>
    </div>
