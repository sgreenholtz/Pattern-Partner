<%--
  User: Kolya
  Date: 2016-03-03
  Time: 2:45 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
<%@ page import="com.patternpartner.RhinoTest" %>
<%
    RhinoTest previewer = (RhinoTest) session.getAttribute("rhino");
    for (int i=0; i<previewer.getLineClass().size(); i++) {
        out.println(request.getParameter("a" + i));
    }

%>


<jsp:include page="footer.jsp"/>