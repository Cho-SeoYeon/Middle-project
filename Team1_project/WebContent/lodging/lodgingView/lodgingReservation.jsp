<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@page import="kr.or.ddit.vo.LodgingCouponVO"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="kr.or.ddit.vo.ResLodgingInfoVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제주놀멘</title>
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
<script src="<%=request.getContextPath() %>/js/lodging.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/lodging/lodging.css">
<%
	
	ResLodgingInfoVO infoVo = (ResLodgingInfoVO) request.getAttribute("ResLodgingInfo");
	String lodName = (String)request.getAttribute("lodName");
	String lodStart = (String)request.getAttribute("lodStart");
	String lodEnd = (String)request.getAttribute("lodEnd");
	
	String userId = null;
	if(session.getAttribute("loginMember") != null){
		userId = ((MemberVO)session.getAttribute("loginMember")).getUser_id();
	}
	
	long nights = 0;
	
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	try {
		Date startDate = format.parse(lodStart);
		Date endDate = format.parse(lodEnd);
		long diff = endDate.getTime() - startDate.getTime();
		nights = diff / (24 * 60 * 60 * 1000); 
	} catch (Exception e){
		e.printStackTrace();
	}
	
	int price = infoVo.getRoom_price();
	int allIterPrice = price * (int) nights;
	
	int roomNo = infoVo.getRoom_no();
	String lodCode = infoVo.getLod_code();
%>

<script>
$(function(){
	
	let allIterPrice = <%= allIterPrice%>;
	
	// 쿠폰 적용 버튼
	$('#couponBtn').on('click', function(){
		
		let cnpCode = $('#cnp_code').val();
		let user_id = <%= session.getAttribute("user_id")%>;
		
		// 쿠폰코드 체크
		$.ajax({
			url : `<%= request.getContextPath()%>/lodgingCnpCheck.do`,
			type : 'post',
			data : {
					 "cnpCode" : cnpCode,
					 "user_id" : user_id
			},
			success : function(result){

				if (result.status === "success"){
					let cnpSale = result.cnp_sale;
					let salePrice = allIterPrice * (cnpSale / 100);
					let totalPrice = allIterPrice * (100 - cnpSale) / 100;
					
					$('.cnp_sale').html("- " + salePrice + "원");
					$('.total_price').html(totalPrice+"원");
					$('#resLodBtn').val("총 " + totalPrice + "원 결제하기");
				} else if (result.status === "fail"){ 
					// 상황 별 message 출력				
					alert(result.message);
				}	
				
			},
			error : function(xhr){
				alert("상태 : " + xhr.status);
			},
			dataType : 'json'
		}); // 쿠폰코드 체크 ajax 끝

	}); // 쿠폰적용 버튼 이벤트
	
	
	// 결제수단 버튼 클릭 이벤트
	$('.pay-method-Btn').on('click', function(){
		
        // 다른 버튼의 active 클래스 제거
        $('.pay-method-Btn').not(this).removeClass('active');
        // 현재 클릭된 버튼의 active 클래스 토글
        $(this).toggleClass('active');
        
	}); // 결제수단 버튼 클릭 이벤트 끝
	
	
	// 결제하기 버튼 클릭 이벤트
	$('#resLodBtn').on('click', function(){
		
		// 값 가져오기
		let roomNo = <%= roomNo%>;
		let copCode = $('#cnp_code').text();
		let lodStart = "<%= lodStart%>";
		let lodEnd = "<%= lodEnd%>";
		let lodPriceText = $('.total_price').text();
		let lodPrice = lodPriceText.replace(/[^0-9]/g, '');
		let lodCode = "<%= lodCode %>";
		let lodName = $('.lodg-info-lodgName').val();
		let resUserName = $('.user_name').val();
		let resUserTel = $('.user_tel').val();
		let resPayMethod = $(this).data('method');

		// form에 값 저장
		$('#res_room_no').val(roomNo);
		$('#res_cop_code').val(copCode);
		$('#res_lod_start').val(lodStart);
		$('#res_lod_end').val(lodEnd);
		$('#res_lod_price').val(lodPrice);
		$('#res_lod_code').val(lodCode);
		$('#res_lod_name').val(lodName);
		$('#res_user_name').val(resUserName);
		$('#res_user_tel').val(resUserTel);
		$('#res_pay_method').val(resPayMethod);
		
		alert("결제가 완료 되었습니다.");
		
		// form 제출하기
		$('#pay-send').submit();
		
	});
	
}); // 전체 펑션 끝

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

