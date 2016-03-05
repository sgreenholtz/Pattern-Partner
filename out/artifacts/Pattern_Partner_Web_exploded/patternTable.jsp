<%--
  Pattern Partner: Table to preview pattern

  User: Kolya
  Date: 2016-02-27
  Time: 7:21 AM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.patternpartner.PatternPreview" %>
<%
    PatternPreview previewer = (PatternPreview) session.getAttribute("previewer");
    int size = previewer.getLines().size();
%>
<table class="table table-hover ">
    <tbody>
    <% int i = 0;
        for (i=0; i<size; i++) { %>
    <tr class="<%= previewer.getLineClass().get(i) %>" id="<%= i %>" onclick="setRow(<%= i %>)">
        <td><% out.print(previewer.getLines().get(i)); %></td>
    </tr>
    <%
    } %>
    </tbody>
</table>

<script>

    function setRow(i) {
        var idA = "a" + i.toString();
        if (document.getElementById(i).className == "") {
            document.getElementById(i).className = "danger";
            document.getElementById(idA).value = "danger";
        } else {
            document.getElementById(i).className = "";
            document.getElementById(idA).value = "";
        }
    }

</script>

<form action="saveChanges.jsp">
    <% for (i=0; i<previewer.getLines().size(); i++) { %>
    <input type="hidden" id="a<%= i %>" name="a<%= i %>" value="<%= previewer.getLineClass().get(i) %>"/>
    <%
        } %>
    <input type="hidden" name="nextPage" value="<%= session.getAttribute("nextPage") %>" />
    <input type="submit" value="Save" class="btn btn-default btn-lg btn-block" />
</form>

<ul class="pager">
    <li class="previous"><a href="<%= session.getAttribute("lastPage") %>">&larr; Back</a></li>
</ul>