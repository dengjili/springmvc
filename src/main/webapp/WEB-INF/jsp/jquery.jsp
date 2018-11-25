<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>复杂参数学习</title>
	<script type="text/javascript" src="${pageContext.request.contextPath }/resource/js/jquery-1.11.3.min.js"></script>
	<script type="text/javascript">
		
		$(function($) {
			$("#json").bind("click", function() {
				var data = {
					name : "mmp",
					param : {
						start : 1,
						limit : 10
					}
				};
				// 发送json数据
				$.ajax({
					type : "POST",
					url : "requestBody",
					data : JSON.stringify(data),
					contentType : 'application/json',
					success : function(data) {
						alert(JSON.stringify(data));
					}
				});
			});

			$("#list").bind("click", function() {
				// []认为是数组
				var data = [ 1, 2, 4 ];
				// 发送json数据
				$.ajax({
					type : "POST",
					url : "listArray",
					data : JSON.stringify(data),
					contentType : 'application/json',
					success : function(data) {
						alert(JSON.stringify(data));
					}
				});
			});

			$("#custlist").bind("click", function() {
				// []认为是数组,自定义类型
				var data = [ {
					start : 1,
					limit : 10
				}, {
					start : 5,
					limit : 20
				}, {
					start : 100,
					limit : 200
				} ];
				// 发送json数据
				$.ajax({
					type : "POST",
					url : "listCust",
					data : JSON.stringify(data),
					contentType : 'application/json',
					success : function(data) {
						alert(JSON.stringify(data));
					}
				});
			});

			$("#commit").bind("click", function() {
				// []认为是数组
				var data = [ 1, 2, 4 ];
				// 发送json数据
				$.ajax({
					type : "GET",
					url : "serialize",
					data : $("#form").serialize(),
					success : function(data) {
						alert(JSON.stringify(data));
					}
				});
			});
		});
	</script>
</head>
<body>
	<h2>json</h2>
	<button type="button" id="json">json</button>
	<hr>
	<h2>列表数据</h2>
	<button type="button" id="list">列表数据</button>
	<hr>
	<h2>自定义类型列表</h2>
	<button type="button" id="custlist">自定义类型列表</button>
	<hr>
	<h2>表单序列化</h2>
	<form id="form" action="serialize">
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
				<td align="right"><input id="commit" type="submit" value="点击"/></td>
			</tr>
		</table>
	</form>
</body>
</html>