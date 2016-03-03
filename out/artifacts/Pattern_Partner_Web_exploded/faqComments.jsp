<%--
  Pattern Partner: FAQ and Comments
  
  User: Kolya
  Date: 2016-02-21
  Time: 2:33 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
<%@ page import="com.patternpartner.RhinoTest" %>
<%@ page import="org.mozilla.javascript.*" %>
<%@ page import="java.util.*" %>
<%
    RhinoTest previewer = new RhinoTest();
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

        var now = new java.util.Date();
        if (document.getElementById(i).className == "") {
            document.getElementById(i).className = "<%= session.getAttribute("classSet") %>";
            alert(now);
        } else {
            document.getElementById(i).className = "";
            // add to lineClass
        }
    }


</script>

<%--<image src="images/meme.jpeg" />--%>
<jsp:include page="footer.jsp"/>