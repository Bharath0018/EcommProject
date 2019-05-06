<%@include file="Header.jsp"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container">




<c:url var="addAction" value="/AddUser"/>
	<form:form action="${addAction}"
		modelAttribute="user" method="post">
		<table align="center" class="table table-bordered">
			<tr class="info">
				<td colspan="6"><center>SignUp Here</center></td>
			</tr>
			<tr>
				<td colspan="2">Username</td>
				<td colspan="2"><form:input path="username" required="true"/></td>
			</tr>
			<tr>
				<td colspan="2">Password</td>
				<td colspan="2"><form:input path="password" type="password" required="true" /></td>
			</tr>
			<tr>
				<td colspan="2">Mobile No.(10-digits)</td>
				<td colspan="2"><form:input type="tel" path="mobileNo" required="true" pattern="[0-9]{10}"/></td>
			</tr>
			<tr>
				<td colspan="2">Email Address</td>
				<td colspan="2"><form:input path="emailId" type="email" required="true"/></td>
			</tr>
			<tr>
				<td colspan="2">Complete Shipment Address</td>
				<td colspan="2"><form:input path="address" required="true" /></td>
			</tr>
			<tr>
				<td colspan="6">
					
						<input type="submit" value="Submit" class="btn btn-success" />
					
				</td>
			</tr>
		</table>
	</form:form>
	</div>		
</body>
</html>