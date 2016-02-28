<%--
  Pattern Partner: Set Pattern Rows
  
  User: Kolya
  Date: 2016-02-27
  Time: 8:19 AM
--%>
<jsp:include page="header.jsp"/>
<% session.setAttribute("classSet", "warning"); %>
<% session.setAttribute("nextPage", "finalPreview.jsp"); %>
<% session.setAttribute("lastPage", "setDescription.jsp"); %>
<h2>Select Pattern Rows</h2>
<jsp:include page="patternTable.jsp"/>
<jsp:include page="footer.jsp"/>