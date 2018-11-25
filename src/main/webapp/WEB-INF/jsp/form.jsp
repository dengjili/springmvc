<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>参数学习</title>
</head>
<body>
	<h2>normalParam</h2>
	<form id="form" action="normalParam">
		<table>
			<tr>
				<td>名称</td>
				<td><input id="name" name="name" value=""/></td>
			</tr>
			<tr>
				<td>备注</td>
				<td><input id="note" name="note" value=""/></td>
			</tr>
			<tr>
				<td></td>
				<td align="right"><input type="submit" value="点击"/></td>
			</tr>
		</table>
	</form>
	<hr/>
	<h2>beanParam</h2>
	<form id="form" action="beanParam">
		<table>
			<tr>
				<td>名称</td>
				<td><input id="name" name="name" value=""/></td>
			</tr>
			<tr>
				<td>备注</td>
				<td><input id="note" name="note" value=""/></td>
			</tr>
			<tr>
				<td></td>
				<td align="right"><input type="submit" value="点击"/></td>
			</tr>
		</table>
	</form>
	<hr/>
	<h2>requestParam</h2>
	<form id="form" action="requestParam">
		<table>
			<tr>
				<td>名称</td>
				<td><input id="pre_name" name="pre_name" value=""/></td>
			</tr>
			<tr>
				<td>备注</td>
				<td><input id="pre_note" name="pre_note" value=""/></td>
			</tr>
			<tr>
				<td></td>
				<td align="right"><input type="submit" value="点击"/></td>
			</tr>
		</table>
	</form>
	
	<hr/>
	<h2>pathVariable</h2>
	<a href="get/123/张三">pathVariable</a>
</body>
</html>