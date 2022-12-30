package com.training.WebsiteEcommerce;

import java.util.Scanner;

public class ecommain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("1.Customer");
		System.out.println("2.Product");
	
		
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter Your Choice");
				int num=sc.nextInt();
				switch (num) {
				case 1:
					EcommerceAppCustomer ecom=new EcommerceAppCustomer();
					break;
				case 2:
					
					EcommerceAppProduct ecommerceAppProduct=new EcommerceAppProduct();
					break;
				default:
					break;
				}

	}

}
