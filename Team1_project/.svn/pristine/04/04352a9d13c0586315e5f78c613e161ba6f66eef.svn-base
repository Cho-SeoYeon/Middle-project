<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- <-- Bootstrap CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
 <!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script type="text/javascript" src="<%= request.getContextPath()%>/js/jquery-3.7.1.min.js"></script>
<link rel="stylesheet" href="<%= request.getContextPath()%>/font/font.css">
<link rel="stylesheet" href="<%= request.getContextPath()%>/css/main.css">
	<script>
	$(document).ready(function() {
	// 아이디 유효성 여부
	let isIdValid = false;
	let isPwValid = false;
	
	$("#id").on("keyup", function() {
		let inputId=$("#id").val().trim();
		
		$.ajax({
			url : "<%= request.getContextPath()%>/checkId.do",
			method : "POST",
			data : {"inputId" : inputId},
			success : function(responseData) {
				// validation 두 개의 클래스를 삭제한다
				$("#id").removeClass("is-valid is-invalid");
				if(responseData==0 && inputId.length >=4) { 	// 사용 가능한 아이디
					$("#id").toggleClass("is-valid");//사용가능한 아이디
				} else { // 사용 불가능한 아이디
					$("#id").toggleClass("is-invalid");//사용 불가능한 아이디
					
					isIdValid = false;
					
				}
			},
			error : function (xhr) {
				alert("상태" + xhr.status);
			}
		});
	});
	
	$("#passChk").on("input", function() {
	pass = document.getElementById('pass').value;
	 passChk = document.getElementById('passChk').value;
	 
	 $("#passChk").removeClass("is-valid is-invalid");
		if(pass == passChk) { 	// 사용 가능한 비밀번호
			$("#passChk").toggleClass("is-valid");//사용가능한 아이디
		} else { // 사용 불가능한 아이디
			$("#passChk").toggleClass("is-invalid");//사용 불가능한 아이디
			
			isIdValid = false;
			
		}
	})
				
	

	});
	const autoHyphen = (target) => {
 target.value = target.value
   .replace(/[^0-9]/g, '')
   .replace(/^(\d{2,3})(\d{3,4})(\d{4})$/, `$1-$2-$3`);
}
</script>
</head>
<body>
<!-- header str -->
<div class="border-bottom">
<div class="container">
<nav class="navbar navbar-expand-lg justify-content-lg-between">
  <a class="navbar-brand" href="<%=request.getContextPath()%>/main.jsp"><img alt="로고" src="<%=request.getContextPath()%>/images/logo.png"></a>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link navTxt" href="<%=request.getContextPath()%>/lodging/resLodging.jsp">숙소 </a>
      </li>
      <li class="nav-item">
        <a class="nav-link navTxt" href="<%=request.getContextPath()%>/Car/carList.jsp">렌트카</a>
      </li>
      <li class="nav-item">
        <a class="nav-link navTxt" href="">이벤트</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <img alt="귤" src="<%=request.getContextPath()%>/images/gyul.png">
        </a>
<%
	MemberVO loginMember = (MemberVO)session.getAttribute("loginMember");
%>
<%
if(loginMember == null){
	
%>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="<%=request.getContextPath()%>/Member/login.jsp">로그인/회원가입</a>
        </div>
	<%
} else {		//로그인이 되었을 때..
%>
<div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a id="mainMyPage"class="dropdown-item" href="<%=request.getContextPath()%>/Member/memUpdate.jsp">마이페이지</a>
          <a class="dropdown-item" href="<%=request.getContextPath()%>/reservation/reservation.jsp">예약내역</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="<%=request.getContextPath()%>/memberLogout.do">로그아웃</a>
</div>

		
	<%
}
	%>
        
      </li>
    </ul>
  </div>
</nav>
</div>
</div>
<!-- header end -->
<div class="container xsCont">
<h3>회원가입</h3>
	<form action="<%= request.getContextPath() %>/memberServlet.do" method="post" id="signupForm">
		<!-- 아이디 -->
		<div>
		<label class="form-label mt-2" for="id">아이디</label>
		<input class="form-control" type="text" id="id" name="id">
		<div class="valid-feedback">사용 가능한 아이디입니다.</div>
		<div class="invalid-feedback">사용 불가능한 아이디입니다.</div>
		</div>
		<!-- 비밀번호 -->
		<label class="form-label mt-2" for="pass">비밀번호</label>
		<input class="form-control" type="password" id="pass" name="pass">
		<!-- 비밀번호 확인-->
		<label class="form-label mt-2" for="passChk">비밀번호확인</label>
		<input class="form-control" type="password" id="passChk" name="passChk">
		<div class="invalid-feedback">비밀번호가 일치하지 않습니다.</div>
		<!-- 비밀번호 -->
		<label class="form-label mt-2" for="name">이름</label>
		<input class="form-control" type="text" id="name" name="name">
		<!-- 비밀번호 -->
		<label class="form-label mt-2" for="tel">휴대폰번호</label>
		<input class="form-control" type="tel" id="tel" name="tel" maxlength="13" oninput="autoHyphen(this)" >
		<!-- 비밀번호 -->
		<label class="form-labe mt-2l" for="email">이메일</label>
		<input class="form-control" type="email" id="email" name="email">
		<!-- 비밀번호 -->
		<label class="form-label mt-2" for="birth">생년월일</label>
		<input class="form-control" type="date" id="birth" name="birth">
		<div class="mt-5 text-center">
<!-- 			<button class="btn btn-success" type="submit" disabled="disabled">확인</button> -->
			<button class="btn btn-success" type="submit">확인</button>
		</div>
	</form>
</div>
<!-- footer str -->
<div class="footer">
	<div class="ftWrap">
		<div class="ftTxt">
			<p>(주)제주놀멘컴퍼니</p>
			<p>주소 : 대전광역시 대전광역시 중구 계룡로 846, 3층 305호 | 대표이사 : 김현경 | 사업자등록번호 : 123-12-12345</p>
			<p>전화번호 : 042-222-8202 | 호스팅서비스제공자의 상호 표시 : (주)제주놀멘컴퍼니</p>
		</div>
		<ul class="mt-3">
			<li><a href="#">이용약관</a></li>
			<li><a href="#"><span class="black">개인정보처리방침</span></a></li> 
			<li><a href="#">소비자 분쟁해결 기준</a></li>
			<li><a href="#">콘텐츠산업진흥법에 의한 표시</a></li>
		</ul>
		<div class=copyright>
			<p>Copyright JEJUNOLE COMPANY Corp. All rights reserved.</p>
		</div>
	</div>
</div>
<!-- footer end -->
</body>
</html>