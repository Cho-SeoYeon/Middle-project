package kr.or.ddit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import kr.or.ddit.service.CarServiceImpl;
import kr.or.ddit.vo.CarListVO;

@WebServlet("/carList.do")
public class CarList extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // 클라이언트로부터 받은 파라미터 추출
        String carName = request.getParameter("carName");
        String inDate = request.getParameter("inDate");
        String outDate = request.getParameter("outDate");
        String carType = request.getParameter("carType");
        System.out.println(carName);
        System.out.println(inDate);
        System.out.println(outDate);
        System.out.println(carType);
        
        CarServiceImpl service = CarServiceImpl.getInstance();
        List<CarListVO> carList = null;
        carList = service.carSearchList(carName, inDate, outDate, carType);
        	
        
        String json = new Gson().toJson(carList);
        System.out.println("!@#!@#!@#"+json);
        response.getWriter().write(json);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // doPost에서 doGet을 호출하여 같은 로직을 수행
        doGet(request, response);
    }
}
