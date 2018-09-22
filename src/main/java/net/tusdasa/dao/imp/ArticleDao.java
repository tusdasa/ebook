package net.tusdasa.dao.imp;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import net.tusdasa.dao.DaoInterface;
import net.tusdasa.domain.Article;
import net.tusdasa.utils.SqlSessionFactoryUtils;

public class ArticleDao implements DaoInterface<Object> {
	private SqlSession session = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();

	@Override
	public Boolean add(Object object) {
		if (object == null) {
			return false;
		}
		try {

			Article article = (Article) object;
			
			int result = session.insert("Article.addArticle", article);

			if (result == 1) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {

		}
	}

	@Override
	public Boolean del(int id) {
		if (id <= 0) {
			return false;
		}
		try {
			int result = session.delete("Article.delArticleById", id);
			if(result==1) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {

		}
	}

	@Override
	public Boolean change(int id, Object object, String type) {
		if (id <= 0 || object == null) {
			return false;
		}
		try {
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {

		}
	}

	@Override
	public Article get(int id) {
		try {
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {

		}
	}

	@Override
	public Article get(String type, Object object) {
		try {
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {

		}
	}

	@Override
	public List<Article> findall() {
		try {
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {

		}
	}

	@Override
	public List<Article> findByPage(int start, int row) {
		try {
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {

		}
	}

}
