<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@page import="kr.or.ddit.vo.LodgingRoomReviewVO"%>
<%@page import="kr.or.ddit.vo.RoomsVO"%>
<%@page import="kr.or.ddit.vo.LodgingDetailVO"%>
<%@page import="com.google.gson.JsonElement"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=0yaizupxy9&submodules=geocoder"></script>
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

	String mypath = request.getContextPath();
	List<LodgingDetailVO> detailList = (List<LodgingDetailVO>) request.getAttribute("theLodgingList");
	String lodCode = (String)request.getAttribute("lodgingCode");
	String startDate = (String)request.getAttribute("startDate");
	String endDate = (String)request.getAttribute("endDate");
%>	

<script>
$(function(){
	
	// 예약하기 버튼 클릭 이벤트
	$(document).on('click', '#resRoomBtn', function(){
		
		// alert("성공");
		let roomName = $('#detail-lod-Name').text();
		let roomType = $(this).data('room-type');
		
		// form에 값 저장
		$("#resLodName").val(roomName);
		$("#resRoomType").val(roomType);
			
		// form 제출 
		$('#res-lod').submit();
	
	}); // 예약하기 버튼 이벤트 끝
	
}); // 전체 펑션 끝
</script>

</head>

<body>

<!-- 예약하기 버튼 클릭할 때 데이터 보낼 form -->
<form id="res-lod" action="<%=request.getContextPath()%>/resLodgingInfoCheck.do" method="post">
	<input type="hidden" name="lod_name" id="resLodName">
	<input type="hidden" name="lod_code" id="resLodCode" value="<%=lodCode%>">
	<input type="hidden" name="lod_start" id="resStartDate"  value="<%=startDate%>">
	<input type="hidden" name="lod_end" id="resEndDate" value="<%=endDate%>">
	<input type="hidden" name="room_type" id="resRoomType">
</form>
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
<div class="container smCont">
	
	<%
	String lodAddr = null;
		for(LodgingDetailVO detail : detailList){
			lodAddr = detail.getLod_addr();
	%>
	
	<div class="lodging-detail-body">
		<div class="lodging-detail-body-img text-center my-5">
		   <img src="<%= request.getContextPath() %>/lodgingImage.do?imgName=<%= detail.getL_img_path() %>" alt="<%= detail.getL_img_path() %>"/>
		</div>
		
		<div class="detail-lod-Type-Name">
		   <p class="detail-lod-Type"> <%= detail.getLod_type() %> </p><br>
		   <p class="detail-lod-Name" id="detail-lod-Name"> <%= detail.getLod_nm() %> </p><br>
		</div>
		<hr><br>
		
		   <p class="detail-lod-select"> 객실 선택 </p>
		   <!-- 객실 리스트 출력 부분 -->
		<%
		   for(RoomsVO room : detail.getRoomList()){
		%>
			<div class="detail-oneRoom-info">
				
				<div class="room-img">
			       <img src="<%=request.getContextPath() %>/lodgingImage.do?imgName=<%=room.getR_img_path() %>" alt="<%=room.getR_img_path() %>"/>
		       	</div>
		
				<div class="room-info"> 
					<div class="room-type">	
						<p> <%=room.getRoom_type()%> (<%=room.getRoom_prs() %> 인실) </p>
				    </div>
				    <div class="room-type-innerbox">
				    	<div class="checkinNoutTime">
							<p> 입실  14:00 <br>
							<p> 퇴실  11:00 <br>
						</div>
						<div class="res-room">
							<p class="room-price"> <%=room.getRoom_price() %>원 <br>
							<input type="button" class="res-room-btn btn btn-outline-warning" id="resRoomBtn" value="객실예약" data-room-type="<%=room.getRoom_type() %>" data-room-img="<%=room.getR_img_path() %>">
						</div>
					</div>
				</div> 
			</div>
		<%	   
		   }
		%>
		  
		<hr>
		<div>
			<br>
			<p class="detail-lodg-intro"> 숙소 소개 <br>
			<p class="lodCont text-muted"> <%= detail.getLod_cont() %> <br> 
			<br>
		</div>
		
		<hr>
		<div>
			<br>
			<p class="detail-lodg-info"> 숙소 이용 정보 <br>
			<p class="lodInfo text-muted"> <%= detail.getLod_info() %> <br> 
			<br>
		</div>
		<hr>
		<div>
			<br>
			<p class="detail-lodg-location"> 위치 <br>
			<p class="lodAddr text-muted"> <%= detail.getLod_addr() %> <br>
			      <div class="search">
		         <input id="address" type="text" placeholder="검색할 주소" style ="display : none;">
		         <input id="submit" type="button" value="주소검색" style ="display : none;">
		      </div>
		      <div id="map" style="width:100%;height:600px;"></div>
			<br>
		</div>
		<hr>
		
		<div class="review">
			<p class="detail-lodg-revw"> 리뷰 <br>
		<%
		   for(LodgingRoomReviewVO review : detail.getReviewList()){
		%>
			<div class="lodg-review-cont">
				<div class="review-info">
					<p class="review-writer"><%= review.getUser_id() %>	
		            <p class="review-star">
		            <% 
		            String stars = "";
		            for(int i = 0; i < review.getRvw_star(); i++) {
		                stars += "★";
		            }
		            for(int i = review.getRvw_star(); i < 5; i++) {
		                stars += "☆";
		            }
		            out.print(stars);
		            %>
		            </p>
				</div>
				<div class="review-cont">
					<p> <%=review.getRvw_cont() %>
				</div>
				<hr>
			</div>
		<%
		   } // for문 끝
		%>	
		</div>
	</div>
	<%} %>
	
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

