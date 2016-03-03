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
    session.setAttribute("preview", uploader.getPreviewer());
//    session.setAttribute("lineClass", uploader.getPreviewer().getLineClass());
//    session.setAttribute("title", uploader.getPreviewer().getTitle());

    response.sendRedirect("setMaterials.jsp");
%>