package com.jsp.hibernate.shoping_cart;

import java.util.Scanner;

import com.jsp.hibernate.shopping_cart.dao.ShoppingCartDao;

public class App 
{
    public static void main( String[] args )
    {
        
    	
    	Scanner sc = new Scanner(System.in);
    	

		
    	while(true) {
    		
    		System.out.println("1:Add Product  \n2:Add User with cart  \n3:Add product to Cart  \n4:Remove Product From  cart  \n5:Find All Product from Cart  \n6:Exit");
    		
    		System.out.println("Enter the Choice ");
    		
    		int choice = sc.nextInt(); 
    		
    		
    		switch (choice) {
			case 1:
				ShoppingCartDao.addProduct(choice, null, null, choice);
				break;
				
			case 2:
				ShoppingCartDao.addUserWithCart(choice, null, null, choice, null, choice);
				break;
				
			case 3:
				ShoppingCartDao.addProductIntocart();
				break;
				
			case 4:
				ShoppingCartDao.removeProductFromCart();
				break;
			case 5:
				ShoppingCartDao.findAllProductFromCart();
				break;
			case 6 :
				System.out.println("Thanks exit Successfully");
				System.exit(5);
			default:
				System.out.println("Envalid data !!");
				break;
			}
    	}
    }
}
