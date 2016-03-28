<%--
  Pattern Preview: Set Materials

  User: Kolya
  Date: 2016-02-27
  Time: 7:31 AM
--%>
<%@ page import="com.patternpartner.LoadProperties" %>
<%@ page import="java.util.Properties" %>
<% if (session.getAttribute("preview") != null) {

    Properties properties = new LoadProperties().loadProperties("patternpartner.properties");
    session.setAttribute("classSet", properties.getProperty("materials.class"));
    session.setAttribute("nextPage", "setDescription.jsp");
    session.setAttribute("lastPage", "addPattern.jsp"); %>

    <jsp:include page="header.jsp"/>
    <h2>Select Materials</h2>
    <jsp:include page="patternTable.jsp"/>
    <jsp:include page="footer.jsp"/>
<% } else {
    response.sendRedirect("addPattern.jsp");
} %>
