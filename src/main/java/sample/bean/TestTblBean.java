package sample.bean;

import java.io.Serializable;
import java.util.Date;

public class TestTblBean implements Serializable {

	private static final long serialVersionUID = -2758511412673492544L;

	private int testId;
	private int testNum;
	private String testName;
    private Date updateTime;

	public int getTestId() {
		return testId;
	}
	public void setTestId(int testId) {
		this.testId = testId;
	}
	public int getTestNum() {
		return testNum;
	}
	public void setTestNum(int testNum) {
		this.testNum = testNum;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}


}