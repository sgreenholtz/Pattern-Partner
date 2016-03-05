<%--
  Pattern Partner: FAQ and Comments
  
  User: Kolya
  Date: 2016-02-21
  Time: 2:33 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
<% if (session.getAttribute("sandwich") != null) { out.print("sandwich"); } else { out.print("nully"); } %>
<image src="images/meme.jpeg" />
<jsp:include page="footer.jsp"/>