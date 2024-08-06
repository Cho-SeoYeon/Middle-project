/**
 * 
 */

//id가 delete인 삭제 버튼 클릭시 공지사항 삭제하기

$.noticeDelete = function(noticeNum){
	
	$.ajax({
		url : `${mypath}/noticeDelete.do`,
		data : { noticeNum : noticeNum },
		type : 'post',
		success : result => {
			alert("해당 공지사항 삭제가 완료되었습니다.");
			$.noticeList();
		},
		error : xhr => {
			alert("상태 : " + xhr.status);
		},
		dataType : 'json'
	
	});
	
}

//클릭시 해당 공지사항의 상세내용이 나오게
$.noticeDetail = function(){
	
	$.ajax({
		url :`${mypath}/noticeDetail.do`,
		type : 'get',
		success : result => {
			alert("성공시 공지사항 세부사항 창이 열릴 예정입니다.");
		},
		error : xhr => {
			alert("상태 : " + xhr.status);
		},
		dataType : 'json'
	})
	
}



//전체 공지사항 리스트 출력
$.noticeList = function(){
	
	$.ajax({
		url : `${mypath}/noticeList.do`,
		type : 'get',
		success : result => {
			
		 	 code = `<div class="container">
                    <h3 class='mt-5'>공지사항 리스트</h3>
					<div class="row mb-3">
					<div class="col-8"></div>
					<div class="col-3">
					</div>
					<div class="col-1 mb-3">
						<input type="button" id="insert" name="insert" value="공지사항 등록" class="btn btn-success">
					</div>
	
                    <table class='table table-hover'>
                      <thead>
                        <tr>
                          <th>No</th>
                          <th>제목</th>
                          <th>내용</th>
                          <th>작성일</th>
                          <th>조회</th>
                        </tr>
                      </thead>
                      <tbody>`;
		//반복문을 써서 모든 리스트를 꺼내와야함					
			$.each(result,function(i,v){
				
			/*content = v.notice_cont;
			
			content = content.replaceAll(/\n/g, "<br>");*/
			
			 code += `<tr>
            <td>${v.notice_no}</td>
            <td><a href="${mypath}/noticeDetail.do?noticeNo=${v.notice_no}">${v.notice_title}</a></td>
            <td>${v.notice_cont}</td>
            <td>${v.notice_date}</td>
            <td><button type="button" class="deleteBtn btn btn-outline-danger" name="delete" idx="${v.notice_no}">삭제</button></td>
         </tr>`;
      });

      code += `</tbody>
              </table>
            </div>
		`;

		$('#list').html(code);	
		
		
		$('.deleteBtn').on('click', function() {
                var noticeNum = $(this).attr('idx');
                $.noticeDelete(noticeNum);
            });				
			
		},
		error : xhr => {
			alert("상태 : " + xhr.status);
		},
		dataType : 'json'
		
		
	})	

	
	
	
}