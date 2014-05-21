package sample.bean;

import java.io.Serializable;
import java.util.Date;

public class JoonTblBean implements Serializable {

	private static final long serialVersionUID = 7307399913453177687L;

	private int joonId;
	private int joonNum;
	private String joonName;
    private Date updateTime;

	public int getJoonId() {
		return joonId;
	}
	public void setJoonId(int joonId) {
		this.joonId = joonId;
	}
	public int getJoonNum() {
		return joonNum;
	}
	public void setJoonNum(int joonNum) {
		this.joonNum = joonNum;
	}
	public String getJoonName() {
		return joonName;
	}
	public void setJoonName(String joonName) {
		this.joonName = joonName;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}


}