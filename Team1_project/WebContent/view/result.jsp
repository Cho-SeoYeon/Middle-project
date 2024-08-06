<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
//Controller에서 저장한 값 꺼내기
int res = (Integer)request.getAttribute("cnt");

if(res > 0){ // 성공
	
%>

{
	"flag" : "성공"
}



<% } else { %>


	{
		"flag" : "실패"
	}

<%	
}
%>    