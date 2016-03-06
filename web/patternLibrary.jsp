<%--
  Pattern Partner: Pattern Library
  
  User: Kolya
  Date: 2016-02-21
  Time: 2:40 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% if (!(session.getAttribute("username") == null || session.isNew())) { %>
<%@ page import="com.patternpartner.ViewPattern" %>
<jsp:include page="header.jsp"/>
<% ViewPattern viewer = new ViewPattern((String) session.getAttribute("username"));


%>
<jsp:include page="footer.jsp"/>
<% } else {
    response.sendRedirect("logIn.jsp");
} %>