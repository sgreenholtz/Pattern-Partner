<%--
  Review Comments submitted by users on the faq-comments page

  User: Kolya
  Date: 2016-04-03
  Time: 1:33 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.patternpartner.CommentViewer" %>
<%@ page import="java.util.Map" %>
<% if (session.getAttribute("username").equals("skolya")) {
    CommentViewer comments = new CommentViewer();
%>
<jsp:include page="header.jsp" />

<ul class="nav nav-tabs">
    <li class="active"><a href="#home" data-toggle="tab">Unread</a></li>
    <li><a href="#profile" data-toggle="tab">All</a></li>
</ul>
<div id="myTabContent" class="tab-content">
    <div class="tab-pane fade active in" id="home">
        <form action="updateRead" method="post" class="form-horizontal">
        <%
            for (Map<String, String> comment : comments.getComments()) {
                if (comment.get("reviewed").equals("0")) {
        %>
                    <fieldset>
                        <label class="col-lg-2 control-label">Name</label>
                        <div class="col-lg-10">
                            <p><% out.print(comment.get("name")); %></p>
                        </div>
                        <label class="col-lg-2 control-label">Email</label>
                        <div class="col-lg-10">
                            <p><% out.print(comment.get("email")); %></p>
                        </div>
                        <label class="col-lg-2 control-label">Comment</label>
                        <div class="col-lg-10">
                            <p><% out.print(comment.get("comment")); %></p>
                        </div>
                        <label class="col-lg-2 control-label">Timestamp</label>
                        <div class="col-lg-10">
                            <p><% out.print(comment.get("timestamp")); %></p>
                        </div>
                        <div class="checkbox">
                            <label>
                                <input type="checkbox" name="read" id="<%= comment.get("id") %>"> Mark Read?
                            </label>
                        </div>
                    </fieldset>
        <%
                }
            }
        %>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
    <div class="tab-pane fade" id="profile">
    <%
        for (Map<String, String> comment : comments.getComments()) {
            out.print(comment.get("comment"));
        }
    %>
    </div>
</div>
<jsp:include page="footer.jsp" />
<%
    } else {
        response.sendRedirect("logIn.jsp");
    }
%>