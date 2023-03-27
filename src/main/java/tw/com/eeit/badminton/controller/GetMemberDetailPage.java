package tw.com.eeit.badminton.controller;

import java.io.IOException;
import java.sql.Connection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tw.com.eeit.badminton.conn.ConnectionFactory;
import tw.com.eeit.badminton.model.bean.MemberDetail;
import tw.com.eeit.badminton.model.dao.MemberDetailDAO;


@WebServlet("/GetMemberDetailPage.do")
public class GetMemberDetailPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.valueOf(request.getParameter("id")) ;
		
		try {
			Connection conn = ConnectionFactory.getConnection();
			MemberDetailDAO mdDAO = new MemberDetailDAO(conn);
			MemberDetail md = mdDAO.findProductByID(id);
			HttpSession session = request.getSession();
			session.setAttribute("newid", id);
			session.setAttribute("memberdetail", md);
			
			conn.close();
			
			request.getRequestDispatcher("UpdateMemberDetailPage.jsp").forward(request, response);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
