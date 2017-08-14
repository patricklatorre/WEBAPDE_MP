
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
    <div id="header">
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">WEBAPDE MP1</a>
                </div>
                <div class="collapse navbar-collapse">
                    <form class="navbar-form navbar-left" role="search">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Search Profile">
                        </div>
                        <a href="profile.html">
                            <button type="button" class="btn btn-default">
                                <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
                            </button>
                        </a>
                    </form>
                        <ul class="nav navbar-nav">
                        <li role="presentation"><a href="index.html">Home</a></li>
                        <li role="presentation" class="active"><a href="photos.html">Photos</a></li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
    <div class="container text-center">
        <div class="page-header">
            <h1>Photos</h1>
        </div>
        <div class="row">
            <div id="recent-photos">
            </div>
            <button type="button" class="btn btn-default" onclick="load();">View More</button>
        </div>
    </div>
</body>
</html>
