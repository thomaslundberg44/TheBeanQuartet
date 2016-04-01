
<%@page session="true"%>
<%
	if (session.getAttribute("type") == null) {
		response.sendRedirect("index.html");
	} else if (!session.getAttribute("type").equals("NetEng")) {
		response.sendRedirect("index.html");
	}
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Network Manager Page</title>

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
				<li><a onclick="callFailAndDurationByEMSI()" href="#">Call
						Failures and Call Duration by IMSI</a></li>
				<li><a onclick="TopTenImsiWithCallFailure()" href="#">Top 10
						IMSI By Call Failure</a></li>	
				<li><a onclick="UniqueDetailAboutModelOfPhone()" href="#">Unique
						Failure, EventId & Cause Code For Given Model</a></li>
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
		<div id="frame" align="center">
			<h1 align="center">Welcome</h1>
		</div>
	</div>
	<script>
		function callFailAndDurationByEMSI() {
	        $("#msgbox").fadeOut(function(){
        		$(this).text(
        				'Counts, for each IMSI, the number of call failures and their total duration during a given time period.'
        				).fadeIn();
    		});
			frame = document.getElementById("frame");
			frame.innerHTML = '<iframe src="userStoryNineCountEachImsi.html" width="98%" height="100%"></iframe>';
		}
		
		function TopTenImsiWithCallFailure() {
	        $("#msgbox").fadeOut(function(){
        		$(this).text(
        				'Show Top 10 IMSI, that had call failures during a time period.'
        				).fadeIn();
    		});
			frame = document.getElementById("frame");
			frame.innerHTML = '<iframe src="UserStoryTwelve.html" width="98%" height="100%"></iframe>';
		}
		
		function UniqueDetailAboutModelOfPhone(){
	        $("#msgbox").fadeOut(function(){
        		$(this).text(
        				'Display For A Given Model Unique Failure, EventId and Cause Code Combination And Number Of Occurences.'
        				).fadeIn();
    		});
			frame = document.getElementById("frame");
			frame.innerHTML = '<iframe src="UserStoryTenSample.html" width="98%" height="100%"></iframe>';
		}
		
	</script>

</body>
</html>