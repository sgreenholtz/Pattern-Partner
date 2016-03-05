<%--
  Pattern Partner: Set Description
  
  User: Kolya
  Date: 2016-02-27
  Time: 7:34 AM
--%>
<% if (session.getAttribute("preview") != null) {
    session.setAttribute("classSet", "success");
    session.setAttribute("nextPage", "setPatternRows.jsp");
    session.setAttribute("lastPage", "setMaterials.jsp"); %>

    <jsp:include page="header.jsp"/>
    <h2>Select Description</h2>
    <jsp:include page="patternTable.jsp"/>
    <jsp:include page="footer.jsp"/>
<% } else {
    response.sendRedirect("addPattern.jsp");
} %>