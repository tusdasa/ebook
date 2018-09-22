package net.tusdasa.utils;

import net.tusdasa.dao.DaoInterface;
import net.tusdasa.dao.imp.EbookDao;
import net.tusdasa.dao.imp.UserDao;

public class DaoFactory {
	//DaoFactory 返回一个dao
	public static DaoInterface<Object> getDao(String daoname) {
		
		if(daoname.equals("ebook")) {
			return new EbookDao();
		}
		if(daoname.equals("user")) {
			return new UserDao();
		}
		
		return null;
	}

}
