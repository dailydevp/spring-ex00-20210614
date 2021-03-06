package org.zerock.mapper;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.ReplyVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j
;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {

	@Setter(onMethod_=@Autowired)
	private ReplyMapper mapper;
	
	@Test
	public void testMapper() {
		assertNotNull(mapper);
	}

	@Test
	public void TestInsert() {
		ReplyVO vo = new ReplyVO();
		vo.setReply("댓글!!!");
		vo.setReplyer("user00");
		vo.setBno(130L);
		
		//Long 참조타입
		//long 기본타입
		
		int cnt = mapper.insert(vo);
		assertEquals(1, cnt);
	}
	
	@Test
	public void testRead() {
		ReplyVO vo = mapper.read(2L);
		
		assertEquals("댓글!!!", vo.getReply());
	}
	
	@Test
	public void testDelete() {
		ReplyVO vo = new ReplyVO();
		vo.setBno(3L);
		vo.setReply("댓글~~");
		vo.setReplyer("user00");
		
		mapper.insertSelectKey(vo);
		
		int cnt = mapper.delete(vo.getRno());
		
		assertEquals(1, cnt);
	}
	
	@Test
	public void testUpdate() {
		ReplyVO vo = mapper.read(1L);
		
		String re = "수정된 댓글";
		
		vo.setReply(re);
		
		assertEquals(1, mapper.update(vo));
		
		vo = mapper.read(1L);
		assertEquals(re, vo.getReply());
	}
	
	@Test
	public void testGetList() {
		Long bno = 130L;
		
		List<ReplyVO> list = mapper.getList(bno);
		assertTrue(list.size() > 0);
		
		bno = 130L;
		list = mapper.getList(bno);
		assertTrue(list.size() > 0);
		
		bno = 6L;
		list = mapper.getList(bno);
		assertTrue(list.size() == 0);
		
	}
	
	@Test
	public void testDeleteByBon() {
		Long bno = 130L;
		
		mapper.deleteByBno(bno);
	}
}
