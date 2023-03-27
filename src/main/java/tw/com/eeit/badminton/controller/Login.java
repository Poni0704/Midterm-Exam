package tw.com.eeit.badminton.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.jasper.compiler.NewlineReductionServletWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tw.com.eeit.badminton.conn.ConnectionFactory;
import tw.com.eeit.badminton.model.bean.Member;

@WebServlet("/Login.do")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processAction(request, response);
//		adminlogin(request, response);
	}

	private void processAction(HttpServletRequest request, HttpServletResponse response) {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String isAdmin = request.getParameter("isAdmin");
//		System.out.println(username + password);

		try {
			Connection conn = ConnectionFactory.getConnection();
			String SQL = "SELECT * FROM [BadmintonCourse].[dbo].[Member] WHERE [username] = ? AND [password] = ? AND [isAdmin] = ?";
			PreparedStatement prepareStatement = conn.prepareStatement(SQL);
			prepareStatement.setString(1, username);
			prepareStatement.setString(2, password);
			prepareStatement.setString(3, isAdmin);

			ResultSet rs = prepareStatement.executeQuery();
			if (rs.next()) {
				HttpSession session = request.getSession();

				Member m = new Member(rs.getString("username"),rs.getString("password"),rs.getString("isAdmin"));

				session.setAttribute("LoginUser", m);

				// 回應給使用者看
				response.setContentType("text/html;charset:UTF-8");
				response.setHeader("Refresh", "1;URL=http://localhost:8080/Badminton1/index.jsp");
				PrintWriter out = response.getWriter();
				out.write("您已登入成功!!");

				out.close();
				rs.close();
				prepareStatement.close();
				
			} else {
				response.setContentType("text/html;charset:UTF-8");
				response.setHeader("Refresh", "1;URL=http://localhost:8080/Badminton1/index.jsp");
				PrintWriter out = response.getWriter();
				out.write("輸入錯誤，請重新登入!");

				out.close();
			}

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	private void adminlogin(HttpServletRequest request, HttpServletResponse response) {
//		try {
//			Connection conn = ConnectionFactory.getConnection();
//			String SQL = "SELECT * FROM [BadmintonCourse].[dbo].[Member] WHERE [isAdmin] = ? ";
//			PreparedStatement prepareStatement = conn.prepareStatement(SQL);
//			new Member();
//			prepareStatement.setString(1,);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}

}
