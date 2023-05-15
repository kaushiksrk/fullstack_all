package com.cgi;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cgi.factory.SpringConfig;
import com.cgi.model.Orders;
import com.cgi.model.Users;
import com.cgi.service.OrdersService;
import com.cgi.service.UsersService;


public class App {
	
	public static final int LOGIN_THRESHOLD=3;
	static Scanner scanner=new Scanner(System.in);
	
	
    public static void main( String[] args ) {
    	ApplicationContext context=new AnnotationConfigApplicationContext(SpringConfig.class);
    	
    	OrdersService ordersService =context.getBean("ordersService",OrdersService.class);
    	UsersService usersService=context.getBean("usersService",UsersService.class);
    	
    	System.out.println("Order Details!");
    	System.out.println("Enter your username and password to login.");
    	

    	if(login(usersService)) {
    		startSystem(ordersService, usersService);
    	}else {
    		System.out.println("Application logged off due to incorrect credentials!");
    	}
    }

	private static void startSystem(OrdersService ordersService, UsersService usersService) {
        
        System.out.println("1. Create Order");
        System.out.println("2. View All Orders");
        System.out.println("3. View Orders By Id");
        System.out.println("4. Update Order By Name");
        System.out.println("5. Update Order By Price");
        System.out.println("6. Maximum Order By Id");
        System.out.println("7. Minimum All Orders");
        System.out.println("8. Delete Order By Id");
        System.out.println("9. Delete All Orders");
        System.out.println("10. Exit");
        
        System.out.println("Enter any one of the above options.");
        int option=Integer.parseInt(scanner.next());
        
        switch(option) {
        case 1:
        	Orders createOrders=new Orders();
        	
        	System.out.print("Enter Order Name: ");
        	createOrders.setOrderName(scanner.next());
        	
			System.out.print("Enter Order Price: ");
			createOrders.setOrderPrice(Double.parseDouble(scanner.next()));
			
			ordersService.createOrder(createOrders);
			
			System.out.print("Order Placed!");
			
        	System.exit(0);
        case 2:
        	System.out.println("Below are the Orders Available in our system!");
        	
        	System.out.println(ordersService.getAllOrders());
        	System.exit(0);
        case 3:
        	Orders viewOrderById=new Orders();
        	
        	System.out.print("Enter Order Id: ");
        	viewOrderById.setOrderId(Integer.parseInt(scanner.next()));
        	
        	System.out.println(ordersService.findOrderByID(viewOrderById));
        	
        	System.exit(0);
        case 4:
        	Orders updateOrderByName=new Orders();
        	
        	System.out.print("Enter Order Id: ");
        	updateOrderByName.setOrderId(Integer.parseInt(scanner.next()));
        	
        	System.out.print("Enter Order Name to Update: ");
        	updateOrderByName.setOrderName(scanner.next());
        	
        	ordersService.updateOrderByName(updateOrderByName);
        	
        	System.out.println("Order Name updated!");
        	
        	System.exit(0);
        case 5:
        	Orders updateOrderByPrice=new Orders();
        	
        	System.out.print("Enter Order Id: ");
        	updateOrderByPrice.setOrderId(Integer.parseInt(scanner.next()));
        	
        	System.out.print("Enter Order Price to Update: ");
        	updateOrderByPrice.setOrderName(scanner.next());
        	
        	
        	ordersService.updateOrderByPrice(updateOrderByPrice);
        	
        	System.out.println("Order Price updated!");
        	
        	System.exit(0);
        case 6:
        	System.out.println("Below is the Maximum Order!");
        	
        	System.out.println(ordersService.findMaxOrderValue());
        	System.exit(0);
        case 7:
        	System.out.println("Below is the Minimum Order!");
        	
        	System.out.println(ordersService.findMinOrderValue());
        	System.exit(0);
        case 8:
        	System.out.println("Enter the Order Id to delete!");
        	Orders deleteOrderById=new Orders();
        	
        	deleteOrderById.setOrderId(Integer.parseInt(scanner.next()));
        	
        	ordersService.deleteOderById(deleteOrderById);
        	System.out.println("Order Deleted!");
        	System.exit(0);
        case 9:
        	System.out.println("Deleting All the Orders!");
        	
        	ordersService.deleteAllOrders();
        	System.exit(0);
        case 10:
        	System.out.println("Application Closed!");
        	System.exit(0);
        
        }
	}


	private static boolean login(UsersService usersService) {
		Users users=new Users();
    	
    	String username="";
    	String password="";
    	
    	for(int i=0; i<LOGIN_THRESHOLD; i++) {
    		System.out.println("Username: ");
    		username=scanner.next();
    		
    		System.out.println("Password: ");
        	password=scanner.next();
        	
        	users.setPassword(username);
        	users.setUsername(password);
        	
    		if(usersService.login(users)) {
    			return true;
    		}else {
    			int count=i+1;
    			System.out.println("Incorrect Password! : " + count);
    		}
    	}
    	return false;
	}
}
