package tw.com.eeit.badminton.controller;

import java.io.IOException;
import java.sql.Connection;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tw.com.eeit.badminton.conn.ConnectionFactory;
import tw.com.eeit.badminton.model.bean.Product;
import tw.com.eeit.badminton.model.dao.ProductDAO;


@WebServlet("/GetUpdatePage.do")
public class GetUpdatePage extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//我要開始拿值，透過request要，因為是user端丟request過來
		Integer id = Integer.valueOf(request.getParameter("id")) ;
		try {
			Connection conn = ConnectionFactory.getConnection();
			ProductDAO pDAO = new ProductDAO(conn);
			//找到這個id的所有資料
			Product p = pDAO.findProductByID(id);
			//並且把它的值存起來，用seesion(可以跨頁取得值)
			HttpSession session = request.getSession();
			session.setAttribute("newid", id);
			session.setAttribute("product", p);
			
			conn.close();
			//在導向updatePage的jsp
			request.getRequestDispatcher("UpdatePage.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
