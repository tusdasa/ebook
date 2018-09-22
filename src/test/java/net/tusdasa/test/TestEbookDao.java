package net.tusdasa.test;

import static org.junit.Assert.*;

import org.junit.Test;

import net.tusdasa.dao.imp.EbookDao;
import net.tusdasa.domain.Ebook;

public class TestEbookDao {
	private EbookDao ebookdao = new EbookDao();
	private Ebook ebook = new Ebook();
	@Test
	public void testAdd() {
		ebook.setType("测试");
		if(ebookdao.add(ebook)) {
			
		}else {
			fail("Not yet implemented");
		}
		
	}

	@Test
	public void testDel() {
		if(ebookdao.del(2)) {
			
		}else {
			fail("Not yet implemented");
		}
		
	}

	@Test
	public void testChenge() {
		if(ebookdao.change(3, ebook, "all")) {
			
		}else {
			fail("Not yet implemented");
		}
		
	}

	@Test
	public void testGet() {
		if(ebookdao.get(4)!=null) {
			
		}else {
			fail("Not yet implemented");
		}
		
	}

	@Test
	public void testFindall() {
		if(ebookdao.findall().size()>0) {
			
		}else {
			fail("Not yet implemented");
		}
		
	}

	@Test
	public void testFindByPage() {
		if(ebookdao.findByPage(4, 2).size()>0) {
			
		}else {
			fail("Not yet implemented");
		}
		
	}

}
