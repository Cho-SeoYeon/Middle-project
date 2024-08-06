/**
 * 
 */
// 숙박과 관련된 JAVASCRIPT 파일입니다.	


// 조건선택 후 검색버튼 클릭 후 조건에 따른 숙소리스트 가져오기
$.searchLodgingList = function(){
	
	let lodgingName = $('#lodgingName').val();
    let startDate = $('#startDate').val();
    let endDate = $('#endDate').val();
    let guestNum = $('#guestNum').val();
	let lodgingType = $('input[name="lodgingType"]:checked').val();

	$.ajax({
		url : `${mypath}/lodgingList.do`,
		type : 'get',
		data : {
				"lodgingName" : lodgingName,
				"startDate"   : startDate,
				"endDate"     : endDate,
				"guestNum"    : guestNum,
				"lodgingType" : lodgingType
		},
		success : function(result){
			
			code = "";
		
		$.each(result, function(i, v){
			
			code +=`<div class="lodging" id="lodgingBox">
					   <div class="lod-img">
					       <img src="${mypath}/lodgingImage.do?imgName=${v.l_img_path}" alt="${v.l_img_path}"/>
			           </div>		  
					   <div class="lod-info-container">
						   <div class="lod-list-info">
							   <p class="lod-list-lodCode" data-lod-code='${v.lod_code}' style="display : none;"> ${v.lod_code} <br>
							   <p class="lod-list-lodType"> ${v.lod_type} <br>
				               <a class="lod-list-lodName"> ${v.lod_nm} </a>
			                   <p class="lod-list-lodAddr"> ${v.lod_addr} <br>
					       </div>
						   <div class="lod-list-price">
							   <p> ${v.lowestRoomPrice}원<br>
						   </div>
					   </div>
				    </div> 
                    <br><hr>`;
		}); // $.each문 끝

			$('#lodgingList').html(code);	
			
		},
		error : function(xhr){
			alert("상태 : " + xhr.status);
		},
		dataType : 'json'
	}); // ajax 끝
}; // 검색버튼 함수 끝


// 숙박검색 페이지의 첫 숙소 리스트
//$.lodgingList = function(startDate, endDate, searchValue){
//	
//	$.ajax({
//		url : `${mypath}/lodgingList.do`,
//		//나중에 페이징처리도 해야함
//		data : {
//			     "startDate" : startDate,
//            	 "endDate" : endDate,
//            	 "searchValue" : searchValue
//		},
//		
//		type : 'get',
//		success : function(result){
//			// alert("성공");
//			code = "";
//			$.each(result, function(i, v){
//				code +=`<div class="lodging" id="lodgingBox">
//						   <div class="lod-img">
//						       <img src="${mypath}/lodgingImage.do?imgName=${v.l_img_path}" alt="${v.l_img_path}"/>
//				           </div>		  
//						   <div class="lod-info-container">
//							   <div class="lod-list-info">
//								   <p class="lod-list-lodCode"  data-lod-code='${v.lod_code}' style="display : none;"> ${v.lod_code} <br>
//								   <p class="lod-list-lodType"> ${v.lod_type} <br>
//					               <a class="lod-list-lodName"> ${v.lod_nm} </a>
//				                   <p class="lod-list-lodAddr"> ${v.lod_addr} <br>
//						       </div>
//							   <div class="lod-list-price">
//								   <p> ${v.lowestRoomPrice}원<br>
//							   </div>
//						   </div>
//					    </div> 
//	                    <br><hr>`;
//			}); // $.each문 끝
//			$('#lodgingList').html(code);	
//		},
//		error : function(xhr){
//			alert("상태 : " + xhr.status);
//		},
//		dataType : 'json'
//	}); // ajax끝
//
//}; // lodgingList함수 끝 


/*
// 페이징 처리
pageList = function(startPage, endPage, totalPage){
	
	pager = `<ul class="pagination">`;
	
	// previous 버튼 생성
	if(startPage > 1){
		pager += `<li class="page-item"><a class="page-link prev" href="#">Previous</a></li>`;
		
	}
	
	// 페이지 번호 생성
	// 현재 currentPage = 9인 경우 마지막페이지의 마지막 데이터가 지워질 때,
	// 새로 계산해서 가져온 totalPage는 -1된 상태
	if (currentPage > totalPage) currentPage = totalPage;
	
	for(i = startPage; i <= endPage; i++){
		
		if (i == currentPage){
			// 현재페이지일 때는 <li>태그에 active
			pager += `<li class="page-item active"><a class="page-link pageNum" href="#">${i}</a></li>`;
		} else{
			pager += `<li class="page-item"><a class="page-link pageNum" href="#">${i}</a></li>`;
		}
	}
	
	// next 버튼 생성
	if ( endPage < totalPage ){ // 두번째 칸에 오는 페이지가 전체 페이지보다 작을 때는,
		// Next 버튼
		pager += `<li class="page-item"><a class="page-link next" href="#">Next</a></li>`;
	}
	pager += `</ul>`;
	
	return pager;
}; // 페이징처리 끝
*/	
