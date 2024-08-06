/**
 * 
 */


//차량 클릭시 해당 차량 상세페이지(이미지 보여야함)
$.carDetail = function(rentCode){
	
	$.ajax ({
		url : `${mypath}/adminCarDetail.do?rentCode=${rentCode}`,
		type : 'get',
		data : {'rentCode' : rentCode },
		success : result => {
			code = "";
			code += '<table><tr><th>차량 번호</th><th>차량명</th><th>렌트 가격</th><th>차종</th><th>연식</th><th>상세정보</th></tr>';
			
			$.each(result, function(i,v){
			code += `<tr>
			<td>${v.car_no}</td>
			<td>${v.car_name}</td>
			<td>${v.car_price}</td>
			<td>${v.car_type}</td>
			<td>${v.car_year}</td>
			<td>${v.car_cont}</td>
			</tr>`;
		})

     	 code+= `</table>`;

		$('#carListTable').html(code);

		},
		error : xhr => {
			aler("상태 : " + xhr.status);
		},
		dataType : 'json'
	})
}

//리스트에서 차량 삭제
$.carDelete = function(rentCode){
	
	$.ajax({
		url : `${mypath}/carDelete.do`,
		data : { rentCode : rentCode },
		type : 'post',
		success : result => {
			alert("해당 렌터카 업체 삭제가 완료되었습니다.");
			$.carList();
		},
		error : xhr => {
			alert("상태 : " + xhr.status);
		},
		dataType : 'json'
	})
	
}


//렌트카 업체 리스트 출력
$.carList = function(){
		$.ajax({
		url : `${mypath}/managementCarList.do`,
		type : `get`,
		success : result => {
		
			code = `<div class = "container">
					<h3>렌트카 업체 리스트</h3>
					 <table class='table table-hover'>
                      <thead>
                        <tr>
                          <th>렌트카 업체명</th>
                          <th>업체 코드</th>
                          <th>업체 주소</th>
						  <th>연락처</th>
						  <th>메일</th>
						  <th>비고</th>
                        </tr>
                      </thead>
                      <tbody>`;
		//반복문을 사용하여 값 출력
		
		$.each(result, function(i,v){
		
			code += `<tr>
			<td>${v.rent_nm}</td>
			<td><a href= "${mypath}/adminCarDetail.do?rentCode=${v.rent_code}">${v.rent_code}</a></td>
			<td>${v.rent_addr}</td>
			<td>${v.rent_tel}</td>
			<td>${v.rent_mail}</td>
			<td><button type="button" class="deleteBtn btn btn-outline-danger" name="delete" idx="${v.rent_code}">삭제</button></td>
			</tr>`;
		})
		
		  code += `</tbody>
              </table>
            </div>
			<div class="button-container" style="display: flex; justify-content: center; gap: 10px;">
    <input type="button" id="companyInsert" name="companyInsert" value="업체 등록" class="btn btn-success">
    <input type="button" id="carInsert" name="carInsert" value="차량등록" class="btn btn-success">
</div>`

	
		$('#list').html(code);
		
		$('.deleteBtn').on('click', function() {
                var rentCode = $(this).attr('idx');
                $.carDelete(rentCode);
            });				
	
		},
		error : xhr => {
			alert("상태 : " + xhr.status);
		},
		dataType : 'json'
		
		
	});
	
	
}