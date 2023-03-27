package tw.com.eeit.badminton.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Base64;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import tw.com.eeit.badminton.conn.ConnectionFactory;
import tw.com.eeit.badminton.model.bean.MemberDetail;
import tw.com.eeit.badminton.model.bean.Product;
import tw.com.eeit.badminton.model.dao.MemberDetailDAO;
import tw.com.eeit.badminton.model.dao.ProductDAO;

@MultipartConfig
@WebServlet("/CreateMemberDetail.do")
public class CreateMemberDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		processAction(request, response);
	}
	
	private void processAction(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		PrintWriter out = null;
		
		try {
			response.setContentType("text/html;charset:UTF-8");
			out = response.getWriter();
			
			String username = request.getParameter("username");
			String gender = request.getParameter("gender");
			Integer age = Integer.valueOf(request.getParameter("age"));
			String birth = request.getParameter("birth");
			Integer phone = Integer.valueOf(request.getParameter("phone"));
			String address = request.getParameter("address");
			String email = request.getParameter("email");
			
			// 我現在要把byte陣列變成String，要用getEncoder()裡的encodeToString()
			Part part = request.getPart("photo");
			// part物件裡有一個getInpurStream功能，再用readAllBytes取出來
			InputStream is = part.getInputStream();
			String encodeToString = Base64.getEncoder().encodeToString(is.readAllBytes());
			String newphoto = "data:image/png;base64," + encodeToString;
			is.close();
			
			try {
				//我在跟資料庫重新拿一次資料
				Connection conn = ConnectionFactory.getConnection();
				MemberDetailDAO mdDAO = new MemberDetailDAO(conn);
				MemberDetail md = new MemberDetail();
				md.setUsername(username);
				md.setGender(gender);
				md.setAge(age);
				md.setBirth(birth);
				md.setPhone(phone);
				md.setAddress(address);
				md.setEmail(email);
				md.setPhoto(newphoto);
				

				mdDAO.createMemberDetail(md);
				
				conn.close();
				
				//回應給使用者看
				response.setContentType("text/html;charset:UTF-8");
				response.setHeader("Refresh", "1;URL=http://localhost:8080/Badminton1/ShowAllMemberDetail.do");
				out = response.getWriter();
				out.write("您已將會員資料新增成功!!");
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
