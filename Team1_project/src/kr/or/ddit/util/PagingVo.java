package kr.or.ddit.util;

public class PagingVo {
	
	String searchTxt = "";
	
    int startNo = 0;
    int endNo = 0;
    int pageNo = 1;
    int recordCountPerPage = 10;
    
	public void setPaging(int pageNo, int recordCountPerPage) {
    	this.pageNo = pageNo;
    	this.recordCountPerPage = recordCountPerPage;
    	
    	this.startNo = (pageNo - 1) * recordCountPerPage;
    	this.endNo = pageNo * recordCountPerPage;
	}

	public String getSearchTxt() {
		return searchTxt;
	}

	public void setSearchTxt(String searchTxt) {
		this.searchTxt = searchTxt;
	}
	
	
	
}
