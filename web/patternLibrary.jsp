<%--
  Pattern Partner: Pattern Library
  
  User: Kolya
  Date: 2016-02-21
  Time: 2:40 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% if (!(session.getAttribute("username") == null || session.isNew())) { %>
<%@ page import="com.patternpartner.ViewPattern" %>
<%@ page import="java.util.*" %>

<jsp:include page="header.jsp"/>
<% ViewPattern viewer = new ViewPattern((String) session.getAttribute("username"));
    Map<Integer, String> titles = viewer.getAllPatternTitles();
    Map<Integer, String> kOrC = viewer.getKnitOrCrochet();

    


%>
<jsp:include page="footer.jsp"/>
<% } else {
    response.sendRedirect("logIn.jsp");
} %>