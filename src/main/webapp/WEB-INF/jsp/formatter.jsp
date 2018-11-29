<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>格式化学习</title>
</head>
<body>
	<h2>格式化学习</h2>
	<form id="form" action="format" method="post">
		<table>
			<tr>
				<td>日期</td>
				<td><input id="date" name="date" value="2018-01-12"/></td>
			</tr>
			<tr>
				<td>金额</td>
				<td><input id="amount" name="amount" value="123,000.00"/></td>
			</tr>
			<tr>
				<td></td>
				<td align="right"><input type="submit" value="点击"/></td>
			</tr>
		</table>
	</form>
</body>
</html>