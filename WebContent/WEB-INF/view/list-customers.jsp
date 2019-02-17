<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>
<body>
	List Customers 
	
	<div id="wrapper">
		<div id="header">
				<h2>CRM Customer Table</h2>
		</div>
	
		
		<div id="container">
			<div id="content">
		
			<input type="button" value="Add Customer" onClick="window.location.href='showFormForAdd'; return false;" 
			class= "add-button"/>
		
				<table>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Action</th>
						<th>Action 2</th>
					</tr>
				
				
				<c:forEach var="tempCust" items="${customers}">
				
					<c:url var="updateLink" value="showFormForUpdate">
						<c:param name="customerId" value="${tempCust.id}"></c:param>
					</c:url>
					
					<c:url var="deleteLink" value="delete">
						<c:param name="customerId" value="${tempCust.id}"></c:param>
					</c:url>
				
					<tr>
						<td> ${tempCust.firstName}</td>
						<td> ${tempCust.lastName}</td>
						<td> ${tempCust.email}</td>
						<td> <a href="${updateLink}" >Update</a></td>
						<td> <a href="${deleteLink}" onClick="if (!(confirm('Wanna Delete the customer?')))">Delete</a></td>
					</tr>
				</c:forEach>
				</table>
				
			</div>
		</div>
	</div>
	
	
</body>
</html>