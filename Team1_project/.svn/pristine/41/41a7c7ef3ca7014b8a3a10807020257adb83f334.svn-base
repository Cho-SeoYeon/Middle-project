/**
 * 
 */

//이벤트 등록
/*$.eventInsert = function(){
	
	$.ajax
	
	
}
*/




//특정 이벤트 클릭시 상세 페이지(이미지 보이게)
$.eventDetail = function(){
	
	$.ajax({
		url : `${mypath}/eventDetail.do`,
		type : 'get',
		success : result => {
			alert("열람 성공");
		},
		error : xhr => {
			alert("상태 : " + xhr.status);
		},
		dataType : 'json'
	})
	
}


//이벤트 삭제
$.eventDelete = function(eventNum){
	
	$.ajax({
		url : `${mypath}/eventDelete.do`,
		data : { eventNum : eventNum },
		type : 'post',
		success : result => {
			alert("해당 이벤트 삭제가 완료되었습니다.");
			$.eventList();
		},
		error : xhr => {
			alert("상태 : " + xhr.status);
		},
		dataType : 'json'
	
	});
	
}



//이벤트 리스트 출력
$.eventList = function(){
	
	$.ajax({
		url : `${mypath}/eventList.do`,
		type : `get`,
		success : result => {
		
			code = `<div class = "container">
					<h3 class='mt-5'>이벤트 리스트</h3>
					<div class="row mb-3">
					<div class="col-8"></div>
					<div class="col-3">
					</div>
					<div class="col-1 mb-3">
						<input type="button" id="insert" name="insert" value="이벤트 등록하기" class="btn btn-success">
					</div>
					
					 <table class='table table-hover'>
                      <thead>
                        <tr>
                          <th>No</th>
                          <th>제목</th>
                          <th>쿠폰번호</th>
                          <th>비고</th>
                        </tr>
                      </thead>
                      <tbody>`;
		//반복문을 사용하여 값 출력
		
		$.each(result, function(i,v){
		
			code += `<tr>
			<td>${v.evnt_no}</td>
			<td><a href = "${mypath}/eventDetail.do?evntNo=${v.evnt_no}">${v.evnt_title}</a></td>
			<td>${v.cnp_code}</td>
			<td><button type="button" class="deleteBtn btn btn-outline-danger" name="delete" idx="${v.evnt_no}">삭제</button></td>
			</tr>`;
		})
		
		  code += `</tbody>
              </table>
            </div>
			`;
	
		$('#list').html(code);
		
		$('.deleteBtn').on('click', function() {
                var eventNum = $(this).attr('idx');
                $.eventDelete(eventNum);
            });				
	
		},
		error : xhr => {
			alert("상태 : " + xhr.status);
		},
		dataType : 'json'
		
		
		
	});
	
}