<%@page session="true"%>
<%
	if (session.getAttribute("type")==null) {
		response.sendRedirect("index.html");
	}
	else if(!session.getAttribute("type").equals("Admin")) {
		response.sendRedirect("index.html");
	}
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Admin Page</title>

<link rel="stylesheet" href="css/style1.css">
<link rel="stylesheet" href="css/style.css">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">

</head>

<body>

	<div class="row">
	<div class="col-md-6">
			<img id='img' src="Ericsson_logo.png" alt="EricssonLogo"
				style="width: 155px; height: 140px;">
				</div>
		<div class="col-md-6">

		</div>
	</div>

	<div class="row border">
		<div class="col-md-6">
			<ul class="nav nav-pills nav-justified">
				<li><a onclick="viewTables()" href="#">View Tables</a></li>
				<li><a onclick="viewUsers()" href="#">View Users</a></li>
				<li><a onclick="createUser()" href="#">Create User</a></li>
			</ul>
		</div>

		<div class="col-md-6">
			<ul class="nav nav-pills nav-justified navbar-right">
				<li><div align="center">
						Welcome -
						<%=session.getAttribute("user")%>
					</div></li>
				<li><a href="logout.jsp">Logout</a></li>
			</ul>
		</div>
	</div>

	<div id="wrapper">
		<div id="header2"></div>
		<div id="frame">
			<h1 align="center">
				Welcome
				<%=session.getAttribute("type")%>

			</h1>
		</div>
	</div>
	<footer id="footer">
		<div class="innertube">
			<p>Footer...</p>
		</div>
	</footer>


	<script>
		function viewTables() {
			frame = document.getElementById("frame");
			frame.innerHTML = '<iframe src="tables/baseDataTable.html" width="100%" height="1000"></iframe>';
		}
		function viewUsers() {
			frame = document.getElementById("frame");
			frame.innerHTML = '<iframe src="http://localhost:8080/TheBeanQuartet/rest/user" width="100%" height="1000"></iframe>';
		}
		function createUser() {
			frame = document.getElementById("frame");
			frame.innerHTML = '<iframe src="createUser.html" width="100%" height="1000"></iframe>';
		}
	</script>

</body>
</html>