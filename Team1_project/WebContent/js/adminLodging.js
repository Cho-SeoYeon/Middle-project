/**
 * 
 */



/*//lodCode로 숙소 검색
$.lodgingSearch = function(lodgingName){
	
	$.ajax({
		url : `${mypath}/lodgingSearch.do?lodgingName=${lodgingName}`,
		type : 'get',
		data : {'lodgingName' : lodgingName },
		success : result => {
			alert("검색 성공");
		},
		error : xhr => {
			alert("상태 : " + xhr.status);
		},
		dataType : 'json'		
	})
}*/

// 숙소명으로 숙소 검색
$.lodgingSearch = function(lodgingName){
    $.ajax({
        url: `${mypath}/lodgingSearch.do`,
        type: 'GET',
        data: {'lodgingName': lodgingName},
        success: function(result) {
            // 결과를 화면에 표시하는 로직
            var code = `<div class = "container">
                        <h3>검색된 숙소 리스트</h3>
                        <table class='table table-hover'>
                        <thead>
                            <tr>
                                <th>숙박 업소명</th>
                                <th>숙소 종류</th>
                                <th>숙소 코드</th>
                                <th>숙소 전화번호</th>
                                <th>숙소 이메일</th>
                                <th>숙소 정보</th>
                                <th>조치</th>
                            </tr>
                        </thead>
                        <tbody>`;

            $.each(result, function(i, v) {
                code += `<tr>
                            <td>${v.lod_nm}</td>
                            <td>${v.lod_type}</td>
                            <td>${v.lod_code}</td>
                            <td>${v.lod_tel}</td>
                            <td>${v.lod_mail}</td>
                            <td>${v.lod_info}</td>
                            <td><button type="button" class="deleteBtn btn btn-outline-danger" name="delete" idx="${v.lod_code}">삭제</button></td>
                        </tr>`;
            });

            code += `</tbody></table></div>`;
            $('#list').html(code);
        },
        error: function(xhr) {
            alert("검색 중 오류가 발생했습니다. 상태: " + xhr.status);
        },
        dataType: 'json'
    });
}



//숙소 클릭시 해당 숙소의 객실 리스트 출력
$.lodgingDetail = function(lodgingCode){
	
	$.ajax({
		url : `${mypath}/adminLodgingDetail.do?lodgingCode=${lodgingCode}`,
		type : 'get',
		data : {'lodgingCode' : lodgingCode },
		success : result => {
			code = "";
			code += '<table><tr><th>객실 번호</th><th>객실 타입</th><th>객실 가격</th></tr>';
			
			$.each(result, function(i,v){
			code += `<tr>
			<td>${v.room_no}</td>
			<td>${v.room_type}</td>
			<td>${v.room_price}</td>
			</tr>`;
		})

     	 code+= `</table>`;

		$('#roomListTable').html(code);

		},
		error : xhr => {
			aler("상태 : " + xhr.status);
		},
		dataType : 'json' 
		
	})
	
	
}


//숙소 삭제
$.lodgingDelete = function(lodgingCode){
	
	$.ajax({
		url : `${mypath}/lodgingDelete.do`,
		data : {  lodgingCode :  lodgingCode },
		type : 'post',
		success : result => {
			alert("해당 숙소 삭제가 완료되었습니다.");
			$.lodgingList();
		},
		error : xhr => {
			alert("상태 : " + xhr.status);
		},
		dataType : 'json'
	
		
	})
	
}


//숙소 리스트 출력
$.lodgingList = function(){
		$.ajax({
		url : `${mypath}/managementLodgingList.do`,
		type : `get`,
		success : result => {
		
			code = `<div class = "container">
					<h3 class="mt-5">숙소 리스트</h3>
					<div class="row mb-3">
					<div class="col-8"></div>
					<div class="col-3">
						<input type="text" id="lodgingName" name="lodgingName" placeholder="숙소명을 입력해주세요." style="width:300px" class="form-control">
					</div>
					<div class="col-1">
						<input type="button" id="search" name="search" value="검색" class="pointer btn btn-success">
					</div>
					</div>
					
					
					 <table class='table table-hover'>
                      <thead>

                        <tr>
                          <th>숙박 업소명</th>
                          <th>숙소 종류</th>
                          <th>숙소 코드</th>
						  <th>숙소 전화번호</th>
						  <th>숙소 이메일</th>
						  <th>숙소 정보</th>
						  <th>비고</th>
                        </tr>
                      </thead>
                      <tbody>`;
		//반복문을 사용하여 값 출력
		
		$.each(result, function(i,v){
		
			code += `<tr>
			<td>${v.lod_nm}</td>
			<td>${v.lod_type}</td>
			<td><a href = "${mypath}/adminLodgingDetail.do?lodgingCode=${v.lod_code}">${v.lod_code}</a></td>
			<td>${v.lod_tel}</td>
			<td>${v.lod_mail}</td>
			<td>${v.lod_info}</td>
			<td><button type="button" class="deleteBtn btn btn-outline-danger" name="delete" idx="${v.lod_code}">삭제</button></td>
			</tr>`
		})
		
		  code += `</tbody>
              </table>
            </div>
		<div class="button-container" style="display: flex; justify-content: center; gap: 10px;">
    		<input type="button" id="lodgingCompanyInsert" name="lodgingCompanyInsert" value="숙소 등록" class="btn btn-success">
    		<input type="button" id="lodgingInsert" name="lodgingInsert" value="객실 등록" class="btn btn-success">
		</div>`;

		$('#list').html(code);
		
		$('.deleteBtn').on('click', function() {
             var lodgingCode = $(this).attr('idx');
                $.lodgingDelete(lodgingCode);
            });				
	
	/*	$('#searchName').click(function() {
        var lodgingName = $('searchName').val(); // 사용자가 입력한 숙소 코드를 가져옵니다.
            $.lodgingSearch(lodgingName); 
    	});
*/

		

		},
		error : xhr => {
			alert("상태 : " + xhr.status);
		},
		dataType : 'json'
		
		
	});
	$(document).on('click','#search',function() {
			let lodgingName = $("#lodgingName").val();
			$.lodgingSearch(lodgingName);
			
		})
	
}