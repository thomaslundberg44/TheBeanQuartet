
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
	<script src="bootstrap/js/bootstrap.min.js"></script>

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
		<div class="col-md-6 dropdown">
			<ul class="nav nav-pills nav-justified">
				<li><a href="#" data-toggle="dropdown"> Network Management
						Engineer </a>
					<ul class="dropdown-menu">
						<li><a onclick="userStory9()" href="#"> Count, for each
								IMSI, number of call failures and duration during a time period
						</a></li>
						<li><a onclick="userStory10()" href="#"> For a model of
								phone, Show failure Event Id/Cause Code combinations and the
								number of occurrences.</a></li>
						<li><a onclick="userStory11()" href="#"> Show top 10
								Market/Operator/Cell ID combinations with call failures during a
								time period </a></li>
						<li><a onclick="userStory12()" href="#"> Show top 10
								IMSIs that had call failures during a time period</a></li>
					</ul></li>
				<li><a href="#" data-toggle="dropdown"> Support Engineer </a>
					<ul class="dropdown-menu">
						<!-- user story in order 7, 8, 14 -->
						<li><a onclick="userStory7()" href="#">IMSIs with call
								failures during time period</a></li>
						<li><a onclick="userStory8()" href="#">Model of phone,
								count call failures during a time period</a></li>
						<li><a onclick="userStory14()" href="#">Failure Cause
								Class, the IMSIs that were affected.</a></li>
					</ul></li>
				<li><a href="#" data-toggle="dropdown"> Customer Service
						Representative </a>
					<ul class="dropdown-menu">
						<!-- user story in order 4, 5, 6 -->
						<li><a onclick="userStory4()" href="#">For affected IMSI,
								show the Event ID and Cause Code</a></li>
						<li><a onclick="userStory5()" href="#">Count, for a given
								IMSI, the number of failures during a time period.</a></li>
						<li><a onclick="userStory6()" href="#">For a given IMSI,
								show unique Cause Codes</a></li>
					</ul></li>
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
		function userStory9() {
	        $("#msgbox").fadeOut(function(){
        		$(this).text(
        				'Counts, for each IMSI, the number of call failures and their total duration during a given time period.'
        				).fadeIn();
    		});
			frame = document.getElementById("frame");
			frame.innerHTML = '<iframe src="userStoryNineCountEachImsi.html" width="98%" height="100%"></iframe>';
		}
		function userStory10(){
	        $("#msgbox").fadeOut(function(){
        		$(this).text(
        				'Display For A Given Model Unique Failure, EventId and Cause Code Combination And Number Of Occurences.'
        				).fadeIn();
    		});
			frame = document.getElementById("frame");
			frame.innerHTML = '<iframe src="UserStoryTen.html" width="98%" height="100%"></iframe>';
		}
		function userStory11(){
	        $("#msgbox").fadeOut(function(){
        		$(this).text(
        				'Display Top 10 Market/Operator/Cell ID combinations that had call failures during a time period'
        				).fadeIn();
    		});
			frame = document.getElementById("frame");
			frame.innerHTML = '<iframe src="11.html" width="98%" height="100%"></iframe>';
		}
		
		function userStory12() {
	        $("#msgbox").fadeOut(function(){
        		$(this).text(
        				'Show Top 10 IMSI, that had call failures during a time period.'
        				).fadeIn();
    		});
			frame = document.getElementById("frame");
			frame.innerHTML = '<iframe src="UserStoryTwelve.html" width="98%" height="100%"></iframe>';
		}
		

		
		/*
		From other Users
		*/
		
		
		/*User Story 7*/
		function userStory7() {
	        $("#msgbox").fadeOut(function(){
        		$(this).text(
        				'List of all IMSIs with call failures during a given time period'
        				).fadeIn();
    		});
			frame = document.getElementById("frame");
			frame.innerHTML = '<iframe src="userStorySevenListImsiFailure.html" width="98%" height="1000"></iframe>';
		}
		/*User Story 8*/
		function userStory8() {
	        $("#msgbox").fadeOut(function(){
        		$(this).text(
        				'Counts, for a given model of phone, the number of call failures it has had during a given time period.'
        				).fadeIn();
    		});
			frame = document.getElementById("frame");
			frame.innerHTML = '<iframe src="userStoryEightSearchByPhoneModel.html" width="98%" height="100%"></iframe>';
		}
		/*User Story 14*/
		function userStory14() {
	        $("#msgbox").fadeOut(function(){
        		$(this).text(
        				'Display, for a given failure Cause Class, the IMSIs that were affected.'
        				).fadeIn();
    		});
			frame = document.getElementById("frame");
			frame.innerHTML = '<iframe src="unknown.html" width="98%" height="100%"></iframe>';
		}
		
		/*User Story 4*/
		function userStory4() {
	        $("#msgbox").fadeOut(function(){
        		$(this).text(
        				'Display, for a given affected IMSI, the Event ID and Cause Code for any / all failures affecting that IMSI.'
        				).fadeIn();
    		});
			frame = document.getElementById("frame");
			frame.innerHTML = '<iframe src="userStoryFourDisplayUsingImsi.html" width="98%" height="100%"></iframe>';
		}
		/*User Story 5*/
		function userStory5(){
			$("#msgbox").fadeOut(function(){
        		$(this).text(
        				'Display, for a given IMSI, the number of failures during given time period.'
        				).fadeIn();
    		});
			frame = document.getElementById("frame");
			frame.innerHTML = '<iframe src="userStoryFive.html" width="98%" height="100%"></iframe>';
		}
		/*User Story 6*/
		function userStory6(){
			$("#msgbox").fadeOut(function(){
        		$(this).text(
        				'Display, for a given IMSI, all the unique Cause Codes associated with its call failures'
        		).fadeIn();
    		});
			frame = document.getElementById("frame");
			frame.innerHTML = '<iframe src="unknown.html" width="98%" height="100%"></iframe>';
		}
	</script>

</body>
</html>