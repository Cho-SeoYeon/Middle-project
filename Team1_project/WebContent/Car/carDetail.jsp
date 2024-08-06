<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="true"%>
<!DOCTYPE html>
<html>
<head>
        <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
    <script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=0yaizupxy9&submodules=geocoder"></script>
<!-- 	<script  src="http://code.jquery.com/jquery-latest.min.js"></script> -->
<!-- 	<script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script> -->
<title>Insert title here</title>
<link rel="stylesheet" href="<%= request.getContextPath()%>/Car/carDetail.css">
</head>
<script type="text/javascript" src="<%= request.getContextPath()%>/js/jquery-3.7.1.min.js"></script>
 
 
<body>
<!-- 	<input type="button" value = "테스트" id="test"> -->

<!-- rentNm  carName  imgPath  carNo -->


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
	<hr>
<!-- !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->  
	<div class = "center">
		<img class="carDetail-img" alt="asd" src="<%= request.getContextPath()%>/images/imageView.do?filepath=<%= request.getAttribute("imgPath") %>" style="width : 40%;" padding-left : 11%;" >
	</div>
	
	<div class = "carName">
		
		<div class = "car-rent-name">
			<div class = "car-name"><h1><%= request.getAttribute("carName") %></h1></div>
			<div class = "rent-name"><h5> <%= request.getAttribute("rentNm") %></h5></div>
			<div><%= request.getAttribute("car_year") %></div>
		</div>

		<hr>
		<div class = "car-inSurance">
			<div>자차보험</div>
			<div class = "inSurances">
				<div class = "none">
					<div>
						<div>미포함</div>
						<div><input class = "car-res-btn" type="button" value="차량예약" data-price="11100"></div>
						<div>이용요금 11,100원</div>
					</div>
					<div></div>
				</div> 
				<div class="nomal">
					<div>
						<div>일반자차</div>
						<div><input class = "car-res-btn" type="button" value="차량예약" data-price="21100"></div>
						<div>이용요금 21,100원</div>
					</div>
					<div></div>
				</div>
				<div class="perfect">
					<div>
						<div>완전자차</div>
						<div><input class = "car-res-btn" type="button" value="차량예약" data-price="31100"></div>
						<div>이용요금 31,100원</div>
					</div>
					<div></div>
				</div>
			</div>
			<br>
		</div>
		<hr>
		<div class = "useInfo">
			<div>이용안내</div>
			<br>
			<div class = "usingContent"><%= request.getAttribute("carCont") %></div>
			<br><br>
		</div>
		<div class="search">
			<input id="address" type="text" placeholder="검색할 주소" style ="display : none;">
			<input id="submit" type="button" value="주소검색" style ="display : none;">
		</div>
		<div id="map" style="margin-left:25%; width:60%;height:600px;"></div>
		
	</div>
	<br>
	<div class="review-all">
		<div>리뷰 (평점) <span class= "avg"></span></div>
		<hr>
		<div class="review-id-cont">			
			<div id="reviewCont"></div>
		</div>
	</div>
</div>






<%
	String rentAddr = (String)request.getAttribute("rentAddr");
	String carNo = (String)request.getAttribute("carNo");
%>
<div  class="res_rentNm"><%= request.getAttribute("rentNm") %></div>
<div  class="res_carName"><%= request.getAttribute("carName") %></div>
<div  class="res_imgPath"><%= request.getAttribute("imgPath") %></div>
<div  class="res_carNo"><%= request.getAttribute("carNo") %></div>
<div  class="res_carCont"><%= request.getAttribute("carCont") %></div>
<div  class="res_rentAddr"><%= request.getAttribute("rentAddr") %></div>
<div  class="res_inDate"><%= request.getAttribute("inDate") %></div>
<div  class="res_outDate"><%= request.getAttribute("outDate") %></div>
<div  class="res_car_year"><%= request.getAttribute("car_year") %></div>
<div  class="res_car_price"><%= request.getAttribute("car_price") %></div>
<!-- style="display : none;" -->
<form id="formResInfo" action="<%= request.getContextPath()%>/carReservaion.do">
	<input type="hidden" name="rent_nm" id="res_rent_nm">
	<input type="hidden" name="car_name" id="res_car_name">
	<input type="hidden" name="img_path" id="res_img_path">
	<input type="hidden" name="car_no" id="res_car_no">
	<input type="hidden" name="car_cont" id="res_car_cont">
	<input type="hidden" name="rent_addr" id="res_rent_addr">
	<input type="hidden" name="inDate" id="res_inDate">
	<input type="hidden" name="outDate" id="res_outDate">
	<input type="hidden" name="car_year" id="res_car_year">
	<input type="hidden" name="car_price" id="res_car_price">
	<input type="hidden" name="car_insuranceprice" id="res_car_insuranceprice">
