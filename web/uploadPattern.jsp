<%--

  Pattern Preview: Upload Pattern

  User: Kolya
  Date: 2016-03-05
  Time: 4:22 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.patternpartner.PatternPreview" %>
<%@ page import="com.patternpartner.PatternUploader" %>
<% if (!(session.getAttribute("username") == null || session.isNew())) { %>
    <% if (session.getAttribute("preview") != null) {

        PatternPreview previewer = (PatternPreview) session.getAttribute("preview");
        PatternUploader upload = new PatternUploader(previewer,
                (String) session.getAttribute("username"));


        upload.upload();

        response.sendRedirect("home.jsp");

    } else {
        response.sendRedirect("addPattern.jsp");
    }
} else {
    response.sendRedirect("logIn.jsp");
} %>