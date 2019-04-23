<%@include file="Header.jsp" %>

<form action="<c:url value="/addCategory"/>" method="post">
<table>
	<tr>
		<td colspan="2"><center>Category Detail</center></td>
	</tr>
	<tr>
		<td>Category Name</td>
		<td><input type="text" name="catName" id="catName"/></td>
	</tr>
	<tr>
		<td>Category Description</td>
		<td><textarea rows="6" cols="30" name="catDesc"></textarea>
	</tr>
	<tr>
		<td colspan="2">
		<center><input type="submit" value="Add Category"/></center>
		</td>
	</tr>

</table>
</form>
</body>
</html>