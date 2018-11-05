package com.ntl.pos.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.ntl.pos.bean.CartBean;
import com.ntl.pos.bean.CredentialsBean;
import com.ntl.pos.bean.CreditCardBean;
import com.ntl.pos.bean.FoodBean;
import com.ntl.pos.bean.OrderBean;
import com.ntl.pos.bean.StoreBean;
import com.ntl.pos.dao.CustomerDAO;
import com.ntl.pos.utill.impl.DatabaseImpl;
import com.ntl.pos.utill.impl.DbUtillImpl;

public class CustomerDAOImpl implements CustomerDAO{
	static CredentialsBean cb  = new CredentialsBean();
	static int loginFlag = 0;
	static Connection conn; //Interface
	static Statement stmt; // Interface
	static ResultSet rs;
	
	static PreparedStatement pstmt;
	public CustomerDAOImpl() {
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
	public int addToCart(CartBean cartBean) {
		// TODO Auto-generated method stub
		DatabaseImpl db = new DatabaseImpl();
		String email = db.getEmail();
		int userId = db.getUserId(email);
		int fId = cartBean.getFoodId();
		FoodBean f = new FoodBean();
		String sql = "select * from foods where FoodId =" +fId;
		try {
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				 f.setFoodId(rs.getInt("FoodId"));
				 f.setName(rs.getString("Name"));
				 f.setType(rs.getString("Type"));
				 f.setFoodSize(rs.getString("FoodSize"));
				 f.setQuantity(rs.getInt("Quantity"));
				 f.setPrice(rs.getInt("Price"));
				 f.setStoreId(rs.getInt("StoreId"));
				 
				 // Processing
				 cartBean.setType(f.getType());
				 double cost = cartBean.getQuantity() * f.getPrice();
				 cartBean.setCost(cost);
				
				 Date date = new Date();
				 java.sql.Date sqlDate = new java.sql.Date(date.getTime());
				 cartBean.setOrderDate(sqlDate);
				 //ADD CART DATABASE PROCESSING
				 String sql1 = "select * from mycart where UserId = ? and FoodId =?";
				 pstmt = conn.prepareStatement(sql1);
				 pstmt.setInt(1,userId);
				 pstmt.setInt(2, fId);
				 rs = pstmt.executeQuery();
				 if(rs.next()) {
					 //Just need to update Data
						String updateTableSQL = "UPDATE mycart SET ";
						updateTableSQL+="Quantity=?,Cost=?,OrderDate=?";
						updateTableSQL+=" where UserId = ? and FoodId =?";
						pstmt = conn.prepareStatement(updateTableSQL);
						int qty = rs.getInt("Quantity");
						qty += cartBean.getQuantity();
						cost = qty * f.getPrice();
						pstmt.setInt(1, qty);
						pstmt.setDouble(2, cost);
						pstmt.setDate(3, sqlDate);
						pstmt.setInt(4,userId);
						pstmt.setInt(5, fId);
						int z = pstmt.executeUpdate();
						return z; 
				 }
				 else {
					 pstmt = conn.prepareStatement("insert into mycart (UserId,FoodId,Type,Quantity,Cost,OrderDate) values (?,?,?,?,?,?)");
					 pstmt.setInt(1,userId);
					 pstmt.setInt(2, fId);
					 pstmt.setString(3,f.getType());
					 pstmt.setInt(4, cartBean.getQuantity());
					 pstmt.setDouble(5, cost);
					 pstmt.setDate(6, sqlDate);
					 int z = pstmt.executeUpdate();
					 return z; 
				 }
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	//@Override
	public boolean modifyCart(CartBean cartBean) {
		// TODO Auto-generated method stub
		if(cartBean.getQuantity()==0) {
			return deleteCart(cartBean);
		}
		FoodBean f = new FoodBean();
		int fId = cartBean.getFoodId();
		String sql = "select * from foods where FoodId =" +fId;
		try {
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				 f.setFoodId(rs.getInt("FoodId"));
				 f.setQuantity(rs.getInt("Quantity"));
				 f.setPrice(rs.getInt("Price"));
				 Date date = new Date();
				 java.sql.Date sqlDate = new java.sql.Date(date.getTime());
				 cartBean.setOrderDate(sqlDate);
				 //ADD CART DATABASE PROCESSING
				 String sql1 = "select * from mycart where cartId =?";
				 pstmt = conn.prepareStatement(sql1);
				 pstmt.setInt(1,cartBean.getCartID());
				 rs = pstmt.executeQuery();
				 if(rs.next()) {
					 //Just need to update Data
						String updateTableSQL = "UPDATE mycart SET ";
						updateTableSQL+="Quantity=?,Cost=?,OrderDate=?";
						updateTableSQL+=" where cartId = ?";
						pstmt = conn.prepareStatement(updateTableSQL);
						int qty =cartBean.getQuantity();
						double cost = qty * f.getPrice();
						pstmt.setInt(1, qty);
						pstmt.setDouble(2, cost);
						pstmt.setDate(3, sqlDate);
						pstmt.setInt(4,cartBean.getCartID());
						int z = pstmt.executeUpdate();
						if(z==1)
							return true;
				 }
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	//@Override
	public String cancelOrder(String orderId) {
		// TODO Auto-generated method stub
		return null;
	}
	//@Override
	public ArrayList<StoreBean> viewStore(String city) {
		// TODO Auto-generated method stub
				ArrayList<StoreBean> pizzStores = new ArrayList<StoreBean>();
				String sql = "select * from pizzastore where City='" +city+"'";
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
	//@Override
	public ArrayList<CartBean> viewCart(String userid) {
		// TODO Auto-generated method stub
		DatabaseImpl db = new DatabaseImpl();
		String email = db.getEmail();
		int uid = Integer.parseInt(userid);
		if(email.length()>0)
		    uid = db.getUserId(email);
		
		ArrayList<CartBean> mycart = new ArrayList<CartBean>();
		String sql = "select * from mycart where StoreId = 0 and UserId = "+uid;
		try {
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				CartBean crb = new CartBean();
				crb.setCartID(rs.getInt("CartId"));
				crb.setUserId(uid);
				crb.setFoodId(rs.getInt("FoodId"));
				crb.setType(rs.getString("Type"));
				crb.setQuantity(rs.getInt("Quantity"));
				crb.setCost(rs.getDouble("Cost"));
				crb.setOrderDate(rs.getDate("OrderDate"));
				mycart.add(crb);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return mycart;
	}
	//@Override
	public int Available(int foodId) {
		// TODO Auto-generated method stub
		System.out.println("aa rha hai");
	    try {
	    	String sql = "select Quantity from foods where FoodId ="+foodId;
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
			   int Qty = rs.getInt(1);
			   return Qty;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	//@Override
	public boolean isMyCartId(int cartId) {
		DatabaseImpl db = new DatabaseImpl();
		String email = db.getEmail();
		int uid = db.getUserId(email);
		try {
			String sql = "select * from mycart where StoreId = 0 and cartId ="+cartId+" and userId ="+uid;
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
	public int getFoodId(int cartId) {
		// TODO Auto-generated method stub
		String sql = "select FoodId from mycart where cartId ="+cartId;
		try {
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				return rs.getInt("FoodId");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
   public boolean deleteCart(CartBean cartBean) {
	   String delQry = "update mycart set StoreId =1 where cartId=?";
	   try {
		pstmt = conn.prepareStatement(delQry);
		pstmt.setInt(1, cartBean.getCartID());
		int z = pstmt.executeUpdate();
		if(z!=0) {
			return true;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
	   return false;
   }
	//@Override
	public int myQuantity(int cartId) {
		try {
	    	String sql = "select Quantity from mycart where cartId ="+cartId;
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
			   int Qty = rs.getInt(1);
			   return Qty;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	//@Override
	public boolean isMyCreditCart() {
		DatabaseImpl db = new DatabaseImpl();
		String email = db.getEmail();
		int uid = db.getUserId(email);
		String sql = "select * from creditcard where UserId ="+uid;
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
	public boolean addCreditCard(CreditCardBean creditCardBean) {
		// TODO Auto-generated method stu
		try {
			DatabaseImpl db = new DatabaseImpl();
			String email = db.getEmail();
			int uid = db.getUserId(email);
			String sql = "select * from creditcard where UserId ="+uid;
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				String updateTableSQL = "UPDATE creditcard SET ";
				updateTableSQL+="CreditCardNumber=?,ValidFrom=?,ValidTo=?,Balance=?";
				updateTableSQL+=" where UserId = ?";
				pstmt = conn.prepareStatement(updateTableSQL);
			}
			else {
				pstmt = conn.prepareStatement("insert into creditcard (CreditCardNumber,ValidFrom,ValidTo,Balance,UserId) values (?,?,?,?,?)");	
			}
			pstmt.setString(1, creditCardBean.getCreditCardNumber());
			pstmt.setString(2, creditCardBean.getValidFrom());
			pstmt.setString(3, creditCardBean.getValidTo());
			pstmt.setInt(4, creditCardBean.getBalance());
			pstmt.setInt(5, uid);
			int z = pstmt.executeUpdate();
			if(z!=0) {
				return true;
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	//@Override
	public String confirmOrder(ArrayList<Integer> cartIds) {
		// TODO Auto-generated method stub
		int totalCost = 0;
		for(Integer id : cartIds) {
			int cartId = id;
			String sql = "select cost from mycart where StoreId = 0 and cartId ="+cartId;
			try {
				rs = stmt.executeQuery(sql);
				if(rs.next()) {
					totalCost += rs.getInt("cost");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		DatabaseImpl db = new DatabaseImpl();
		String email = db.getEmail();
		int uid = db.getUserId(email);
		int available = -1;
		String sql = "select Balance from creditcard where UserId ="+uid;
		try {
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
			  available = rs.getInt("Balance");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(available<totalCost) {
			return "Insufficient Balance";
		}
		else {
			int result = 0;
			for(Integer id : cartIds) {
				int cartId = id;
				Date date = new Date();
				java.sql.Date sqlDate = new java.sql.Date(date.getTime());	
				int storeId = getStoreIdFromCartId(cartId);
				String orderStatus = "Success";
				String userSql ="select * from usersprofile where userId ="+uid;
				try {
					rs = stmt.executeQuery(userSql);
					if(rs.next()) {
						pstmt = conn.prepareStatement("insert into orders (UserId,OrderDate,StoreId,CartId,TotalPrice,OrderStatus,Street,City,State,Pincode,MobileNo) values (?,?,?,?,?,?,?,?,?,?,?)");		
						pstmt.setInt(1, uid);
						pstmt.setDate(2, sqlDate);
						pstmt.setInt(3, storeId);
						pstmt.setInt(4, cartId);
						pstmt.setInt(5, totalCost);
						pstmt.setString(6, orderStatus);
						pstmt.setString(7, rs.getString("Street"));
						pstmt.setString(8, rs.getString("City"));
						pstmt.setString(9, rs.getString("State"));
						pstmt.setString(10, rs.getString("Pincode"));
						pstmt.setString(11, rs.getString("MobileNo"));
						int msg = pstmt.executeUpdate();
						if(msg==1) {
							String delQry = "update mycart set StoreId =1 where cartId="+cartId;
							result += stmt.executeUpdate(delQry);
							int FoodId = getFooIdFromCartId(cartId);
							int qty = Available(FoodId);
							int mQty = myQuantity(cartId);
							int newQty = qty-mQty;
							if(newQty<0) {
								newQty = 0;
							}
							String updateQty = "update foods set Quantity = ? where FoodId = ?";
							pstmt = conn.prepareStatement(updateQty);		
							pstmt.setInt(1, newQty);
							pstmt.setInt(2, FoodId);
							int finalResult  = pstmt.executeUpdate(); 
						}
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			available = available - totalCost;
			String updateCart = "update creditcard set Balance = ? where UserId = ?";
			try {
				pstmt = conn.prepareStatement(updateCart);
				pstmt.setInt(1, available);
				pstmt.setInt(2, uid);
				int sess = pstmt.executeUpdate();
				if(sess!=0) {
					return "Pending";
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
		
		return "Fail";
	}
	private int getFooIdFromCartId(int cartId) {
		// TODO Auto-generated method stub
		String sql = "select FoodId from mycart where CartId ="+cartId;
		try {
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
			  return rs.getInt("FoodId");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	private int getStoreIdFromCartId(int cartId) {
		// TODO Auto-generated method stub
		String sql = "select FoodId from mycart where CartId ="+cartId;
		try {
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				int foodId = rs.getInt("FoodId");
				return getStoreIdFromFoodId(foodId);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	private int getStoreIdFromFoodId(int foodId) {
		// TODO Auto-generated method stub
		String sql = "select StoreId from foods where FoodId ="+foodId;
		try {
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
			 return rs.getInt("StoreId");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	//@Override
	public ArrayList<OrderBean> viewOrder() {
		// TODO Auto-generated method stub
		DatabaseImpl db = new DatabaseImpl();
		String email = db.getEmail();
		int uid = db.getUserId(email);
		ArrayList<OrderBean> myOrders = new ArrayList<OrderBean>();
		String sql = "select * from orders where UserId = "+uid;
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
				myOrders.add(crb);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return myOrders;
	}
}
