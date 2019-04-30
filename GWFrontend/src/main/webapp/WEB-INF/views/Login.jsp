<%@ page language="java" contentType="text/html"%>

<%@include file="Header.jsp" %>
<%@include file="Carousel.jsp" %>

<form action="perform_login" method="post">
<table class="table table-bordered responsive">
	<tr class="success">
		<td colspan="4" class="text-center">Login In Here</td>
	</tr>
	<tr>
		<td colspan="2">Username or Email Address</td>
		<td colspan="2"><input type="text" name="username"/></td>
	</tr>
	<tr>
		<td colspan="2">Password</td>
		<td colspan="2"><input type="password" name="passwd"/></td>
	</tr>
	<tr>
		<td colspan="4">
			<center>
			<input type="submit" value="Login" class="btn btn-success"/>
			</center>
		</td>
	</tr>
	</table>
	</form>
</body>
</html>