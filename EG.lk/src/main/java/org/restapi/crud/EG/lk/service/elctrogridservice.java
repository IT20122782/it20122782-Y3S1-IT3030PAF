package org.restapi.crud.EG.lk.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.restapi.crud.EG.lk.model.elctrogridmodel;

public class elctrogridservice {

Connection con;
	
	
	public elctrogridservice(){
		try {
			
			String url = "jdbc:mysql://localhost:3306/users1";
			String uname = "root";
			String pwd = "";
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,uname,pwd);
			}catch(Exception e){
			System.out.println(e +"Data insert unsuccessful!");	
		}
		
		
	}

	public elctrogridmodel insertUser(elctrogridmodel user) {
		String insert= "insert into tb_consum(acc_no,date,units) values(?,?,?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setString(1, user.getAccountno());
			ps.setLong(2, user.getDate());
			ps.setLong(3, user.getUnits());
			
			ps.execute();
			
		}catch(Exception e) {
			System.out.println(e +"Data insert unsuccessful!");
		}
		return user;
	}
	
	public ArrayList<elctrogridmodel> getUser() throws SQLException{
		
		ArrayList<elctrogridmodel> data = new ArrayList<elctrogridmodel>();
		
		String select = "select * from tb_consum";
		PreparedStatement ps = con.prepareStatement(select);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			elctrogridmodel model = new elctrogridmodel();
			
			model.setCustomerid(rs.getInt("id"));
			model.setAccountno(rs.getString("acc_no"));
			model.setDate(rs.getInt("date"));
			model.setUnits(rs.getInt("units"));
			
			data.add(model);
			
		}
		
		return data;
	}
	
	
public ArrayList<elctrogridmodel> getUserById(int id) throws SQLException{
		
		ArrayList<elctrogridmodel> data = new ArrayList<elctrogridmodel>();
		String select = "select * from tb_consum where id=?";
		PreparedStatement ps = con.prepareStatement(select);
		ps.setInt(1,id);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			elctrogridmodel model = new elctrogridmodel();
			
			model.setCustomerid(rs.getInt("id"));
			model.setAccountno(rs.getString("acc_no"));
			model.setDate(rs.getInt("date"));
			model.setUnits(rs.getInt("units"));
			
			data.add(model);
			}
		return data;
	}

public elctrogridmodel updateUser(elctrogridmodel user) {
	String insert= "update tb_consum set acc_no=? , date=? , units=? where id=?";
	
	try {
		PreparedStatement ps = con.prepareStatement(insert);
		ps.setString(1, user.getAccountno());
		ps.setLong(2, user.getDate());
		ps.setLong(3, user.getUnits());
		ps.setInt(4, user.getCustomerid());
		
		ps.executeUpdate();
		
	}catch(Exception e) {
		System.out.println(e +"Data insert unsuccessful!");
	}
	return user;
}

public int deleteUser(int id) {
	String insert= "delete from tb_consum where id=?";
	
	try {
		PreparedStatement ps = con.prepareStatement(insert);
		ps.setInt(1,id);
		
		ps.executeUpdate();
		
	}catch(Exception e) {
		System.out.println(e +"Data insert unsuccessful!");
	}
	return id;
}

}
