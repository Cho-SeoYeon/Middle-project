<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/admin/adminMain.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>렌트카 업체 관리</title>
    <script src="/Team1_project/js/jquery-3.7.1.min.js"></script>
      <script src="/Team1_project/js/adminCar.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/admin/list.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
	<script>
	        // 'mypath'는 서버 경로를 담고 있는 전역 변수입니다.
	        // notice.js에서 사용될 경로입니다.
	        var mypath = "<%=request.getContextPath()%>";
	
	        $(function() {
	            $.carList();
	            
	            $(document).on('click', '#companyInsert', function(){
	            	location.href = "carCompanyForm.jsp";
	            })
	
	            $(document).on('click', '#carInsert', function(){
	            	location.href = "carForm.jsp";
	            })
			            
	         })
	    </script>
<body>

    <div id="list">
        <!-- 관리대상 차량 리스트가 여기에 출력됩니다 -->
    </div>


    
</body>
</html>
