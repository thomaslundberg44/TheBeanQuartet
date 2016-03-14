<%
   	String name = request.getParameter( "username" );
String name1 = request.getParameter( "user" );
	session.setAttribute( "theName", name );
	session.setAttribute( "theName1", name1 );
%>

<HTML>
<BODY>
<!-- <A HREF="NextPage.jsp">Continue</A>  -->

</BODY>
</HTML>