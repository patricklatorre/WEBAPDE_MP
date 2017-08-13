<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>WEBAPDE MP2</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
 	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
 	<script src="js/jquery-3.2.1.min.js"></script>
 	<script src="js/bootstrap.min.js"></script>
</head>
<body>
<%--
	<div class="row">
		<div class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="col-sm-1"></div>
				<div class="navbar-header">
					<a class="navbar-brand" href="#">WEBAPDE MP2</a>
				</div>
			</div>
		</div>
	</div>
 --%>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">WEBAPDE MP2</a>
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
					<li role="presentation" class="active"><a href="index.html">Home</a></li>
					<li role="presentation"><a href="photos.html">Photos</a></li>
				</ul>
			</div>
		</div>
	</nav>
	
	<div class="row">
		<div class="col-sm-2"></div>
		<div class="col-sm-3">
			<h2>Register</h2>
			<form class="form" action="register" method="POST">
				<div class="form-group">
					<label for="reg_username">First Name:</label>
					<input type="text" class="form-control" id="reg_username" name="reg_username">
				</div>
				<div class="form-group">
					<label for="reg_password">Password:</label>
					<input type="password" class="form-control" id="reg_password" name="reg_password">
				</div>
				<button type="submit" class="btn btn-default">Register</button>
			</form>
		</div>
		<div class="col-sm-2"></div>
		<div class="col-sm-3">
			<h2>Login</h2>
			<form class="form" action="login" method="POST">
				<div class="form-group">
					<label for="login_username">Email:</label>
					<input type="text" class="form-control" id="login_username" name="login_username">
				</div>
				<div class="form-group">
					<label for="login_password">Password:</label>
					<input type="password" class="form-control" id="login_password" name="login_password">
				</div>
				<button type="submit" class="btn btn-default">Login</button>
			</form>
		</div>
	</div>
</body>
</html>