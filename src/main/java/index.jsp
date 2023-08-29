<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name = "viewport" content = "width=device-width, initial-scale = 1">  
<link href = "https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">  
<script src = "https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js">  
</script>  
<title>Insert title here</title>
</head>
<body>
 	<h2>How to fetch data from database in Spring MVC</h2>


	<table class = "table">  
  <thead>  
		<th>Sr No</th>
		<th>Name</th>
		<th>Designation</th>
		<th>Department</th>
		<th>Salary</th>
		<th>Location</th>

		<c:forEach var="emp" items="${listEmp}" varStatus="status">
			<tr>
				<td>${status.index + 1}</td>
				<td>${emp.name}</td>
				<td>${emp.designation}</td>
				<td>${emp.dept}</td>
				<td>${emp.salary}</td>
				<td>${emp.location}</td>

			</tr>
		</c:forEach>
		</thead>
	</table>

 	
</body>
</html>