<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>
<title>제주놀멘</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css">
<!-- <-- Bootstrap CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
 <!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script   src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

<script type="text/javascript" src="<%= request.getContextPath()%>/js/jquery-3.7.1.min.js"></script>
<link rel="stylesheet" href="<%= request.getContextPath()%>/font/font.css">
<link rel="stylesheet" href="<%= request.getContextPath()%>/css/main.css">
</head>
<script>
	var mypath = "<%=request.getContextPath()%>";
	$(function() {
		$.ajax({
			url : `${mypath}/noticeList.do`,
			type : 'get',
			success : function(result){
				
		 	 code =`<div class="container">`
	         code += `<table class="table table-hover" style="width: 100%">`
	         code += `<thead><tr><th>No</th><th>제목</th><th>내용</th><th>작성일</th></tr></thead><tbody>`;
			//반복문을 써서 모든 리스트를 꺼내와야함					
			$.each(result,function(i,v){
					
				content = v.notice_cont;
					
				content = content.replaceAll(/\n/g, "<br>");
				
				code += `<tr>`
				code += `<td>${v.notice_no}</td>`
			    code += `<td><a href="${mypath}/userNoticeDetail.do?noticeNo=${v.notice_no}">${v.notice_title}</a></td>`
			    code += `<td>${content}</td>`
			    code += `<td>${v.notice_date}</td> </tr>`;
	       		 		
	      	});

	      	code += `</tbody></table></div>`;

			$('#list').html(code);
			
			},
			error : function(xhr) {
				alert("상태 : " + xhr.status);
			},
			dataType : 'json'
			
		})	
	})
</script>
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
<div class="container">
	<div class="row">
		<div class="col-3">
			<ul class="mypage">
			  <li><a href="<%=request.getContextPath()%>/Member/memUpdate.jsp">내정보관리</a></li>
			  <li><a href="<%=request.getContextPath()%>/reservation/reservation.jsp">예약내역확인</a></li>
			  <li><a href="<%=request.getContextPath()%>/review/myReviewList.jsp">내가 쓴 리뷰보기</a></li>
			  <li><a href="<%=request.getContextPath()%>/qna/qnaList.jsp">고객문의</a></li>
			  <li><a href="<%=request.getContextPath()%>/notice/userNotice.jsp">공지사항</a></li>
			</ul>
		</div>
		<div class="col-9">
			<div class="mt-5">
				 <h4>공지사항</h4>
				 <p>제주놀맨 업데이트 정보 등 다양한 소식을 알려드립니다.</p><hr>
			 </div>
			 <div id="list"></div>
		 </div>
	</div>
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