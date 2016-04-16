<%--

  Confirm Delete Pattern

  User: Kolya
  Date: 2016-04-16
  Time: 8:16 AM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
<h1>Are you sure you want to delete this pattern?</h1>
<h1>${param.title}</h1>
<a href="deletePattern?id=${param.id}" class="btn btn-success">Delete</a>
<a href="patternLibrary" class="btn btn-danger">Send Me Back!</a>
<jsp:include page="footer.jsp"/>
