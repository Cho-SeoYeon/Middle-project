



$.replyInsert = function(qnaNo){
	
	$.ajax({
		url : `${mypath}/adminQnaReplyInsert.do`,
		data : { qnaNo : qnaNo },
		type : 'post',
		success : result => {
			alert("성공!!!!!!!!!!!");			
			//$.qnaList();
		},
		error : xhr => {
			alert("상태 : " + xhr.status);
		},
		dataType : 'json'
	
	});
	
}



$.qnaList = function(){
		
	$.ajax({
		url : `${mypath}/adminQnaList.do`,
		type : 'get',
		success : result =>{
			 code = `<div class="container">
                    <h3 class="mt-5">고객문의 리스트</h3>
                    <table class='table table-hover'>
                      <thead>
                        <tr>
                          <th>No</th>
                          <th>제목</th>
                          <th>내용</th>
                          <th>작성일</th>
                          <th>작성자</th>
                          <th>비고</th>
                        </tr>
                      </thead>
                      <tbody>`;
	
			//반복문을 써서 모든 리스트를 꺼내와야함					
			$.each(result,function(i,v){
			 code += `<tr>
            <td>${v.qna_no}</td>
            <td>${v.qna_title}</a></td>
            <td>${v.qna_cont}</td>
            <td>${v.qna_date}</td>
            <td>${v.user_id}</td>
			<td><input class="btn btn-warning" type="button" idx="${v.qna_no}" id="replyInsert" name="replyInsert" value="답변 등록"></td>
         </tr>`;
      });

      code += `</tbody>
              </table>
            </div>
		`;

		$('#list').html(code);	
//
//		$('#replyInsert').on('click', function() {
//                var qnaNo = $(this).attr('idx');
//                $.replyInsert(qnaNo);
//  				location.href = `qnaReplyForm.jsp?qna_no=${qnaNo}`;
//            });		

		},
		error : xhr => {
			alert("실패");
		},
		dataType : 'json'	
	})		
	
		
	
}