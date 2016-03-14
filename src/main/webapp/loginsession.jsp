<!--login.jsp-->
 
<%@page session="true"%>
<%
	String user=request.getParameter("user");
	String type=request.getParameter("type");

	session.setMaxInactiveInterval(24 * 60 * 60);
	session.setAttribute("user",user);
	session.setAttribute("type",type);
	
	
	if (type.equals("Admin")) {
		response.sendRedirect("MainSystemAdmin.jsp");
	}
	if (type.equals("SupEng")) {
		response.sendRedirect("SupportEngineer.jsp");
	}
	if (type.equals("NetEng")) {
		response.sendRedirect("NetManEngineer.jsp");
	}
	if (type.equals("CSR")) {
		response.sendRedirect("CustSupRep.jsp");
	}

%>
