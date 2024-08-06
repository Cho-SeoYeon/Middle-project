<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
   <%@ include file="/HeadFoot/header.jsp" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>공지사항 등록</title>
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
    <script>
    $(document).ready(function() {
        $("#submitBtn").click(function() {
            data = {
                title: $("#title").val(),
                content: $("#content").val()
            };
            
            $.ajax({
                url: "<%=request.getContextPath()%>/noticeInsert.do",
                type: "POST",
                data: data,
                success: function(response) {
                        alert("등록이 완료되었습니다");
                        window.location.href = "notice.jsp"; // 성공 후 이동할 페이지
                },
                error: function() {
                    alert("등록 중 오류가 발생했습니다");
                },
                dataType: "json"
            });
        });
        
        $('#cancelBtn').click(function(){
		    window.history.back(); // 이전 페이지로 돌아가기
		});

        
    });
    </script>
    
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col-3">
			<ul class="mypage">
			  <li><a href="<%=request.getContextPath()%>/Car/car.jsp">차량 관리</a></li>
			  <li><a href="<%=request.getContextPath()%>/lodging/lodging.jsp">숙소 관리</a></li>
			  <li><a href="<%=request.getContextPath()%>/event/event.jsp">이벤트 관리</a></li>
			  <li><a href="<%=request.getContextPath()%>/notice/notice.jsp">공지사항 관리</a></li>
			  <li><a href="<%=request.getContextPath()%>/qnaReply/qnaReply.jsp">고객문의 관리</a></li>
			</ul>
		</div>
		<div class="col-9">
		    <div id="insertForm">
		    	<div class="mt-5">
			        <h3>공지사항 등록</h3>
			        <hr>
		        </div>
		        <form id="noticeForm">
		        	<div class="cont1 xsCont">
		            	<div>
			                <label for="title" class="form-label">제목:</label>
			                <input class="form-control" type="text" id="title" name="title" required>
			            </div>
			            <div>
			                <label for="content" class="form-label">내용:</label>
			                <textarea class="form-control" id="content" name="content" required></textarea>
			            </div>
						 <div id="button" class="text-center mt-5">
			                <button class="btn btn-success" type="button" id="submitBtn">등록</button>
			                <button class="btn btn-outline-danger" type="button" id="cancelBtn">취소</button>
			            </div>
		           </div>
		        </form>
		    </div>
		</div>
	</div>
</div>
</body>
</html>
