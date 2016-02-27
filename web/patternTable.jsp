<%--
  Pattern Partner: Table to preview pattern

  User: Kolya
  Date: 2016-02-27
  Time: 7:21 AM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%
    ArrayList<String> lines = (ArrayList<String>) session.getAttribute("lines");
    ArrayList<String> lineClass = (ArrayList<String>) session.getAttribute("lineClass");
%>
<table class="table table-hover ">
    <thead>
    <tr>
        <th><%= session.getAttribute("title") %></th>
    </tr>
    </thead>
    <tbody>
    <%  int i = 0;
        for (String line : lines) { %>
    <tr class="<%= lineClass.get(i) %>">
        <td><% out.print(line); %></td>
    </tr>
    <%   i++;
    } %>
    </tbody>
</table>
