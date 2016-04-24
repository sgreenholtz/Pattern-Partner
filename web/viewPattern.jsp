<%--
  
  Pattern Partner: View Pattern

  View pattern, click to save the active line and it will be saved

  User: Kolya
  Date: 2016-03-12
  Time: 1:50 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.patternpartner.ViewPattern" %>
<%@ page import="com.patternpartner.Pattern" %>
<%@ page import="com.patternpartner.LoadProperties" %>
<c:choose>
<c:when test="${username} == null">
    <% response.sendRedirect("login"); %>
</c:when>
<c:otherwise>
<jsp:include page="header.jsp"/>
<%
    Integer patternID = Integer.valueOf(request.getParameter("id"));

    ViewPattern viewer = new ViewPattern((String) session.getAttribute("username"));
    Pattern pattern = viewer.getPattern(patternID);

    LoadProperties propertiesLoader = new LoadProperties();
    String active = propertiesLoader.loadProperties("patternpartner.properties").getProperty("is.active");

    Integer savedActive = 0;
    Integer repeatCount = 0;
%>
    <h1>${param.title}</h1>

    <div class="btn-group btn-group-justified">
        <a href="editTitle.jsp?title=${param.title}&id=${param.id}" class="btn btn-default">Edit Title</a>
        <a href="downloadText?id=${param.id}" class="btn btn-default">Download</a>
        <a href="confirmDelete?title=${param.title}&id=${param.id}" class="btn btn-default">Delete</a>
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

        <h5>Row Repeat Counter</h5>
        <div class="btn-toolbar">
            <div class="btn-group">
                <div class="btn btn-default" onclick="increase()">+</div>
                <div class="btn btn-default" id="repeat">12</div>
                <div class="btn btn-default" onclick="decrease()">-</div>
                <div class="btn btn-default" onclick="clearRepeat()">Clear</div>
            </div>
        </div>
<table class="table table-hover ">
    <tbody>
        <tr><th>Instructions</th></tr>
        <% int i = 0;
            for (i=0; i<pattern.getPatternRows().size(); i++) {
                String color = "";
                if (pattern.getIsActiveRow().get(i)) {
                    color = active;
                    savedActive = i;
                    repeatCount = pattern.getRepeatCount().get(i);
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
    <input type="hidden" name="repeat" id="repeatForm" value="<%= repeatCount %>" />
    <input type="submit" value="Save and Return to Library" class="btn btn-default btn-lg btn-block" />
</form>
<jsp:include page="footer.jsp"/>
</c:otherwise>
</c:choose>