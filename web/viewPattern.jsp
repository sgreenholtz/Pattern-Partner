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

    <div class="btn-group btn-group-justified">
        <a href="editTitle.jsp?title=${param.title}&id=${param.id}" class="btn btn-default">Edit Title</a>
        <a href="downloadText?id=${param.id}" class="btn btn-default">Download Text</a>
        <a href="confirmDelete?title=${param.title}&id=${param.id}" class="btn btn-default">Delete Pattern</a>
    </div>
    <h5><% out.print(pattern.getDescription().get(0)); %></h5>
    <table class="table table-hover ">
        <tbody>
        <tr><th>Materials</th></tr>
        <% for (String material : pattern.getMaterials()) { %>
        <tr><td><% out.print(material); %></td></tr>
        <%
            } %>
        </tbody>
    </table>

<table class="table table-hover ">
    <tbody>
        <div class="btn-toolbar">
            <div class="btn-group">
                <a href="#" class="btn btn-default" onclick="increase()">+</a>
                <div id="repeat">12</div>
                <a href="#" class="btn btn-default" onclick="decrease()">-</a>
                <a href="#" class="btn btn-default" onclick="clearRepeat()">Clear</a>
            </div>

        </div>
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

    function clearRepeat() {
        document.getElementById("repeat").innerHTML = 0;
        document.getElementById("repeatForm").value = 0;
    }

    function increase() {
        document.getElementById("repeat").innerHTML++;
        document.getElementById("repeatForm").value++;
    }

    function decrease() {
        document.getElementById("repeat").innerHTML--;
        document.getElementById("repeatForm").value--;
    }
</script>

<form action="saveActive" method="get">
    <input type="hidden" id="oldActive" name="oldActive" value="<%= savedActive %>"/>
    <input type="hidden" id="newActive" name="newActive" value=""/>
    <input type="hidden" name="patternID" value="<%= patternID %>" />
    <input type="hidden" name="repeat" id="repeatForm" value="" />
    <input type="submit" value="Save and Return to Library" class="btn btn-default btn-lg btn-block" />
</form>
<jsp:include page="footer.jsp"/>
<%
} else {
    response.sendRedirect("login");
}
%>