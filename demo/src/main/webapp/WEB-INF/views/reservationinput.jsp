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

<form action="http://localhost:8090/board/reservationinput" method="post">

번호 : <input type="text" name="boardId" value="${boardId}" readonly><br>
렌터 : <input type="text" name="buyerId" value="렌터세션ID" readonly> <br>
오너 : <input type="text" name="sellerId" value="${param.userId}" readonly> <br>
커넥트시작 : <input type="text" name="startRental"> <br>
커넥트종료 : <input type="text" name="endRental"> <br>
희망비용 : <input type="text" name="price" >원 <br>
<input type="submit" value="예약"> 

</form>


<br>
<a href="http://localhost:8090/">홈으로</a>

</body>
</html>