</form>


</body>
    <script>
    $(document).ready(function() {
    	
    	 $(document).on('click', '.car-res-btn', function() {
    		 	var insurancePrice = this.getAttribute('data-price');
    	        var rentNm = $('.res_rentNm').text();
    	        var carName = $('.res_carName').text();
    	        var imgPath = $('.res_imgPath').text();
    	        var carNo = $('.res_carNo').text();
    	        var carCont = $('.res_carCont').text();
    	        var rentAddr = $('.res_rentAddr').text();
    	        var inDate = $('.res_inDate').text();
    	        var outDate = $('.res_outDate').text();
    	        var car_year = $('.res_car_year').text();
    	        var car_price = $('.res_car_price').text();
    	        
    	    	$('#res_rent_nm').val(rentNm);
    	    	$('#res_car_name').val(carName);
    	    	$('#res_img_path').val(imgPath);
    	    	$('#res_car_no').val(carNo);
    	    	$('#res_car_cont').val(carCont);
    	    	$('#res_rent_addr').val(rentAddr);
    	    	$('#res_inDate').val(inDate);
    	    	$('#res_outDate').val(outDate);
    	    	$('#res_car_year').val(car_year);
    	    	$('#res_car_price').val(car_price);
    	    	$('#res_car_insuranceprice').val(insurancePrice);
    	    	
    	    	$('#formResInfo').submit();
    	   	});
    	
    	
        // 직접 주소를 함수에 전달
        $(".car-res-btn").on('click',function(){
        	location.href="<%= request.getContextPath()%>/carReservaion.do";
        })
        
        var carNo = "<%=carNo%>";
        
        var address = "<%=rentAddr%>";
        searchAddressToCoordinate(address);
        
        $.ajax({
            url: "<%=request.getContextPath()%>/carReviewList.do",
            type: "GET",
            data:{
            	"carNo" : carNo
            },
            dataType: "json",
            success : function(carReviewList) {
                var tableHtml = "";
                var sum = 0;
                var cnt = 0;
                $.each(carReviewList, function(i, v){
//                 	alert(v.rvw_cont);
               		tableHtml += `<div>${v.user_id}</div>`;
               		switch(v.rvw_star){
               		case 1: tableHtml += `<div>★☆☆☆☆</div>`;
               			break;
               		case 2: tableHtml += `<div>★★☆☆☆</div>`;
               			break;
               		case 3: tableHtml += `<div>★★★☆☆</div>`;
               			break;
               		case 4: tableHtml += `<div>★★★★☆</div>`;
               			break;
               		case 5: tableHtml += `<div>★★★★★</div>`;
               			break;
               		case 0: tableHtml += `<div>☆☆☆☆☆</div>`;
               			break;
               		}
               		sum+= v.rvw_star;
               		cnt++;
               		tableHtml += `<p>${v.rvw_cont}</p>`;
               		tableHtml += `<hr>`;
                });
                avg = sum/cnt;
                
                $('#reviewCont').html(tableHtml);
                if(avg >0){
	                $('.avg').text(avg + " 점");
                }
            },
            error: function(xhr) {
                alert('Error: ' + xhr.status);
            }
        });
        
        
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
              return alert('주소 정보가 없습니다.');
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
  	mapList += "	<td>" + address + "</td>"
  	mapList += "	<td>" + latitude + "</td>"
  	mapList += "	<td>" + longitude + "</td>"
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

  //지도를 그려주는 함수
  function selectMapList() {
  	
  	var map = new naver.maps.Map('map', {
  	    center: new naver.maps.LatLng(37.3595704, 127.105399),
  	    zoom: 10
  	});
  }


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