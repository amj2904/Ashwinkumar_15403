//package com.training.WebsiteEcommerce;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.util.List;
//import java.util.Scanner;
//
//import com.training.WebsiteEcommerce.controller.ProductController;
//import com.training.WebsiteEcommerce.dao.ProductDao;
//import com.training.WebsiteEcommerce.dao.Dbconnection;
//import com.training.WebsiteEcommerce.model.Product;
//
//
//public class EcommerceApp {
//
//	public static void main(String[] args) {
//
//		
//
//		try {
//			final ProductController productController=
//					ProductController.getProductCollection();
//			System.out.println("1. Displa all Customer");
//			System.out.println("2. Customer Details by ID");
//			System.out.println("3. Delete Customer by ID");
//			System.out.println("4. Update Name by ID");
//			
//			int choice=1;
//			System.out.println("1. Displa all Customer");
//			mainOptions(productController, choice);
//			
//			System.out.println("2. Customer Details by ID");
//			choice=2;
//			mainOptions(productController, choice);
//			
//			System.out.println("3. Delete Customer by ID");
//			choice=3;
//			mainOptions(productController, choice);
//			
//			System.out.println("4. Update name by id");
//			choice=4;
//			mainOptions(productController, choice);
//			
//			System.out.println("5. Add");
//			choice=5;
//			mainOptions(productController, choice);
//			
//			
//			choice=1;
//			System.out.println("1. Displa all Customer");
//			mainOptions(productController, choice);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}
//
//	private static void mainOptions(final ProductController productController, int choice) throws SQLException {
//		switch(choice) {
//		case 1: 
//				List<Product> list=productController.findAll();
//				for(Product customer:list) {
//					System.out.println(customer);
//				}
//				break;
//		case 2: 
//			final Product product=productController.findOne(2);
//			System.out.println(product);
//			break;
//		case 3: 
//			if(productController.findOneAndDelete(2)) {
//				System.out.println("id: 3 Records Deleted");
//			}
//			break;
//		case 4: 
//			final Product updatProduct=productController.findOne(1);
//			updatProduct.setPname("ash ");
//			if(productController.findOneAndUpdate(1,updatProduct)) {
//				System.out.println("id: 3 Records Deleted");
//			}
//			break;	
//		case 5: 
//			final Product newProduct=new Product(10,"lap",27.50);
//			if(productController.createNew(newProduct)) {
//				System.out.println(newProduct+ " Created in DB");
//			}
//			break;
//		default:
//			System.out.println("Please select between 1 to 5 options");
//			break;
//		}
//	}
//
//	private static void printAccounts(ProductDao dao) throws SQLException {
//		final List<Product> list=dao.findAll();
//		for(Product a: list) {
//			System.out.println(a);
//		}
//	}
//
//}
//
//********************************************
package com.training.WebsiteEcommerce;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.training.WebsiteEcommerce.controller.ProductController;
import com.training.WebsiteEcommerce.dao.ProductDao;
import com.training.WebsiteEcommerce.dao.Dbconnection;
import com.training.WebsiteEcommerce.model.Product;


public class EcommerceApp {

	public static void main(String[] args) {

		

		try {
			final ProductController productController=
					ProductController.getProductCollection();
			
			 Scanner sc = new Scanner(System.in);
			 int choice=0;
			   do {
			System.out.println("1. Displa all Product");
			System.out.println("2. Product Details by ID");
			System.out.println("3. Delete Product by ID");
			System.out.println("4. Update Product Name by ID");
			  System.out.println("5. Add");
			  System.out.println("0. Exit program");
              System.out.print("Enter your selection : ");
              choice=sc.nextInt();
			
			 choice=1;
			System.out.println("1. Displa all Product");
			mainOptions(productController, choice);
			
			System.out.println("2. Product Details by ID");
			choice=2;
			mainOptions(productController, choice);
			
			System.out.println("3. Delete Product by ID");
			choice=3;
			mainOptions(productController, choice);
			
			System.out.println("4. Update Product name by id");
			choice=4;
			mainOptions(productController, choice);
			
			System.out.println("5. Add");
			choice=5;
			mainOptions(productController, choice);
			
			
			choice=1;
			System.out.println("1. Displa all Product");
			mainOptions(productController, choice);
		} while(choice != 0);
		}
			   catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void mainOptions(final ProductController productController, int choice) throws SQLException {
		 Scanner sc = new Scanner(System.in);
		 Scanner sc2 = new Scanner(System.in);
		switch(choice) {
		case 1: 
				List<Product> list=productController.findAll();
				for(Product product:list) {
					System.out.println(product);
				}
				break;
		case 2: 
			  System.out.print("Find Product by id ? ");
	            int id = sc.nextInt();
			final Product product=productController.findOne(id);
			System.out.println(product);
			break;
		case 3: 
			 System.out.print("Enter the id of Prouct to be deleted");
	            int id1 = sc.nextInt();
			if(productController.findOneAndDelete(id1)) {
				System.out.println("id:"+id1+" Records Deleted");
			}
			break;
		case 4: 
			 System.out.print("Enter the id of Product to be updated");
	            int id3 = sc.nextInt();
			final Product updatProduct=productController.findOne(id3);
			 System.out.print("Enter the new pname ");
	            String prname = sc.next();
			updatProduct.setPname(prname);
			if(productController.findOneAndUpdate(id3,updatProduct)) {
				System.out.println("id:"+id3+"Records Updated");
			}
			break;	
		case 5: 
			 System.out.println("Enter Product Id:");
	            int prid = sc.nextInt();
	            System.out.println("\nEnter Product Name:");
	            String prname2= sc2.nextLine();
	            System.out.println("Enter Product Price:");
	            double pr=sc.nextDouble();
	          
	            System.out.println("Record Updated");
			final Product newProduct=new Product(prid,prname2,pr);
			if(productController.createNew(newProduct)) {
				System.out.println(newProduct+ " Created in DB");
			}
			break;
		default:
			System.out.println("Please select between 1 to 5 options");
			break;
		}
	}

	private static void printAccounts(ProductDao dao) throws SQLException {
		final List<Product> list=dao.findAll();
		for(Product a: list) {
			System.out.println(a);
		}
	}

}

