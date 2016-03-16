<%--
  
  Pattern Partner: 

  User: ${USER}
  Date: ${DATE}
  Time: ${TIME}
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% if (!(session.getAttribute("username") == null || session.isNew())) { %>
<jsp:include page="header.jsp"/>
<%-- PAGE CODE GOES HERE --%>
<jsp:include page="footer.jsp"/>
<%
} else { 
    response.sendRedirect("logIn.jsp");
}
%>