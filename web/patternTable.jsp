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
    <tbody>
    <% int i = 0;
        for (i=0; i<lines.size(); i++) { %>
    <tr class="<%= lineClass.get(i) %>" id="<%= i %>" onclick="setRow(<%= i %>)">
        <td><% out.print(lines.get(i)); %></td>
    </tr>
    <%
    } %>
    </tbody>
</table>

<script>
    var rowChanges = [];
    function setRow(i) {
        if (document.getElementById(i).className == "") {
            document.getElementById(i).className = "<%= session.getAttribute("classSet") %>";
            rowChanges[i] = "<%= session.getAttribute("classSet") %>";
        } else {
            document.getElementById(i).className = "";
            rowChanges[i] = "";
        }
    }
</script>
<ul class="pager">
    <li class="previous"><a href="setMaterials.jsp">&larr; Back</a></li>
    <li class="next"><a href="setPatternRows.jsp">Next &rarr;</a></li>
</ul>
<% lineClass.set(i, (String) session.getAttribute("classSet")); %>