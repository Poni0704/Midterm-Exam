package tw.com.eeit.badminton.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tw.com.eeit.badminton.conn.ConnectionFactory;
import tw.com.eeit.badminton.model.dao.MemberDetailDAO;


@WebServlet("/DeleteMemberDetailByID.do")
public class DeleteMemberDetailByID extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id =Integer.valueOf(request.getParameter("id"));    
		try {
			Connection conn = ConnectionFactory.getConnection();
			MemberDetailDAO mdDAO = new MemberDetailDAO(conn);
			mdDAO.deleteMemberDetailByID(id);
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setContentType("text/html;charset:UTF-8");
		response.setHeader("Refresh", "1;URL=http://localhost:8080/Badminton1/ShowAllMemberDetail.do");
		PrintWriter out = response.getWriter();
		out.write("您已將會員刪除成功!!");
		
		out.close();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
