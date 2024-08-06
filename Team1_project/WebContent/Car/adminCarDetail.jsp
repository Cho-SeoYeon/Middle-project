<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.vo.ManagementCarVO"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>렌트카별 보유 차량 정보</title>
<script src="/Team1_project/js/jquery-3.7.1.min.js"></script>
<script src="/Team1_project/js/adminCar.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/admin/list.css">
<style>
      

        a {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 15px;
            background-color: #007bff;
            color: #fff;
            text-decoration: none;
            border-radius: 5px;
        }

        a:hover {
            background-color: #0056b3;
        }

      
    </style>    
</head>


<%

List<ManagementCarVO> list  = (List<ManagementCarVO>)request.getAttribute("carDetail");

%>

<body>
<jsp:include page="../HeadFoot/header.jsp"/>
<div id="container">
    <h3> 해당 렌트카업체별 보유 차량 정보</h3>
    <!-- 차량 정보를 동적으로 표시할 테이블 -->
    <div id="roomListTable">
    
      <table border="1" class="table">
        <tr>
        <td>차량 번호</td>
         <td>차량명</td>
          <td>차량 가격</td>
        <td>차량 종류</td>
         <td>연식</td>
          <td>상세내용</td>
        <td>비고</td>
        </tr>
        
       <%
       for(ManagementCarVO vo : list){
       %> 
        
        <tr>
        <td><%= vo.getCar_no() %></td>
        <td><%= vo.getCar_name() %></td>
        <td><%= vo.getCar_price()%></td>
        <td><%= vo.getCar_type()%></td>
        <td><%= vo.getCar_year()%></td>
        <td><%= vo.getCar_cont()%></td>
    
        <td><input type="button" value="객실 삭제"></td> 
        </tr>
        
        <%
       }
        %>
      </table>
        <a href="/Team1_project/lodging/lodging.jsp"> 목록으로 돌아가기</a>
    
    </div>
</div>
<jsp:include page="../HeadFoot/footer.jsp"/>
</body>
</html>
