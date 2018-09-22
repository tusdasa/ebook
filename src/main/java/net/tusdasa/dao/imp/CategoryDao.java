package net.tusdasa.dao.imp;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import net.tusdasa.dao.DaoInterface;
import net.tusdasa.domain.Category;
import net.tusdasa.utils.SqlSessionFactoryUtils;

public class CategoryDao implements DaoInterface<Object> {
	private SqlSession session = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
	@Override
	public Boolean add(Object object) {
		if(object==null) {
			return false;
		}
		try {
			
			Category category = (Category) object;
			
			int result = session.insert("", category);
			
			if(result==1) {
				return true;
			}else {
				return false;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			
		}
	}

	@Override
	public Boolean del(int id) {
		
		return null;
	}

	@Override
	public Boolean change(int id, Object object, String type) {
		
		return null;
	}

	@Override
	public Category get(int id) {
		
		return null;
	}

	@Override
	public Category get(String type, Object object) {
		
		return null;
	}

	@Override
	public List<?> findall() {
		
		return null;
	}

	@Override
	public List<?> findByPage(int start, int row) {
		
		return null;
	}

}
