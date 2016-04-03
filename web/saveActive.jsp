<%--
  Save Active Row

  User: Kolya
  Date: 2016-03-26
  Time: 8:09 AM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@ page import="com.patternpartner.ViewPattern" %>
<%
    if (!(session.getAttribute("username") == null || session.isNew())) {
        Integer row = new Integer(request.getParameter("active"));
        Integer patternid = new Integer(request.getParameter("id"));

        ViewPattern.updateActiveRowByPatternID(patternid, row);

        response.sendRedirect("patternLibrary.jsp");
    } else {
        response.sendRedirect("logIn.jsp");
    }
%>