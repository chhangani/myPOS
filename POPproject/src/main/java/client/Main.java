package client;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.ntl.pos.bean.CartBean;
import com.ntl.pos.bean.CredentialsBean;
import com.ntl.pos.bean.CreditCardBean;
import com.ntl.pos.bean.FoodBean;
import com.ntl.pos.bean.OrderBean;
import com.ntl.pos.bean.ProfileBean;
import com.ntl.pos.bean.StoreBean;
import com.ntl.pos.service.Administrator;
import com.ntl.pos.service.Customer;
import com.ntl.pos.service.impl.AdministratorImpl;
import com.ntl.pos.service.impl.CustomerImpl;
import com.ntl.pos.service.impl.Services;
import com.ntl.pos.utill.impl.UserImpl;

public class Main {
	static  Scanner sc = new Scanner(System.in);
    AdministratorImpl admin=new AdministratorImpl();
    Customer cust=new CustomerImpl();
	public static void main(String[] args) {
       Main m = new Main();
       
       m.getData();
    }
	
	public void getData() {	
		
	   int flag = 1;
	   UserImpl user  = new UserImpl();
	   while(flag == 1) {
		   if(user.isLogin() && user.isAdmin()) {
			   System.out.println("\t\t\tEnter Your Choice\n"); 
			   System.out.println("\t\t\t1. View All Stores");  
			   System.out.println("\t\t\t2. Add One Store");
			   System.out.println("\t\t\t3. Quit");
			   System.out.println("\t\t\t4. View Store Details");
			   System.out.println("\t\t\t5. Remove Stores");
			   System.out.println("\t\t\t6. Modify a Store");
			   			/** Food Options **/
			   System.out.println("\t\t\t7. View All Foods");  
			   System.out.println("\t\t\t8. Add One Food");
			   System.out.println("\t\t\t9. View Food Details");
			   System.out.println("\t\t\t10. Remove Foods");
			   System.out.println("\t\t\t11. Modify Food");
			   
			   /** Orders Options **/
			   System.out.println("\t\t\t12. View All Orders");
			   System.out.println("\t\t\t13. Update Order Status");
			   
			   /**LOG-OUT **/
			   System.out.println("\t\t\t100. Logout");
			   
			   int userChoice = sc.nextInt();
			   switch(userChoice){
			   case 1 :  displayDetails();
			   			 break;
			   case 2:   addStore();
			   			 break;
			   case 3:   flag = 0;
			   			 System.out.println("Program Closed....");
			   			 break;	
			   case 4:   viewStore();
			   			 break;
			   case 5:   removeStore();
			   			 break;
			   case 6:  modifyStore();
			   			break;
			   case 7 :  displayFoodDetails();
	   			 		 break;
			   case 8 : addFood();
			   			break;
			   case 9 : viewFoodDetails();
			   			break;
			   case 10 :removeFood();
			   			break;
			   case 11: modifyFood();
			   			break;
			   case 12: viewAllOrder();
			   			break;	
			   case 13: updateOrderStatus();
			   			break;
			   case 100: logout();
	   					break;
			   default : System.out.println("Not Yet");
			   }   
  		    }
		   else if(user.isLogin()) {
			   System.out.println("\t\t\tEnter Your Choice\n"); 
			   System.out.println("\t\t\t1. ADD FOOD IN CART");  
			   System.out.println("\t\t\t2. View Cart");
			   System.out.println("\t\t\t3. View Stores in City");
			   System.out.println("\t\t\t4. Quit");
			   System.out.println("\t\t\t5. Modify Cart");
			   System.out.println("\t\t\t6. Confirm Order");
			   System.out.println("\t\t\t7. Add Credit Card Details");
			   System.out.println("\t\t\t8. View My Orders");
			   System.out.println("\t\t\t100. Logout");
			   int userChoice = sc.nextInt();
			   switch(userChoice){
			   case 1 :  addToCart();
			   			 break;
			   case 2:   viewCart();
			   			 break;
			   case 3:   storesInCity();
			   			 break;
			   case 4:   flag = 0;
			   			 System.out.println("Program Closed....");
			   			 break;	
			   case 5:   modifyCart();
			   			 break;
			   case 6:   confirmOrder();
			   			 break;
			   case 7:   addCreditCard();
			   			 break;
			   case 8:   viewMyOrders();	
			   			 break;
			   case 9:   logout();
			   			 break;
			   case 100: logout();
					     break;
			   default : System.out.println("Not Yet");
			   }   
		   }
		   else {
			   System.out.println("\t\t\tEnter Your Choice\n"); 
			   System.out.println("\t\t\t1. Display Data");  
			   System.out.println("\t\t\t2. Login");
			   System.out.println("\t\t\t3. Signup");
			   System.out.println("\t\t\t4. Quit");
			   int userChoice = sc.nextInt();
			   switch(userChoice){
			   case 1 :  displayData();
			   			 break;
			   case 2:   login();
			   			 break;
			   case 3:   signup();
			   			 break;
			   case 4:   flag = 0;
			   			 System.out.println("Program Closed....");
			   			 break;			 
			   default : System.out.println("Not Yet");
			   }   
		   }
	   }
	}

