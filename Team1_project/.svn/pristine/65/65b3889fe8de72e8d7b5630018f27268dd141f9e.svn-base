<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.temporal.ChronoUnit"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="true"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%= request.getContextPath()%>/Car/carReservation.css">
<script src="<%= request.getContextPath()%>/js/jquery-3.7.1.min.js"></script>
</head>
<script>
$(function(){
	
	let userName = $('#res-user-name').val();
	let userPhoneNum = $('#res-user-phoneNum').val();
	
    // Context Path를 설정하는 방법 중 하나 (JSP 내에 직접 삽입된 경우)
  	<%
		int car_price = Integer.parseInt(request.getParameter("car_price"));
		int car_insurancePrice = Integer.parseInt(request.getParameter("car_insuranceprice"));
		int sum = car_price + car_insurancePrice;
		String car_no = String.valueOf(request.getAttribute("carNo"));
		
		String startDate = String.valueOf(request.getAttribute("inDate"));
		String endDate = String.valueOf(request.getAttribute("outDate"));
		long nights = 0;
		   
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
	      Date rentStartDate = format.parse(startDate);
	      Date rentendDate = format.parse(endDate);
	      long diff = rentendDate.getTime() - rentStartDate.getTime();
	      nights = diff / (24 * 60 * 60 * 1000); 
	   } catch (Exception e){
	      e.printStackTrace();
	   }
		
		
	%>
	salePrice = 0;
	oneDayPrice = <%=car_price%>;
	allDayprice = oneDayPrice * <%=nights%>;
	insurPrice = <%=car_insurancePrice%>;
	totalPrice = allDayprice-salePrice+insurPrice;
	carNo = "<%=car_no%>";
    var contextPath = "<%=request.getContextPath()%>"; 
    $(".coupon-use").on('click', function(){
        let cpnCodeNum = $(".coupon-codenum").val();
        
        $.ajax({
            url: contextPath + "/carCoupon.do", // JSP 내에서 동적으로 처리되어야 함
            type: "post",
            data: {
                "cpnCodeNum" : cpnCodeNum
            },
            dataType: "json",
            success: function(res) {
            	if(res.status === "success"){
            		sale = parseInt(res.sale);
                    salePrice = sale *0.01 * allDayprice;
                	oneDayPrice = <%=car_price%>;
                	allDayprice = oneDayPrice * <%=nights%>;
                	insurPrice = <%=car_insurancePrice%>;
                	totalPrice = allDayprice-salePrice+insurPrice;
                	
                	
                	
                    $('.car-res-price').text("대여가격 " + allDayprice + "원");
                    $('.car-res-couponPrice').text("할인적용 -" + salePrice + "원");
                    $('.car-res-insurancePrice').text("보험가격 " + insurPrice + "원");
                    $('.car-res-total-price').text("총 결제금액 "+ totalPrice +"원");
                    $('.car-res-pay-btn').val("총 결제금액 " + totalPrice + "원");
                    
                    
                    
                    
                    
            	} else if(res.status === "fail"){
            		alert(res.msg);
            	}
            },
            error: function(xhr) {
                alert("사용불가");
            }
        });
    });
    $('.car-res-price').text("대여가격 " + allDayprice + "원");
    $('.car-res-couponPrice').text("할인적용 -" + salePrice + "원");
    $('.car-res-insurancePrice').text("보험가격 " + insurPrice + "원");
    $('.car-res-total-price').text("총 결제금액 "+ totalPrice +"원");
    $('.car-res-pay-btn').val("총 결제금액 " + totalPrice + "원");
    $("#car_pay_carNo").val(carNo);
    $('#car_pay_insurancePrice').val(insurPrice);
    
    
    $('.car-res-pay-btn').on('click',function(){

//    		차량번호 전페이지에서 가져와야함```````````
//    		일반자차 가격이 11100이면 미포함 21100이면일반자차 31100이면완전자차`````````
//    		입실일 전페이지에서 가져와야함`````````
//    		퇴실일 전페이지에서 가져와야함``````````

//    		쿠폰코드 input값 가져와야함``````````
//    		전체가격 위에서 가져와야함````````````
//    		회원아이디	세션에서 가져와야함```````이거는 서블릿에서 세션으로 처리.

            // 값을 가져와서 변수에 저장
            let paytotalPrice = $('.car-res-total-price').text();
   	        let insurancePrice =  $('#res_car_insuranceprice').text();
   	        let carNo =  $('#car_pay_carNo').val();
<%--    	    	let inDate = <%=String.valueOf(request.getParameter("inDate"))%>; --%>
<%--    	        let outDate = <%=String.valueOf(request.getParameter("outDate"))%>; --%>
   	    	let cpnCode = $('.coupon-codenum').val();
   	    	
   	    	// 위에 저장한 변수값을 form에 값을 넣어준다.
   	    	$('#car_pay_carNo').val(carNo);
   	    	$('#car_pay_inDate').val("<%=String.valueOf(request.getParameter("inDate"))%>");
   	    	$('#car_pay_outDate').val("<%=String.valueOf(request.getParameter("outDate"))%>");
   	    	$('#car_pay_cpnCode').val(cpnCode);
   	    	$('#car_pay_totalPrice').val(paytotalPrice);
	   		$('#res_car_insuranceprice').val(insurancePrice);

			$('#formResPayment').submit();
    })
    
});
</script>
<body>
<form id="formResPayment" action="<%= request.getContextPath()%>/carResPayment.do">
	<input type="hidden" name="pay_totalPrice" id="car_pay_totalPrice">
	<input type="hidden" name="pay_insurancePrice" id="car_pay_insurancePrice">
	<input type="hidden" name="pay_carNo" id="car_pay_carNo">
	<input type="hidden" name="pay_inDate" id="car_pay_inDate">
	<input type="hidden" name="pay_outDate" id="car_pay_outDate">
	<input type="hidden" name="pay_cpnCode" id="car_pay_cpnCode">
