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

    function init() {
        if (window.XMLHttpRequest) {
            req = new XMLHttpRequest();
        } else if (window.ActiveXObject) {
            req = new ActiveXObject("Microsoft.XMLHTTP");
        }
        var url = "/PatternPartner/PatternPreview";
        req.open("GET", url, true);
        req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    }

    function setRow(i) {
        init();
        if (document.getElementById(i).className == "") {
            document.getElementById(i).className = "<%= session.getAttribute("classSet") %>";
            req.send("class=", "<%= session.getAttribute("classSet") %>");
            req.send("id=", i);
        } else {
            document.getElementById(i).className = "";
            req.send("class=", "");
            req.send("id=", i);
        }
    }


</script>

<%--<a href="#" class="btn btn-default btn-lg btn-block" onclick="updateClassArray()">Save Changes</a>--%>
<ul class="pager">
    <li class="previous"><a href="<%= session.getAttribute("lastPage") %>">&larr; Back</a></li>
    <li class="next"><a href="<%= session.getAttribute("nextPage") %>">Next &rarr;</a></li>
</ul>