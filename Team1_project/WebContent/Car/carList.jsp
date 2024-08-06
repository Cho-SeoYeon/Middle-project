<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@page import="kr.or.ddit.vo.CarVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="true" %>
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
<link rel="stylesheet" href="<%= request.getContextPath()%>/Car/car.css">


<script>

$(function(){
// 	대여일시,반납일시에 오늘날짜와 내일날짜를 placeholder처럼 넣어놓은 코드

	let mainStrHddn = "<%=(String)request.getAttribute("mainStrHddn") %>";
	let mainEndHddn = "<%=(String)request.getAttribute("mainEndHddn") %>";
	let mainSearchHddn = "<%=(String)request.getAttribute("mainSearchHddn") %>";	
	
	if(mainSearchHddn === "null"){
		mainSearchHddn="";
	}
	
	$('#inDate').val(mainStrHddn);
	$('#outDate').val(mainEndHddn);
	$('#carName').val(mainSearchHddn);
	
	if($('#inDate').val() === "" && $('#outDate').val() === ""){
		let currentDate = new Date();
	 	$('#inDate').val(currentDate.toISOString().slice(0, 10));
	 	currentDate.setDate(currentDate.getDate() + 1);
	 	let tomorrow = currentDate.toISOString().slice(0, 10);
	 	$('#outDate').val(tomorrow);
	}

///////////////////////////////////////////////////////////

	// 평상시 리스트 띄워주는곳(검색 안했을때)
			let carName1 = $('#carName').val();
			let inDate1 = $('#inDate').val();
			let outDate1 = $('#outDate').val();
			let carType1 = $('input[name="carType"]:checked').val();
			
			 $.ajax({
			        url: "<%=request.getContextPath()%>/carList.do",
			        type: "GET",
			        data : {
			        	"carName" : carName1,
			        	"inDate" :inDate1,
			        	"outDate" :outDate1,
			        	"carType" :carType1
			        },
			        dataType: "json",
			        success: function(carList) {
			            var tableHtml = "";
			         
			            $.each(carList, function(i, car){
			            	tableHtml += `<div class="car-item mt-5">`;
			               	tableHtml += `<img class="car-img" alt="asd" src="<%= request.getContextPath()%>/imageView.do?file=${car.c_img_path}">`;
			               	tableHtml += `<div class = "center-right-info">`;
			               	tableHtml += `<p class ="car-rent-nm">${car.rent_nm}</p>`;
			               	tableHtml += `<p class="car-name">${car.car_name}</p>`;
			               	tableHtml += `<p class ="car-price">${car.car_price}</p>`;
			               	tableHtml += `<p style="display : none;" class ="car-no" data-car-no ='${car.car_no}' >${car.car_no}</p>`;
			               	tableHtml += `<p style="display : none;" class ="car-cont" data-car-cont ='${car.car_cont}' >${car.car_cont}</p>`;
			               	tableHtml += `<p style="display : none;" class ="rent-addr" data-rent-addr ='${car.rent_addr}' >${car.rent_addr}</p>`;
			               	tableHtml += `<p style="display : none;" class ="inDate" data-inDate ='${car.inDate}' >${car.inDate}</p>`;
			               	tableHtml += `<p style="display : none;" class ="outDate" data-outDate ='${car.outDate}' >${car.outDate}</p>`;
			               	tableHtml += `<p style="display : none;" class ="car_year" data-car_year ='${car.car_year}' >${car.car_year}</p>`;
			               	tableHtml += `</div></div><br>`;
			   				tableHtml += `<hr>`;
			            	
			            });
			            
			            tableHtml += '</table>';
			            $('#firstInput').html(tableHtml);
			        },
			        error: function(xhr) {
			            alert('Error: ' + xhr.status);
			        }
			    });
//     $.ajax({
<%--         url: "<%=request.getContextPath()%>/carList.do", --%>
//         type: "GET",
//         dataType: "json",
//         success: function(carList) {
//             var tableHtml = "";
            
//             $.each(carList, function(i, car){
//            		tableHtml += `<div class="car-item">`;
<%--                	tableHtml += `<img class="car-img" alt="asd" src="<%= request.getContextPath()%>/imageView.do?file=${car.c_img_path}">`; --%>
//                	tableHtml += `<div class = "center-right-info">`;
//                	tableHtml += `<p class ="car-rent-nm">${car.rent_nm}</p>`;
//                	tableHtml += `<p class="car-name">${car.car_name}</p>`;
//                	tableHtml += `<p class ="car-price">${car.car_price}</p>`;
//                	tableHtml += `<p style="display : none;" class ="car-no" data-car-no ='${car.car_no}' >${car.car_no}</p>`;
//                	tableHtml += `<p style="display : none;" class ="car-cont" data-car-cont ='${car.car_cont}' >${car.car_cont}</p>`;
//                	tableHtml += `<p style="display : none;" class ="rent-addr" data-rent-addr ='${car.rent_addr}' >${car.rent_addr}</p>`;
//                	tableHtml += `<p style="display : none;" class ="car_year" data-car_year ='${car.car_year}' >${car.car_year}</p>`;
//                	tableHtml += `</div></div><br>`;
//    				tableHtml += `<hr>`;
               	
//             });
            
//             tableHtml += '</table>';
//             $('#firstInput').html(tableHtml);
//         },
//         error: function(xhr) {
//             alert('Error: ' + xhr.status);
//         }
//     });


    $(document).on('click', '.car-item', function() {
        
        var rentNm = $(this).find('.car-rent-nm').text();
        var carName = $(this).find('.car-name').text();
        var imgPath = $(this).find('.car-img').attr('src');
        var carNo = $(this).find('.car-no').data("car-no");
        var carCont = $(this).find('.car-cont').data("car-cont");
        var rentAddr = $(this).find('.rent-addr').data("rent-addr");
        var inDate = $('#inDate').val();
        var outDate = $('#outDate').val();
        var car_year = $(this).find('.car_year').data("car_year");
        var carPrice = $(this).find('.car-price').text();
		alert(carPrice);
// 		alert(inDate);
// 		alert(outDate);
//         var inDate =  = $(this).find('.rent-addr').data("rent-addr");
// 		var outDate =  = $(this).find('.rent-addr').data("rent-addr");
// 		var carYear =  = $(this).find('.rent-addr').data("rent-addr");
// 		var carPrice =  = $(this).find('.rent-addr').data("rent-addr");
    	
    	$('#car_price').val(carPrice);
    	$('#rent_nm').val(rentNm);
    	$('#car_name').val(carName);
    	$('#img_path').val(imgPath);
    	$('#car_no').val(carNo);
    	$('#car_cont').val(carCont);
    	$('#rent_addr').val(rentAddr);
    	$('#detail_InDate').val(inDate);
    	$('#detail_OutDate').val(outDate);
    	$('#car_year').val(car_year);
    	
    	$('#formInfo').submit();
   	});

//--------------------------------------------------------------------------

		// 검색조건에 맞게 리스트 띄워주는곳
		$('#search').on('click', function(){
			let carName = $('#carName').val();
			let inDate = $('#inDate').val();
			let outDate = $('#outDate').val();
			let carType = $('input[name="carType"]:checked').val();
			
			 $.ajax({
			        url: "<%=request.getContextPath()%>/carList.do",
			        type: "GET",
			        data : {
			        	"carName" : carName,
			        	"inDate" :inDate,
			        	"outDate" :outDate,
			        	"carType" :carType
			        },
			        dataType: "json",
			        success: function(carList) {
			            var tableHtml = "";
			            
			            $.each(carList, function(i, car){
			            	tableHtml += `<div class="car-item mt-5">`;
			               	tableHtml += `<img class="car-img" alt="asd" src="<%= request.getContextPath()%>/imageView.do?file=${car.c_img_path}">`;
			               	tableHtml += `<div class = "center-right-info">`;
			               	tableHtml += `<p class ="car-rent-nm">${car.rent_nm}</p>`;
			               	tableHtml += `<p class="car-name">${car.car_name}</p>`;
			               	tableHtml += `<p class ="car-price">${car.car_price}</p>`;
			               	tableHtml += `<p style="display : none;" class ="car-no" data-car-no ='${car.car_no}' >${car.car_no}</p>`;
			               	tableHtml += `<p style="display : none;" class ="car-cont" data-car-cont ='${car.car_cont}' >${car.car_cont}</p>`;
			               	tableHtml += `<p style="display : none;" class ="rent-addr" data-rent-addr ='${car.rent_addr}' >${car.rent_addr}</p>`;
			               	tableHtml += `<p style="display : none;" class ="inDate" data-inDate ='${car.inDate}' >${car.inDate}</p>`;
			               	tableHtml += `<p style="display : none;" class ="outDate" data-outDate ='${car.outDate}' >${car.outDate}</p>`;
			               	tableHtml += `<p style="display : none;" class ="car_year" data-car_year ='${car.car_year}' >${car.car_year}</p>`;
			               	tableHtml += `</div></div><br>`;
			   				tableHtml += `<hr>`;
			            	
			            });
			            
			            tableHtml += '</table>';
			            $('#firstInput').html(tableHtml);
			        },
			        error: function(xhr) {
			            alert('Error: ' + xhr.status);
			        }
			    });
		});

	
})
</script>
</head> 
<form id="formInfo" action="<%= request.getContextPath()%>/carDetail.do">
	<input type="hidden" name="car_price" id="car_price">
	<input type="hidden" name="rent_nm" id="rent_nm">
	<input type="hidden" name="car_name" id="car_name">
	<input type="hidden" name="img_path" id="img_path">
	<input type="hidden" name="car_no" id="car_no">
	<input type="hidden" name="car_cont" id="car_cont">
	<input type="hidden" name="rent_addr" id="rent_addr">
	<input type="hidden" name="inDate" id="detail_InDate">
	<input type="hidden" name="outDate" id="detail_OutDate">
	<input type="hidden" name="car_year" id="car_year">
