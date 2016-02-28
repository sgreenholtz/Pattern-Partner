<%--
  Pattern Preview: Set Materials

  User: Kolya
  Date: 2016-02-27
  Time: 7:31 AM
--%>
<jsp:include page="header.jsp"/>
<% session.setAttribute("classSet", "info"); %>
<% session.setAttribute("nextPage", "setDescription"); %>
<% session.setAttribute("lastPage", "#"); %>
<h2>Select Materials</h2>
<jsp:include page="patternTable.jsp"/>
<jsp:include page="footer.jsp"/>