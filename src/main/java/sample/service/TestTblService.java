package sample.service;

import java.util.List;

import sample.bean.JoonTblBean;
import sample.bean.TestTblBean;
import sample.bean.para.InsertTblPara;

public interface TestTblService {

	public void insertTestTbl(InsertTblPara testTblPara) throws Exception;
	public List<TestTblBean> selectTestTblList(String stgNum) throws Exception;
	public List<JoonTblBean> selectJoonTblList(String stgNum) throws Exception;

}