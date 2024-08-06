<%@page import="com.google.gson.GsonBuilder"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="kr.or.ddit.vo.NoticeVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    

<%
   //controller에 저장한 데이터 꺼내와야함.
   
   List<NoticeVO> vo = (List<NoticeVO>)request.getAttribute("noticeList");
   
   Gson gson = new GsonBuilder().setPrettyPrinting().create();
   
   //데이터 직렬화 시키기
   
   String result = gson.toJson(vo);
   
   out.print(result);
   out.flush();
   
%> 