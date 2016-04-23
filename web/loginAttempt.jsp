<%--
  Pattern Partner: Login Attempt
  
  User: Kolya
  Date: 2016-02-20
  Time: 11:44 AM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.patternpartner.UserVerification" %>
<jsp:include page="header.jsp" />

<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    UserVerification verify = new UserVerification(username, password);
    if (verify.checkExistingUser()) {
        session.setAttribute("username", username);
        response.sendRedirect("home.jsp");
    } else {
%>

<a href="login" class="btn btn-primary">Try Loggin In Again</a>
<a href="register.jsp" class="btn btn-success">Register New User</a>

<% } %>

<jsp:include page="footer.jsp" />