</form>

<div class = "all-div">
	<div class = "top">
<!-- 		<div class = "top-left"> -->
			<img class ="top-left"  alt="logo" src="<%= request.getContextPath()%>/images/logo.png">
<!-- 		</div> -->
		
		<div class = "top-right">
			<a href="">숙소</a>
			<a href="">렌트카</a>
			<a href="">이벤트</a>
		</div>
		
	</div>
	<hr style="margin-left : -20px;">
<!-- !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->  
	<div class = "center">
		<div class= "center-left">
			<h3>예약 확인 및 결제</h3>
			<h4>예약자 정보</h4>
			
			<p>예약자 이름</p><input id="res-user-name" type="text" placeholder="텍스트를 입력해 주세요.">
			<br><br>
			<p>휴대폰 번호</p><input id="res-user-phoneNum" type="text" placeholder="텍스트를 입력해 주세요.">
			<br><br>
			<hr>
			<h3>할인 적용</h3>
			<p>쿠폰 번호</p><input class="coupon-codenum" type="text" placeholder="텍스트를 입력해 주세요.">
			<input class="coupon-use" type="button" value="적용">
			<br><br>
			<hr>
			<h3>결제 수단</h3>
			<input type="button" value="신용/체크카드"><input type="button" value="간편 계좌 이체">
		</div>
		<div class="center-right">
			<div class = "center-right-top">
				<div class="rent-img-info">
					<img class="carDetail-img" alt="asd" src="<%= request.getContextPath()%>/images/imageViewRes.do?filepath=<%= request.getAttribute("imgPath") %>">
				</div>
				<div class = "rent-all">
					<div class ="rent-info">
						<p>연식 </p>
						<p>대여기간</p>
						<p>기준인원</p>
					</div>
<!-- 					rentNm carName imgPath carNo carCont rentAddr inDate outDate car_year -->
					<div class ="rent-cont">
						<p><%=request.getParameter("car_year") %></p>
						<p>`<%=String.valueOf(request.getParameter("inDate"))%> ~ <%=String.valueOf(request.getParameter("outDate"))%> (<%=  nights%>)박`</p>
						<p>4인</p>
					</div>
				</div>
			</div>

			<div class = "center-right-bottom">
				<div><p>결제정보</div>
				<div><p class="car-res-price"></p></div>
				<div><p class="car-res-insurancePrice"></p></div>
				<div><p class="car-res-couponPrice"></p></div>
				<hr>
				<div><p class="car-res-total-price"></p></div>
				<input class="car-res-pay-btn" type="button" value="">
			</div>
					
		</div>
	</div>
</div>
</body>
</html>