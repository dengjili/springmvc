<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>文件上传学习</title>
</head>
<body>
	<h2>文件上传学习</h2>
	<form id="form" action="upload" enctype="multipart/form-data" method="post">
		<table>
			<tr>
                <td>请选择文件：</td>
                <td><input type="file" name="file"></td>
            </tr>
			<tr>
				<td>产品编号</td>
				<td><input id="productId" name="productId" value=""/></td>
			</tr>
			<tr>
				<td>用户编号</td>
				<td><input id="userId" name="userId" value=""/></td>
			</tr>
			<tr>
				<td></td>
				<td align="right"><input type="submit" value="点击"/></td>
			</tr>
		</table>
	</form>
</body>
</html>