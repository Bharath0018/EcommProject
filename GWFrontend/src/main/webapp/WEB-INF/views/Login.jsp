<%@include file="Header.jsp" %>


<div class="container">
<form action="perform_login" method="post">
<table class="table table-bordered responsive">
	<tr class="success">
		<td colspan="4" class="text-center">Login In Here</td>
	</tr>
	<tr>
		<td colspan="2">Username or Email Address</td>
		<td colspan="2"><input type="text" name="username" required/></td>
	</tr>
	<tr>
		<td colspan="2">Password</td>
		<td colspan="2"><input type="password" name="password" required/></td>
	</tr>
	<tr>
	<td colspan="2"></td>
		<td colspan="2" align="left">
			
			<input type="submit" value="Login" class="btn btn-success"/>
			
		</td>
	</tr>
	</table>
	</form>
	</div>
