package net.tusdasa.test;

import static org.junit.Assert.fail;

import org.junit.Test;

import net.tusdasa.dao.imp.UserDao;
import net.tusdasa.domain.User;

public class TestUserDao {
	
	UserDao userdao = new UserDao();

	@Test
	public void testAdd() {
		User user= new User();
		user.setEmail("a@b.com");
		user.setPassword("11111");
		user.setStatus(2);
		user.setType(1);
		user.setUsername("admin");
		if(userdao.add(user)) {
			System.out.println("add success");
		}else {
			fail("Not yet implemented");
		}
		
	}

	@Test
	public void testDel() {
		if(userdao.del(10)) {
			System.out.println("del success");
		}else {
			fail("Not yet implemented");
		}
		
	}

	@Test
	public void testChenge() {
		User user= new User();
		user.setEmail("a@b.com");
		user.setPassword("11111");
		user.setStatus(2);
		user.setType(1);
		user.setUsername("admin1");
		if(userdao.change(11,user,"all")) {
			System.out.println("Chenge success");
		}else {
			fail("Not yet implemented");
		}
		
	}

	@Test
	public void testGet() {
		User user = userdao.get(12);
		if(user!=null) {
			System.out.println("Get success");
		}else {
			fail("Not yet implemented");
		}
		
	}

	@Test
	public void testFindall() {
		if(userdao.findall().size()==0) {
			fail("Not yet implemented");
		}else {
			System.out.println("Findall success");
		}
		
		
	}

	
	@Test
	public void testFindByPage() {
		if(userdao.findByPage(5, 2).size()==0) {
			fail("Not yet implemented");
		}else {
			System.out.println("FindByPage success");
		}
		
	}

}
