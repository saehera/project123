<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
      table {
        border-collapse: inherit;
        border-spacing: 0 15px;
      }
      th {
        background-color: #4287f5;
        color: white;
      }
      th,
      td {
        width: 100px;
        text-align: center;
        border: 1px solid black;
        padding: 0px;
      }
      h2 {
        color: #4287f5;
      }
    </style>
</head>
<body>

	<h1 align="center">User Account Creation Form</h1>

	<form:form action="createUser" method="post" modelAttribute="userAccModel">
		<table align="center">
		
			<tr>
			
				<th>First Name:</th>
				<td><form:input path="firstName" /></td>
			</tr>
			<tr>
				<th>Last Name:</th>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<th>Email:</th>
				<td><form:input path="email" /></td>
			</tr>
			
			
			<tr>
					<th>Gender</th>
					<td><form:radiobuttons path="gender" items="${gender}" /></td>
				</tr>

			<tr>
					<th>Role</th>
					<td><form:select path="role" items="${role}"></form:select></td>	
				</tr>
			
			

			<tr>
				<th></th>
				<td><input type="reset" value="Reset">&nbsp;<input
					type="submit" value="Create"></td>
					
			</tr>
		</table>
	</form:form>
</body>

</html>