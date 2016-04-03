<%--
  Pattern Partner: Log In

  User: Kolya
  Date: 2016-02-21
  Time: 2:33 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp" />

<% if (session.getAttribute("username") == null || session.isNew()) { %>

    <form class="form-horizontal" method="post" action="loginAttempt.jsp">
        <fieldset>
            <legend>Log In</legend>
            <div class="form-group">
                <label for="username" class="col-lg-2 control-label">Username</label>
                    <div class="col-lg-10">
                        <input type="text" class="form-control" id="username" name="username" placeholder="Username">
                    </div>
            </div>
            <div class="form-group">
                <label for="inputPassword" class="col-lg-2 control-label">Password</label>
                <div class="col-lg-10">
                    <input type="password" class="form-control" id="inputPassword" name="password" placeholder="Password">
                </div>
            </div>

            <div class="form-group">
                <div class="col-lg-10 col-lg-offset-2">
                    <button type="reset" class="btn btn-default">Cancel</button>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </div>
            </div>
        </fieldset>
    </form>

    <% } else { %>
    <h3>You are logged in as <%= session.getAttribute("username") %></h3>
    <a href="logOut.jsp" class="btn btn-primary btn-lg">Log Out</a>

    <% } %>

<jsp:include page="footer.jsp" />