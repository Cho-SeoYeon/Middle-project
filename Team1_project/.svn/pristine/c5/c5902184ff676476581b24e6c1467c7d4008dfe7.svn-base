package kr.or.ddit.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.mybatis.config.MybatisUtil;
import kr.or.ddit.vo.QnaVO;

public class QnaDaoImpl implements IQnaDao {
	
	private static QnaDaoImpl dao;
	
	private QnaDaoImpl() {}
	
	public static QnaDaoImpl getInstance() {
		if(dao == null) dao = new QnaDaoImpl();
		return dao;
	}

	@Override
	public List<QnaVO> qnaList(QnaVO qnavo) {
		SqlSession session = null;
		List<QnaVO> qnalist = new ArrayList<QnaVO>();
		try {
			session = MybatisUtil.getSqlSession();
			qnalist = session.selectList("qna.qnaList", qnavo);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) try { session.close();}catch(Exception e) {}
		}
		return qnalist;
	}
	
	@Override
	public int qnaListCnt(QnaVO qnavo) {
		SqlSession session = null;
		int cnt = 0;
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.selectOne("qna.qnaListCnt", qnavo);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) try { session.close();}catch(Exception e) {}
		}
		return cnt;
	}
	
	@Override
	public int myQnaInsert(QnaVO qnavo) {
		SqlSession session = null;
		int cnt = 0;
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.insert("qna.myQnaInsert", qnavo);
			
			if(cnt>0) session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null)try {session.close();} catch(Exception e) {}
		}
		return cnt;
	}
	
	@Override
	public QnaVO qnaDetail(int qnaNo) {
		SqlSession session = null;
		QnaVO qnaVo = new QnaVO();
		try {
			session = MybatisUtil.getSqlSession();
			qnaVo =  session.selectOne("qna.qnaDetail", qnaNo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) try { session.close();}catch(Exception e) {}
		}
		return qnaVo;
	}

	//관리자용
	@Override
	public List<QnaVO> qnaList() {
		SqlSession session = MybatisUtil.getSqlSession();
		List<QnaVO> vo = null;
		
		try {
			
			vo = session.selectList("qna.adminQnaList");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null)
				session.close();
		}
		
		return vo;
	}

}
