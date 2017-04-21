<%--
  Pattern Partner: Registration Attempt
  
  User: Kolya
  Date: 2016-02-20
  Time: 12:58 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.patternpartner.UserVerification" %>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String firstName = request.getParameter("firstName");
    String lastName = request.getParameter("lastName");
    String email = request.getParameter("email");

    UserVerification verify = new UserVerification();

    verify.registerUser(username, password, email, firstName, lastName);
    session.setAttribute("username", username);
    response.sendRedirect("home.jsp");

%>