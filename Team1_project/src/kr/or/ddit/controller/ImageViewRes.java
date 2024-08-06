package kr.or.ddit.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 		서버에 저장된 Image데이터를 응답으로 보내는 서블릿.
 *		 	
 */
@WebServlet("/images/imageViewRes.do")
public class ImageViewRes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// 파라미터로 넘어온 파일 번호를 구한다.
		String imgName = request.getParameter("filepath");

		String uploadPath = "D:/A_TeachingMaterial/03_HighJava/workspace/Team1_project/WebContent/images";
		
		// 저장될 폴더가 없으면 새로 만들어 준다.
		File f = new File(uploadPath);
		if(!f.exists()) {
			f.mkdirs();
		}
		
		File imgFile = new File(f, imgName);
		
		if(imgFile.exists() ) {	    // 해당 파일이 존재할 때
			BufferedInputStream bin = null;
			BufferedOutputStream bout = null;
			try {
				// 출력용 스트림 객체 생성 ==> Response객체 이용
				bout = new BufferedOutputStream(response.getOutputStream());
				
				// 파일 입력용 스트림 객체 생성
				bin = new BufferedInputStream(new FileInputStream(imgFile));
				
				byte[] temp = new byte[1024];
				int len = 0;
				while((len = bin.read(temp)) > 0) {
					bout.write(temp, 0, len);
				}
				bout.flush();
				
			} catch (IOException e) {
				System.out.println("입출력 오류 : " + e);
			} finally {
				if(bin != null) try { bin.close(); } catch(IOException e) {}
				if(bout != null) try { bout.close(); } catch(IOException e) {}
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
