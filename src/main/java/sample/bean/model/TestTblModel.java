package sample.bean.model;

import java.io.Serializable;
import java.util.List;

import sample.bean.JoonTblBean;
import sample.bean.TestTblBean;

public class TestTblModel implements Serializable {

	private static final long serialVersionUID = -2758511412673492544L;

	private List<TestTblBean> listTestTblBean;
	private List<JoonTblBean> listJoonTblBean;

	private TestTblBean testTblBean;

	public List<TestTblBean> getListTestTblBean() {
		return listTestTblBean;
	}

	public void setListTestTblBean(List<TestTblBean> listTestTblBean) {
		this.listTestTblBean = listTestTblBean;
	}

	public List<JoonTblBean> getListJoonTblBean() {
		return listJoonTblBean;
	}

	public void setListJoonTblBean(List<JoonTblBean> listJoonTblBean) {
		this.listJoonTblBean = listJoonTblBean;
	}

	public TestTblBean getTestTblBean() {
		return testTblBean;
	}

	public void setTestTblBean(TestTblBean testTblBean) {
		this.testTblBean = testTblBean;
	}

}