<!--logout.jsp-->
 
<%@page import = "java.util.Date" session="true"%>
<%
 
session.setAttribute("user", null);
session.setAttribute("type", null);
session.invalidate();
//response.sendRedirect("index.jsp");
response.sendRedirect("index.html");
%>