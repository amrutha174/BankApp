<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
session=request.getSession();
out.println("Welcome "+session.getAttribute("name"));
%>
<br><br>
<a href="Balance">Check Balance</a>
<br>
<a href="changePwd.jsp">Change Password</a>
<br>
<a href="transfer.jsp">Amt transfer</a>
<br>
<a href="GetStatement">Get Statement</a>
<br>
<a href="loan.jsp">Apply Loan</a>
<br>
<a href="Logout">Logout</a>
</body>
</body>

</html>