    private void updateOrderStatus() {
		// TODO Auto-generated method stub
    	System.out.println("********** UPDATE ORDER STATUS *********");
    	viewAllOrder();
    	System.out.println("You can change status of above mentioned orders");
    	int orderId = 0;
    	while(admin.isThisOrderId(orderId)==false) {
    		System.out.println("Enter ORDER ID which can be change in DB.");
    		orderId = sc.nextInt();
    	}
    	System.out.println("1. Success 2.Cancel 3.Taken");
    	int status = 0;
    	while((status!=1 && status!=2 && status!=3)) {
    		status = sc.nextInt();
    	}
    	String changeMessage  =  admin.changeOrderStatus(orderId,status);
    	System.out.println("Change Message - " + changeMessage);
	}
	private void viewAllOrder() {
		// TODO Auto-generated method stub
    	ArrayList<OrderBean> allOrders = admin.viewAllOrder();
    	if(allOrders.size()>0) {
    		for(OrderBean ob : allOrders) {
    			System.out.println(ob);
    		}
    	}
    	else {
    		System.out.println("No Orders.");
    	}
		
	}
	private void viewMyOrders() {
		// TODO Auto-generated method stub
    	ArrayList<OrderBean> myOrders = cust.viewOrder();
    	if(myOrders.size()>0) {
    		for(OrderBean ob : myOrders) {
    			System.out.println(ob);
    		}
    	}
    	else {
    		System.out.println("No Orders.");
    	}
	}
    
