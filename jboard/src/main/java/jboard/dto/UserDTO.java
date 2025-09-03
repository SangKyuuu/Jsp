package jboard.dto;

public class UserDTO {
	  private String usid;       
	  private String pass;       
	  private String us_name;    
	  private String nick;   
	  private String email;
	  private String hp;      
	  private String us_role;     
	  private String zip;   
	  private String addr1;  
	  private String addr2; 
	  private String reg_ip;
	  private String reg_date;
	  private String leave_date;
	  
	  public String getUsid() {
		  return usid;
	  }
	  public void setUsid(String usid) {
		  this.usid = usid;
	  }
	  public String getPass() {
		  return pass;
	  }
	  public void setPass(String pass) {
		  this.pass = pass;
	  }
	  public String getUs_name() {
		  return us_name;
	  }
	  public void setUs_name(String us_name) {
		  this.us_name = us_name;
	  }
	  public String getNick() {
		  return nick;
	  }
	  public void setNick(String nick) {
		  this.nick = nick;
	  }
	  public String getEmail() {
		  return email;
	  }
	  public void setEmail(String email) {
		  this.email = email;
	  }
	  public String getHp() {
		  return hp;
	  }
	  public void setHp(String hp) {
		  this.hp = hp;
	  }
	  public String getUs_role() {
		  return us_role;
	  }
	  public void setUs_role(String us_role) {
		  this.us_role = us_role;
	  }
	  public String getZip() {
		  return zip;
	  }
	  public void setZip(String zip) {
		  this.zip = zip;
	  }
	  public String getAddr1() {
		  return addr1;
	  }
	  public void setAddr1(String addr1) {
		  this.addr1 = addr1;
	  }
	  public String getAddr2() {
		  return addr2;
	  }
	  public void setAddr2(String addr2) {
		  this.addr2 = addr2;
	  }
	  public String getReg_ip() {
		  return reg_ip;
	  }
	  public void setReg_ip(String reg_ip) {
		  this.reg_ip = reg_ip;
	  }
	  public String getReg_date() {
		  return reg_date;
	  }
	  public void setReg_date(String reg_date) {
		  this.reg_date = reg_date;
	  }
	  public String getLeave_date() {
		  return leave_date;
	  }
	  public void setLeave_date(String leave_date) {
		  this.leave_date = leave_date;
	  }
	  
	  @Override
	  public String toString() {
		return "UserDTO [usid=" + usid + ", pass=" + pass + ", us_name=" + us_name + ", nick=" + nick + ", email="
				+ email + ", hp=" + hp + ", us_role=" + us_role + ", zip=" + zip + ", addr1=" + addr1 + ", addr2="
				+ addr2 + ", reg_ip=" + reg_ip + ", reg_date=" + reg_date + ", leave_date=" + leave_date + "]";
	  }
	  
	  
	  
}
