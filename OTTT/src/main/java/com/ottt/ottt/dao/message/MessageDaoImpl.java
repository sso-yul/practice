package com.ottt.ottt.dao.message;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ottt.ottt.domain.MessageSearchItem;
import com.ottt.ottt.dto.MessageDTO;


@Repository
public class MessageDaoImpl implements MessageDao {
	
	
	@Autowired
	private SqlSession session;
	private static String namespace = "com.ottt.ottt.dao.message.MessageMapper.";

	//메세지 내용 불러오기
	@Override
	public MessageDTO selectMsg(Integer message_no) throws Exception {
		return session.selectOne(namespace + "selectMsg", message_no);
	}

	
	//받은 메세지 목록 불러오기
	@Override
	public List<MessageDTO> selectRecv(MessageSearchItem msc) throws Exception {
		return session.selectList(namespace + "selectRecv", msc);
	}

	//보낸 메세지 목록 불러오기
	@Override
	public List<MessageDTO> selectSend(MessageSearchItem msc) throws Exception {
		return session.selectList(namespace + "selectSend", msc);
	}

	//메세지 보내기(메세지 생성)
	@Override
	public int insert(MessageDTO messageDTO) throws Exception {
		return session.insert(namespace + "insert", messageDTO);
	}

	//메세지 지우기(해당된 메세지)
	@Override
	public int delete(Integer message_no, String user_no) throws Exception {
		Map map = new HashMap();
		map.put("message_no", message_no);
		map.put("user_no", user_no);
		return session.delete(namespace + "delete", map);
	}
	
	//메세지 지우기(전체)
	@Override
	public int deleteAll() throws Exception {
		return session.delete(namespace + "deleteAll");
	}

	//sql id 맞춰서 수정 
	@Override
	public List<MessageDTO> selectPage(Map map) throws Exception {
		return session.selectList(namespace + "selectPage", map);
	}

	
	@Override
	public int recvCount() throws Exception {
		return session.selectOne(namespace + "recvCount");
	}

	@Override
	public int sendCount() throws Exception {
		return session.selectOne(namespace + "sendCount");
	}

	@Override
	public int searchResultCnt(MessageSearchItem msc) throws Exception {
		return session.selectOne(namespace + "searchResultCnt", msc);
	}


	@Override
	public List<MessageDTO> selectPage(MessageSearchItem msc) throws Exception {
		return session.selectList(namespace + "selectPage", msc);
	}


}