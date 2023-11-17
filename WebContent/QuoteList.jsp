<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>All Quote List</title>
</head>
<body>
   <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Quotes</h2></caption>
            <tr>
				<th>Quote ID</th>
                <th>Date</th>
                <th># of Trees</th>
                <th>Price</th>
                <th>Status</th>
                <th>Completed</th>
                
                

            </tr>
            <c:forEach var="quotes" items="${listQuote}">
                <tr style="text-align:center">
                    <td><c:out value="${quotes.quote_id}" /></td>
                    <td><c:out value="${quotes.date}" /></td>
                    <td><c:out value="${quotes.num_trees}" /></td>         
                    <td><c:out value="${quotes.price}" /></td>
                    <td><c:out value="${quotes.status}" /></td>
                    <td><c:out value="${quotes.completed}" /></td>
          
                    
            </c:forEach>
        </table>
    </div>   
</body>
</html>