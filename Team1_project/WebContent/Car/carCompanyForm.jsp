<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/HeadFoot/header.jsp" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>차량 등록하기</title>
 <script src="/Team1_project/js/jquery-3.7.1.min.js"></script>
 <script src="/Team1_project/js/jquery.serializejson.min.js"></script>

<script>

	$(document).ready(function(){
		$('#submitBtn').click(function(){
		
// 		var formData = new FormData($('#carCompanyForm')[0]);
		var formData = $("#carCompanyForm").serialize();
			$.ajax({
				url : `<%=request.getContextPath() %>/carCompanyInsert.do`,
				type : "post",
				data : $('#carCompanyForm').serialize(),
// 				data : formData,
// 				enctype : "multipart/form-data",
// 				cache : false,
// 				contentType : false,
// 				processData : false,
// 				async : true,
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
	<form id="carCompanyForm" method="post" enctype="multipart/form-data">
		<div id="insertForm">
			<h3>렌터카 업체 등록</h3>
            <div>
                <label for="title">업체명</label>
                <input type="text" id="rent_nm" name="rent_nm" required>
            </div>
            <div>
                <label for="title">업체코드</label>
                <input type="text" id="rent_code" name="rent_code" required>
            </div>
            <div>
                <label for="title">전화번호</label>
                <input type="text" id="rent_tel" name="rent_tel" required>
            </div>
            <div>
                <label for="title">주소</label>
                <input type="text" id="rent_addr" name="rent_addr" required>
            </div>
            <div>
                <label for="title">이메일</label>
                <input type="text" id="rent_mail" name="rent_mail" required>
            </div>
            <div id="button">
                <button type="button" id="submitBtn">등록</button>
                <button type="button" id="cancelBtn" style="background: #f44336; color: #fff; padding: 10px 20px; border: none; border-radius: 4px; cursor: pointer;">취소</button>
            </div>
		</div>
	</form>

</body>
</html>
 <%@ include file="/HeadFoot/footer.jsp" %>