<%--
  Pattern Partner: Process Pattern
  Direct from Add Pattern page
  User: Kolya
  Date: 2016-02-21
  Time: 3:00 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.patternpartner.FileUploader" %>
<% if (!(session.getAttribute("username") == null || session.isNew())) {
    FileUploader uploader = new FileUploader();
    uploader.uploadFile(request, application);
    session.setAttribute("preview", uploader.getPreviewer());

    response.sendRedirect("setMaterials.jsp");

} else {
    response.sendRedirect("logIn.jsp");
}
%>