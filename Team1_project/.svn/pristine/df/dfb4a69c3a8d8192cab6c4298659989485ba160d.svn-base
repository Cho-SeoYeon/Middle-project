<%@page import="kr.or.ddit.vo.MemberVO"%>
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

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script   src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

<script type="text/javascript" src="<%= request.getContextPath()%>/js/jquery-3.7.1.min.js"></script>
<link rel="stylesheet" href="<%= request.getContextPath()%>/font/font.css">
<link rel="stylesheet" href="<%= request.getContextPath()%>/css/main.css">
</head>
<script>

$(function(){

	let nav = document.querySelector('#tab-button-nav')
    let sections = document.querySelectorAll('.tab-section');
	
	//탭버튼 클릭시 해당 영역 show
	$('.tab-button').on('click', function() {
		sections.forEach(function(section) {
			section.setAttribute('hidden', true);
		});
		var selectSection = $(this).data('tab-section')
		$('#'+selectSection).removeAttr('hidden');
	})
	
    $(document).on('click','.reviewInsertCar',function(){
    	$("#rvwInsert").attr("action", "<%=request.getContextPath()%>/carReviewInsert.do");
  		resNo = $(this).data('resno');
  		
  		
  		const reviewTable = $(this).parents(".afterCar");
  		
  		const car_img = $(".car_img", reviewTable).html();
  		const car_type = $(".car_type", reviewTable).html();
  		const rent_nm = $(".rent_nm", reviewTable).html();
  		const start = $(".rent_start", reviewTable).html();
  		const end = $(".rent_end", reviewTable).html();
  		
  		
  		$('#resNo').val(resNo);
  		$('#img').html(car_img);
  		$('#type').html(car_type);
  		$('#nm').html(rent_nm);
  		$('#start').html(start);
  		$('#end').html(end);
  		
  		
    	$('#myModal').modal('show', function(){
    		
    	});

    
    });
    
    $(document).on('click','.reviewInsert',function(){
    	$("#rvwInsert").attr("action", "<%=request.getContextPath()%>/roomReviewInsert.do");

			resNo = $(this).data('resno');

			const reviewTable = $(this).parents(".afterRomm");

			const lod_img = $(".lod_img", reviewTable).html();
			const lod_type = $(".lod_type", reviewTable).html();
			const lod_nm = $(".lod_nm", reviewTable).html();
			const room_type = $(".room_type", reviewTable).html();
			const start = $(".start", reviewTable).html();
			const end = $(".end", reviewTable).html();

			$('#resNo').val(resNo);
			$('#img').html(lod_img);
			$('#type').html(lod_type);
			$('#nm').html(lod_nm);
			$('#room_type').html(room_type);
			$('#start').html(start);
			$('#end').html(end);

			$('#myModal').modal('show', function() {

			});

	});
    //예약 취소에 대하여
    $(document).on('click','.roomCancle',function(){
    	var resNo = $(this).data('resno');
    	location.href = '<%=request.getContextPath()%>/deleteResRoom.do?resNo='+resNo;
    	
    });
    
    $(document).on('click','.carCancle',function(){
    	var resNo = $(this).data('resno');
    	location.href = '<%=request.getContextPath()%>/deleteResCar.do?resNo='+resNo;
    	
    });
    
//  별점 작동하는 이벤트
    $('.review_score > .star').click(function(){
       $(this).parent().children('span').removeClass('on');
       $(this).addClass('on').prevAll('span').addClass('on');
       
       var value = parseInt(this.getAttribute("data-value"));
       console.log("선택된 별의 값:", value);
	   $('#star').val(value);
    })
});

