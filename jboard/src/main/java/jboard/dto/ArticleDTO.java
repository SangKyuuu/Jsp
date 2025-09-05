package jboard.dto;

import java.util.List;

public class ArticleDTO {

	private int ano;
	private String cate;
	private String title;
	private String content;
	private int comment_cnt;
	private int file_cnt;
	private int hit_cnt;
	private String writer;
	private String reg_ip;
	private String wdate;
	
	// 추가 필드
	private String nick;
	private List<FileDTO> files;
	
	public List<FileDTO> getFiles() {
		return files;
	}
	
	public void setFiles(List<FileDTO> files) {
		this.files = files;
	}	
	
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getCate() {
		return cate;
	}
	public void setCate(String cate) {
		this.cate = cate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getComment_cnt() {
		return comment_cnt;
	}
	public void setComment_cnt(int comment_cnt) {
		this.comment_cnt = comment_cnt;
	}
	public int getFile_cnt() {
		return file_cnt;
	}
	public void setFile_cnt(int file_cnt) {
		this.file_cnt = file_cnt;
	}
	public int getHit_cnt() {
		return hit_cnt;
	}
	public void setHit_cnt(int hit_cnt) {
		this.hit_cnt = hit_cnt;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getReg_ip() {
		return reg_ip;
	}
	public void setReg_ip(String reg_ip) {
		this.reg_ip = reg_ip;
	}
	public String getWdate() {
		return wdate.substring(2, 16);
	}
	public void setWdate(String wdate) {
		this.wdate = wdate;
	}
	@Override
	public String toString() {
		return "ArticleDTO [ano=" + ano + ", cate=" + cate + ", title=" + title + ", content=" + content
				+ ", comment_cnt=" + comment_cnt + ", file_cnt=" + file_cnt + ", hit_cnt=" + hit_cnt + ", writer="
				+ writer + ", reg_ip=" + reg_ip + ", wdate=" + wdate + "]";
	}
	
	
	
}