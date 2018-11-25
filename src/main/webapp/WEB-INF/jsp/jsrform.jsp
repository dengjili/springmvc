<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>参数校验学习</title>
</head>
<body>
	<h2>JSR 303</h2>
	<form id="form" action="validate">
		<table>
			<tr>
				<td>产品编号</td>
				<td><input id="productId" name="productId" value=""/></td>
			</tr>
			<tr>
				<td>用户编号</td>
				<td><input id="userId" name="userId" value=""/></td>
			</tr>
			<tr>
				<td>交易日期</td>
				<td><input type="date" id="date" name="date" value=""/></td>
			</tr>
			<tr>
				<td>价格</td>
				<td><input id="price" name="price" value=""/></td>
			</tr>
			<tr>
				<td>数量</td>
				<td><input id="quantity" name="quantity" value=""/></td>
			</tr>
			<tr>
				<td>交易金额</td>
				<td><input id="amount" name="amount" value=""/></td>
			</tr>
			<tr>
				<td>电话号码</td>
				<td><input id="phone" name="phone" value=""/></td>
			</tr>
			<tr>
				<td>备注</td>
				<td>
					<textarea id="remarks" name="remarks" rows="5" cols="20"></textarea> 
				</td>
			</tr>
			<tr>
				<td></td>
				<td align="right"><input type="submit" value="点击"/></td>
			</tr>
		</table>
	</form>
</body>
</html>