<!-- 결제하기 버튼 클릭 시 전송할 데이터 담는 hidden form -->
<form id="pay-send" action="<%=request.getContextPath()%>/resLod.do" method="post">
	<input type="hidden" name="room_no" id="res_room_no">
	<input type="hidden" name="room_no" id="res_room_no">
	<input type="hidden" name="lod_start" id="res_lod_start">
	<input type="hidden" name="lod_end" id="res_lod_end">
	<input type="hidden" name="lod_price" id="res_lod_price"> 
	<input type="hidden" name="cop_code" id="res_cop_code"> 
	<input type="hidden" name="lod_code" id="res_lod_code"> 
	<input type="hidden" name="lod_name" id="res_lod_name"> 
	<input type="hidden" name="userId" id="res_user_id" value="<%=userId%>"> 
	<input type="hidden" name="user_name" id="res_user_name"> 
	<input type="hidden" name="user_tel" id="res_user_tel"> 
	<input type="hidden" name="pay_method" id="res_pay_method"> 
</form>

<div class="container smCont">
		
		<div class="row">
			<div class="col-8">
				<div class="res-info-check mt-5">
					<h3> 예약 확인 및 결제 </h3><br>
					<div class="user-info-check">
						<h4 class="res-user-info"> 예약자 정보 </h4>
						<label for="userName"> 예약자 이름 </label>
						<div class="row">
							<div class="col-4">
							<input type="text" placeholder="텍스트를 입력해 주세요." class="user_name form-control mb-3">
							</div>
						</div>
						<label for="phone-num"> 휴대폰 번호 </label>
						<div class="row">
							<div class="col-4">
							<input type="text" placeholder="텍스트를 입력해 주세요." class="user_tel form-control">
							</div>
						</div>
						
					</div>
					<br>
					<hr>
					<br>
					<div class="sale-info-check">
						<h4 class="res-sale-info"> 할인 정보 </h4>
						<label for="cnp_code"> 쿠폰번호 </label>
						  	<div class="row">
								<div class="col-4">
								<input class="form-control" type="text" placeholder="텍스트를 입력해주세요." name="cnp_code" id="cnp_code">
								</div>
								<div class="col-1">
								<input class="btn btn-warning" type="button" id="couponBtn" value="적용">
								</div>
							</div>
						
					</div>
					<br><hr>
					
					<div class="pay-info-check">
						<h4 class="res-pay-method"> 결제 수단 </h4>
						<input type="button" value="신용/체크 카드" class="pay-method-Btnbtn btn btn-outline-success" data-method="credit_card">
						<input type="button" value="간편 계좌 이체" class="pay-method-Btnbtn btn btn-outline-success" data-method="bank_transfer">
					</div>
				</div>
			</div>
		
			
		<div class="col-4">
				<div class="res-room mt-5"> 
					<div class="lodg-info-check mb-3">
						<p class="lodg-info-lodgName"> <%= lodName %> </p>
						<div class="res-room-img mb-3">
							<img src="<%= request.getContextPath() %>/lodgingImage.do?imgName=<%=infoVo.getR_img_path() %>" alt="<%=infoVo.getR_img_path() %>" style="width:100%;">
						</div>
						<table class="lodg-table">
						<tr><td class="text-muted">객실</td><td class="txtSize" id="re_room_name"><%= infoVo.getRoom_type() %></td></tr>
						<tr><td class="text-muted">일정</td><td class="txtSize"><%= lodStart %>~<%= lodEnd %>(<%= nights %>박)</td></tr>
						<tr><td class="text-muted">기준인원</td><td class="txtSize">최대 <%= infoVo.getRoom_prs() %> 인</td></tr>
						</table>
					</div>
				
					<div class="pay-info">
						<table class="price-table" style="width:100%">
						<tr><td class="text-muted">객실 가격 </td> <td class="priceValue"><%= allIterPrice %>원</td></tr>
						<tr><td class="text-muted">할인 적용 </td> <td class="priceValue"><p class="cnp_sale">0원</p></td></tr>
						<tr><td class="text-muted">총 결제 금액 </td> <td class="priceValue"><p class="total_price"><%= allIterPrice %>원</p></td></tr>
						</table>
						<div class="text-center mt-3">
						<input class="btn btn-success" type="button" id="resLodBtn" value="총 <%= allIterPrice %>원 결제하기">
						</div>
					</div> 		
				</div>
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