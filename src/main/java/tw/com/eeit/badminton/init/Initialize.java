package tw.com.eeit.badminton.init;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Base64;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import tw.com.eeit.badminton.conn.ConnectionFactory;
import tw.com.eeit.badminton.model.bean.Member;
import tw.com.eeit.badminton.model.bean.MemberDetail;
import tw.com.eeit.badminton.model.bean.Product;

@WebListener
public class Initialize implements ServletContextListener{
	private Connection conn;
	private String realPath;
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		realPath = sce.getServletContext().getRealPath("");
		System.out.println("System Initialized!");
		
		try {
			conn = ConnectionFactory.getConnection();
			createDataBase();
			createProductTabale();
			createMemberTabale();
			createMemberDetailTabale();
			insertIntoDataToProduct();
			insertIntoDataToMember();
			insertIntoDataToMemberDetail();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	//建立BadmintonCourse資料庫
	private void createDataBase() throws Exception {
		//如果沒有就幫我建立
		String SQL="IF DB_ID('BadmintonCourse') IS NULL CREATE DATABASE BadmintonCourse";
		Statement state = conn.createStatement();
		state.execute(SQL);
		state.close();
	}
	//建立Product資料表
	private void createProductTabale() throws Exception {
		//如果資料表是空的，就幫我建立
		String SQL = "IF OBJECT_ID('[BadmintonCourse].[dbo].[Product]') IS NULL " + "CREATE TABLE [BadmintonCourse].[dbo].[Product]("
				+ "[id] INT IDENTITY(1,1) PRIMARY KEY NOT NULL," + "[pteacher] NVARCHAR(50) NOT NULL,"
				+ "[pcontent] NVARCHAR(50) NOT NULL," + "[price] int NOT NULL," + "[photo] NVARCHAR(MAX))" ;
			Statement state = conn.createStatement();
			state.execute(SQL);
			state.close();
	}
	//新增data進去Product資料表
	private void insertIntoDataToProduct() throws Exception {
		String SQL = "INSERT INTO [BadmintonCourse].[dbo].[Product]([pteacher],[pcontent],[price],[photo]) VALUES (?, ?, ?, ?)";
		
		if(conn.createStatement().executeQuery("SELECT ID FROM [BadmintonCourse].[dbo].[Product]").next()) {
			return;
		}
		
		BufferedReader br = new BufferedReader(
				new FileReader(realPath + "WEB-INF/ForInitialization/Product.json"));
		List<Product> ProductList = new Gson().fromJson(br, new TypeToken<List<Product>>() {
		}.getType());
		
		br.close();

		PreparedStatement preState = conn.prepareStatement(SQL);
		
		//透過for each的方式將值塞進去
		for (Product p : ProductList) {
			preState.setString(1,p.getPteacher() );
			preState.setString(2, p.getPcontent());
			preState.setInt(3, p.getPrice());

			BufferedInputStream bis = new BufferedInputStream(
					new FileInputStream(realPath + "WEB-INF/ForInitialization/teacher/" + p.getPhoto() + ".jpg"));

			preState.setString(4, "data:image/png;base64," + Base64.getEncoder().encodeToString(bis.readAllBytes()));
			bis.close();

			preState.addBatch();
		}
		preState.executeBatch();

		preState.close();
	}
	
	/*
	 * 建立一張新的表-Member會員表，資料表裡面的title有id/username/password/level
	 * 接著在啟動server的時候insert進來
	 */
	
	private void createMemberTabale() throws Exception {
		String SQL = "IF OBJECT_ID('[BadmintonCourse].[dbo].[Member]') IS NULL " + "CREATE TABLE [BadmintonCourse].[dbo].[Member]("
				+ "[id] INT IDENTITY(1,1) PRIMARY KEY NOT NULL," + "[username] NVARCHAR(100) NOT NULL,"
				+ "[password] NVARCHAR(50) NOT NULL," + "[isAdmin] NVARCHAR(50) NOT NULL)";

		Statement state = conn.createStatement();
		state.execute(SQL);
		state.close();
	}
	
	private void insertIntoDataToMember() throws Exception {
		String SQL = "INSERT INTO [BadmintonCourse].[dbo].[Member]([username],[password],[isAdmin]) VALUES (?, ?, ?)";

		if (conn.createStatement().executeQuery("SELECT id FROM [BadmintonCourse].[dbo].[Member]").next()) {
			return;
		}

		BufferedReader br = new BufferedReader(new FileReader(realPath + "WEB-INF/ForInitialization/Member.json"));
		List<Member> memberList = new Gson().fromJson(br, new TypeToken<List<Member>>() {
		}.getType());
		
		br.close();

		PreparedStatement preState = conn.prepareStatement(SQL);

		for (Member m : memberList) {
			preState.setString(1, m.getUsername());
			preState.setString(2, m.getPassword());
			preState.setString(3, m.getIsAdmin());
			preState.addBatch();
		}
		preState.executeBatch();

		preState.close();

	}
	
	/*
	 * 建立一張新的表-MemberDetail會員表，資料表裡面的title有id/username/gender/age/birth/phone/address/email/photo
	 * 接著在啟動server的時候insert進來
	 */
	
	private void createMemberDetailTabale() throws Exception {
		String SQL = "IF OBJECT_ID('[BadmintonCourse].[dbo].[MemberDetail]') IS NULL " + "CREATE TABLE [BadmintonCourse].[dbo].[MemberDetail]("
				+ "[id] INT IDENTITY(1,1) PRIMARY KEY NOT NULL," + "[username] NVARCHAR(100) NOT NULL,"
				+ "[gender] NVARCHAR(50) NOT NULL," + "[age] INT NOT NULL,"+"[birth] NVARCHAR(50) NOT NULL,"+"[phone] INT NOT NULL,"
						+ "[address] NVARCHAR(50) NOT NULL,"+"[email] NVARCHAR(50) NOT NULL,"+"[photo] NVARCHAR(MAX) NOT NULL)";

		Statement state = conn.createStatement();
		state.execute(SQL);
		state.close();
	}
	
	private void insertIntoDataToMemberDetail() throws Exception {
		String SQL = "INSERT INTO [BadmintonCourse].[dbo].[MemberDetail]([username],[gender],[age],[birth],[phone],[address],[email],[photo]) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		if (conn.createStatement().executeQuery("SELECT id FROM [BadmintonCourse].[dbo].[MemberDetail]").next()) {
			return;
		}

		BufferedReader br = new BufferedReader(new FileReader(realPath + "WEB-INF/ForInitialization/MemberDetail.json"));
		List<MemberDetail> memberDetailList = new Gson().fromJson(br, new TypeToken<List<MemberDetail>>() {
		}.getType());
		
		br.close();

		PreparedStatement preState = conn.prepareStatement(SQL);

		for (MemberDetail md : memberDetailList) {
			preState.setString(1, md.getUsername());
			preState.setString(2, md.getGender());
			preState.setInt(3, md.getAge());
			preState.setString(4, md.getBirth());
			preState.setInt(5, md.getPhone());
			preState.setString(6, md.getAddress());
			preState.setString(7, md.getEmail());

			BufferedInputStream bis = new BufferedInputStream(
					new FileInputStream(realPath + "WEB-INF/ForInitialization/users/" + md.getPhoto() + ".png"));

			preState.setString(8, "data:image/png;base64," + Base64.getEncoder().encodeToString(bis.readAllBytes()));
			bis.close();

			preState.addBatch();
		}
		preState.executeBatch();

		preState.close();

	}
	
	
	
}
