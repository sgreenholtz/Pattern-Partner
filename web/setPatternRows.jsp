<%--
  Pattern Partner: Set Pattern Rows
  
  User: Kolya
  Date: 2016-02-27
  Time: 8:19 AM
--%>
<jsp:include page="header.jsp"/>
<% session.setAttribute("classSet", "warning"); %>
<h2>Select Pattern Rows</h2>
<jsp:include page="patternTable.jsp"/>
<ul class="pager">
    <li class="previous"><a href="setDescription.jsp">&larr; Back</a></li>
    <li class="next"><a href="finalPreview.jsp">Next &rarr;</a></li>
</ul>
<jsp:include page="footer.jsp"/>