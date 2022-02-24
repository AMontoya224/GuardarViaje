<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
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
		<h1>
			Save Travels
		</h1>
		<table>
        	<thead>
		        <tr>
		            <th>Expense</th>
		            <th>Vendor</th>
		            <th>Amount</th>
		            <th>Actions</th>
		        </tr>
		    </thead>
        	<tbody>
				<c:forEach var="expense" items="${expensesList}">
					<tr>
                    	<td>
                    		<form action="/expenses/${expense.getId()}" method="GET">
								<button type="submit" class="link">
									<c:out value="${expense.getName()}"/>
								</button>
							</form>
						</td>
                        <td><c:out value="${expense.getVendor()}"/></td>
                        <td><c:out value="${expense.getAmount()}"/></td>
                        <td>
                        	<div class="row">
	                        	<form action="/expenses/edit/${expense.getId()}" method="GET">
									<button type="submit" class="link">
										edit
									</button>
								</form>
								<form action="/expenses/delete/${expense.getId()}" method="POST">
									<input type="hidden" name="_method" value="DELETE" />
									<button type="submit" class="delete">
										delete
									</button>
								</form>
							</div>
						</td>
					</tr>
            	</c:forEach>
			</tbody>
		</table>
		<main>
			 <h1>
				Add an expense:
			</h1> 
			<form:form method="POST" action="/expenses/register" modelAttribute="expense">
				<div>
					<p><form:errors path="name" class="error"/></p>
					<p><form:errors path="vendor" class="error"/></p>
					<p><form:errors path="amount" class="error"/></p>
					<p><form:errors path="description" class="error"/></p>
				</div>
				<div class="justify">
					<form:label path="name" for="name">
						Expense Name:
					</form:label>
					<form:input path="name" type="text" name="name" id="name" />
				</div>
				<div class="justify">
					<form:label path="vendor" for="vendor">
						Vendor:
					</form:label>
					<form:input path="vendor" type="text" id="vendor" name="vendor"/>
				</div>
				<div class="justify">
					<form:label path="amount" for="amount">
						Amount:
					</form:label>
					<form:input path="amount" type="text" id="amount" name="amount"/>
				</div>
				<div class="justify">
					<form:label path="description" for="description">
						Description:
					</form:label>
					<form:textarea path="description" placeholder="Write a description..." id="description" name="description"></form:textarea>	
				</div>
				<button type="submit" class="submit" >
					Submit
				</button>
			</form:form>
		</main>
	</body>
</html>