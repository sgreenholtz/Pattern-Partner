<%--
  Pattern Partner: Set Description
  
  User: Kolya
  Date: 2016-02-27
  Time: 7:34 AM
--%>
<jsp:include page="header.jsp"/>
<% session.setAttribute("classSet", "success"); %>
<h2>Select Description</h2>
<jsp:include page="patternTable.jsp"/>
<ul class="pager">
    <li class="previous"><a href="setMaterials.jsp">&larr; Back</a></li>
    <li class="next"><a href="setPatternRows.jsp">Next &rarr;</a></li>
</ul>
<jsp:include page="footer.jsp"/>