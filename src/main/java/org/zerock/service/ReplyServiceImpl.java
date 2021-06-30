package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.ReplyVO;
import org.zerock.mapper.ReplyMapper;

import lombok.Setter;


@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;
	
	/*
	@Autowired
	public void setMapper(ReplyMapper mapper) {
		this.mapper = mapper;
	}
	*/

	@Override //mapper에 insert 메소드 실행.
	public int register(ReplyVO vo) {
		return mapper.insert(vo);
	}

	@Override // 하나의 댓글 얻어오기
	public ReplyVO get(Long rno) {
		return mapper.read(rno);
	}

	@Override //수정하기
	public int modify(ReplyVO vo) {
		return mapper.update(vo);
	}

	@Override // 삭제하기
	public int remove(Long rno) {
		// TODO Auto-generated method stub
		return mapper.delete(rno);
	}

	@Override // 게시물 번호를 알고 있는 bno 값을 넣어서 리턴.
	public List<ReplyVO> getList(Long bno) {
		// TODO Auto-generated method stub
		return mapper.getList(bno);
	}
	
	


}
