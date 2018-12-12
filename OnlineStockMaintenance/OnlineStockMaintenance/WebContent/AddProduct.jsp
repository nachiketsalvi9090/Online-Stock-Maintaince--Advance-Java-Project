<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Stock Maintenance(Add Product)</title>
<script type="text/javascript">
	function validate() {
		var frm = document.getElementById("frm1");

		var pname = frm.pname.value;

		var pprice = frm.pprice.value;

		var pcategory = frm.pcateory.value;

		if (pname == "") {
			alert("please Enter Product Name");
			return false;
		} else if (pprice == "") {
			alert("please Enter Product Price");
			return false;
		} else if (pcategory == "") {
			alert("please Enter Product category");
			return false;
		}
		return true;
	}
</script>
</head>
<body
	background="BackgroundImg.jpg">
	<h1 align="center">
		<font style="font-family: fantasy;" color="Blue" size="15">Add
			New Product </font>
	</h1>
	<form method="get" action="AddProductServlet"
		onsubmit="return validate()" id="frm1">
		<table align="center">
			<%-- <tr>
				<td>ID</td>
				<td><input type="text" name="pid" value="${pid }"></td>
			</tr>  --%>
			<tr>
				<td>Name</td>
				<td><input type="text" name="pname"></td>
			</tr>
			<tr>
				<td>Price</td>
				<td><input type="text" name="pprice"></td>
			</tr>
			<tr>
				<td>Category</td>
				<td><input type="text" name="pcateory"></td>
			</tr>
			<tr>
				<td><input type="submit" name="add" value="ADD"></td>
				<td><input type="reset" name="cancel" value="Cancel"></td>
			</tr>


		</table>
	</form>
</body>
</html>