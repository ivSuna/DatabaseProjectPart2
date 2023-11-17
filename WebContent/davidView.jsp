<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>David Smith Page</title>
</head>
<body>

<div align = "center">
	<center><h1>Welcome David Smith! Job Dashboard Below</h1> </center>
	
	<div align="center">
        <table border="1" cellpadding="6">
            <caption><h2>List of Clients</h2></caption>
            <tr>
                <th>Email</th>
                <th>First name</th>
                <th>Last name</th>
                <th>Address</th>
                <th>Password</th>
                <th>Birthday</th>
                <th>cash_bal($)</th>
                
            </tr>
            <c:forEach var="users" items="${listUser}">
                <tr style="text-align:center">
                    <td><c:out value="${users.email}" /></td>
                    <td><c:out value="${users.firstName}" /></td>
                    <td><c:out value="${users.lastName}" /></td>
                    <td><c:out value= "${users.adress_street_num} ${users.adress_street} ${users.adress_city} ${users.adress_state} ${users.adress_zip_code}" /></td>
                    <td><c:out value="${users.password}" /></td>
                    <td><c:out value="${users.birthday}" /></td>
                    <td><c:out value="${users.cash_bal}"/></td>
                    
            </c:forEach>
        </table>
       
       <table border="1" cellpadding="6">
            <caption><h2>List of Quotes</h2></caption>
            <tr>
                <th>Quote Id</th>
                <th>First Name</th>
                <th>Date</th>
                <th># of Trees</th>
                <th>Price</th>
                <th>Status</th>
                <th>Completed</th>
                
                
            </tr>
            <c:forEach var="quote" items="${listQuote}">
                <tr style="text-align:center">
                   	<td>${quote.quote_id} </td>
                   	<td>${quote.firstName} </td>
                   	<td>${quote.quote_id} </td>
                   	<td>${quote.quote_id} </td>
                   	<td>${quote.quote_id} </td>
                   	<td>${quote.quote_id} </td>

				</tr>
                    
            </c:forEach>
        </table>
       
	
       
       <a href="login.jsp"target ="_self" > logout</a><br><br> 
	</div>
	
	
</div>

</body>
</html>










