package kr.or.ddit.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.service.IManagementCarService;
import kr.or.ddit.service.ManagementCarServiceImpl;
import kr.or.ddit.vo.ManagementCarVO;
import kr.or.ddit.vo.MemberVO;

@WebServlet("/carCompanyInsert.do")
public class CarCompanyInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	    response.setContentType("application/json; charset=utf-8");
        
	    String companyName = request.getParameter("rent_nm");
        String companyCode = request.getParameter("rent_code");
        String companyTel = request.getParameter("rent_tel");
        String companyAddr = request.getParameter("rent_addr");
        String companyMail = request.getParameter("rent_mail");

		/*
		 * System.out.println(companyName + "!!!!!!!!!!!!!companyName");
		 * System.out.println(companyCode + "!!!!!!!!!!!!!companyCode");
		 * System.out.println(companyTel + "!!!!!!!!!!!!!companyTel");
		 * System.out.println(companyAddr + "!!!!!!!!!!!!!companyAddr");
		 * System.out.println(companyMail + "!!!!!!!!!!!!!companyMail");
		 */
        
        ManagementCarVO vo = new ManagementCarVO();
        
        try {
			BeanUtils.populate(vo, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
        System.out.println("vo >>>> " + vo);
        
//        vo.setRent_nm(companyName);
//        vo.setRent_code(companyCode);
//        vo.setRent_tel(companyTel);
//        vo.setRent_addr(companyAddr);
//        vo.setRent_mail(companyMail);
	
        
        IManagementCarService service = ManagementCarServiceImpl.getInstance();
        
        int cnt = service.carCompanyInsert(vo);
        
        request.setAttribute("cnt", cnt);
        request.getRequestDispatcher("/view/result.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
