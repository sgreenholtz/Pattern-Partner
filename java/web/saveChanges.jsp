<%--
  Pattern Partner: Save Changes to Pattern Table

  User: Kolya
  Date: 2016-03-03
  Time: 2:45 PM
--%>
<% if (session.getAttribute("preview") != null) { %>
<%@ page import="com.patternpartner.PatternPreview" %>
<%
    PatternPreview previewer = (PatternPreview) session.getAttribute("preview");
%>
<%
    for (int i=0; i<previewer.getLineClass().size(); i++) {
        previewer.getLineClass().set(i, request.getParameter("a" + i));
    }

    response.sendRedirect(request.getParameter("nextPage"));
%>
<% } else {
    response.sendRedirect("addPattern.jsp");
    } %>