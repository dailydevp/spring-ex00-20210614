package org.zerock.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.Test1VO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class Test1MapperTests {
	
	private Test1Mapper mapper;

	@Autowired
	public void setMapper(Test1Mapper mapper) {
		this.mapper = mapper;
	}
	
//	@Setter(onMethod_= @Autowired)
	
	@Test
	public void testMapper() {
		assertNotNull(mapper);
	}
	
	@Test
	public void testGetList() {
		
		List<Test1VO> list = mapper.getList();
		
		assertTrue(list.size()>0);
	}
	
	@Test
	public void testInsert() {
		Test1VO test1 = new Test1VO();
		test1.setName("방타니");
		test1.setAge(20);
/*		
		int cnt = mapper.insert(test1);
		
		assertEquals(1, cnt);
		
		*/
		int before = mapper.getList().size();
		
		mapper.insert(test1);
		
		int after = mapper.getList().size();
		
		assertEquals(before + 1 ,after);
	}

	@Test
	public void testInsertSelectKey() {
		Test1VO test1 = new Test1VO();
		test1.setName("내새꾸들");
		test1.setAge(77);
		
//		assertEquals(0, test1.getId());
		
//		int cnt = mapper.insertSelectKey(test1);
		mapper.insertSelectKey(test1);
		
//		assertEquals(1, cnt);
		assertNotEquals(0, test1.getId());
	}
	

	
	@Test
	public void testRead() {
		Test1VO vo = mapper.read(1);
		
	//	assertNotNull(vo);
	//	assertEquals(1, vo.getId());
		
		assertEquals("남준", vo.getName());
		assertEquals(28, vo.getAge());
		/*
		Test1VO test1 = new Test1VO();
		test1.setName("사랑둥이타니들");
		test1.setAge(22);
		
//		int cnt = mapper.insertSelectKey(test1);
		
		long key = test1.getId();
		
		Test1VO newTest = mapper.read(key);
		
		assertNotNull(newTest);
		assertEquals(key, newTest.getId());
		*/
	}
	
	@Test
	public void testDelete() {
		int cnt = mapper.delete(8);
		
		Test1VO test1 = mapper.read(8);
		
		assertNull(test1);
		/*
		assertEquals(8, cnt);
		
		Test1VO test1 = new Test1VO();
		test1.setName("name");
		test1.setAge(11);
		
//		mapper.insertSelectKey(test1);
		
		cnt = mapper.delete(test1.getId());
		assertEquals(1, cnt);
		*/
	}
	
	@Test
	public void testUpdate() {
	//	long id = 8;
		
		Test1VO test1 = new Test1VO();
		test1.setId(1);
		test1.setName("아미");
		test1.setAge(8);
		
		int cnt = mapper.update(test1);
		
	//	assertEquals(1, cnt);
		
		Test1VO test8 = mapper.read(8);
		
		assertEquals(test1.getName(), test8.getName());
		assertEquals(test1.getAge(), test8.getAge());
	}
	
}
