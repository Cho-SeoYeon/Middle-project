package kr.or.ddit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.service.ILodgingService;
import kr.or.ddit.service.LodgingServiceImpl;
import kr.or.ddit.vo.LodgingDetailVO;
import kr.or.ddit.vo.LodgingRoomReviewVO;
import kr.or.ddit.vo.RoomsVO;


@WebServlet("/lodgingDetail.do")
public class LodgingDetail extends HttpServlet {
   private static final long serialVersionUID = 1L;


   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("utf-8");
      
      String lodgingCode = request.getParameter("lod_code");
      String lodgingName = request.getParameter("lod_nm");
      String guestStr = request.getParameter("guestNum");
      
      int guestNum = Integer.parseInt(guestStr==null ? "2" : guestStr);
      String lodgingType = request.getParameter("lodgingType");
      String startDate = request.getParameter("lod_start");
      String endDate = request.getParameter("lod_end");
      
      ILodgingService service = LodgingServiceImpl.getInstance();
      List<LodgingDetailVO> lodgingList = null;
      
      lodgingList = service.lodgingDetail(lodgingCode, lodgingName, guestNum, lodgingType, startDate, endDate);
      
      for(LodgingDetailVO lodgvo : lodgingList) {
         
         List<RoomsVO> roomList = service.roomsList(lodgvo.getLod_code(), guestNum, startDate, endDate);
         if(roomList!=null) {
            lodgvo.setRoomList(roomList);
         }
         
         // 리뷰 추가
         List<LodgingRoomReviewVO> reviewList = service.lodgingReview(lodgvo.getLod_code());
         if (reviewList != null) {
            lodgvo.setReviewList(reviewList);
         }
      }
      
      // request로 저장
      request.setAttribute("theLodgingList", lodgingList);
      request.setAttribute("lodgingCode", lodgingCode);
      request.setAttribute("startDate", startDate);
      request.setAttribute("endDate", endDate);
      // view
      request.getRequestDispatcher("/lodging/lodgingView/lodgingDetail.jsp").forward(request, response);
      
   }


}
