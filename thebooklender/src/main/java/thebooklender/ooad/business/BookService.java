package thebooklender.ooad.business;

import thebooklender.ooad.database.BuyerDatabase;
import thebooklender.ooad.models.BuyerInfoModel;
import thebooklender.ooad.models.LoginModel;
import thebooklender.ooad.models.SignUpModel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import thebooklender.ooad.database.BookDatabase;
import thebooklender.ooad.models.BookInfo;

public class BookService {

	private BookDatabase bookDatabase=new BookDatabase();

	/*
	 * public BookService() { bookDatabase=new BookDatabase(); }
	 */
	public boolean addbook(BookInfo bookinfo) {
			if(bookDatabase.addbook(bookinfo)==1) {
				return true;
			}
		return false;
	}
	
	public List<BookInfo> getParticularItem(int bookId) {
		System.out.println("b");
		return bookDatabase.getParticularItem(bookId);
	}
	
}
