<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${path}/js/jquery-3.6.0.min.js" ></script>
<script>
$(document).ready(function(){

});
</script>

</head>
<body>
<h1> ConnectUS 상세 품목</h1>



<img alt="상품이미지가 없습니다." src="http://localhost:8090/upload/${oneBoard.img}">

	<table border=5>
				<thead>
				  <tr>
				    <th>번호</th>			
				    <th>물건</th>
				    <th>내용</th>
				    <th>동네</th>
				    <th>빌려주는분</th>
				    <th>올린날짜</th>
				  </tr>
				</thead>				
<tbody>
 <tr>
<th>${oneBoard.id}</th>
<td>${oneBoard.title}</td>
<td>${oneBoard.contents}</td>
<td>${oneBoard.boardRegion}</td>
<td>${oneBoard.userId}</td>
<td>${oneBoard.createdAt}</td>
</tr>
</tbody>

</table>

<br>
<br>

<form action="http://localhost:8090/board/${oneBoard.id}/reservationinput" method="post">
<input type="hidden" value="${oneBoard.userId}" name="userId">
<input type="submit" value="예약하기">
</form>

<br>


<br>
<br>

<a href="http://localhost:8090/">홈으로</a>




</body>
</html>