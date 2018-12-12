<%@page import="com.utility.Product"%>
<%@page import="com.operation.ProductOperations"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Stock Maintenance(Delete product)</title>
</head>
<body >
	<form action="DeleteProductServlet" method="get">
		<table>
			<tr>
				<td>ID</td>
				<td><input type="text" readonly="readonly"
					value="${product.pid}" name="pid"></td>
			</tr>
			
			<tr>
				<td>Name</td>
				<td><input readonly="readonly" name="pname" type="text"
					value="${product.pname}"></td>
			</tr>
			<tr>
				<td>Price</td>
				<td><input readonly="readonly" type="text"
					value="${product.pprice}" name="pprice"></td>
			</tr>
			<tr>
				<td>Category</td>
				<td><input readonly="readonly" type="text"
					value="${product.pcatagory}" name="pcatagory"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Delete" name="delete"></td>
				<td><input type="button" value="Cancle" name="cancle"
					onclick="DisplayProductDetailsServlet.java"></td>
			</tr>
		
		</table>
	</form>
</body>
</html>