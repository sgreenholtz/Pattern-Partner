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
    String knitOrCrochet = request.getParameter("korc");

    ViewPattern viewer = new ViewPattern((String) session.getAttribute("username"));
    Pattern pattern = viewer.getPattern(id, knitOrCrochet);

    LoadProperties propertiesLoader = new LoadProperties();
    String active = propertiesLoader.loadProperties("patternpartner.properties").getProperty("is.active");
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
                }
        %>
        <tr class="<%= color %>" id="<%= i %>" onclick="setRow(<%= i %>)">
            <td><% out.print(pattern.getPatternRows().get(i)); %></td>
        </tr>
        <% } %>
        </tbody>
    </table>
<jsp:include page="footer.jsp"/>
<%
} else {
    response.sendRedirect("logIn.jsp");
}
%>