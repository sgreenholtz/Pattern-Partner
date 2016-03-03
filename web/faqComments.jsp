<%--
  Pattern Partner: FAQ and Comments
  
  User: Kolya
  Date: 2016-02-21
  Time: 2:33 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
<%@ page import="com.patternpartner.RhinoTest" %>
<%
    RhinoTest previewer = new RhinoTest();
    session.setAttribute("rhino", previewer);
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
        var idA = "a" + i.toString();
        if (document.getElementById(i).className == "") {
            document.getElementById(i).className = "danger";
            document.getElementById(idA).value = "danger";
            alert(idA);
        } else {
            document.getElementById(i).className = "";
            document.getElementById(idA).value = "";

        }
    }


</script>

<form action="display.jsp">
    <% for (i=0; i<previewer.getLines().size(); i++) { %>
    <input type="hidden" id="a<%= i %>" name="a<%= i %>" value="<%= previewer.getLineClass().get(i) %>"/>
    <%
        } %>
    <input type="submit" value="Save" />
</form>

<%--<image src="images/meme.jpeg" />--%>
<jsp:include page="footer.jsp"/>