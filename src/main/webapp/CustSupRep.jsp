
<%@page session="true"%>
<%
	if (session.getAttribute("type") == null) {
	//	response.sendRedirect("index.html");
	} else if (!session.getAttribute("type").equals("CSR")) {
	//	response.sendRedirect("index.html");
	}
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Customer Support Page</title>

<link rel="stylesheet" href="css/style1.css">
<link rel="stylesheet" href="css/style.css">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" language="javascript"
	src="media/js/jquery.js"></script>

</head>

<body>

	<div class="row">
		<div class="col-md-6">
			<img id='img' src="Ericsson_logo.png" alt="EricssonLogo"
				style="width: 155px; height: 140px;">
		</div>
		<div class="col-md-6"></div>
	</div>

	<div class="row border">
		<div class="col-md-6">
			<ul class="nav nav-pills nav-justified">
				<li><a onclick="EvenID_CauseCodeByEMSI()" href="#">Event ID
						and Cause Code by EMSI with call failures</a></li>
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
		<div id="header2">
		<br>
		<div align="center" style="color: white;"id="msgbox"></div>
		</div>
		<div id="frame">
			<h1 align="center">Welcome</h1>
		</div>
	</div>


	<script>
		function EvenID_CauseCodeByEMSI() {
	        $("#msgbox").fadeOut(function(){
        		$(this).text(
        				'Display, for a given affected IMSI, the Event ID and Cause Code for any / all failures affecting that IMSI.'
        				).fadeIn();
    		});
			frame = document.getElementById("frame");
			frame.innerHTML = '<iframe src="userStoryFourDisplayUsingImsi.html" width="100%" height="1000"></iframe>';
		}
	</script>

</body>
</html>