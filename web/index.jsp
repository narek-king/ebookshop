<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<c:import url="includes/header.jsp"></c:import>
<%--<jsp:include page="includes/header.jsp" />--%>
<c:choose>
    <c:when test="${page == 'category'}">
        <c:import url="includes/category.jsp"></c:import>
    </c:when>
    <c:when test="${page == 'author'}">
        <c:import url="includes/author.jsp"></c:import>
    </c:when>
    <c:when test="${page == 'register'}">
        <c:import url="includes/register.jsp"></c:import>
    </c:when>
    <c:when test="${page == 'login'}">
        <c:import url="includes/login.jsp"></c:import>
    </c:when>
    <c:when test="${page == 'cart'}">
        <c:import url="includes/cart.jsp"></c:import>
    </c:when>
    <c:otherwise>
        <c:import url="includes/main.jsp"></c:import>
    </c:otherwise>
</c:choose>

<jsp:include page="includes/footer.jsp" />