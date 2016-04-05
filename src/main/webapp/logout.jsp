<!--logout.jsp-->
 
<%@page import = "java.util.Date" session="true"%>
<%
 
session.setAttribute("user", null);
session.setAttribute("type", null);
session.invalidate();
//response.sendRedirect("index.jsp");
response.sendRedirect("index.html");
%>
<script type="text/javascript">
	function stopAutoImport() {
		alert("Stopping auto-import service")
		$.ajax({
			async:false,
			type:"GET",
			url:"rest/watchservice/stop"})
	}
	stopAutoImport();
</script>