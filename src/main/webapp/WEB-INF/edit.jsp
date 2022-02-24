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
			Read Share
		</title>
		<link rel="stylesheet" type="text/css" href="/css/style.css">
	</head>
	<body>
		<main>
			<div class="row">
				 <h1>
					Edit Expense:
				</h1> 
				<form action="/expenses" method="GET">
					<button type="submit" class="link">
						Go back
					</button>
				</form>
			</div>
			<form:form method="POST" action="/expenses/${expense.getId()}" modelAttribute="expense">
				<input type="hidden" name="_method" value="put">
				<input type="hidden" name="id" value="${expense.getId()}">
				<div>
					<p><form:errors path="name" class="error"/></p>
					<p><form:errors path="vendor" class="error"/></p>
					<p><form:errors path="amount" class="error"/></p>
					<p><form:errors path="description" class="error"/></p>
				</div>
				<div>
					<form:label path="name" for="name">
						Expense Name:
					</form:label>
					<form:input path="name" type="text" name="name" id="name" value="${expense.getName()}" />
				</div>
				<div>
					<form:label path="vendor" for="vendor">
						Vendor:
					</form:label>
					<form:input path="vendor" type="text" id="vendor" name="vendor" value="${expense.getVendor()}" />
				</div>
				<div>
					<form:label path="amount" for="amount">
						Amount:
					</form:label>
					<form:input path="amount" type="text" id="amount" name="amount" value="${expense.getAmount()}" />
				</div>
				<div>
					<form:label path="description" for="description">
						Description:
					</form:label>
					<form:textarea path="description" id="description" name="description" value="${expense.getDescription()}"></form:textarea>	
				</div>
				<button type="submit" class="submit" >
					Submit
				</button>
			</form:form>
		</main>
	</body>
</html>