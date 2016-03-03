<%--
  Pattern Partner: Table to preview pattern

  User: Kolya
  Date: 2016-02-27
  Time: 7:21 AM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ page import="com.patternpartner.PatternPreview" %>
<%@ page import="com.patternpartner.JavascriptHandler" %>
<%
    PatternPreview previewer = (PatternPreview) session.getAttribute("previewer");
%>
<table class="table table-hover ">
    <tbody>
    <% int i = 0;
        for (i=0; i<previewer.getLines().size(); i++) { %>
    <tr class="<%= previewer.getLineClass().get(i) %>" id="<%= i %>" onclick="setRow(<%= i %>)">
        <td><% out.print(previewer.getLines().get(i)); %></td>
    </tr>
    <%
    } %>
    </tbody>
</table>

<script>

    function setRow(i) {
        importPackage(Packages.org.mozilla.javascript);
        importClass(Packages.com.patternpartner.PatternPreview);
        var now = new Packages.java.util.Date();
        if (document.getElementById(i).className == "") {
            document.getElementById(i).className = "<%= session.getAttribute("classSet") %>";
            alert(now);
        } else {
            document.getElementById(i).className = "";
            // add to lineClass
        }
    }


</script>

<%--<a href="#" class="btn btn-default btn-lg btn-block" onclick="updateClassArray()">Save Changes</a>--%>
<ul class="pager">
    <li class="previous"><a href="<%= session.getAttribute("lastPage") %>">&larr; Back</a></li>
    <li class="next"><a href="<%= session.getAttribute("nextPage") %>">Next &rarr;</a></li>
</ul>