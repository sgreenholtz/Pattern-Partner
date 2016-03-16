<%--
  
  Pattern Partner: View Pattern

  User: Kolya
  Date: 2016-03-12
  Time: 1:50 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.patternpartner.ViewPattern" %>
<% if (!(session.getAttribute("username") == null || session.isNew())) { %>
<jsp:include page="header.jsp"/>
<%
    String title = request.getParameter("title");
    Integer id = Integer.parseInt(request.getParameter("id"));
    String knitOrCrochet = request.getParameter("korc");
    ViewPattern viewer = new ViewPattern((String) session.getAttribute("username"));
%>
    <h1><% out.print(title); %></h1>
    <%--Right here goes all the lines in a table--%>
<jsp:include page="footer.jsp"/>
<%
} else {
    response.sendRedirect("logIn.jsp");
}
%>