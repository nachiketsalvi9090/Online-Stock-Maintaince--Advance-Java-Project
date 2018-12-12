package com.operation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dbconnection.DbConnection;
import com.utility.User;


public class UserOperation {
public String findUserType(String name,String password){
	String type="user";
	try {
		Connection conn=DbConnection.getConnection();
		String query="select type from logindata where username=? and password=?";
		PreparedStatement ps= conn.prepareStatement(query);
		ps.setString(1, name);
		ps.setString(2, password);
		ResultSet rs= ps.executeQuery();
		if(rs.next()){
			type = rs.getString(1);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return type;
	
	
}
public boolean validateUser(User user)
{
boolean status=false;
try {
	Connection conn=DbConnection.getConnection();
	String query = "select username,password from logindata where username=? and password=?";
	PreparedStatement ps = conn.prepareStatement(query);
	ps.setString(1, user.getUsername());
	ps.setString(2, user.getPassword());
	ResultSet rs = ps.executeQuery();
	if(rs.next())
	{
		status=true;
	}
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
return status;
}
}
