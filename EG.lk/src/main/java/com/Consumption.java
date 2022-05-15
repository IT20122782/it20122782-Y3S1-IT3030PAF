package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Consumption {
	
	private Connection connect() {
        Connection con = null;
        try {
     	   Class.forName("com.mysql.jdbc.Driver");
     	   con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users1","root","");
     	   }
        catch(Exception e) {
     	   e.printStackTrace();
        }
        return con;
}
public String createConsume(String ID, String AccountNo, String Date, String Units){
String output = "";

try {
Connection con = connect();

if (con == null)
{
return"Error while connecting to the database for inserting.";
}
String query = "insert into tb_consum(acc_no,date,units) values(?,?,?)";
PreparedStatement preparedStmt = con.prepareStatement(query);
preparedStmt.setString(1,AccountNo);
preparedStmt.setInt(2, Integer.parseInt(Date));
preparedStmt.setInt(3, Integer.parseInt(Units));

preparedStmt.execute();
con.close();

String newConsume = readConsume();
output = "{\"status\":\"sucess\",\"data\":\""+newConsume+"\"}";
}
catch(Exception e) {
output = "{\"status\":\"sucess\",\"data\":\"Error while inserting the details.\"}";
System.err.println(e.getMessage());
}
return output;

}

public String readConsume(){
String output = "";

try {
Connection con = connect();
if (con == null) {
return "Error while connecting to the database for reading.";
}

output ="<table border=\"1\" class=\"table\"><tr>"
	  + "<th>ID</th>"
	  + "<th>Account No</th>"
	  + "<th>Date</th>"
	  + "<th>Units</th>"
	  + "<th>Update</th>"
	  + "<th>Remove</th></tr>";
String query = "select * from tb_consum";
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery(query);

while(rs.next())
{
String ID = Integer.toString(rs.getInt("id"));
String AccountNo = rs.getString("acc_no");
String Date = Integer.toString(rs.getInt("date"));
String Units = Integer.toString(rs.getInt("units"));

output += "<tr><td><input id= 'hidIDUpdate' name='hidIDUpdate' type='hidden' value='"+ID+"'>"+AccountNo+"</td>";
output += "<td>" + Date + "</td>";
output += "<td>" + Units + "</td>";

output += "<td><input name = 'btnUpdate' type='button' value='Update'"
		  + "Class='btnUpdate btn.secondary' data.ID='"+ID+"'></td>"
		  + "<td>input name= 'btnRemove' type='button' value='Remove'"
		  + "class='btnRemove btn.danger' data.ID='"+ID+"'></td></tr>";
		  }
con.close();
output += "</table>";
}
catch (Exception e) {
          output = "Error while reading the bills.";
          System.err.println(e.getMessage());
}
return output;
}

public String updateConsume(String ID, String AccountNo, String Date, String Units, String string) {
String output = "";
try {
Connection con = connect();

if (con == null)
{
return"Error while connecting to the database for updating.";
}
String query = "UPDATE tb_consum SET  acc_no=?,date=?,units=? WHERE id=?";
PreparedStatement preparedStmt = con.prepareStatement(query);
preparedStmt.setString(1,AccountNo);
preparedStmt.setInt(2, Integer.parseInt(Date));
preparedStmt.setInt(3, Integer.parseInt(Units));

preparedStmt.execute();
con.close();

String newConsume = readConsume();
output = "{\"status\":\"sucess\",\"data\":\""+newConsume+"\"}";
}
catch(Exception e) {
output = "{\"status\":\"error\",\"data\":\"Error while updating the details.\"}";
System.err.println(e.getMessage());
}
return output;
} 

public String deleteConsume(String ID) {
String output = "";
try {
Connection con = connect();

if (con == null)
{
return"Error while connecting to the database for deleting.";
}
String query = "delete tb_consum where id=?";
PreparedStatement preparedStmt = con.prepareStatement(query);
preparedStmt.setInt(1, Integer.parseInt(ID));

preparedStmt.execute();
con.close();

String newConsume = readConsume();
output = "{\"status\":\"sucess\",\"data\":\""+newConsume+"\"}";
}
catch(Exception e) {
output = "{\"status\":\"error\",\"data\":\"Error while deleting the details.\"}";
System.err.println(e.getMessage());
}
return output;
}

}
