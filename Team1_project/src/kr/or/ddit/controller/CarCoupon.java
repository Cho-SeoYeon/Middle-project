package kr.or.ddit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import kr.or.ddit.service.CarServiceImpl;
import kr.or.ddit.vo.CarCouponVO;
import kr.or.ddit.vo.MemberVO;

@WebServlet("/carCoupon.do")
public class CarCoupon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession(false);
		MemberVO memVo = (MemberVO) session.getAttribute("loginMember");
		String cpnCodeNum = request.getParameter("cpnCodeNum");
        String userId = memVo.getUser_id();
        
        
        CarServiceImpl service = CarServiceImpl.getInstance();
        CarCouponVO cpnVo = null;
        CarCouponVO cnt = null;
        cpnVo = service.carCouponUseCheck(cpnCodeNum, userId);
        cnt = service.carCouponCodeCheck(cpnCodeNum);
        
        JSONObject jsonObj = new JSONObject();
        
        // 쿠폰이 유효하고 아직 사용하지 않았을 경우
        if(cnt != null && cpnVo == null) {
        	jsonObj.put("status","success");
        	jsonObj.put("sale", cnt.getCnp_sale());
        }else {
        	jsonObj.put("status","fail");
        	if(cnt==null) {
        		jsonObj.put("msg","유효하지 않은 쿠폰입니다.");
        	}else if(cpnVo != null) {
        		jsonObj.put("msg","이미 사용한 쿠폰입니다.");
        	}
        }
        
        response.getWriter().print(jsonObj.toJSONString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
