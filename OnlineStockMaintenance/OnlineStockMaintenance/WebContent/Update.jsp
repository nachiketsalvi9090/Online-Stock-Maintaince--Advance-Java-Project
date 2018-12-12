<%@page import="com.operation.ProductOperations"%>
<%@page import="com.utility.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Stock Maintenance(Update Product)</title>
</head>
<body background="BackgroundImg.jpg">
<font style=" font-family: fantasy;" color="Blue" size="15">Update product Details </font>
	<form action="UpdateProductDetailsServlet" method="get">
		<table align="center">
			<tr>
				<td>ID</td>
				<td><input type="text"  readonly="readonly" value="${product.pid}" name="pid">
				</td>
			</tr>
			
			<tr>
			<td>Name</td>
			<td><input name="pname"type="text" value="${product.pname}"> </td>
			</tr>
			<tr>
			<td>Price</td>
			<td>
			<input type="text" value="${product.pprice}" name="pprice"></td>
			</tr>
			<tr>
			<td>Category</td>
			<td><input type="text" value="${product.pcatagory}"name="pcatagory"></td>
			</tr>
			<tr>
			<td><input type="submit" value="Update" name="update"></td>
			<td><input type="reset" value="Cancle" name="reset"></td></tr>
		</table>
	</form>
</body>
</html>