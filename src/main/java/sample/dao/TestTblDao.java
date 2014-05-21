package sample.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import sample.bean.JoonTblBean;
import sample.bean.TestTblBean;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class TestTblDao extends SqlMapClientDaoSupport {

	public int insertTestTbl(Map<String, Object> mapApplistApp) throws SQLException {
		return getSqlMapClientTemplate().update("insertTestTbl", mapApplistApp);
	}

	public int insertJoonTbl(Map<String, Object> mapApplistApp) throws SQLException {
		return getSqlMapClientTemplate().update("insertJoonTbl", mapApplistApp);
	}

	@SuppressWarnings("unchecked")
	public List<TestTblBean> selectTestTblList(Map<String, Object> mapParam) throws SQLException {
		return (List<TestTblBean>) getSqlMapClientTemplate().queryForList("selectTestTbl",mapParam);
	}

	@SuppressWarnings("unchecked")
	public List<JoonTblBean> selectJoonTblList(Map<String, Object> mapParam) throws SQLException {
		return (List<JoonTblBean>) getSqlMapClientTemplate().queryForList("selectJoonTbl",mapParam);
	}

}