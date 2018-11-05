package com.ntl.pos.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ntl.pos.bean.CredentialsBean;
import com.ntl.pos.bean.FoodBean;
import com.ntl.pos.bean.OrderBean;
import com.ntl.pos.bean.StoreBean;
import com.ntl.pos.dao.AdministratorDAO;
import com.ntl.pos.utill.impl.DatabaseImpl;
import com.ntl.pos.utill.impl.DbUtillImpl;

public class AdministratorDAOImpl implements AdministratorDAO {

	
	static CredentialsBean cb  = new CredentialsBean();
	static int loginFlag = 0;
	static Connection conn; //Interface
	static Statement stmt; // Interface
	static ResultSet rs;
	static PreparedStatement pstmt;
	public AdministratorDAOImpl() {
		DbUtillImpl db = new DbUtillImpl();
		conn = db.getDBConnection("mysql");
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//@Override
	public String addStore(StoreBean storebean) {
		// TODO Auto-generated method stub
		int z = 0;
		try {
			pstmt = conn.prepareStatement("insert into pizzastore (Name,Street,MobileNo,City,State,Pincode) values (?,?,?,?,?,?)");
			pstmt.setString(1,storebean.getName());
			pstmt.setString(2,storebean.getStreet());
			pstmt.setString(3,storebean.getMobileNo());
			pstmt.setString(4,storebean.getCity());
			pstmt.setString(5,storebean.getState());
			pstmt.setString(6,storebean.getPincode());
			z = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "FAIL";
			
		}
		if(z==1) {
			return "SUCCESS";
		}
		return "ERROR";
	}

	//@Override
	public boolean modifyStore(StoreBean storebean) {
		try {
			String updateTableSQL = "UPDATE pizzastore SET ";
			updateTableSQL+="Name = ?,Street =?,MobileNo =?,City=?,State=?,Pincode=?";
			updateTableSQL+=" WHERE storeId = ?";
			pstmt = conn.prepareStatement(updateTableSQL);
			pstmt.setString(1,storebean.getName());
			pstmt.setString(2,storebean.getStreet());
			pstmt.setString(3,storebean.getMobileNo());
			pstmt.setString(4,storebean.getCity());
			pstmt.setString(5,storebean.getState());
			pstmt.setString(6,storebean.getPincode());
			pstmt.setInt(7, storebean.getStoreID());
			int z = pstmt.executeUpdate();
			if(z==1) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	

	//@Override
	public int removeStore(ArrayList<String> storeId) {
		// TODO Auto-generated method stub
		int count = 0;
		try {
			String sql = "DELETE FROM pizzastore WHERE storeId = ?";
			pstmt = conn.prepareStatement(sql);
			for(String s : storeId) {
				int id = Integer.parseInt(s);
				pstmt.setInt(1, id);
	            // execute the delete statement
	            count += pstmt.executeUpdate();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}

	//@Override
	public StoreBean viewStore(String storeId) {
		// TODO Auto-generated method stub
		int sId = Integer.parseInt(storeId);
		StoreBean sb = new StoreBean();
		String sql = "select * from pizzastore where storeId =" +sId;
		try {
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				 sb.setStoreID(rs.getInt("StoreId"));
				 sb.setName(rs.getString("Name"));
				 sb.setStreet(rs.getString("Street"));
				 sb.setMobileNo(rs.getString("MobileNo"));
				 sb.setCity(rs.getString("City"));
				 sb.setState(rs.getString("State"));
				 sb.setPincode(rs.getString("Pincode"));
				 return sb;
			 }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb;
	}

	//@Override
	public ArrayList<StoreBean> viewAllStore() {
		// TODO Auto-generated method stub
		ArrayList<StoreBean> pizzStores = new ArrayList<StoreBean>();
		System.out.println("View All Working");
		String sql = "select * from pizzastore";
		try {
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				 StoreBean sb = new StoreBean();
				 sb.setStoreID(rs.getInt("StoreId"));
				 sb.setName(rs.getString("Name"));
				 sb.setStreet(rs.getString("Street"));
				 sb.setMobileNo(rs.getString("MobileNo"));
				 sb.setCity(rs.getString("City"));
				 sb.setState(rs.getString("State"));
				 sb.setPincode(rs.getString("Pincode"));
				 pizzStores.add(sb);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pizzStores;
	}
	public boolean isStoreId(int storeId) {
		String sql = "select * from pizzastore where storeid ="+storeId;
		try {
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	//@Override
	public ArrayList<FoodBean> viewAllFood(int storeId) {
		// TODO Auto-generated method stub
		System.out.println("View All Food Called.");
		ArrayList<FoodBean> fb = new ArrayList<FoodBean>();
		String sql = "select * from foods where StoreId = "+storeId;
		try {
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				 FoodBean f = new FoodBean();
				 f.setFoodId(rs.getInt("FoodId"));
				 f.setName(rs.getString("Name"));
				 f.setType(rs.getString("Type"));
				 f.setFoodSize(rs.getString("FoodSize"));
				 f.setQuantity(rs.getInt("Quantity"));
				 f.setPrice(rs.getInt("Price"));
				 f.setStoreId(rs.getInt("StoreId"));
				 fb.add(f);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fb;
	}
	//@Override
	public String addFood(FoodBean foodbean, int storeId) {
		int z = 0;
		try {
			pstmt = conn.prepareStatement("insert into foods (Name,Type,FoodSize,Quantity,Price,StoreId) values (?,?,?,?,?,?)");
			pstmt.setString(1,foodbean.getName());
			pstmt.setString(2,foodbean.getType());
			pstmt.setString(3,foodbean.getFoodSize());
			pstmt.setInt(4,foodbean.getQuantity());
			pstmt.setInt(5,foodbean.getPrice());
			pstmt.setInt(6,foodbean.getStoreId());
			z = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "FAIL";
		}
		if(z==1) {
			return "SUCCESS";
		}
		return "ERROR";
	}
	//@Override
	public FoodBean viewFood(String foodId) {
		// TODO Auto-generated method stub
		int fId = Integer.parseInt(foodId);
		FoodBean f = new FoodBean();
		String sql = "select * from foods where FoodId =" +fId;
		try {
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				 f.setFoodId(rs.getInt("FoodId"));
				 f.setName(rs.getString("Name"));
				 f.setType(rs.getString("Type"));
				 f.setFoodSize(rs.getString("FoodSize"));
				 f.setQuantity(rs.getInt("Quantity"));
				 f.setPrice(rs.getInt("Price"));
				 f.setStoreId(rs.getInt("StoreId"));
			 }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
	}
	//@Override
	public boolean removeFood(int foodId, int storeId) {
		// TODO Auto-generated method stub
		int count = 0;
		try {
			String sql = "DELETE FROM foods WHERE FoodId = ? and storeId = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, foodId);
			pstmt.setInt(2, storeId);
	        count =  pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(count==1)
		return true;
		return false;
	}
	//@Override
	public boolean modifyFood(FoodBean foodbean) {
		try {
			String updateTableSQL = "UPDATE foods SET ";
			updateTableSQL+="Name = ?,Type =?,FoodSize =?,Quantity=?,Price=?,StoreId=?";
			updateTableSQL+=" WHERE foodId = ?";
			pstmt = conn.prepareStatement(updateTableSQL);
			pstmt.setString(1,foodbean.getName());
			pstmt.setString(2,foodbean.getType());
			pstmt.setString(3,foodbean.getFoodSize());
			pstmt.setInt(4,foodbean.getQuantity());
			pstmt.setInt(5,foodbean.getPrice());
			pstmt.setInt(6,foodbean.getStoreId());
			pstmt.setInt(7, foodbean.getFoodId());
			int z = pstmt.executeUpdate();
			if(z==1) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	//@Override
	public boolean isFoodId(int foodId) {
		String sql = "select * from foods where FoodId = " +foodId;
		try {
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	//@Override
	public ArrayList<OrderBean> viewAllOrder() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		ArrayList<OrderBean> allOrders = new ArrayList<OrderBean>();
		String sql = "select * from orders";
		try {
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				OrderBean crb = new OrderBean();
				crb.setOrderId(rs.getInt("OrderId"));
				crb.setUserId(rs.getInt("UserId"));
				crb.setOrderDate(rs.getDate("OrderDate"));
				crb.setStoreID(rs.getInt("StoreId"));
				crb.setCartId(rs.getInt("cartId"));
				crb.setTotalPrice(rs.getInt("TotalPrice"));
				crb.setOrderStatus(rs.getString("OrderStatus"));
				crb.setStreet(rs.getString("street"));
				crb.setCity(rs.getString("city"));
				crb.setState(rs.getString("State"));
				crb.setPincode(rs.getString("Pincode"));
				crb.setMobileNo(rs.getString("mobileNo"));
				allOrders.add(crb);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return allOrders;
	}
	//@Override
	public boolean isThisOrderId(int orderId) {
		String sql = "select * from orders where OrderId ="+orderId;
		try {
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	//@Override
	public String changeOrderStatus(int orderId, int option) {
		// TODO Auto-generated method stub
		String Message = "";
		if(option==1)
			Message = "Success";
		if(option==2)
			Message = "Cancel";
		else
			Message = "Taken";
		
		String sql = "UPDATE orders set OrderStatus='"+Message+"' where orderid ="+orderId;
		try {
			int z = stmt.executeUpdate(sql);
			if(z!=0)
			{
				return "Success";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Fail";
	}

}
