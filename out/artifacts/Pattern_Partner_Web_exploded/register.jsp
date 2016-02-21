<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Pattern Partner</title>

    <!-- Bootstrap Core CSS -->
    <link href="https://bootswatch.com/readable/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <style>
        body {
            padding-top: 70px;
            /* Required padding for .navbar-fixed-top. Remove if using .navbar-static-top. Change if height of navigation changes. */
        }
    </style>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

<div class="container">
    <div class="row">
        <h1>Pattern Partner</h1>
    </div>

    <nav class="navbar navbar-inverse">
        <div class="container-fluid">

            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-2">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>

            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2">
                <ul class="nav navbar-nav">
                    <li><a class="navbar-brand" href="home.jsp">Home</a></li>
                    <li><a href="patternLibrary.jsp">Pattern Library</a></li>
                    <li><a href="addPattern.jsp">Add Pattern</a></li>
                    <% if (session.getAttribute("username").equals("") ||
                            session.getAttribute("username") == null ||
                            session.isNew()) { %>
                    <li><a href="logIn.jsp">Log In</a></li>
                    <% } else { %>
                    <li><a href="logOut.jsp">Log Out</a></li>
                    <% } %>
                    <li><a href="faqComments.jsp">FAQ and Comments</a></li>
                </ul>
            </div>

        </div>
    </nav>

    <form class="form-horizontal" method="post" action="registerAttempt.jsp">
        <fieldset>
            <legend>Register</legend>
            <div class="form-group">
                <label for="inputUsername" class="col-lg-2 control-label">Username</label>
                <div class="col-lg-10">
                    <input type="text" class="form-control" id="inputUsername" name ="password" placeholder="Username">
                </div>
            </div>
            <div class="form-group">
                <label for="inputPassword" class="col-lg-2 control-label">Password</label>
                <div class="col-lg-10">
                    <input type="password" class="form-control" id="inputPassword" name="password" placeholder="Password">
                </div>
            </div>
            <div class="form-group">
                <label for="firstName" class="col-lg-2 control-label">First Name</label>
                <div class="col-lg-10">
                    <input type="text" class="form-control" id="firstName" name="firstName" placeholder="First Name">
                </div>
            </div>
            <div class="form-group">
                <label for="lastName" class="col-lg-2 control-label">Last Name</label>
                <div class="col-lg-10">
                    <input type="text" class="form-control" id="lastName" name="lastName" placeholder="Last Name">
                </div>
            </div>
            <div class="form-group">
                <label for="email" class="col-lg-2 control-label">Email</label>
                <div class="col-lg-10">
                    <input type="text" class="form-control" id="email" name="email" placeholder="Email">
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
<%@ include file="footer.jsp" %>