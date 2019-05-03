<%@include file="Header.jsp"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container">


<h3 align="center">Register Page</h3>

<c:url var="addAction" value="/AddUser"/>
	<form:form action="${addAction}"
		modelAttribute="user" method="post">
		<table align="center" class="table table-bordered">
			<tr class="info">
				<td colspan="2"><center>SignUp Here</center></td>
			</tr>
			<tr>
				<td colspan="2">Username or Email Address</td>
				<td colspan="2"><form:input path="username" /></td>
			</tr>
			<tr>
				<td colspan="2">Password</td>
				<td colspan="2"><form:input path="password" /></td>
			</tr>
			<tr>
				<td colspan="2">Mobile No.</td>
				<td colspan="2"><form:input path="mobileNo" /></td>
			</tr>
			<tr>
				<td colspan="2">Email Address</td>
				<td colspan="2"><form:input path="emailId" /></td>
			</tr>
			<tr>
				<td colspan="2">Complete Shipment Address</td>
				<td colspan="2"><form:input path="address" /></td>
			</tr>
			<tr>
				<td colspan="2">
					
						<input type="submit" value="Submit" class="btn btn-success" />
					
				</td>
			</tr>
		</table>
	</form:form>
	</div>		
</body>
</html>