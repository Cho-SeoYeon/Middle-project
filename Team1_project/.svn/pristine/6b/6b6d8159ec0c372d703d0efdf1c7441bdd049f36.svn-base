<%@page import="kr.or.ddit.vo.CarVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<CarVO> carList = (List<CarVO>)request.getAttribute("cars");

	
%>

<%
	if(carList.size() > 0){
		%>
		
		{"flag" : "성공"}
		<%
	}else{	
		%>
	
		{"flag" : "실패"}
	<%
	}
	%>
		

		



