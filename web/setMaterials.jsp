<%--
  Pattern Preview: Set Materials

  User: Kolya
  Date: 2016-02-27
  Time: 7:31 AM
--%>
<jsp:include page="header.jsp"/>
<% session.setAttribute("classSet", "info"); %>
<h2>Select Materials</h2>
<jsp:include page="patternTable.jsp"/>
<ul class="pager">
    <li class="next"><a href="setDescription.jsp">Next &rarr;</a></li>
</ul>
<jsp:include page="footer.jsp"/>