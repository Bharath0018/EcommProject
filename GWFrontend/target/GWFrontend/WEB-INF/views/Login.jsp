<%@include file="Header.jsp" %>
<style>
body
{
	margin: 0;
	padding: 0;
	background: url('/GWFrontend/resources/images/gadgetworld.jpg');
	background-size: cover;
	background-position: center;
	font-family: sans-serif;
}

.loginbox
{
	width: 320px;
	height: 420px;
	background: #76D7C4;
	color: #CD5C5C;
	top: 50%;
	left: 50%;
	position: absolute;
	transform: translate(-50%,-50%);
	box-sizing: border-box;
	padding: 70px 30px;
}

.avatar
{
	width: 100px;
	heigth: 100px;
	border-radius: 50%;
	position: absolute;
	top: -10%;
	left: calc(50% - 50px);
}

h1
{
	margin: 0;
	padding: 0 0 20px;
	text-align: center;
	font-size: 22px;
	font-color: #CD5C5C;
}

.loginbox p
{
	margin: 0;
	padding: 0;
	font-weight: bold;
	font-color: #CD5C5C;
}

.loginbox input
{
	width: 100%;
	margin-bottom: 20px;
}

.loginbox input[type="text"], input[type="password"]
{
	border: none;
	border-bottom: 1px solid #fff;
	background: transparent;
	outline: none;
	height: 40px;
	color: #fff;
	font-size: 16px;
}

.loginbox input[type="submit"]
{
	border: none;
	outline: none;
	height: 40px;
	background: #00ff00;
	color: #fff;
	border-radius: 20px;
}

.loginbox input[type="submit"]:hover
{
	cursor: pointer;
	background: #ffc107;
	color: #000;	
}

.loginbox a
{
	text-decoration: none;
	font-size: 12px;
	line-height: 20px;
	color: darkgrey;
}

.loginbox a:hover
{
	color: #ffc107;
}
</style>
<div class="loginbox">
	<img src="<c:url value="/resources/images/avatar.jpg"/>" class="avatar">

<!-- <form action="perform_login" method="post">
<table class="table table-bordered responsive">
	<tr class="success">
		<td colspan="4" class="text-center">Login In Here</td>
	</tr>
	<tr>
		<td colspan="2">Username </td>
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
	</form> -->
	<h1>Login Here</h1>
		 <form action="perform_login" method="post"> 
			<p>Username</p>
			<input type="text" id="id1"placeholder="Enter Username" name="username" required >
			<p>Password</p>
			<input type="password" placeholder="Enter Password" name="password" required>
			<input type="submit" value="Submit" class="btn btn-success">
			
			
		</form>
</div>