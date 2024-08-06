package kr.or.ddit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.service.CarServiceImpl;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.ResCarVO;

@WebServlet("/carResPayment.do")
public class CarResPayment extends HttpServlet {
   private static final long serialVersionUID = 1L;

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("utf-8");
      HttpSession session = request.getSession(false);
      MemberVO memVo = (MemberVO) session.getAttribute("loginMember");
      String userId = memVo.getUser_id();
      String totalPriceString = request.getParameter("pay_totalPrice");
      int totalPrice = Integer.parseInt(totalPriceString.replaceAll("[^0-9]", ""));
      String insurancePrice = request.getParameter("pay_insurancePrice");
      if("11100".equals(insurancePrice)) {
         insurancePrice = "미포함";
      }else if("21100".equals(insurancePrice)) {
         insurancePrice = "일반자차";
      }else if("31100".equals(insurancePrice)){
         insurancePrice = "완전자차";
      }
      String carNo = request.getParameter("pay_carNo");
      String inDate = request.getParameter("pay_inDate");
      String outDate = request.getParameter("pay_outDate");
      String cpnCode = request.getParameter("pay_cpnCode");

      System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
      System.out.println("userId : " + userId);
      System.out.println("totalPrice : " + totalPrice);
      System.out.println("insurancePrice : " + insurancePrice);
      System.out.println("carNo : " + carNo);
      System.out.println("inDate : " + inDate);
      System.out.println("outDate : " + outDate);
      System.out.println("cpnCode : " + cpnCode);
      System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
      
      ResCarVO resCarVo = new ResCarVO();
//      '회원아이디', '차량번호 ', '쿠폰코드', '일반자차', '입실일', '퇴실일', '전체가격'
      CarServiceImpl service = CarServiceImpl.getInstance();
      resCarVo.setUser_id(userId);
      resCarVo.setCar_no(carNo);
      resCarVo.setCnp_code(cpnCode);
      resCarVo.setCar_insr(insurancePrice);
      resCarVo.setRent_start(inDate);
      resCarVo.setRent_end(outDate);
      resCarVo.setRent_price(totalPrice);
      
      int cnt = service.resCarPayment(resCarVo);
      
      request.getRequestDispatcher("/main.jsp").forward(request, response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      doGet(request, response);
   }

}