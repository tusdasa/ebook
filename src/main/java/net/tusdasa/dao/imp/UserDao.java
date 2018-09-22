package net.tusdasa.dao.imp;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.tusdasa.dao.DaoInterface;
import net.tusdasa.domain.User;
import net.tusdasa.utils.SqlSessionFactoryUtils;

public class UserDao implements DaoInterface<Object> {
	private SqlSession session = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
	private final Logger logger = LoggerFactory.getLogger(UserDao.class);

	@Override
	public Boolean add(Object object) {
		// 判断参数是否合法
		if (object == null) {
			logger.error("add null");
			return false;
		}
		// 可能发生异常
		try {
			// 获取用户对象
			User user = (User) object;
			// 插入一个对象
			int result = session.insert("User.addUser", user);
			// 返回数据库受影响的条数
			if (result == 1) {
				logger.info(user.getUsername() + "add success");
				return true;
			} else {
				logger.info("add fail" + user.getUsername());
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.warn("add Exception");
			return false;
		} finally {
			//session.close();
		}
	}

	@Override
	public Boolean del(int id) {
		// 合法检查
		if (id <= 0) {
			return false;
		}
		try {
			int result = session.delete("User.delUserById", id);

			if (result == 1) {
				logger.info("del success " + " UID: " + id);
				return true;
			} else {
				logger.info("del fail " + " UID: " + id);
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.warn("del Exception");
			return false;
		} finally {
			//session.close();
		}

	}

	@Override
	public Boolean change(int id, Object object, String type) {
		// 合法检查
		if (id <= 0 && object == null) {
			return false;
		}

		try {
			// all username password email type status
			switch (type) {
			case "all":
				type = "User.upUserById";
				break;
			case "username":
				type = "User.upUserByUsername";
				break;
			case "password":
				type = "User.upUserByPassword";
				break;
			case "email":
				type = "User.upUserByEmail";
				break;
			case "type":
				type = "User.upUserByType";
				break;
			case "status":
				type = "User.upUserByStatus";
				break;
			default:
				throw new SQLException();
			}

			User user = (User) object;

			user.setUid(id);
			logger.info("User chenge" + type);
			int result = session.update(type, user);

			if (result == 1) {
				logger.info("chenge success ");
				return true;
			} else {
				logger.info("chenge fail ");
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.warn("chenge Exception");
			return false;
		} finally {
			//session.close();
		}
	}

	@Override
	public User get(int id) {

		if (id <= 0) {
			return null;
		}

		try {

			User user = session.selectOne("User.findUserById", id);

			if (user != null) {
				logger.info("get success ");
				// System.out.println("User.findUserById "+user.getUid());
				return user;
			} else {
				return null;
			}

		} catch (Exception e) {
			logger.warn("get Exception");
			return null;
		} finally {
			//session.close();
		}
	}

	@Override
	public List<User> findall() {
		try {
			List<User> alluser = session.selectList("User.findAll");

			if (alluser.size() == 0) {
				return null;
			} else {
				logger.info("findall success ");
				// for (User user : alluser) {
				// System.out.println("User.findAll "+user.getUid());
				// }
				return alluser;
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.warn("findall Exception");
			return null;
		} finally {
			//session.close();
		}

	}

	@Override
	public List<User> findByPage(int start, int row) {
		if (start < 0 && row < 0) {
			return null;
		}

		try {
			Map<String, Integer> map = new HashMap<>();
			map.put("start", start);
			map.put("row", row);
			List<User> page = session.selectList("User.findUserByPage", map);

			if (page.size() == 0) {
				return null;
			} else {
				logger.info("findByPage success");
				// for (User user : page) {
				// System.out.println("User.findUserByPage "+user.getUid());
				// }
				return page;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.warn("findByPage Exception");
			return null;
		} finally {
			//session.close();
		}

	}

	@Override
	public List<User> get(String type, Object object) {
		if (object == null) {
			return null;
		}
		try {
			String id ="";
			String parameter = String.valueOf(object);
			
			switch (type) {
			case "username":
				id="User.findUserByUsername";
				break;
			case "email":
				id="User.findUserByEmail";
				break;
			default:
				throw new SQLException();
			}
			
			List<User> users = session.selectList(id, parameter);
			if(users.size()==0) {
				return null;
			}else {
				return users;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			//session.close();
		}
	}

}
