package kr.or.ddit.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.json.simple.JSONObject;

import kr.or.ddit.service.IManagementLodgingService;
import kr.or.ddit.service.ManagementLodgingServiceImpl;
import kr.or.ddit.vo.ManagementLodgingVO;

@WebServlet("/lodgingCompanyInsert.do")
@MultipartConfig(
		fileSizeThreshold = 1024*1024*10,
		maxFileSize = 1024 * 1024 * 5, // 5MB
		maxRequestSize = 1024 * 1024 * 50 // 50MB
)
public class LodgingCompanyInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	    response.setContentType("application/json; charset=utf-8");
	    
	    String type = request.getParameter("type");
	    String name = request.getParameter("name");
	    String tel = request.getParameter("tel");
	    String mail = request.getParameter("mail");
	    String addr = request.getParameter("addr");
	    String info = request.getParameter("info");
	    String content = request.getParameter("content");
	    String lodgingCode = request.getParameter("lodgingCode");
	    
	    Part lodgingImgPart = request.getPart("lodgingImg"); // 숙소 이미지
        String fileName = extractFileName(lodgingImgPart);
	    
	    ManagementLodgingVO vo = new ManagementLodgingVO();
	    
	    vo.setLod_code(lodgingCode);
	    vo.setLod_type(type);
	    vo.setLod_nm(name);
	    vo.setLod_tel(tel);
	    vo.setLod_mail(mail);
	    vo.setLod_addr(addr);
	    vo.setLod_info(info);
	    vo.setLod_cont(content);
	     
	    IManagementLodgingService service = ManagementLodgingServiceImpl.getInstance();
	     
	    String uploadPath = "D:/A_TeachingMaterial/03_HighJava/workspace/Team1_project/WebContent/images";
	    System.out.println("uploadPath" + uploadPath);
	    // 저장될 폴더가 없으면 새로운 폴더 생성
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
        
        String lodgingImgFilePath= uploadPath + File.separator + fileName;
        System.out.println("filePath : " + lodgingImgFilePath);
        
        lodgingImgPart.write(lodgingImgFilePath);
        
        vo.setL_img_path(fileName);
        
        //	서비스 실행
        int cnt = service.lodgingInsert(vo);
        
        request.setAttribute("cnt", cnt);
        request.getRequestDispatcher("/view/result.jsp").forward(request, response);


        JSONObject json = new JSONObject();
        response.getWriter().print(json.toJSONString());
	     
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
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
