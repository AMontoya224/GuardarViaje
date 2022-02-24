<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>
			Show Expense
		</title>
		<link rel="stylesheet" type="text/css" href="/css/style.css">
	</head>
	<body>
		<main>
			<div class="row">
				 <h1>
					Expense Details
				</h1> 
				<form action="/expenses/" method="GET">
					<button type="submit" class="link">
						Go back
					</button>
				</form>
			</div>
			<h3>
				Expense Name: <c:out value="${expense.getName()}"/>
			</h3>
			<h3>
				Expense Description: <c:out value="${expense.getDescription()}"/>
			</h3>
			<h3>
				Vendor: <c:out value="${expense.getVendor()}"/>
			</h3>
			<h3>
				Amount Spent: <c:out value="${expense.getAmount()}"/>
			</h3>
		</main>
	</body>
</html>