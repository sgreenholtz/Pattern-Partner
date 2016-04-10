<%--
  Pattern Partner: Process Pattern
  Direct from Add Pattern page
  User: Kolya
  Date: 2016-02-21
  Time: 3:00 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.patternpartner.FileUploaderStream" %>
<% if (!(session.getAttribute("username") == null || session.isNew())) {
    FileUploaderStream uploader = new FileUploaderStream();
    uploader.uploadFile(request, application);
    session.setAttribute("preview", uploader.getPreviewer());

    response.sendRedirect("setMaterials");

} else {
    response.sendRedirect("logIn.jsp");
}
%>