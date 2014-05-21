package sample.bean.para;

import java.util.Date;

public class SelectTblPara {

	private String testNum;
	private String testName;
	private String exception;
    private Date updateTime;

	public String getTestNum() {
		return testNum;
	}
	public void setTestNum(String testNum) {
		this.testNum = testNum;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public String getException() {
		return exception;
	}
	public void setException(String exception) {
		this.exception = exception;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}