</form>

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
<!-- 	<input type="button" value = "테스트" id="test"> -->
<div class = "container">
	<div class="row">
		<div class="col-3">
			<div class = "side-left">
				<div class ="side-left-info">
					<h6>일정</h6>
					<input id="carName" class="form-control"  type="text" placeholder="차량을 검색하시오."><br>
					
					대여일시<br>
					<input id="inDate" class="form-control"  type="date"><br>
					
					반납일시<br>
					<input id="outDate" class="form-control"  type="date"><br>
					
					<hr>
					<br>
					
				</div>
				
				<div class = "left-radio-select" id="carOptions">
				    차량종류<br>
				  <br>
				  <input type="radio" id="optionAll" name="carType" value="전체" checked>
				  <label for="optionAll">전체</label><br>
				
				  <input type="radio" id="optionEconomy" name="carType" value="경/소형">
				  <label for="optionEconomy">경/소형</label><br>
				
				  <input type="radio" id="optionSedan" name="carType" value="중형차">
				  <label for="optionSedan">중형차</label><br>
				
				  <input type="radio" id="optionSUV" name="carType" value="SUV">
				  <label for="optionSUV">SUV</label><br>
				
				  <input type="radio" id="optionLuxury" name="carType" value="전기차">
				  <label for="optionLuxury">전기차</label><br>
				</div>
				<br>
				<input class="btn btn-outline-success" id="search" type="button" value="검색">
			</div>
		</div>
			<div class="col-9">
				<div class = "side-right">
					<div class = "car-list">
						<div class = "car-list-selectOne">
							<div id="firstInput"></div>
						</div>	
						<hr>
						
					</div>
				</div>
					<nav aria-label="Page navigation example">
					  <ul class="pagination justify-content-center">
					    <li class="page-item disabled">
					      <a class="page-link">Previous</a>
					    </li>
					    <li class="page-item"><a class="page-link" href="#">1</a></li>
					    <li class="page-item"><a class="page-link" href="#">2</a></li>
					    <li class="page-item"><a class="page-link" href="#">3</a></li>
					    <li class="page-item">
					      <a class="page-link" href="#">Next</a>
					    </li>
					  </ul>
					</nav>
			</div>
	</div>
<!-- !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
	
	
<!-- !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->	

	
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