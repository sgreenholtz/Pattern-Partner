<%--
  User: Kolya
  Date: 2016-03-03
  Time: 2:45 PM
--%>
<%@ page import="com.patternpartner.PatternPreview" %>
<%
    PatternPreview previewer = (PatternPreview) session.getAttribute("previewer");
%>
<%
    for (int i=0; i<previewer.getLineClass().size(); i++) {
        previewer.getLineClass().set(i, request.getParameter("a" + i));
    }

    response.sendRedirect(request.getParameter("nextPage"));
%>