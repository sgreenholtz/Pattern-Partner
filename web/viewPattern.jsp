<%--
  
  Pattern Partner: View Pattern

  View pattern, click to save the active line and it will be saved

  User: Kolya
  Date: 2016-03-12
  Time: 1:50 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.patternpartner.ViewPattern" %>
<%@ page import="com.patternpartner.Pattern" %>
<%@ page import="com.patternpartner.LoadProperties" %>
<% if (!(session.getAttribute("username") == null || session.isNew())) { %>
<jsp:include page="header.jsp"/>
<%
    Integer patternID = Integer.valueOf(request.getParameter("id"));

    ViewPattern viewer = new ViewPattern((String) session.getAttribute("username"));
    Pattern pattern = viewer.getPattern(patternID);

    LoadProperties propertiesLoader = new LoadProperties();
    String active = propertiesLoader.loadProperties("patternpartner.properties").getProperty("is.active");

    Integer savedActive = 0;
%>
    <h1>${param.title}</h1>
    <a href="editTitle.jsp?title=${param.title}&id=${param.id}" class="btn btn-default">Edit Title</a>
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
        var oldID = document.getElementById("oldActive").value;
        document.getElementById(oldID).className = "";

        // Set the new active row to highlight and save value
        document.getElementById(i).className = "<%= active %>";
        document.getElementById("newActive").value = i;
    }
</script>

<form action="saveActive" method="get">
    <input type="hidden" id="oldActive" name="oldActive" value="<%= savedActive %>"/>
    <input type="hidden" id="newActive" name="newActive" value=""/>
    <input type="hidden" name="patternID" value="<%= patternID %>" />
    <input type="submit" value="Save and Return to Library" class="btn btn-default btn-lg btn-block" />
</form>
<jsp:include page="footer.jsp"/>
<%
} else {
    response.sendRedirect("login");
}
%>