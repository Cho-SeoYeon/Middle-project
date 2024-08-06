package kr.or.ddit.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.json.simple.JSONObject;

import kr.or.ddit.service.IManagementCarService;
import kr.or.ddit.service.ManagementCarServiceImpl;
import kr.or.ddit.vo.ManagementCarVO;

@WebServlet("/carInsert.do")
@MultipartConfig(
		fileSizeThreshold = 1024*1024*10,
		maxFileSize = 1024 * 1024 * 5, // 5MB
		maxRequestSize = 1024 * 1024 * 50 // 50MB
)
public class CarInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("utf-8");
	        response.setContentType("application/json; charset=utf-8");

	        //연식, 차량종류, 차량명, 가격, 업체명, 전화번호, 주소, 이메일, 이용정보, 파일
	        
	        String carNo = request.getParameter("no") + " ";
	        String carYear  = request.getParameter("year");
	        String carType = request.getParameter("type");
	        String carName = request.getParameter("name");
	        int carPrice = Integer.parseInt(request.getParameter("price"));
	        String companyCode = request.getParameter("companyCode");
	        String content = request.getParameter("content");
	        
	        Part part = request.getPart("fimg");
	        System.out.println("part : " + part);
	        
	        String fileName = extractFileName(part);
	        //String saveFileName = UUID.randomUUID().toString() + "_" + fileName;
	        System.out.println("fileName  === " + fileName);
	        
	        ManagementCarVO vo = new ManagementCarVO();
	        
	        vo.setCar_no(carNo);
	        vo.setCar_year(carYear);
	        vo.setCar_type(carType);
	        vo.setCar_name(carName);
	        vo.setCar_price(carPrice);
	        vo.setRent_code(companyCode);
	        vo.setCar_cont(content);
	        
	        
	        IManagementCarService service = ManagementCarServiceImpl.getInstance();

	        // 업로드된 파일들이 저장될 폴더 설정 (웹 애플리케이션 내부 경로 사용)
	        String uploadPath = "D:/A_TeachingMaterial/03_HighJava/workspace/Team1_project/WebContent/images";
	        
	        System.out.println("uploadPath" + uploadPath);
	        // 저장될 폴더가 없으면 새로운 폴더 생성
	        File uploadDir = new File(uploadPath);
	        if (!uploadDir.exists()) {
	            uploadDir.mkdirs();
	        }
	        
	        
	        String filePath = uploadPath + File.separator + fileName;
	        System.out.println("filePath : " + filePath);
	       
	        part.write(filePath); // 파일을 경로에 저장


	        vo.setC_img_path(fileName);
	        
	        //	서비스 실행
	        int cnt = service.carInsert(vo);
	        System.out.println("cnt ===" + cnt);

	        JSONObject json = new JSONObject();
	        response.getWriter().print(json.toJSONString());
	}
	
	 private String extractFileName(Part part) {
	        String contentDisp = part.getHeader("content-disposition");
	        String[] items = contentDisp.split(";");
	        for (String item : items) {
	            if (item.trim().startsWith("filename")) {
	                return item.substring(item.indexOf("=") + 2, item.length()-1);
	            }
	        }
	        return "";
	    }

}
