<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/HeadFoot/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>차량 등록하기</title>
 <script src="/Team1_project/js/jquery-3.7.1.min.js"></script>

<script>

	$(document).ready(function(){
		$('#submitBtn').click(function(){
		
		/* var vform = document.querySelector('#carForm');	
		var formData = new FormData(vform);
		
		formData = vforom.serializeJSON(); */
		
		var formData = new FormData($('#carForm')[0]);
		
		/* data = {
			"no" : $('#no').val(),
			"year" : $('#year').val(),
			"type" : $('#type').val(),
			"name" : $('#name').val(),
			"price" : $('#price').val(),
			"companyName" : $('#companyName').val(),
			"companyCode" : $('#companyCode').val(),
			"companyTel" : $('#companyTel').val(),
			"companyAddr" : $('#companyAddr').val(),
			"companyMail" : $('#companyMail').val(),
			"content" : $('#content').val(),
			"imgPath" : $('#imgPath').val()
		}
		 */
		$.ajax({
			url : "<%=request.getContextPath() %>/carInsert.do",
			type : "post",
			data : formData,
			enctype : "multipart/form-data",
			//cache : false,
			contentType : false,
			processData : false,
			async : true,
			success : function(response){
				alert("등록 성공");
				window.location.href = "car.jsp";
			},
			error : function(){
				alert("등록 실패!!!");
			},
			dataType : 'json'
 		 })
			
	   })
	   
	   $('#cancelBtn').click(function(){
		    window.history.back(); // 이전 페이지로 돌아가기
		});
	   
	   
	})



</script>
<link rel="stylesheet" type="text/css" href="/Team1_project/admin/form.css">
</head>
<body>
	<form id="carForm" method="post" enctype="multipart/form-data">
		<div id="insertForm">
			<h3>차량 등록</h3>
			<div>
                <label for="title">업체코드</label>
                <input type="text" id="companyCode" name="companyCode" required>
            </div>
			<div>
                <label for="title">차량번호</label>
                <input type="text" id="no" name="no" required>
            </div>
			<div>
                <label for="title">연식</label>
                <input type="text" id="year" name="year" required>
            </div>
			<div>
                <label for="type">차량종류</label>
                <select id="type" name="type" required>
                	<option value="경/소형">경/소형</option>
                	<option value="중형차">중형차</option>
                	<option value="SUV">SUV</option>
                	<option value="전기차">전기차</option>
                </select>
            </div>
			<div>
                <label for="title">차량명</label>
                <input type="text" id="name" name="name" required>
            </div>
			<div>
                <label for="title">가격</label>
                <input type="text" id="price" name="price" required>
            </div>
            <div>
                <label for="title">이용정보</label>
				<textarea id="content" name="content" style="width: 500px; height:200px;"></textarea>
            </div>
            <div>
            	차량 이미지 첨부 <input type="file" id="imgPath" name="fimg">
            </div>
            <div id="button">
                <button type="button" id="submitBtn">등록</button>
                <button type="button" id="cancelBtn" style="background: #f44336; color: #fff; padding: 10px 20px; border: none; border-radius: 4px; cursor: pointer;">취소</button>
            </div>
		</div>
	</form>


</body>
</html>