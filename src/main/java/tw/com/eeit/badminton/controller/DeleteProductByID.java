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
import tw.com.eeit.badminton.model.dao.ProductDAO;


@WebServlet("/DeleteProductByID.do")
public class DeleteProductByID extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//我要開始拿值，透過request要
		//我透過getParameter去拿到我要的參數，丟到id裡，強制轉型成27行程式碼可以用
		Integer id =Integer.valueOf(request.getParameter("id"));    
		
		try {
			Connection conn = ConnectionFactory.getConnection();
			ProductDAO pDAO = new ProductDAO(conn);
			pDAO.deleteProductByID(id);
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setContentType("text/html;charset:UTF-8");
		response.setHeader("Refresh", "1;URL=http://localhost:8080/Badminton1/ShowAllProduct.do");
		PrintWriter out = response.getWriter();
		out.write("您已將課程刪除成功!!");
		
		out.close();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
