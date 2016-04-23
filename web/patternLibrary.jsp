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
    for (Entry<Integer, ArrayList<String>> pattern : viewer.getTitlesAndDescriptions().entrySet()) {
%>
<div class="col-sm-6">
    <div class="panel-default">
        <a href="viewPattern?title=<%= pattern.getValue().get(0) %>&id=<%= pattern.getKey() %>">
            <div class="panel-heading">
                <h3 class="panel-title"><% out.print(pattern.getValue().get(0)); %></h3>
            </div>
            <div class="panel-body">
                <% out.print(pattern.getValue().get(1)); %>
            </div>
        </a>
    </div>
</div>
<%
    }
%>
<jsp:include page="footer.jsp"/>
<% } else {
    response.sendRedirect("login");
} %>