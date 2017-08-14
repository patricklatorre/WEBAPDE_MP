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
					<button type="button" class="btn btn-default">
						<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
					</button>
				</form>
        			<ul class="nav navbar-nav">
					<li role="presentation"><a href="index.html">Home</a></li>
					<li role="presentation"><a href="photos.html">Photos</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container">   
		<div class="row">
			<div class="page-header">
				<h1 id="profile-name">Name</h1>
			</div>
		</div>
		<div class="row">
        		<div id="recent-posts" class="col-md-6">
				<div class="well">
					
        				<button type="button" class="btn btn-default">View More</button>
				</div>
        		</div>
			<div id="photo-albums" class="col-md-6">
				<div class="well">
					<button type="button" class="btn btn-default">View More</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