function beforeRoom(){
	$.ajax({
		url : "<%=request.getContextPath()%>/beforeResRoom.do",
		type : "GET",
		dataType :  "json",
		success : function(res){
			var list = "";
			$.each(res,function(i,v){
				list += "<tr><td rowspan = '6'><img src='../images/"+v.l_img_path+"' alt='숙소이미지' width='200px' height='200px'></td></tr>";
				list +=	"<tr><td>"+v.lod_type+"</td></tr>";
				list +=	"<tr><td>"+v.lod_nm+"</td></tr>";
				list +=	"<tr><td>"+v.room_type+"</td></tr>";
				list +=	"<tr><td>시작일: "+v.lod_start+"</td></tr>";
				list +=	"<tr><td>종료일: "+v.lod_end+"</td></tr>";
				list +=	"<tr><td><input type='button' value='예약취소' class='btn btn-danger roomCancle' data-resno='"+v.res_r_no+"'></td></tr>"
				list += "<tr colspan='2'><td></td></tr>"
			})
			if (res.length == 0) {
				list += "<tr>";
				list += 	"<td colspan='4' style='text-align:center'>데이터가 존재하지 않습니다.</td>";
				list += "</tr>";
			} 
			
			$('#beforeRoom').empty();
			$("#beforeRoom").append(list);
		},
		error :  function(xhr){
			alert("상태 : "+xhr.status)
		}
	});	
}

function afterRoom(){
	$.ajax({
		url : "<%=request.getContextPath()%>/afterResRoom.do",
		type : "GET",
		dataType :  "json",
		success : function(res){
			var list = "";
			$.each(res,function(i,v){
				list += "<tr><td rowspan = '6' class='lod_img'><img src='../images/"+v.l_img_path+"' alt='숙소이미지' width='200px' height='200px'></td></tr>";
				list +=	"<tr><td class='lod_type'>"+v.lod_type+"</td></tr>";
				list +=	"<tr><td class='lod_nm'>"+v.lod_nm+"</td></tr>";
				list +=	"<tr><td class='room_type'>"+v.room_type+"</td></tr>";
				list +=	"<tr><td class='start'>시작일: "+v.lod_start+"</td></tr>";
				list +=	"<tr><td class='end'>종료일: "+v.lod_end+"</td></tr>";
				list +=	"<tr><td><input type='button' value='리뷰등록' class='btn btn-success reviewInsert' data-resno='"+v.res_r_no+"'></td></tr>"
				list += "<tr colspan='2'><td></td></tr>";
			})
			if (res.length == 0) {
				list += "<tr>";
				list += 	"<td colspan='4' style='text-align:center'>데이터가 존재하지 않습니다.</td>";
				list += "</tr>";
			}
			$('#afterRoom').empty();
			$("#afterRoom").append(list);
		},
		error :  function(xhr){
			alert("상태 : "+xhr.status)
		}
	});	
}

