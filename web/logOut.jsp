<%--
  Pattern Partner
  
  User: Kolya
  Date: 2016-02-20
  Time: 1:16 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    session.setAttribute("user", null);
    session.invalidate();
    response.sendRedirect("home.jsp");
%>