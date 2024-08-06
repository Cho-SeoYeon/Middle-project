<%@page import="com.google.gson.Gson"%>
<%@page import="kr.or.ddit.vo.ManagementLodgingVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>





<% 
    
	List<ManagementLodgingVO> lodgingList = (List<ManagementLodgingVO>)request.getAttribute("lodgingList");
	
	Gson gson = new Gson();
	String jsonResult = gson.toJson(lodgingList);
	response.setContentType("application/json");
	response.setCharacterEncoding("UTF-8");
    out.print(jsonResult);
    out.flush();
    %>