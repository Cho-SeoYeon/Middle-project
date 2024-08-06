<%@page import="kr.or.ddit.vo.ResLodVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/Team1_project/js/jquery-3.7.1.min.js"></script>
<script src="/Team1_project/js/lodging.js"></script>
<link rel="stylesheet" href="/Team1_project/lodging/lodging.css">
<%
	String userId = (String) request.getAttribute("userId");
	String lodStart = (String) request.getAttribute("lodStart");
	String lodEnd = (String) request.getAttribute("lodEnd");
	int lodPrice = (Integer) request.getAttribute("lodPrice");
	String userName = (String) request.getAttribute("userName");
	String userTel = (String) request.getAttribute("userTel");

%>

</head>
<body>

<p> <%= userId%>(<%= userName%>)님 결재 완료 </p>
<p> 전화번호 : <%= userTel%></p>
<p> 일정 : <%= lodStart%>~<%=lodEnd%></p>
<p> 결재금액 : <%= lodPrice%>원</p>


<input type="button" value="메인으로 돌아가기" name="reslod-success-goMain" id="reslod-success-goMain">


</body>
<script>
$(function(){
	
	let mypath = "<%= request.getContextPath()%>";
	
	$("#reslod-success-goMain").on('click', function(){
		
		 window.location.href = mypath+"/main.jsp";
		
	});
	
});

</script>
</html>