package jboard.dto;

public class PagenationDTO {
	
	private int lastPageNum;
	private int pageGroupStart;
	private int pageGroupEnd;
	private int currentPageStartNum;
	private int total;
	private int currentPage;
	private int start;
	
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getLastPageNum() {
		return lastPageNum;
	}
	public void setLastPageNum(int lastPageNum) {
		this.lastPageNum = lastPageNum;
	}
	public int getPageGroupStart() {
		return pageGroupStart;
	}
	public void setPageGroupStart(int pageGroupStart) {
		this.pageGroupStart = pageGroupStart;
	}
	public int getPageGroupEnd() {
		return pageGroupEnd;
	}
	public void setPageGroupEnd(int pageGroupEnd) {
		this.pageGroupEnd = pageGroupEnd;
	}
	public int getCurrentPageStartNum() {
		return currentPageStartNum;
	}
	public void setCurrentPageStartNum(int currentPageStartNum) {
		this.currentPageStartNum = currentPageStartNum;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	@Override
	public String toString() {
		return "PagenationDTO [lastPageNum=" + lastPageNum + ", pageGroupStart=" + pageGroupStart + ", pageGroupEnd="
				+ pageGroupEnd + ", currentPageStartNum=" + currentPageStartNum + ", total=" + total + ", currentPage="
				+ currentPage + "]";
	}
	
	
}
