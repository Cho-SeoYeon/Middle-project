<%@page import="com.google.gson.Gson"%>
<%@page import="kr.or.ddit.vo.EventVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
        <%
            List<EventVO> eventList = (List<EventVO>) request.getAttribute("eventList");
            /* if(eventList != null && !eventList.isEmpty()) {
                for(EventVO event : eventList) {
                    out.println("<tr>");
                    out.println("<td>" + event.getEvnt_no() + "</td>");
                    out.println("<td>" + event.getEvnt_title() + "</td>");
                    out.println("<td><input type='button' value='삭제'</td>");
                    out.println("</tr>");
                }
            } else {
                out.println("<tr><td colspan='5'>등록된 이벤트 정보가 없습니다.</td></tr>");
            }
         */
         Gson gson = new Gson();
       String result =   gson.toJson(eventList);
  
       out.print(result);
       out.flush();
       
         
        %>
