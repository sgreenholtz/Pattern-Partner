<%--
  Pattern Partner: Set Description
  
  User: Kolya
  Date: 2016-02-27
  Time: 7:34 AM
--%>
<jsp:include page="header.jsp"/>
<% session.setAttribute("classSet", "success"); %>
<% session.setAttribute("nextPage", "setPatternRows.jsp"); %>
<% session.setAttribute("lastPage", "setMaterials.jsp"); %>
<h2>Select Description</h2>
<jsp:include page="patternTable.jsp"/>
<jsp:include page="footer.jsp"/>