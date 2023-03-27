package tw.com.eeit.badminton.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tw.com.eeit.badminton.model.bean.Product;

public class ProductDAO {

	private Connection conn;

	// 與課程資料表相關的方法，如果要使用就必須傳送建構子Connection連線物件才可以使用
	// 等於我要在這邊開一道門給DAO去訪問資料庫做連線
	public ProductDAO(Connection conn) {
		this.conn = conn;
	}

	/*
	 * 取得所有課程的資訊，return一個課程資訊列表list
	 */
	public List<Product> findAllProducts() {
		try {
			// 先查詢資料庫的資料
			String SQL = "SELECT * FROM [BadmintonCourse].[dbo].[Product]";

			// 宣告一個陣列，到時候會把值都存進去
			List<Product> productList = new ArrayList<Product>();

			PreparedStatement preState = conn.prepareStatement(SQL);

			// 將找到的值透過建構方法新增進去動態陣列中
			ResultSet rs = preState.executeQuery();

			while (rs.next()) {

				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setPteacher(rs.getString("pteacher"));
				product.setPcontent(rs.getString("pcontent"));
				product.setPrice(rs.getInt("price"));
				product.setPhoto(rs.getString("photo"));

				// 設值到product中，並一次將全部加進去productList
				productList.add(product);
			}

			rs.close();
			preState.close();

			return productList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * 根據課程ID尋找對應的課程資訊，return product的JavaBean
	 */

	public Product findProductByID(int productID) {
		try {
			// 寫入查詢語句
			String SQL = "SELECT * FROM [BadmintonCourse].[dbo].[Product] WHERE [id] = ?";

			// 先將初始值制定成null
			Product product = null;

			PreparedStatement preState = conn.prepareStatement(SQL);
			preState.setInt(1, productID);

			ResultSet rs = preState.executeQuery();

			// 如果查詢id正確，product會被實體化，並且set基本屬性，
			// 如果查詢id錯誤，中間就會跳過，並且回傳一個空物件
			if (rs.next()) {
				product = new Product();
				product.setId(rs.getInt("id"));
				product.setPteacher(rs.getString("pteacher"));
				product.setPcontent(rs.getString("pcontent"));
				product.setPrice(rs.getInt("price"));
				product.setPhoto(rs.getString("photo"));
			}

			rs.close();
			preState.close();

			return product;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	/*
	 * 根據課程ID刪除對應的課程資訊，return product的JavaBean
	 */

	public boolean deleteProductByID(int id) {
		try {
			String SQL = "DELETE FROM [BadmintonCourse].[dbo].[Product] WHERE ID=?";
			PreparedStatement preState = conn.prepareStatement(SQL);
			preState.setInt(1, id);
			preState.executeUpdate();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;

	}

	/*
	 * 根據課程ID修改對應課程的資料
	 * 
	 * @param memberID 會員ID
	 * 
	 * @param member 欲修改的資料
	 * 
	 * @return true 表示刪除成功、false 表示刪除失敗
	 */

	public boolean updateProduct(int id, Product product) {

		try {
			String SQL = "UPDATE [BadmintonCourse].[dbo].[Product] "
					+ "SET [pteacher] = ?, [pcontent] = ?, [price] = ?, [photo] = ? WHERE [id] = ?";
			PreparedStatement preState = conn.prepareStatement(SQL);
			preState.setString(1, product.getPteacher());
			preState.setString(2, product.getPcontent());
			preState.setInt(3, product.getPrice());
			preState.setString(4, product.getPhoto());
			preState.setInt(5, id);
			preState.executeUpdate();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	/*
	 * 根據傳入的JavaBean建立對應的課程
	 * 
	 * @param member 需包含課程的所有資訊
	 * 
	 * @return true 表示建立成功、false 表示建立失敗
	 */

	public boolean createProduct(Product product) {
		try {
			String SQL = "INSERT INTO [BadmintonCourse].[dbo].[Product]"
					+ "([pteacher],[pcontent],[price],[photo]) VALUES(?, ?, ?, ?)";
			PreparedStatement preState = conn.prepareStatement(SQL);
			preState.setString(1,product.getPteacher());
			preState.setString(2, product.getPcontent());
			preState.setInt(3, product.getPrice());
			preState.setString(4, product.getPhoto());
			
			preState.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/*
	 * 取得所有課程的資訊，return一個課程資訊列表list
	 */
	public List<Product> findAllCourse() {
		try {
			// 先查詢資料庫裡所有課程的資料
			String SQL = "SELECT [pcontent] FROM [BadmintonCourse].[dbo].[Product]";

			// 宣告一個陣列，到時候會把值都存進去
			List<Product> courseList = new ArrayList<Product>();

			PreparedStatement preState = conn.prepareStatement(SQL);
//			preState.setString(1, Product.);

			// 將找到的值透過建構方法新增進去動態陣列中
			ResultSet rs = preState.executeQuery();

			while (rs.next()) {
				Product course = new Product();
				course.setPcontent(rs.getString("pcontent"));


				// 設值到course中，並一次將全部加進去courseList
				courseList.add(course);
			}

			rs.close();
			preState.close();

			return courseList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
