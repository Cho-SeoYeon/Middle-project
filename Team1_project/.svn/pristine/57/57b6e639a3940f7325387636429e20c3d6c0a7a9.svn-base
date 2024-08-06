package kr.or.ddit.dao;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.mybatis.config.MybatisUtil;
import kr.or.ddit.vo.QnaReplyVO;

public class QnaReplyDaoImpl implements IQnaReplyDao {

	private static QnaReplyDaoImpl dao;
	
	private QnaReplyDaoImpl() {}
	
	public static QnaReplyDaoImpl getInstance() {
		if(dao==null) {

			dao = new QnaReplyDaoImpl();
		}
		
		return dao;
	}
	
	
	@Override
	public int replyInsert(QnaReplyVO vo) {
		SqlSession session = MybatisUtil.getSqlSession();
		
		int cnt = 0;
		try {
			
			cnt = session.insert("qnaReply.replyInsert", vo);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null)
				session.commit();
				session.close();
		}
		
		return cnt;
	}

}
