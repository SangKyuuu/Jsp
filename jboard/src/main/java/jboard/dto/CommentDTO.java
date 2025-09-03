package jboard.dto;

public class CommentDTO {
	  private int cno;        
	  private int ano;        
	  private String content; 
	  private String writer;
	  private String reg_ip;  
	  private String wdate;
	  
	  public int getCno() {
		  return cno;
	  }
	  public void setCno(int cno) {
		  this.cno = cno;
	  }
	  public int getAno() {
		  return ano;
	  }
	  public void setAno(int ano) {
		  this.ano = ano;
	  }
	  public String getContent() {
		  return content;
	  }
	  public void setContent(String content) {
		  this.content = content;
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
		  return wdate;
	  }
	  public void setWdate(String wdate) {
		  this.wdate = wdate;
	  }
	  
	  @Override
	  public String toString() {
		return "CommentDTO [cno=" + cno + ", ano=" + ano + ", content=" + content + ", writer=" + writer + ", reg_ip="
				+ reg_ip + ", wdate=" + wdate + "]";
	  }
	  
	  
}
