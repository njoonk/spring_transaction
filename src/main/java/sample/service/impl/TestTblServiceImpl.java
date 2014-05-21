package sample.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sample.bean.JoonTblBean;
import sample.bean.TestTblBean;
import sample.bean.para.InsertTblPara;
import sample.dao.TestTblDao;
import sample.service.TestTblService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestTblServiceImpl implements TestTblService {

	final Logger logger = LoggerFactory.getLogger(TestTblServiceImpl.class);

	@Autowired
    private TestTblDao testTblDao;

	@Transactional(rollbackFor = SQLException.class, propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
//	@Transactional(rollbackFor = Throwable.class, propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
	@Override
	public void insertTestTbl(InsertTblPara testTblPara) throws Exception {

		Map<String, Object> mapTestParam = new HashMap<String, Object>();
		mapTestParam.put("testNum", testTblPara.getTestNum());
		mapTestParam.put("testName", testTblPara.getTestName());

		logger.info("transaction -------------------------------------- 01");
		testTblDao.insertTestTbl(mapTestParam);
		logger.info("transaction -------------------------------------- 02");

		Map<String, Object> mapJoonParam = new HashMap<String, Object>();
		mapJoonParam.put("joonNum", testTblPara.getTestNum());
		mapJoonParam.put("joonName", "Name01");

		logger.info("transaction -------------------------------------- 03");
		testTblDao.insertJoonTbl(mapJoonParam);
		logger.info("transaction -------------------------------------- 04");

		if ("Exception".equals(testTblPara.getException())) {
			throw new Exception("TEST Exception!!");
		} else if ("SQLException".equals(testTblPara.getException())) {
			throw new SQLException("TEST SQLException!!");
		} else if ("IllegalAccessException".equals(testTblPara.getException())) {
			throw new IllegalAccessException("TEST IllegalAccessException!!");
		}

	}

	@Override
	public List<TestTblBean> selectTestTblList(String testNum) throws Exception {

		HashMap<String, Object> mapParam = new HashMap<String, Object>();
		mapParam.put("testNum", testNum);

		return testTblDao.selectTestTblList(mapParam);
	}

	@Override
	public List<JoonTblBean> selectJoonTblList(String testNum) throws Exception {

		HashMap<String, Object> mapParam = new HashMap<String, Object>();
		mapParam.put("testNum", testNum);

		return testTblDao.selectJoonTblList(mapParam);
	}

}