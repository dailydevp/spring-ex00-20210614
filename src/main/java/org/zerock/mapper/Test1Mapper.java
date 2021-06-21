package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.Test1VO;

public interface Test1Mapper {
	public List<Test1VO> getList();
	
	public int insert(Test1VO test1);
	
	public int insertSelectKey(Test1VO test1);
	
	public Test1VO read(long id);
	
	public int delete(long id);
	
	public int update(Test1VO test1);
}
