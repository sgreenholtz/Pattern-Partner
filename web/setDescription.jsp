<%--
  Pattern Partner: Set Description
  
  User: Kolya
  Date: 2016-02-27
  Time: 7:34 AM
--%>
<%@ page import="com.patternpartner.LoadProperties" %>
<%@ page import="java.util.Properties" %>
<% if (session.getAttribute("preview") != null) {

    Properties properties = new LoadProperties().loadProperties("patternpartner.properties");
    session.setAttribute("classSet", properties.getProperty("description.class"));
    session.setAttribute("nextPage", "setPatternRows");
    session.setAttribute("lastPage", "setMaterials"); %>

    <jsp:include page="header.jsp"/>
    <h2>Select Description</h2>
    <jsp:include page="patternTable.jsp"/>
    <jsp:include page="footer.jsp"/>
<% } else {
    response.sendRedirect("addPattern");
} %>