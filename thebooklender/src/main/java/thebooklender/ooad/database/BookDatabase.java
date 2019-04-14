package thebooklender.ooad.database;

import thebooklender.ooad.database.DatabaseConfiguration;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import thebooklender.ooad.models.BuyerInfoModel;
import thebooklender.ooad.models.LoginModel;
import thebooklender.ooad.models.SignUpModel;
import thebooklender.ooad.models.BookInfo;

public class DatabaseConfiguration {
	public static String dataBaseUrl = "jdbc:mysql://localhost:3306/booklender?useSSL=false";
	public static String userName = "anirudh";
	public static String password = "Pr@shan1";
	public DatabaseConfiguration() {
		
	}
	
}

public class BookDatabase {
	
	
	private Connection connection;
	public BookDatabase(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(
					DatabaseConfiguration.dataBaseUrl,
					DatabaseConfiguration.userName,
					DatabaseConfiguration.password);
		}catch(Exception e) {
			System.out.println("Exception while establishing connection");
			System.out.println(e);
		}
	}
	
	
	public Integer addbook(BookInfo bookinfo) {
		Integer result=0;
		try {
			System.out.println("print1 ="+bookinfo);
			System.out.println("print2 ="+bookinfo.getBook_id());
			System.out.println("print3 ="+bookinfo.getTitle());
			System.out.println("print4 ="+bookinfo.getAuthor());
			System.out.println("print2 ="+bookinfo.getAvailable());
			System.out.println("print3 ="+bookinfo.getDescription());
			System.out.println("print4 ="+bookinfo.getImage());
			System.out.println("print2 ="+bookinfo.getIsbn());
			System.out.println("print3 ="+bookinfo.getCategory());
			System.out.println("print4 ="+bookinfo.getPublisher());			
			PreparedStatement stmt=connection.prepareStatement("insert into book(book_id,title,author,publisher,description,isbn,available,owner_id,image,category) values('"+bookinfo.getBook_id()+"','"+bookinfo.getTitle()+"','"+bookinfo.getAuthor()+"','"+bookinfo.getPublisher()+"','"+bookinfo.getDescription()+"','"+bookinfo.getIsbn()+"','"+bookinfo.getAvailable()+"','"+bookinfo.getOwner_id()+"','"+bookinfo.getImage()+"','"+bookinfo.getCategory()+"');");
			System.out.println("print5 ="+stmt);
			result=stmt.executeUpdate();
		}catch(Exception e) {
			System.out.println(e);
		}
		return result;
	}

	
	public List<BookInfo> getParticularItem(int bookId) {
		System.out.println("c");
		ArrayList<BookInfo> arr = new ArrayList<BookInfo>();
		try {
			PreparedStatement stmt = connection.prepareStatement("select book_id,title,author,publisher,description,isbn,available,owner_id,image,category from book where id="+bookId+";");
			System.out.println("print5 ="+stmt);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {

				BookInfo item = new BookInfo();
				item.setBook_id(rs.getString(1));
				item.setTitle(rs.getString(2));
				item.setAuthor(rs.getString(3));
				item.setPublisher(rs.getString(4));
				item.setImage(rs.getString(9));
				item.setCategory(rs.getString(10));
				item.setIsbn(rs.getString(6));
				item.setOwner_id(rs.getString(8));
				item.setDescription(rs.getString(5));
				item.setAvailable(rs.getString(7));
				arr.add(item);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return arr;
		/// return id.getParticularItem(itemId,bday);
	}
	
	

}
