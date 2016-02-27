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
<table class="table table-hover ">
    <thead>
        <tr>
            <th><% out.print(uploader.getPreviewer().getTitle()); %></th>
        </tr>
    </thead>
    <tbody>
<%  int i = 0;
    for (String line : uploader.getPreviewer().getLines()) { %>
        <tr class="<%= uploader.getPreviewer().getLineClass().get(i) %>">
            <td><% out.print(line); %></td>
        </tr>
   <%   i++;
       } %>
    </tbody>
</table>
<jsp:include page="footer.jsp" />