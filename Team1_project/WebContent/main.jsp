<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제주놀멘</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<!-- <-- Bootstrap CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
 <!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script type="text/javascript" src="<%= request.getContextPath()%>/js/jquery-3.7.1.min.js"></script>
<link rel="stylesheet" href="<%= request.getContextPath()%>/font/font.css">
<link rel="stylesheet" href="<%= request.getContextPath()%>/css/main.css">
</head>
<script>
$(function() {
	$("#mainSearchBtn").on("click", function() {
		mainStr = $("#mainStr").val();
		mainEnd = $("#mainEnd").val();
		mainSearch = $("#mainSearch").val();

		
		if($('#mainSelect').val()==="숙소"){
			mainSelectVal = "숙소";
		}else if($('#mainSelect').val()==="렌트카"){
			mainSelectVal = "렌트카";
		}
		
		$("#mainStrHddn").val(mainStr);
		$("#mainEndHddn").val(mainEnd);
		$("#mainSearchHddn").val(mainSearch);
		$("#mainSelectValue").val(mainSelectVal);
		
		$("#mainSearchForm").submit();
		
	});
});
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
        <a class="nav-link navTxt" href="<%=request.getContextPath()%>/notice/userNotice.jsp">이벤트</a>
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
<form id="mainSearchForm" action="<%= request.getContextPath()%>/mainSearch.do">
	<input type="hidden" name="mainStrHddn" id="mainStrHddn">
	<input type="hidden" name="mainEndHddn" id="mainEndHddn">
	<input type="hidden" name="mainSearchHddn" id="mainSearchHddn">
	<input type="hidden" name="mainSelectValue" id="mainSelectValue">
</form>
<div class="visual">
	<img alt="메인이미지" src="<%= request.getContextPath() %>/images/visual.png">
	<div class="visualTxt">
		<h1>제.주.놀.멘.에서</h1>
		<h2>숙소부터 렌트카까지</h2>
	</div>
	<div class="searchArea">
		<div class="row">
			<div class="col-2">
			  <select id="mainSelect" class="form-select mb-3" aria-label="Large select example">
				  <option value="숙소"selected>숙소</option>
				  <option value="렌트카">렌트카</option>
				</select>
			</div>
			<div class="col-3">
			  <input type="date" class="form-control" id="mainStr">
			</div>
			<div class="col-3">
			  <input type="date" class="form-control" id="mainEnd">
			</div>
			<div class="col-3">
			  <input type="text" class="form-control" id="mainSearch" placeholder="검색어를 입력하세요">
			</div>
			<div class="col-1">
			  <input type="button" class="btn btn-primary" id="mainSearchBtn" value="검색">
			</div>
		</div>
	</div>
</div>
<div class="container my-5">
  <h5 class="my-4">이벤트</h5>
 <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
  <div class="carousel-indicators">
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
  </div>
  <div class="carousel-inner">
    <div class="carousel-item active">
      <ul>
      	<li><a><img src="images/coupon-1.jfif" class="d-block w-100" alt="쿠폰이미지1"></a></li>
      	<li><a><img src="images/coupon-2.jfif" class="d-block w-100" alt="쿠폰이미지2"></a></li>
      	<li><a><img src="images/coupon-3.jfif" class="d-block w-100" alt="쿠폰이미지3"></a></li>
      </ul>
    </div>
    <div class="carousel-item">
      <ul>
      	<li><a><img src="images/coupon-4.jfif" class="d-block w-100" alt="쿠폰이미지4"></a></li>
      	<li><a><img src="images/coupon-5.jfif" class="d-block w-100" alt="쿠폰이미지5"></a></li>
      	<li><a><img src="images/coupon-6.jfif" class="d-block w-100" alt="쿠폰이미지6"></a></li>
      </ul>
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
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