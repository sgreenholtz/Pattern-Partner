<%--
  
  Pattern Partner: View Pattern

  User: Kolya
  Date: 2016-03-12
  Time: 1:50 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.patternpartner.ViewPattern" %>
<%@ page import="com.patternpartner.Pattern" %>
<%@ page import="com.patternpartner.LoadProperties" %>
<%@ page import="java.util.*" %>
<% if (!(session.getAttribute("username") == null || session.isNew())) { %>
<jsp:include page="header.jsp"/>
<%
    String title = request.getParameter("title");
    Integer id = Integer.valueOf(request.getParameter("id"));

    ViewPattern viewer = new ViewPattern((String) session.getAttribute("username"));
    Pattern pattern = viewer.getPattern(id);

    LoadProperties propertiesLoader = new LoadProperties();
    String active = propertiesLoader.loadProperties("patternpartner.properties").getProperty("is.active");

    Integer savedActive = 0;
%>
    <h1><% out.print(title); %></h1>
    <h5><% out.print(pattern.getDescription().get(0)); %></h5>
    <table class="table table-hover ">
        <tbody>
        <tr><th>Materials</th></tr>
        <% for (String material : pattern.getMaterials()) { %>
        <tr><td><% out.print(material); %></td></tr>
        <%
            } %>
        <tr><th>Instructions</th></tr>
        <% int i = 0;
            for (i=0; i<pattern.getPatternRows().size(); i++) {
                String color = "";
                if (pattern.getIsActiveRow().get(i)) {
                    color = active;
                    savedActive = i;
                }
        %>
        <tr class="<%= color %>" id="<%= i %>" onclick="setActiveRow(<%= i %>)">
            <td><% out.print(pattern.getPatternRows().get(i)); %></td>
        </tr>
        <% } %>
        </tbody>
    </table>

<script>
    function setActiveRow(i) {
        // Reset the no-longer-active row to no highlight
        var oldID = document.getElementById("active").value;
        document.getElementById(oldID).className = "";

        // Set the new active row to highlight and save value
        document.getElementById(i).className = "<%= active %>";
        document.getElementById("active").value = i;
    }
</script>

<form action="saveActive.jsp">
    <input type="hidden" id="active" name="active" value="<%= savedActive %>"/>
    <input type="hidden" id="id" name="id" value="<%= id %>"/>
    <input type="submit" value="Save and Return to Library" class="btn btn-default btn-lg btn-block" />
</form>
<jsp:include page="footer.jsp"/>
<%
} else {
    response.sendRedirect("logIn.jsp");
}
%>