function beforeCar(){
	$.ajax({
		url : "<%=request.getContextPath()%>/beforeResCar.do",
		type : "GET",
		dataType : "json",
		success : function(res) {
			var list = "";

			$.each(res, function(i, v) {
				list += "<tr><td rowspan = '5'><img src='../images/"+v.c_img_path+"' alt='숙소이미지' width='200px' height='200px'></td></tr>";
				list +=	"<tr><td>"+v.car_type+"</td></tr>";
				list +=	"<tr><td>"+v.car_name+"  "+v.car_year+"</td></tr>";
				list +=	"<tr><td>"+v.rent_nm+"</td></tr>";
				list +=	"<t><td>시작일: "+v.rent_start+" 종료일: "+v.rent_end+"</td></tr>";
				list +=	"<tr><td><input type='button' value='예약취소' class='btn btn-danger carCancle' data-resno='"+v.res_c_no+"'></td></tr>"
				list += "<tr colspan='2'><td></td></tr>";
			})
			if (res.length == 0) {
				list += "<tr>";
				list += 	"<td colspan='4' style='text-align:center'>데이터가 존재하지 않습니다.</td>";
				list += "</tr>";
			}
			$('#beforeCar').empty();
			$("#beforeCar").append(list);

		},
		error : function(xhr) {
			alert("상태 : " + xhr.status)
		}
	});
}
function afterCar(){
	$.ajax({
		url : "<%=request.getContextPath()%>/afterResCar.do",
		type : "GET",
		dataType : "json",
		success : function(res) {
			var list = "";
		
			$.each(res, function(i, v) {
				list += "<tr><td rowspan = '6' class='car_img'><img src='../images/"+v.c_img_path+"' alt='숙소이미지' width='200px' height='200px'></td></tr>";
				list +=	"<tr><td class='car_type'>"+v.car_type+"</td></tr>";
				list +=	"<tr><td class='car_name'>"+v.car_name+"  "+v.car_year+"</td></tr>";
				list +=	"<tr><td class='rent_nm'>"+v.rent_nm+"</td></tr>";
				list +=	"<tr><td class='rent_start'>시작일: "+v.rent_start+"</td></tr>";
				list +=	"<tr><td class='rent_end'>종료일: "+v.rent_end+"</td></tr>";
				list +=	"<tr><td><input type='button' value='리뷰등록' data-resno="+v.res_c_no+" class='btn btn-success reviewInsertCar'></td></tr>";
				list += "<tr colspan='2'><td></td></tr>"
			})
			if (res.length == 0) {
				list += "<tr>";
				list += 	"<td colspan='4' style='text-align:center'>데이터가 존재하지 않습니다.</td>";
				list += "</tr>";
			}
			$('#afterCar').empty();
			$("#afterCar").append(list);
		},
		error : function(xhr) {
			alert("상태 : " + xhr.status)
		}
	});
}
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
				<h3>예약내역</h3>
				<p>나의 예약 내역을 확인하고 이용 후에는 리뷰를 등록할 수 있습니다.</p>
				<hr>
				<nav id="tab-button-nav" class="mb-3">
					<button class="tab-button btn btn-warning" data-tab-section="tab-section-1" onclick="beforeRoom()">이용전(숙소)</button>
					<button class="tab-button btn btn-warning" data-tab-section="tab-section-2" onclick="afterRoom()">이용후(숙소)</button>
					<button class="tab-button btn btn-warning" data-tab-section="tab-section-3" onclick="beforeCar()">이용전(차량)</button>
					<button class="tab-button btn btn-warning" data-tab-section="tab-section-4" onclick="afterCar()">이용후(차량)</button>
				</nav>
			</div>
		<main>
			<br>
			<section id="tab-section-1" class="tab-section ">
				<div>
					이용전 숙소 예약 내역<br>
					<table id="beforeRoom">
					</table>
				</div>
			</section>
			<section id="tab-section-2" class="tab-section" hidden>
				<div>
					이용후 숙소 예약 내역<br>
					<div>
						<table class='afterRomm' id="afterRoom"></table>
					</div>
				</div>
			</section>
			<section id="tab-section-3" class="tab-section" hidden>
				<div>
					이용전 차량 예약 내역<br>
					<table id="beforeCar">
					</table>
				</div>
			</section>
			<section id="tab-section-4" class="tab-section" hidden>
				<div>
					이용후 차량 예약 내역<br>
					<div id="afterCar">
						<table class='afterCar'></table>
					</div>
				</div>
			</section>
		</main>

		<!-- 모달 -->

		<form id="rvwInsert"
			action="<%=request.getContextPath()%>/roomReviewInsert.do" method="post">

			<input type="hidden" name="resNo" value="" id="resNo">
			<div class="modal" id="myModal">
				<div class="modal-dialog">
					<div class="modal-content">

						<div class="modal-header">
							<h3>리뷰등록</h3>
							<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
						</div>

						<div class="modal-body">
							<table id=reservation>
								<tr data-resno="undefined">
									<td rowspan="6" id='img'></td>
								</tr>
								<tr>
									<td id='type'></td>
								</tr>
								<tr>
									<td id='nm'></td>
								</tr>
								<tr>
									<td id='room_type'></td>
								</tr>
								<tr>
									<td id='start'></td>
								</tr>
								<tr>
									<td id='end'></td>
								</tr>

							</table>
							<hr>
							<label for="star">서비스이용에 만족하시나요?</label><br>
							
							<div class="review_score" >
								<span class="star on" data-value="1"></span> 
								<span class="star" data-value="2"></span> 
								<span class="star" data-value="3"></span> 
								<span class="star" data-value="4"> </span> 
								<span class="star" data-value="5"> </span>
							</div>
							<input type="hidden" name="rvw_star" id="star" value = "1">
							
							<label for="cont" class="mt-5">상세리뷰</label>
							<textarea placeholder="내용을 입력해주세요." id="cont" class="review" name="rvw_cont" rows="4" cols="40"></textarea>
							<br> <br>
						</div>

						<div class="modal-footer">
							<button type="button" class="btn btn-danger"
								data-bs-dismiss="modal">취소</button>
							<button type="submit" class="btn" data-bs-dismiss="modal"
								id="send">등록</button>
						</div>

					</div>
				</div>
			</div>
		</form>
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