<%--

  Edit Title: allows users to edit the title of a pattern in their
  pattern library. Form posts to servlet UpdateTitleServlet

  User: Kolya
  Date: 2016-04-03
  Time: 10:49 AM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp" />
<% if (!(session.getAttribute("username") == null || session.isNew())) { %>
<form class="form-horizontal" action="updateTitle">
    <div class="form-group">
        <label class="col-lg-2 control-label">Current Title</label>
        <div class="col-lg-10">
            <p>${param.title}</p>
        </div>
    </div>
    <div class="form-group">
        <label for="newTitle" class="col-lg-2 control-label">New Title</label>
        <div class="col-lg-10">
            <input type="text" class="form-control" id="newTitle" name="newTitle" />
        </div>
    </div>
    <input type="hidden" id="id" name="id" value="${param.id}" />
    <div class="form-group">
        <div class="col-lg-10 col-lg-offset-2">
            <button type="reset" class="btn btn-default">Cancel</button>
            <button type="submit" class="btn btn-primary">Submit</button>
        </div>
    </div>
</form>
<% } else {
    response.sendRedirect("logIn.jsp");
} %>
<jsp:include page="footer.jsp" />
