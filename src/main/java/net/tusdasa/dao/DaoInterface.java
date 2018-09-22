package net.tusdasa.dao;

import java.util.List;

public interface DaoInterface<T> {
	//增
	Boolean add(Object object);
	//删
	Boolean del(int id);
	//改
	Boolean change(int id,Object object,String type);
	//查
	Object get(int id);
	//按类型查
	Object get(String type, Object object);
	//查所有
	List<?> findall();
	//分页
	List<?> findByPage(int start,int row);
}
