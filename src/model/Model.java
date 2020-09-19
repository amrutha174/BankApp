package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import oracle.jdbc.driver.OracleDriver;

public class Model 
{
	private String name;
	private String accno;
	private String balance;
	private String cid;
	private String pwd;
	private String email;
	private Connection con;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccno() {
		return accno;
	}
	public void setAccno(String accno) {
		this.accno = accno;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Model()
	{
		try 
		{
			DriverManager.registerDriver(new OracleDriver());
			con=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE", "system", "system");
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public boolean login()
	{
		try
		{
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM BANK WHERE CID=? AND PWD=?");
			pstmt.setString(1, cid);
			pstmt.setString(2, pwd);
			ResultSet res = pstmt.executeQuery();
			while(res.next()==true)
			{
				name = res.getString("NAME");
				accno=res.getString("ACCNO");
				return true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean checkBalance()
	{
		try 
		{
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM BANK WHERE ACCNO=?");
			pstmt.setString(1, accno);
			ResultSet res = pstmt.executeQuery();
			while(res.next()==true)
			{
				balance = res.getString("BALANCE");
				return true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean changePwd()
	{
		try
		{
			PreparedStatement pstmt = con.prepareStatement("UPDATE BANK SET PWD=? WHERE ACCNO=?");
			pstmt.setString(1, pwd);
			pstmt.setString(2, accno);
			int rows = pstmt.executeUpdate();
			if(rows==0)
				return false;
			else
				return true;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean transfer(String tamt)
	{
		try
		{
			PreparedStatement pstmt = con.prepareStatement("UPDATE BANK SET BALANCE=BALANCE-? WHERE ACCNO=?");
			pstmt.setString(1, tamt);
			pstmt.setString(2, accno);
			int rows = pstmt.executeUpdate();
			
			pstmt=con.prepareStatement("INSERT INTO BANK_STATEMENT VALUES (?,?)");
			pstmt.setString(1, accno);
			pstmt.setString(2, tamt);
			pstmt.executeUpdate();
			
			if(rows==0)
				return false;
			else
				return true;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public ArrayList getStatement()
	{
		ArrayList al = new ArrayList();
		try 
		{
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM BANK_STATEMENT WHERE ACCNO=?");
			pstmt.setString(1, accno);
			ResultSet res = pstmt.executeQuery();
			
			while(res.next()==true)
			{
				al.add(res.getString(2));
			}
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;
	}
	
	public boolean resetPwd()
	{
		try 
		{
			PreparedStatement pstmt = con.prepareStatement("UPDATE BANK SET PWD=? WHERE EMAIL=?");
			pstmt.setString(1, pwd);
			pstmt.setString(2, email);
			int rows = pstmt.executeUpdate();
			if(rows==0)
				return false;
			else
				return true;
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}
}
