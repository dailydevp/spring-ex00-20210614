package org.zerock.mapper;

import org.zerock.domain.MemberVO;
import org.zerock.domain.AuthVO;

public interface MemberMapper {

	public int insert(MemberVO vo);
	
	public int insertAuth(AuthVO vo);
	
	public MemberVO read(String userid);
}
