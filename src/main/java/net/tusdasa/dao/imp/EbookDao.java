package net.tusdasa.dao.imp;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.tusdasa.dao.DaoInterface;
import net.tusdasa.domain.Ebook;
import net.tusdasa.utils.SqlSessionFactoryUtils;

public class EbookDao implements DaoInterface<Object> {

	private SqlSession session = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
	private final Logger logger = LoggerFactory.getLogger(EbookDao.class);

	@Override
	public Boolean add(Object object) {
		if (object == null) {
			return false;
		}
		try {

			Ebook ebook = (Ebook) object;

			int result = session.insert("Ebook.addEbook", ebook);

			if (result == 1) {
				logger.info("add success");
				return true;
			} else {
				logger.info("add fail");
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.info("add exception");
			return false;
		} finally {
			//session.close();
		}
	}

	@Override
	public Boolean del(int id) {
		if (id <= 0) {
			return false;
		}
		try {
			int result = session.delete("Ebook.delEbookById", id);

			if (result == 1) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			//session.close();
		}
	}

	@Override
	public Boolean change(int id, Object object, String type) {
		if (id <= 0 || object == null) {
			return false;
		}
		try {
			// all ,title, cover, desciption, context, type, category, epub, mobi, azw3, pdf
			switch (type) {
			case "all":
				type = "Ebook.upEbookById";
				break;
			case "title":
				type = "Ebook.upEbookByTitle";
				break;
			case "cover":
				type = "Ebook.upEbookByCover";
				break;
			case "desciption":
				type = "Ebook.upEbookByDesciption";
				break;
			case "context":
				type = "Ebook.upEbookByContext";
				break;
			case "type":
				type = "Ebook.upEbookByType";
				break;
			case "category":
				type = "Ebook.upEbookByCategory";
				break;
			case "epub":
				type = "Ebook.upEbookByEpub";
				break;
			case "mobi":
				type = "Ebook.upEbookByMobi";
				break;
			case "azw3":
				type = "Ebook.upEbookByAzw3";
				break;
			case "pdf":
				type = "Ebook.upEbookByPdf";
				break;
			default:
				throw new SQLException();
			}

			Ebook ebook = (Ebook) object;
			ebook.setEid(id);
			int result = session.update(type, ebook);

			if (result == 1) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			//session.close();
		}
	}

	@Override
	public Ebook get(int id) {
		if (id <= 0) {
			return null;
		}

		try {

			Ebook result = session.selectOne("Ebook.findEbookById", id);

			if (result != null) {
				return result;
			} else {
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			//session.close();
		}
	}

	@Override
	public List<Ebook> findall() {
		try {

			List<Ebook> all = session.selectList("Ebook.findAll");

			if (all.size() == 0) {
				return null;
			} else {
				return all;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			//session.close();
		}
	}

	@Override
	public List<Ebook> findByPage(int start, int row) {
		if (start < 0 || row < 0) {
			return null;
		}

		try {
			Map<String, Integer> map = new HashMap<>();
			map.put("start", start);
			map.put("row", row);
			List<Ebook> page = session.selectList("Ebook.findEbookByPage", map);

			if (page.size() == 0) {
				return null;
			} else {
				return page;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			//session.close();
		}
	}

	@Override
	public List<Ebook> get(String type, Object object) {
		if(object==null) {
			return null;
		}
		try {
			String id = "";
			String parameter = String.valueOf(object);
			
			switch (type) {
			case "type":
				id="Ebook.findEbookByType";
				break;
			case "category":
				id="Ebook.findEbookByCategory"; 
				break;
			case "title":
				id="Ebook.findEbookByTitle";
				break;
			default:
				throw new SQLException();
			}
			
			List<Ebook> eb = session.selectList(id, parameter);
			
			if(eb.size()==0) {
				return null;
			}else {
				return eb;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			
		}
	}
}
