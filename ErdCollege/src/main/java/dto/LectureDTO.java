package dto;

public class LectureDTO {
	private int lecNo;
	private String lecName;
	private int lecCredit;
	private int lecTime;
	private String lecClass;
	
	public int getLecNo() {
		return lecNo;
	}
	public void setLecNo(int lecNo) {
		this.lecNo = lecNo;
	}
	public void setLecNo(String lecNo) {
		if(lecNo != null) this.lecNo = Integer.parseInt(lecNo);
		
	}
	public String getLecName() {
		return lecName;
	}
	public void setLecName(String lecName) {
		this.lecName = lecName;
	}
	public int getLecCredit() {
		return lecCredit;
	}
	public void setLecCredit(int lecCredit) {
		this.lecCredit = lecCredit;
	}
	public void setLecCredit(String lecCredit) {
		if(lecCredit != null) this.lecCredit = Integer.parseInt(lecCredit);
	}
	public int getLecTime() {
		return lecTime;
	}
	public void setLecTime(int lecTime) {
		this.lecTime = lecTime;
	}
	public void setLecTime(String lecTime) {
		if(lecTime != null) this.lecTime = Integer.parseInt(lecTime);
	}
	public String getLecClass() {
		return lecClass;
	}
	public void setLecClass(String lecClass) {
		this.lecClass = lecClass;
	}
	
	@Override
	public String toString() {
		return "LectureDTO [lecNo=" + lecNo + ", lecName=" + lecName + ", lecCredit=" + lecCredit + ", lecTime="
				+ lecTime + ", lecClass=" + lecClass + "]";
	}
	
	
}
