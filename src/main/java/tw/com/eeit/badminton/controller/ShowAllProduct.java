package tw.com.eeit.badminton.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tw.com.eeit.badminton.conn.ConnectionFactory;
import tw.com.eeit.badminton.model.bean.Product;
import tw.com.eeit.badminton.model.dao.ProductDAO;


@WebServlet("/ShowAllProduct.do")
public class ShowAllProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//呼叫連線工廠，拿到連線後存成conn
			Connection conn = ConnectionFactory.getConnection();
			
			//我new完dao後，我要去dao裡面要我需要的資料
			//因為我有寫要回傳一個list，所以我需要寫一個productList變數去接他
			ProductDAO productDAO = new ProductDAO(conn);
			List<Product> productList = productDAO.findAllProducts();
//			List<Product> courseList = productDAO.findAllCourse();
			
			conn.close();
			
			
			
			//最後存起來，命名pList，資訊共享給jsp使用
//			request.setAttribute("pList", productList);
//			request.getRequestDispatcher("ShowAllProduct.jsp").forward(request, response);
			
			HttpSession session = request.getSession();
			session.setAttribute("pList", productList);
			response.sendRedirect("ShowAllProduct.jsp");
			
			
//			HttpSession session = request.getSession();
//			session.setAttribute("pList", productList);
//			response.sendRedirect("ShowAllProduct.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
