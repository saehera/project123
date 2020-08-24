<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
<script>
$(document).ready(function(){
	$('#cTable').DataTable({
		"pagingType" : "full_numbers"
		});
	
});
function deleteConfirm(){
	return confirm("Do you want to delete ?");
}
</script>
<title>Insert title here</title>
</head>
<body>
<h1 align="center"><font color='orange',style="italic"><em>All User Details</em></font></h1>

<table border="1" align="center" id="cTable">

	<thead>
			<tr>
				<th>SNO</th>
				<th>FIRST NAME</th>
				<th>LAST NAME</th>
				<th>EMAIL</th>
				<th>ACTION</th>
			</tr>
	</thead>
	<tbody>
	<c:forEach items="${userList}" var="c" varStatus="index">
	<tr>
	<td>${index.count}</td>
	<td>${c.firstName}</td>
	<td>${c.lastName}</td>
	<td>${c.email}</td>
	
	<td><a href="editUser?userId = ${c.userId}"><i class='fas fa-pen'>Edit</i></a>&nbsp;
	 <a href="deleteuserId?userId = ${c.userId}" onclick="deleteConfirm()"><i class='fas fa-trash-alt'>Delete</i></a>
	</td>
	
	</tr>
	
	</c:forEach>
	</tbody>

</table>
  <button type="button"><a href="loadForm">Add New User</a></button>
</body>
</html>