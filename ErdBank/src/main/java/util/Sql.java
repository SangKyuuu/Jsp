package util;

public class Sql {
	
	public static final String SELECT_CUSTOMER_BY_NO_AND_NAME = "SELECT * FROM BANK_CUSTOMER WHERE C_NO = ? AND C_NAME = ?";
	
	public static final String SELECT_ALL_ACCOUNT_WITH_NAME = "select a.*, c.c_name from "
															+ "bank_account a join bank_customer c on a.a_c_no = c.c_no";
	
	public static final String SELECT_CUSTOMER_WITH_ACCOUNT_NO =  "select c.* , a.a_no "
																+ "from bank_customer c "
																+ "join bank_account a on c.c_no = a.a_c_no "
																+ "where c.c_no = ? ";
	
	public static final String INSERT_TRANSACTION = "INSERT INTO BANK_TRANSACTION(T_A_NO, T_DIST, T_AMOUNT, T_DATETIME) VALUES(?,?,?,SYSDATE)";
	
	public static final String UPDATE_ACCOUNT_PLUS = "UPDATE BANK_ACCOUNT SET A_BALANCE = A_BALANCE + ? WHERE A_NO = ?";
	
	public static final String UPDATE_ACCOUNT_MINUS = "UPDATE BANK_ACCOUNT SET A_BALANCE = A_BALANCE - ? WHERE A_NO = ?";
}
