package net.tusdasa.utils;

import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSourceFactory extends UnpooledDataSourceFactory {
	//配置C3P0数据库
	private ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
	//配置到mybatis.xml
	public DataSourceFactory() {
		this.dataSource = comboPooledDataSource;
		
	}

}
