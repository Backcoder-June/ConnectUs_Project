<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${path}/css/main.css">    
<script src="js/jquery-3.6.0.min.js" ></script>
<script>
$(document).ready(function(){

	 var current = new Date().toISOString().slice(0, 10);
	 $("#here").html(current);
	 

});
</script>

</head>
<body>
<h1> ConnectUS 전체 품목 </h1>

<div id="here">

</div>

<a href="http://localhost:8090/registerBoard">물품등록</a>
<br>
<br>
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
   <th>
   <a href ="/board/${board.id}">${board.title} <br>
   <img alt="사진이 없어요" width=200 height=200 src="http://localhost:8090/upload/${board.img}"> <br>
   </a> 
   </th>
   <td>${board.boardRegion}</td>
   <td>${board.userId}</td>
   <td>${board.createdAt}</td>
   </tr>





<%--    <div class="box">
	<span>${board.id}</span>
	<span>${board.title}</span>
	<span>${board.boardRegion}</span>
	<span>${board.userId}</span>
	<span>${board.createdAt}</span>
</div>
 --%>
 
 
</c:forEach>
</tbody>

</table>
<br>



<br>
<a href="http://localhost:8090/">홈으로</a>




</body>
</html>