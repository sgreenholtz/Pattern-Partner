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
        <%
            for (Map<String, String> comment : comments.getComments()) {
                if (comment.get("reviewed").equals("0")) {
                    //print comment if unviewed
                }
            }
        %>
    </div>
    <div class="tab-pane fade" id="profile">
    <%
        for (Map<String, String> comment : comments.getComments()) {
            //print all
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