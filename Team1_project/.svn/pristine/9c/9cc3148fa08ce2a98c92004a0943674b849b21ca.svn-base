package kr.or.ddit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import kr.or.ddit.service.ILodgingService;
import kr.or.ddit.service.LodgingServiceImpl;
import kr.or.ddit.vo.LodgingCouponVO;
import kr.or.ddit.vo.ResLodVO;


@WebServlet("/lodgingCnpCheck.do")
public class LodgingCnpCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		
		String cnpCode = request.getParameter("cnpCode");
		String userId = request.getParameter("user_id");
		
		ILodgingService service = LodgingServiceImpl.getInstance();
		
		LodgingCouponVO cnpVo = service.lodgingCnpCheck(cnpCode);		
		ResLodVO resVo = service.lodgingCnpUseCheck(userId, cnpCode);
		
		JSONObject jsonObj = new JSONObject();
		
		// 쿠폰이 유효하고 아직 사용하지 않았을 경우
		if (cnpVo != null && resVo == null) {
			// 할인율을 JSON객체에 담아 전송
			jsonObj.put("status", "success");
			jsonObj.put("cnp_sale", cnpVo.getCnp_sale());
		} else {
			// 쿠폰이 유효하지 않거나 이미 사용되었을 경우
			jsonObj.put("status", "fail");
			if (cnpVo == null) {
				jsonObj.put("message", "유효하지 않은 쿠폰입니다");
			}else if (resVo != null){
				jsonObj.put("message", "이미 사용한 쿠폰입니다");
			}
		}
		response.getWriter().print(jsonObj.toJSONString());
	}

}
