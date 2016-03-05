<%--
  Pattern Preview: Set Materials

  User: Kolya
  Date: 2016-02-27
  Time: 7:31 AM
--%>
<% if (session.getAttribute("preview") != null) {
    session.setAttribute("classSet", "info");
    session.setAttribute("nextPage", "setDescription.jsp");
    session.setAttribute("lastPage", "#"); %>

    <jsp:include page="header.jsp"/>
    <h2>Select Materials</h2>
    <jsp:include page="patternTable.jsp"/>
    <jsp:include page="footer.jsp"/>
<% } else {
    response.sendRedirect("addPattern.jsp");
} %>
