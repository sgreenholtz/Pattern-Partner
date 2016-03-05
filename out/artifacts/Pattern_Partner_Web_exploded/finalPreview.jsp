<%--
  Pattern Partner: Final Preview

  Note: This page displays the table without any "onclick" function!
  
  User: Kolya
  Date: 2016-02-27
  Time: 8:21 AM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.patternpartner.PatternPreview" %>
<% if (session.getAttribute("preview") != null) { %>
<jsp:include page="header.jsp"/>
<h2>Confirm Changes</h2>
<%
    PatternPreview previewer = (PatternPreview) session.getAttribute("preview");
    int size = previewer.getLines().size();
%>
<table class="table table-hover ">
    <tbody>
    <% int i = 0;
        for (i=0; i<size; i++) { %>
    <tr class="<%= previewer.getLineClass().get(i) %>" id="<%= i %>">
        <td><% out.print(previewer.getLines().get(i)); %></td>
    </tr>
    <%
        } %>
    </tbody>
</table>
<a href="#" class="btn btn-default btn-lg btn-block">Save and Submit</a>
<ul class="pager">
    <li class="previous"><a href="setPatternRows.jsp">&larr; Back</a></li>
</ul>
<jsp:include page="footer.jsp"/>
<% } else {
    response.sendRedirect("addPattern.jsp");
} %>