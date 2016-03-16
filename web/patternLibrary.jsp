<%--
  Pattern Partner: Pattern Library
  
  User: Kolya
  Date: 2016-02-21
  Time: 2:40 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% if (!(session.getAttribute("username") == null || session.isNew())) { %>
<%@ page import="com.patternpartner.ViewPattern" %>
<%@ page import="java.util.*" %>
<%@ page import="java.util.Map.*" %>

<jsp:include page="header.jsp"/>
<% ViewPattern viewer = new ViewPattern((String) session.getAttribute("username"));
    Map<Integer, String> titles = viewer.getAllPatternTitles();
    Map<Integer, String> kOrC = viewer.getKnitOrCrochet();
    String colorClass = viewer.getProperties().getProperty("crochet.class");
    for (Entry<Integer, String> pattern : titles.entrySet()) {
        if (kOrC.get(pattern.getKey()).equals("k")) {
            colorClass = viewer.getProperties().getProperty("knit.class");
        }
%>
<div class="col-xs-4">
    <div class="panel panel-<%= colorClass %>">
        <a href="viewPattern.jsp?title=<%= pattern.getValue() %>id=<%= pattern.getKey() %>korc=<%= kOrC.get(pattern.getKey()) %>">
            <div class="panel-heading">
                <h3 class="panel-title"><% out.print(pattern.getValue()); %></h3>
            </div>
        </a>
        <div class="panel-body">
            No Photo
        </div>
    </div>
</div>
<%
    }
%>
<jsp:include page="footer.jsp"/>
<% } else {
    response.sendRedirect("logIn.jsp");
} %>