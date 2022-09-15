<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.6.0.min.js" ></script>
<script>
$(document).ready(function(){

});
</script>

</head>
<body>
<h1> ConnectUS 전체 품목 </h1>

	<table border=5>
		<thead>
			<tr>
				<th>번호</th>			
				<th>물건</th>
				<th>동네</th>
				<th>빌려주는분</th>
				<th>올린날짜</th>
			</tr>
		</thead>				
	<tbody>
<c:forEach items="${allboard}" var="board">

 <tr>
<th>${board.id}</th>
<td><a href="/board/${board.id}">${board.title}</a></td>
<td>${board.boardRegion}</td>
<td>${board.userId}</td>
<td>${board.createdAt}</td>
</tr>
</c:forEach>
</tbody>

</table>
<br>
<br>
<a href="http://localhost:8090/">홈으로</a>




</body>
</html>