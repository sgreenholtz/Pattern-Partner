<%--
  Pattern Partner: Process Pattern
  Direct from Add Pattern page
  User: Kolya
  Date: 2016-02-21
  Time: 3:00 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.patternpartner.FileUploader" %>
<%

    FileUploader uploader = new FileUploader();
    uploader.uploadFile(request, application);

%>
<jsp:include page="header.jsp" />
<%
    out.print(uploader.getPreviewer().toString());
%>
<jsp:include page="footer.jsp" />