<%--
  Pattern Partner: Final Preview

  Note: This page displays the table without any "onclick" function!
  
  User: Kolya
  Date: 2016-02-27
  Time: 8:21 AM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<jsp:include page="header.jsp"/>
<h2>Confirm Changes</h2>
<%
    ArrayList<String> lines = (ArrayList<String>) session.getAttribute("lines");
    ArrayList<String> lineClass = (ArrayList<String>) session.getAttribute("lineClass");
%>
<table class="table table-hover ">
    <tbody>
    <% int i = 0;
        for (i=0; i<lines.size(); i++) { %>
    <tr class="<%= lineClass.get(i) %>" id="<%= i %>">
        <td><% out.print(lines.get(i)); %></td>
    </tr>
    <%
        } %>
    </tbody>
</table>
<ul class="pager">
    <li class="previous"><a href="setPatternRows.jsp">&larr; Back</a></li>
    <li class="next disabled"><a href="#">Submit &rarr;</a></li>
</ul>
<jsp:include page="footer.jsp"/>