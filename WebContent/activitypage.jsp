<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Activity page</title>
</head>

<center><h1>Welcome!</h1> </center>

 
	<body>
	 <div align = "center">
	 
	 	 <p> Create a quote Below!</p>
	 	 <div align="center">
        <table border="1" cellpadding="6">
            <caption><h2>Logged In User</h2></caption>
            <tr>
                <th>Email</th>
                <th>First name</th>
                <th>Last name</th>
                <th>Address</th>
                <th>Birthday</th>
                <th>cash_bal($)</th>
                
            </tr>
            
            
            <tr style="text-align:center">
                 <td><c:out value="${listCurrUserEmail}" /></td>
                 <td><c:out value="${listCurrUserFirstName}" /></td>
                 <td><c:out value="${listCurrUserLastName}" /></td>
                 <td><c:out value= "${listCurrUserAddNum} ${listCurrUserAddSt} ${listCurrUserAddCity} ${listCurrUserAddState} ${listCurrUserZip}" /></td>
                 <td><c:out value="${listCurrUserBirth}" /></td>
                 <td><c:out value="${listCurrUserCash}"/></td>
            </tr>        
            
        </table>
        
       <br><br><br>
       <h2>User Quotes</h2>
	</div>
		 <a href="createQuote.jsp"target ="_self" > Create Quote</a><br><br>
		 



		 <a href="login.jsp"target ="_self" > logout</a><br><br> 

	 </div>
	</body>
</html>