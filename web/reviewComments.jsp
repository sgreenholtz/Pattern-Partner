<%--
  Review Comments submitted by users on the faq-comments page

  User: Kolya
  Date: 2016-04-03
  Time: 1:33 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.patternpartner.CommentViewer" %>
<%@ page import="java.util.Map" %>
<% if (session.getAttribute("username").equals("skolya")) {
    CommentViewer comments = new CommentViewer();
%>
<jsp:include page="header.jsp" />
<%
    for (Map<String, String> comment : comments.getComments()) {
        out.print(comment.get("name"));
    }
%>
<jsp:include page="footer.jsp" />
<%
    } else {
        response.sendRedirect("logIn.jsp");
    }
%>