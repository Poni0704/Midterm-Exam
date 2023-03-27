package tw.com.eeit.badminton.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tw.com.eeit.badminton.model.bean.MemberDetail;
import tw.com.eeit.badminton.model.bean.Product;

public class MemberDetailDAO {

	private Connection conn;
	// 與會員詳細資料表相關的方法，如果要使用就必須傳送建構子Connection連線物件才可以使用
	// 等於我要在這邊開一道門給DAO去訪問資料庫做連線
	public MemberDetailDAO(Connection conn) {
		this.conn = conn;
	}

	/*
	 * 取得所有會員詳細資訊，return一個會員詳細資訊列表list
	 */
	public List<MemberDetail> findAllMemberDetail() {
		try {
			// 先查詢資料庫的資料
			String SQL = "SELECT * FROM [BadmintonCourse].[dbo].[MemberDetail]";

			// 宣告一個陣列，到時候會把值都存進去
			List<MemberDetail> MemberDetailList = new ArrayList<MemberDetail>();

			PreparedStatement preState = conn.prepareStatement(SQL);

			// 將找到的值透過建構方法新增進去動態陣列中
			ResultSet rs = preState.executeQuery();

			while (rs.next()) {

				MemberDetail MemberDetail = new MemberDetail();
				MemberDetail.setId(rs.getInt("id"));
				MemberDetail.setUsername(rs.getString("username"));
				MemberDetail.setGender(rs.getString("gender"));
				MemberDetail.setAge(rs.getInt("age"));
				MemberDetail.setBirth(rs.getString("birth"));
				MemberDetail.setPhone(rs.getInt("phone"));
				MemberDetail.setAddress(rs.getString("address"));
				MemberDetail.setEmail(rs.getString("email"));
				MemberDetail.setPhoto(rs.getString("photo"));

				// 設值到MemberDetail中，並一次將全部加進去MemberDetailList
				MemberDetailList.add(MemberDetail);
			}

			rs.close();
			preState.close();

			return MemberDetailList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * 根據課程ID尋找對應的會員詳細資訊，return MemberDetail的JavaBean
	 */

	public MemberDetail findProductByID(int MemberDetailID) {
		try {
			// 寫入查詢語句
			String SQL = "SELECT * FROM [BadmintonCourse].[dbo].[MemberDetail] WHERE [id] = ?";

			// 先將初始值制定成null
			MemberDetail MemberDetail = null;

			PreparedStatement preState = conn.prepareStatement(SQL);
			preState.setInt(1, MemberDetailID);

			ResultSet rs = preState.executeQuery();

			// 如果查詢id正確，MemberDetailID會被實體化，並且set基本屬性，
			// 如果查詢id錯誤，中間就會跳過，並且回傳一個空物件
			if (rs.next()) {
				
				MemberDetail = new MemberDetail();
				MemberDetail.setId(rs.getInt("id"));
				MemberDetail.setUsername(rs.getString("username"));
				MemberDetail.setGender(rs.getString("gender"));
				MemberDetail.setAge(rs.getInt("age"));
				MemberDetail.setBirth(rs.getString("birth"));
				MemberDetail.setPhone(rs.getInt("phone"));
				MemberDetail.setAddress(rs.getString("address"));
				MemberDetail.setEmail(rs.getString("email"));
				MemberDetail.setPhoto(rs.getString("photo"));
			}

			rs.close();
			preState.close();

			return MemberDetail;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	/*
	 * 根據課程ID刪除對應的課程資訊，return MemberDetail的JavaBean
	 */

	public boolean deleteMemberDetailByID(int id) {
		try {
			String SQL = "DELETE FROM [BadmintonCourse].[dbo].[MemberDetail] WHERE ID=?";
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
	 * @param MemberDetailID 會員ID
	 * 
	 * @param MemberDetail 欲修改的資料
	 * 
	 * @return true 表示刪除成功、false 表示刪除失敗
	 */

	public boolean updateMemberDetail(int id, MemberDetail MemberDetail) {

		try {
			String SQL = "UPDATE [BadmintonCourse].[dbo].[MemberDetail] "
					+ "SET [username] = ?, [gender] = ?, [age] = ?, [birth] = ?, [phone] = ?,"
					+ "[address] = ?,[email] = ?,[photo] = ? WHERE [id] = ?";
			PreparedStatement preState = conn.prepareStatement(SQL);
			preState.setString(1, MemberDetail.getUsername());
			preState.setString(2, MemberDetail.getGender());
			preState.setInt(3, MemberDetail.getAge());
			preState.setString(4, MemberDetail.getBirth());
			preState.setInt(5, MemberDetail.getPhone());
			preState.setString(6, MemberDetail.getAddress());
			preState.setString(7, MemberDetail.getEmail());
			preState.setString(8, MemberDetail.getPhoto());
			preState.setInt(9, id);
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
	 * @param MemberDetail 需包含課程的所有資訊
	 * 
	 * @return true 表示建立成功、false 表示建立失敗
	 */

	public boolean createMemberDetail(MemberDetail MemberDetail) {
		try {
			String SQL = "INSERT INTO [BadmintonCourse].[dbo].[MemberDetail]"
					+ "([username],[gender],[age],[birth],[phone],[address],[email],[photo]) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preState = conn.prepareStatement(SQL);
			preState.setString(1, MemberDetail.getUsername());
			preState.setString(2, MemberDetail.getGender());
			preState.setInt(3, MemberDetail.getAge());
			preState.setString(4, MemberDetail.getBirth());
			preState.setInt(5, MemberDetail.getPhone());
			preState.setString(6, MemberDetail.getAddress());
			preState.setString(7, MemberDetail.getEmail());
			preState.setString(8, MemberDetail.getPhoto());
			
			preState.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
