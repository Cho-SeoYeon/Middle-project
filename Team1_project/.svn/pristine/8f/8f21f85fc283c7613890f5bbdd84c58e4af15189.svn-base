package kr.or.ddit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.service.CarServiceImpl;
import kr.or.ddit.vo.ReviewVO;

@WebServlet("/carReviewList.do")
public class CarReviewList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		
		CarServiceImpl service = CarServiceImpl.getInstance();
        List<ReviewVO> carReviewList = null;
        String carNo = request.getParameter("carNo");
        carReviewList = service.carReviewList(carNo);
        String json = new Gson().toJson(carReviewList);
        
        
        System.out.println(json);
        response.getWriter().write(json);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
