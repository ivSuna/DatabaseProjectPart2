<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Quote</title>
</head>
<body>
	<div align = "center">
		<form action="createQuote">
			<table border="1" cellpadding="5">
				<tr>
					<th>First Name: </th>
					<td align="center" colspan="3">
						<input type="text" name="firstName" size="45"  value="first name" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>Appointed Date: </th>
					<td align="center" colspan="3">
						<input type="text" name="date" size="45"  value="2000-11-11" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>Number of Trees: </th>
					<td align="center" colspan="3">
						<input type="text" name="num_trees" size="45" value="4" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<td align="center" colspan="5">
						<input type="submit" value="Submit Quote"/>
					</td>
				</tr>
				
			</table>
			<a href="login.jsp" target="_self">Return to Login Page</a>
		</form>
	
	</div>
</body>
</html>