<script>

$(document).ready(function() {
    
	// 직접 주소를 함수에 전달
    var address = "<%= lodAddr %>";
    searchAddressToCoordinate(address);
});
	
	selectMapList();

	//검색한 주소의 정보를 insertAddress 함수로 넘겨준다.
	function searchAddressToCoordinate(address) {
	  naver.maps.Service.geocode({
	      query: address
	  }, function(status, response) {
	      if (status === naver.maps.Service.Status.ERROR) {
	          return alert('Something Wrong!');
	      }
	      if (response.v2.meta.totalCount === 0) {
	          return alert('올바른 주소를 입력해주세요.');
	      }
	      var htmlAddresses = [],
	          item = response.v2.addresses[0],
	          point = new naver.maps.Point(item.x, item.y);
	      if (item.roadAddress) {
	          htmlAddresses.push('[도로명 주소] ' + item.roadAddress);
	      }
	      if (item.jibunAddress) {
	          htmlAddresses.push('[지번 주소] ' + item.jibunAddress);
	      }
	      if (item.englishAddress) {
	          htmlAddresses.push('[영문명 주소] ' + item.englishAddress);
	      }
	      insertAddress(item.roadAddress, item.x, item.y);
	  });
	}
	
	// 주소 검색의 이벤트
	$('#address').on('keydown', function(e) {
	  var keyCode = e.which;
	  if (keyCode === 13) { // Enter Key
	      searchAddressToCoordinate($('#address').val());
	  }
	});
	$('#submit').on('click', function(e) {
	  e.preventDefault();
	  searchAddressToCoordinate($('#address').val());
	});
	naver.maps.Event.once(map, 'init_stylemap', initGeocoder);
	  
	//검색정보를 테이블로 작성해주고, 지도에 마커를 찍어준다.
	function insertAddress(address, latitude, longitude) {
	 var mapList = "";
	 mapList += "<tr>"
	 mapList += "   <td>" + address + "</td>"
	 mapList += "   <td>" + latitude + "</td>"
	 mapList += "   <td>" + longitude + "</td>"
	 mapList += "</tr>"
	
	 $('#mapList').append(mapList);   
	
	 var map = new naver.maps.Map('map', {
	     center: new naver.maps.LatLng(longitude, latitude),
	     zoom: 14
	 });
	  var marker = new naver.maps.Marker({
	      map: map,
	      position: new naver.maps.LatLng(longitude, latitude),
	  });
	}
	
	/*
	//지도를 그려주는 함수
	function selectMapList() {
	 
	 var map = new naver.maps.Map('map', {
	     center: new naver.maps.LatLng(37.3595704, 127.105399),
	     zoom: 10
	 });
	}
	*/
	
	// 지도를 이동하게 해주는 함수
	function moveMap(len, lat) {
	 var mapOptions = {
	        center: new naver.maps.LatLng(len, lat),
	        zoom: 15,
	        mapTypeControl: true
	    };
	  var map = new naver.maps.Map('map', mapOptions);
	  var marker = new naver.maps.Marker({
	      position: new naver.maps.LatLng(len, lat),
	      map: map
	  });
	}
</script>

</html>    
    
