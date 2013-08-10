<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<a href="../add.jsp">添加</a>
	<form action="findById" method="post">
		id:<input name="id" />
		<input type="submit" value="查询" />
	</form>
	<table>
		<c:forEach items="${allPerson}" var="person">
			<tr>
				<td>${person.id}</td>
				<td>${person.name}</td>
				<td><a href="delete?id=${person.id}">删除</a></td>
				<td><a href="update?id=${person.id}&name=${person.name}">修改名字加1</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>