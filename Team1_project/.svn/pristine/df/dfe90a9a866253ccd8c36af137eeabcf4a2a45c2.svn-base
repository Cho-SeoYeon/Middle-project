<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
$(document).ready(function(){
  $(".nav-pills a").click(function(){
	  // 이전 탭에서 작성한 데이터를 지웁니다.
    $(".tab-pane input").val('');
    $("#valMsg").text(''); // #valMsg 요소의 내용을 비웁니다.
    $(".nav-pills a").removeClass("active");
    $(".tab-pane").removeClass("active");
    
    // Add the 'active' class to the clicked nav link
    $(this).addClass("active");
    var target = $(this).attr("href"); // Get the target tab pane ID
    $(".tab-pane").hide(); // Hide all tab panes
    $(target).fadeIn(); // Show the target tab pane
  });

  
  // 아이디 찾기 요청
  $("#findIdForm").submit(function(e) {
      e.preventDefault();
  		
      $.ajax({
          url: "<%= request.getContextPath() %>/memberFindId.do",
          type: "POST",
          data: $(this).serialize(),
          dataType: 'text', // 명시적으로 응답의 타입을 JSON으로 지정
          success: function(response) {
        	var feedback = $("#idMsg");
            feedback.text(response); // 서버로부터 받은 응답을 표시
          },
          error : function(xhr) {
			}
      });
  });

  // 비밀번호 찾기 요청
  $("#findPwdForm").submit(function(e) {
      e.preventDefault();
      
      $.ajax({
          url: "<%= request.getContextPath() %>/memberFindPwd.do",
          type: "POST",
          data: $(this).serialize(),
          dataType: 'text', // 명시적으로 응답의 타입을 JSON으로 지정
          success: function(response) {
        	  var feedback = $("#pwdMsg");
              feedback.text(response); // 서버로부터 받은 응답을 표시
          }
      });
  });
  // 로그인 페이지로 이동
  $("#loginBtn").click(function(){
	    window.location.href = "login.jsp"; // 로그인 페이지로 이동합니다.
	  });
});
	const autoHyphen = (target) => {
		 target.value = target.value
		   .replace(/[^0-9]/g, '')
		   .replace(/^(\d{2,3})(\d{3,4})(\d{4})$/, `$1-$2-$3`);
		}
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
          <a id="mainMyPage"class="dropdown-item" href="<%=request.getContextPath()%>/Member/memUpdate.jsp.jsp">마이페이지</a>
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
<div class="container xsCont">
    <ul class="nav nav-pills mb-5">
        <li class="nav-item"><a class="nav-link active" data-bs-toggl="pill" href="#home">아이디찾기</a></li>
        <li class="nav-item"><a class="nav-link"  data-bs-toggl="pill" href="#menu1">비밀번호찾기</a></li>
    </ul>

    <div class="tab-content">
        <div id="home" class="tab-pane container active">
            <form id="findIdForm">
                <label class="form-label mt-2" for="userName">이름</label>
                <input class="form-control" type="text" id="userName" name="userName">
                <label class="form-label mt-2" for="userTel">휴대전화번호</label>
                <input class="form-control" type="tel" id="userTel" name="userTel" maxlength="13" oninput="autoHyphen(this)" >
                <div class="text-right mt-3">
                <button class="btn btn-success" type="submit">아이디찾기</button>
                </div>
                <p id="idMsg"></p>
                
            </form>
        </div>
        <div id="menu1" class="tab-pane container">
            <form id="findPwdForm">
                <label class="form-label mt-2" for="userId">아이디</label>
                <input class="form-control" type="text" id="userId" name="userId">
                <label class="form-label mt-2" for="userTel">휴대전화번호</label>
                <input class="form-control" type="tel" id="userTel" name="userTel" maxlength="13" oninput="autoHyphen(this)">
                <div class="text-right mt-3">
                <button class="btn btn-success" type="submit">비밀번호찾기</button>
                </div>
                
                <p id="pwdMsg"></p>
            </form>
        </div>
     </div>
     <div class=" mt-5 text-center">
     <button class="btn btn-warning" id="loginBtn">로그인</button>
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