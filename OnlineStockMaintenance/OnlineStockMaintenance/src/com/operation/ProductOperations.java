package com.operation;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.dbconnection.DbConnection;
import com.utility.Product;

public class ProductOperations {
	public ArrayList<Product> getProductDetails() {
		ArrayList<Product> list = new ArrayList<Product>();
		try {
			java.sql.Connection conn = DbConnection.getConnection();
			String query = "select * from productdetails";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				Product product = new Product(rs.getInt(1), rs.getString(2),
						rs.getFloat(3), rs.getString(4));
				list.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}

	public Product getProductById(int pid) {
		Product product = new Product();
		try {
			Connection conn = DbConnection.getConnection();
			String query = "select * from productdetails where pid=" + pid;
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {

				product.setPid(rs.getInt(1));
				product.setPname(rs.getString(2));
				product.setPprice(rs.getFloat(3));
				product.setPcatagory(rs.getString(4));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product;

	}
	public boolean productAdd(Product product)
	{
		boolean status=false;
		try {
			Connection conn=DbConnection.getConnection();
			String query="insert into productdetails values(?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setInt(1, product.getPid());
			ps.setString(2, product.getPname());
			ps.setFloat(3, product.getPprice());
			ps.setString(4, product.getPcatagory());
			int rows=ps.executeUpdate();
			if(rows>0)
			{
				status=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
		
	}
	public boolean productUpdate(Product product){
		boolean status=false;
		try {
			
			Connection conn=DbConnection.getConnection();
			String query="update productdetails set pname=?,price=?,pcatagory=? where pid=?";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1, product.getPname());
			ps.setFloat(2, product.getPprice());
			ps.setString(3, product.getPcatagory());
			ps.setInt(4, product.getPid());
			int rows =ps.executeUpdate();
			if(rows>0){
				status=true;
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return status;	
	}
public boolean productDetele(int pid){
	boolean status=false;
	try {
		Connection conn=DbConnection.getConnection();
		String query="delete from productdetails where pid=?";
		PreparedStatement ps=conn.prepareStatement(query);
		ps.setInt(1, pid);
		int rows =ps.executeUpdate();
		if(rows>0){
			
			status=true;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return status;
	
}
public int getMaxPid(){
int pid = 0;

try {
	Connection conn=DbConnection.getConnection();
		String getPID="select max(pid) from productdetails";
						
		PreparedStatement ps =conn.prepareStatement(getPID);
		ResultSet rs=ps.executeQuery();
	if(rs.next())
		{
		
		pid=rs.getInt(1);
		pid=pid+1;
		}
		else
		{
		 pid=1;
		}
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
return pid;
}
}