	private void confirmOrder() {
		// TODO Auto-generated method stub
      	System.out.println("********** Order Confirmation from My CART ********");
      	viewCart();
      	System.out.println("Enter Cart Id from Above Mentioned Cart Details.");
      		int cartId = 0;
      		ArrayList<Integer> arr = new ArrayList<Integer>();
      		int cartFlag = 0;
      		int count = 0;
        	while(cartFlag == 0) {
        		 System.out.println("Enter YOUR OWN CART ID. Press -1 for place the order.");
        		 cartId = sc.nextInt();
        		 if(cartId==-1) {
        			cartFlag =1;
        			continue;
        		 }
        		 if(cust.isMyCartId(cartId)==true) {
        			 int foodId = cust.getFoodId(cartId);
        			 int maxAv = cust.Available(foodId);
        			 int myQty = cust.myQuantity(cartId);
        			 if(myQty>maxAv) {
        				 System.out.println("This Item Can not be added.");
        				 System.out.println("Quantity Limit exceed.");
        				 System.out.println("You need to modify this item first.");
        				 System.out.println("Do You want to modify Quantity ? ");
        				 System.out.println("1. Yes\t\t 2.No");
        				 int mChoice = sc.nextInt();
        				 if(mChoice==1) {
            				 modifyCart();
        				 }
        				 else {
        					 System.out.println("You Can Order other Items for your cart.");
        				 }
        				 viewCart(); 
        			 }
        			 else {
        				 System.out.println("Item Added in ORDER MEMORY " + cartId);
        				 arr.add(cartId);
        			 }
        		 }
        	}
        	System.out.println("********** ORDER MEMORY **********");
        	for(Integer i : arr) {
        		System.out.println("CART ID " +i);
        	}	
        	while(cust.isMyCreditCart()==false) {
        		System.out.println("First of All you need to add your credit card details.");
        		addCreditCard();
        	}
        	if(arr.size()>0) {
        		String orderMessage = cust.confirmOrder(arr);
        		System.out.println("Order Message - " +orderMessage );
        	}
        	else {
        		System.out.println("Atleast One...");
        	}
        
	}
	private void addCreditCard() {
		// TODO Auto-generated method stub
		System.out.println("********** CREDIT CARD UPDATION / ADDITION ********");
		String creditCard = "";
		while(creditCard.length()!=16) {
			System.out.println("Enter 16 DIGIT Credit Card Details.");
			creditCard = sc.nextLine();
		}
		String ValidFrom ="";
		while(ValidFrom.length()!=7) {
			System.out.println("Enter Valid From Details in MM/YYYY format");
			ValidFrom = sc.nextLine();
		}
		String ValidTo ="";
		while(ValidTo.length()!=7) {
			System.out.println("Enter Valid To Details in MM/YYYY format");
			ValidTo = sc.nextLine();
		}
		int balance = 0;
	   while(balance<2500) {
		   System.out.println("Add Balance more then INR -2500");
		   balance = sc.nextInt();
	   }
	   CreditCardBean ccb = new CreditCardBean(creditCard, ValidFrom, ValidTo, balance,0);
	   boolean status = cust.addCreditCard(ccb);
	   if(status) {
		   System.out.println("Card Details Added Successfully.");
	   }
	   else {
		   System.out.println("Something Went Wrong Try Agian");
	   }
	}
	private void modifyCart() {
		// TODO Auto-generated method stub
    	System.out.println("********** MODIFY CART ********");
    	int cartId = 0;
    	while(cust.isMyCartId(cartId)==false) {
    		 System.out.println("Enter YOUR OWN CART ID.");
    		 cartId = sc.nextInt();
    	}
    	
    	System.out.println("You Can Update Quantity. Press 0 for Removing from the Cart");
    	int foodId = cust.getFoodId(cartId);
    	int maxAv = cust.Available(foodId);
    	int Quantity=-1;
    	while(Quantity<0|| Quantity>maxAv) {
    		System.out.println("Enter Quantity of Food bteween 0 and " + maxAv);
    		Quantity = sc.nextInt();
    	}
    	CartBean cartB = new CartBean(foodId,Quantity);
    	cartB.setCartID(cartId);
    	boolean result = cust.modifyCart(cartB);
    	if(result) {
    		System.out.println("Successs | Modified successfully.");
    	}
    	else {
    		System.out.println("Error | Try Again");
    	}
		
	}
	private void storesInCity() {
		// TODO Auto-generated method stub
    	System.out.println("Enter Your City Name");
    	String city  = sc.nextLine();
    	if(city.length()<2) {
    		city  = sc.nextLine();
    	}
    	ArrayList<StoreBean> arr = cust.viewStore(city);
    	if(arr.size()>0) {
    		for(StoreBean sb : arr) {
        		System.out.println(sb.toString());
        	}
    	}
    	else {
    		System.out.println("We Don't Have Stores in your city!!!");
    	}
    	
	}
	private void viewCart() {
		// TODO Auto-generated method stub
    	
    	ArrayList<CartBean> arr = cust.viewCart("userId");
    	if(arr.size()>0) {
    		for(CartBean crb : arr) {
        		System.out.println(crb.toString());
        	}
    	}
    	else {
    		System.out.println("Cart is empty!!!");
    	}
    	
		
	}
	private void addToCart() {
		// TODO Auto-generated method stub
    	System.out.println("********** ADD TO CART ********");
    	int foodId = 0;
    	while(admin.isFoodId(foodId)==false) {
    		 System.out.println("Enter FOOD ID which exist in DB.");
    		 foodId = sc.nextInt();
    	}
    	int maxAv = cust.Available(foodId);
    	int Quantity=0;
    	while(Quantity<=0|| Quantity>maxAv) {
    		System.out.println("Enter Quantity of Food bteween 1 and " + maxAv);
    		Quantity = sc.nextInt();
    	}
    	CartBean cartB = new CartBean(foodId,Quantity);
    	int result = cust.addToCart(cartB);
    	if(result!=0) {
    		System.out.println("Successs | Added successfully.");
    	}
    	else {
    		System.out.println("Error | Try Again");
    	}
	}
	private void modifyFood() {
		// TODO Auto-generated method stub
    	System.out.println("Modifying FOOD");
    	int foodId = 0;
    	while(admin.isFoodId(foodId)==false) {
    		 System.out.println("Enter FOOD ID which exist in DB.");
    		 foodId = sc.nextInt();
    	}
    	System.out.println("Enter Food Name");
    	String name = sc.nextLine();
    	int flag = 0;
    	if(name.length()<2) {
    		name = sc.nextLine();
    	}
    	flag = 0;
    	System.out.println("Enter Food Type");
    	String type = sc.nextLine();
    	while(flag ==0) {
    		if(!(type.equals("veg") || type.equals("nonveg"))) {
    			System.out.println("veg/ nonveg ");
    			type = sc.nextLine();
    		}
    		else {
    			flag = 1;
    		}
    	}
    	System.out.println("Enter Food Size");
    	String foodSize = sc.nextLine();
        flag = 0;
    	while(flag ==0) {
    		if(!(foodSize.equals("small") || foodSize.equals("medium") || foodSize.equals("large"))) {
    			System.out.println("small / medium / large");
    			foodSize = sc.nextLine();
    		}
    		else {
    			flag = 1;
    		}
    	}
    	System.out.println("Enter Quantity");
    	int Qty= sc.nextInt();
    	
    	System.out.println("Enter Price");
    	int Price= sc.nextInt();
    	
    	int storeId = 0;
    	while(admin.isStoreId(storeId)==false) {
    		 System.out.println("Enter Store Id which exist in DB.");
    		 storeId = sc.nextInt();
    	}
    	FoodBean fb = new FoodBean(foodId,name,type,foodSize,Qty,Price,storeId);
    	boolean status = admin.modifyFood(fb);
    	if(status)
    	System.out.println("Success | modification success.");
    	else
        System.out.println("Error | Try Again.");
		
	}
	private void removeFood() {
		// TODO Auto-generated method stub
    	System.out.println("Removing Food form a perticular store.");
    	int foodId = 0;
    	while(admin.isFoodId(foodId)==false) {
    		 System.out.println("Enter FOOD ID which exist in DB.");
    		 foodId = sc.nextInt();
    	}
    	
    	int storeId = 0;
    	while(admin.isStoreId(storeId)==false) {
    		 System.out.println("Enter Store Id which exist in DB.");
    		 storeId = sc.nextInt();
    	}
		boolean status = admin.removeFood(foodId, storeId);
		if(status) {
			System.out.println("Success | Food Removed.");
		}
		else {
			System.out.println("Error | Try Again.");
		}
	}
	private void viewFoodDetails() {
		// TODO Auto-generated method stub
    	System.out.println("VIEWING FOOD BY FOOD ID");
    	System.out.println("Enter FOOD ID");
    	String foodId = sc.next();
    	FoodBean fb  = admin.viewFood(foodId);
    	System.out.println("Displaying Details of Food ID - " + foodId);
    	if(fb!=null) {
    		System.out.println(fb);
    	}
    	else {
    		System.out.println("No Store with this " + foodId +" StoreId");
    	}
		
	}
	private void addFood() {
		// TODO Auto-generated method stub
    	System.out.println("ADDING FOOD IN A STORE");
    	System.out.println("Enter Food Name");
    	String name = sc.nextLine();
    	int flag = 0;
    	if(name.length()<2) {
    		name = sc.nextLine();
    	}
    	flag = 0;
    	System.out.println("Enter Food Type");
    	String type = sc.nextLine();
    	while(flag ==0) {
    		if(!(type.equals("veg") || type.equals("nonveg"))) {
    			System.out.println("veg/ nonveg ");
    			type = sc.nextLine();
    		}
    		else {
    			flag = 1;
    		}
    	}
    	System.out.println("Enter Food Size");
    	String foodSize = sc.nextLine();
        flag = 0;
    	while(flag ==0) {
    		if(!(foodSize.equals("small") || foodSize.equals("medium") || foodSize.equals("large"))) {
    			System.out.println("small / medium / large");
    			foodSize = sc.nextLine();
    		}
    		else {
    			flag = 1;
    		}
    	}
    	System.out.println("Enter Quantity");
    	int Qty= sc.nextInt();
    	
    	System.out.println("Enter Price");
    	int Price= sc.nextInt();
    	
    	int storeId = 0;
    	while(admin.isStoreId(storeId)==false) {
    		 System.out.println("Enter Store Id which exist in DB.");
    		 storeId = sc.nextInt();
    	}
    	FoodBean fb = new FoodBean(0,name,type,foodSize,Qty,Price,storeId);
    	System.out.println(fb);
    	String storeMessage = admin.addFood(fb,storeId);
    	System.out.println("Returned Message : - " + storeMessage);
    	//System.out.println(sb);
		
	}
	private void displayFoodDetails() {
		// TODO Auto-generated method stub
    	System.out.println("Foods At a specific store.");
    	int storeId = 0;
    	while(admin.isStoreId(storeId)==false) {
    		 System.out.println("Enter Store Id which exist in DB.");
    		 storeId = sc.nextInt();
    	}
    	ArrayList<FoodBean> pizzaFoods = admin.viewAllFood(storeId);
    	if(pizzaFoods.size()>0) {
    		for(FoodBean fb : pizzaFoods) {
            	System.out.println(fb);
            }
    	}
    	else {
    		System.out.println("No Food Available in this store.");
    	}
		
	}
	private void modifyStore() {
		// TODO Auto-generated method stub
    	System.out.println("Modifying A Store");
    	int storeId = 0;
    	while(admin.isStoreId(storeId)==false) {
    		 System.out.println("Enter Store Id which exist in DB.");
    		 storeId = sc.nextInt();
    	}
    	System.out.println("Enter Store Name");
    	String name = sc.nextLine();
    	if(name.length()<2) {
    		name = sc.nextLine();
    	}
    	System.out.println("Enter Street");
    	String street = sc.nextLine();
    	if(street.length()<2) {
    		street = sc.nextLine();
    	}
    	System.out.println("Enter Mobile No");
    	String mobileNo = sc.nextLine();
    	int flag = 0;
    	while(flag ==0) {
    		if(mobileNo.length()!=10) {
    			System.out.println("10 Digit Mobile No.");
    			mobileNo = sc.nextLine();
    		}
    		else {
    			flag = 1;
    		}
    	}
    	System.out.println("Enter City");
    	String city = sc.nextLine();
    	if(city.length()<2) {
    		city = sc.nextLine();
    	}
    	System.out.println("Enter State");
    	String state = sc.nextLine();
    	if(state.length()<2) {
    		state = sc.nextLine();
    	}
    	System.out.println("Enter Pincode");
    	String pincode = sc.nextLine();
        flag = 0;
    	while(flag ==0) {
    		if(pincode.length()!=6) {
    			System.out.println("6 Digit Pincode");
    			pincode = sc.nextLine();
    		}
    		else {
    			flag = 1;
    		}
    	}
    	StoreBean sb = new StoreBean(storeId,name,street,mobileNo,city,state,pincode);
    	System.out.println(sb);
    	boolean status = admin.modifyStore(sb);
        if(status)
        	System.out.println("Modified Successfully.");
        else {
        	System.out.println("Error|  Try Again");
        }
	}
	private void removeStore() {
		// TODO Auto-generated method stub
    	System.out.println("Removing Stores.");
    	ArrayList<String> Ids = new ArrayList<String>();
    	int flag  = 0;
    	System.out.println("Enter -1 for removing stores.");
    	while(flag == 0) {
    		System.out.println("Enter Store Id");
    		String storeId = sc.next();
    		if(storeId.equals("-1")) {
    			flag = 1;
    		}
    		else {
    			Ids.add(storeId);
    		}
    	}
		int count  = admin.removeStore(Ids);
		System.out.println(count + "Stores Removed");
	}
	private void viewStore() {
    	System.out.println("VIEWING A STORE");
    	System.out.println("Enter Store ID");
    	String storeId = sc.next();
    	StoreBean sb  = admin.viewStore(storeId);
    	System.out.println("Displaying Details of Store ID - " + storeId);
    	if(sb!=null) {
    		System.out.println(sb);
    	}
    	else {
    		System.out.println("No Store with this " + storeId +" StoreId");
    	}
		
	}
	private void addStore() {
		// TODO Auto-generated method stub
    	System.out.println("ADDING ONE STORE");
    	System.out.println("Enter Store Name");
    	String name = sc.nextLine();
    	if(name.length()<2) {
    		name = sc.nextLine();
    	}
    	System.out.println("Enter Street");
    	String street = sc.nextLine();
    	if(street.length()<2) {
    		street = sc.nextLine();
    	}
    	System.out.println("Enter Mobile No");
    	String mobileNo = sc.nextLine();
    	int flag = 0;
    	while(flag ==0) {
    		if(mobileNo.length()!=10) {
    			System.out.println("10 Digit Mobile No.");
    			mobileNo = sc.nextLine();
    		}
    		else {
    			flag = 1;
    		}
    	}
    	System.out.println("Enter City");
    	String city = sc.nextLine();
    	if(city.length()<2) {
    		city = sc.nextLine();
    	}
    	System.out.println("Enter State");
    	String state = sc.nextLine();
    	if(state.length()<2) {
    		state = sc.nextLine();
    	}
    	System.out.println("Enter Pincode");
    	String pincode = sc.nextLine();
        flag = 0;
    	while(flag ==0) {
    		if(pincode.length()!=6) {
    			System.out.println("6 Digit Pincode");
    			pincode = sc.nextLine();
    		}
    		else {
    			flag = 1;
    		}
    	}
    	StoreBean sb = new StoreBean(0,name,street,mobileNo,city,state,pincode);
    	String storeMessage = admin.addStore(sb);
    	System.out.println("Returned Message : - " + storeMessage);
    	//System.out.println(sb);
	}
	private void displayDetails() {
		// TODO Auto-generated method stub
    	ArrayList<StoreBean> pizzStores = admin.viewAllStore();
        for(StoreBean sb : pizzStores) {
        	System.out.println(sb);
        }
    }
	private void logout() {
    	UserImpl user  = new UserImpl();
    	String email = user.getEmail();
    	boolean log = user.logout(email);
    	if(log)
    	System.out.println("Success | Logout");
    	else
    	System.out.println("Error | Something went wrong | Try Aging...");
	}
	private void login() {
		UserImpl user  = new UserImpl();
		 if(user.isLogin()) {
	   	  System.out.println("Need to logout first.");	
	   	  return ;
	     }
		// TODO Auto-generated method stub
    	
    	System.out.println("Enter Your Email Address.");
       	String email = sc.next();
    	System.out.println("Enter Your Password.");
    	String pass = sc.next();
    	if(pass.length()<2) {
    		pass = sc.nextLine();
    	}
    	CredentialsBean cb = new CredentialsBean(email,pass);
        String loginMessage = user.login(cb);
        if(loginMessage!=null)
        System.out.println("Login Message " + loginMessage);
		
	}
	private void displayData() {
		// TODO Auto-generated method stub
		UserImpl user  = new UserImpl();
		if(!user.isLogin()) {
	   	  System.out.println("Need to login first.");	
	   	  return ;
	     }
		else {
			String email = user.getEmail();
			ProfileBean pb = user.displayProfile(email);
			System.out.println(pb);
		}
		
	}
	private void signup() {
		UserImpl user  = new UserImpl();
		Scanner sc1=new Scanner(System.in);
		if(!user.isLogin()) {
			int validateFlag= 0;
			System.out.println("Enter Your First Name");
	    	String firstName = sc.nextLine();
	    	if(firstName.length()<2) {
	    		firstName = sc.nextLine();
	    	}
	    	System.out.println("Enter Your Last Name");
	    	String lastName = sc.nextLine();
	    	if(lastName.length()<2) {
	    		lastName = sc.nextLine();
	    	}
	    	
	    	validateFlag = 0;
	    	System.out.println("DOB (dd/mm/yyyy)");
			String dateOfBirth = "";
	        while(Services.validateDate(dateOfBirth)==false) {
	         if(validateFlag==1) {
				   System.out.println("Invalid Date! Enter Again");  
				   System.out.println("STRICT Follow the format - DOB(dd/mm/yyyy) - : ");
				   dateOfBirth= sc1.nextLine();
	          }
	         else {
        		   System.out.println("STRICT Follow the format - DOB(dd/mm/yyyy) - : ");
        		   dateOfBirth= sc1.nextLine();
                   validateFlag = 1;
	           }
	        }
	        System.out.println("Enter Your Gender");
	        String gender;
	        while(true)
	        {
	        	gender = sc1.nextLine();
	        	if(gender.equals("male") || gender.equals("female"))
	        	{
	        		break;
	        	}
	        	else {
	        		System.out.println("Enter Male / Female");
	        	}
	        }
	        System.out.println("Street");
	        String street = sc1.next();
	        if(street.length()<2) {
	        	street = sc1.next();
	        }
	        System.out.println("location");
	        String location = sc1.next();
	        if(location.length()<2) {
	        	location = sc1.next();
	        }
	        System.out.println("city");
	        String city = sc1.next();
	        if(city.length()<2) {
	        	city = sc1.next();
	        }
	        System.out.println("State");
	        String state = sc1.next();
	        if(state.length()<2) {
	          state = sc1.next();
	        }
	        System.out.println("Pincode");
	        String pincode = sc1.next();
	        if(pincode.length()<2) {
	        	pincode = sc1.next();
	        }
	        System.out.println("Mobile No.");
	        String mobileNo = sc1.next();
	        if(mobileNo.length()<2) {
	        	mobileNo = sc1.next();
	        }
	        validateFlag = 0;
		    String userEmail="";
		    while(Services.validateEmail(userEmail)==false
				 || Services.checkDuplicate(userEmail)==true){
			   if(Services.validateEmail(userEmail)==true && 
		        		  Services.checkDuplicate(userEmail)==true) {
		        		  System.out.println("Email Already Used! Enter Another."); 
		          		  userEmail= sc1.nextLine();
		          		  validateFlag = 1;
		           	   }
			   else if(validateFlag==1) {
        		    System.out.println("Invalid Email! Enter Again");  
        		    userEmail= sc1.nextLine();
        	   }
        	   else {
        		   System.out.println("Email - : ");
        		   userEmail= sc1.nextLine();
                   validateFlag = 1;
        	   }
           }
		   validateFlag = 0;
           String userPassword = ""; 
           while(Services.validatePassword(userPassword)==false) {
        	   if(validateFlag==1) {
        		   System.out.println("Invalid Password! Enter Again");  
        		   userPassword= sc1.nextLine();
        	   }
        	   else {
        		   System.out.println("Password - : ");
        		   userPassword= sc1.nextLine();
                   validateFlag = 1;
        	   }
           }
		   
           validateFlag = 0;
		   if(Services.validateEmail(userEmail)) {
			   ProfileBean pb = new ProfileBean(0,firstName,lastName,dateOfBirth,gender,street,
					  location,city,state,pincode,mobileNo,userEmail,userPassword);
			   System.out.println(pb.toString());
			   String status = user.register(pb);
			   if(status.length()>0)
			   System.out.println("SUCCESS ! USER REGISTRATION");
			   else
			   System.out.println("Error | Try Again");
		   }  
		   else {
			   System.out.println("Invalid Data ! Try Again");
		   }
	   }
		else {
			System.out.println("Need to logout first");
		}

	}	
}

