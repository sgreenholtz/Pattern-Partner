<%--

  Review Comments

  User: Kolya
  Date: 2016-04-03
  Time: 1:33 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% if (session.getAttribute("username") == "skolya") { %>
<jsp:include page="header.jsp" />

<jsp:include page="footer.jsp" />
<%
    } else {
        response.sendRedirect("logIn.jsp");
    }
%>