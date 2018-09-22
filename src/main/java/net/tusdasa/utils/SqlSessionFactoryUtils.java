package net.tusdasa.utils;

import java.io.IOException;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SqlSessionFactoryUtils {
	private static Logger logger = LoggerFactory.getLogger(SqlSessionFactoryUtils.class);
	public static SqlSessionFactory getSqlSessionFactory() {
		try {
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis.xml"));
			return sessionFactory;
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("xml读取错误");
			return null;
		}
		
	}

}
