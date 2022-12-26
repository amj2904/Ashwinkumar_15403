package com.training.WebsiteEcommerce;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.training.WebsiteEcommerce.controller.CustomerController;
import com.training.WebsiteEcommerce.dao.CustomerDao;
import com.training.WebsiteEcommerce.dao.Dbconnection;
import com.training.WebsiteEcommerce.model.Customer;


public class EcommerceApp {

	public static void main(String[] args) {

		

		try {
			final CustomerController customerControllerr=
					CustomerController.getCustomerController();
			 Scanner sc = new Scanner(System.in);
			 int choice=0;
			   do {
			System.out.println("1. Displa all Customer");
			System.out.println("2. Customer Details by ID");
			System.out.println("3. Delete Customer by ID");
			System.out.println("4. Update Customer Name by ID");
			  System.out.println("5. Add");
			  System.out.println("0. Exit program");
              System.out.print("Enter your selection : ");
              choice=sc.nextInt();
			
//			System.out.println("1. Display all Customer");
//			System.out.println("2. Customer Details by ID");
//			System.out.println("3. Delete Customer by ID");
//			System.out.println("4. Update Name by ID");
			
			 choice=1;
			System.out.println("1. Displa all Customer");
			mainOptions(customerControllerr, choice);
			
			System.out.println("2. Customer Details by ID");
			choice=2;
			mainOptions(customerControllerr, choice);
			
			System.out.println("3. Delete Customer by ID");
			choice=3;
			mainOptions(customerControllerr, choice);
			
			System.out.println("4. Update name by id");
			choice=4;
			mainOptions(customerControllerr, choice);
			
			System.out.println("5. Add");
			choice=5;
			mainOptions(customerControllerr, choice);
			
			
			choice=1;
			System.out.println("1. Displa all Customer");
			mainOptions(customerControllerr, choice);
		}while(choice != 0);
			   } catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void mainOptions(final CustomerController customerController, int choice) throws SQLException {
		 Scanner sc = new Scanner(System.in);
		 Scanner sc2 = new Scanner(System.in);
		switch(choice) {
		case 1: 
				List<Customer> list=customerController.findAll();
				for(Customer customer:list) {
					System.out.println(customer);
				}
				break;
		case 2: 
			 System.out.print("Find Customer by id ? ");
	            int id = sc.nextInt();
			final Customer customer=customerController.findOne(id);
			System.out.println(customer);
			break;
		case 3: 
			System.out.print("Enter the id of Customer to be deleted");
            int id1 = sc.nextInt();
			if(customerController.findOneAndDelete(id1)) {
				System.out.println("id:"+id1+" Records Deleted");
			}
			break;
		case 4: 
			 System.out.print("Enter the id of Customer to be updated");
	            int id3 = sc.nextInt();
			final Customer updatCustomer=customerController.findOne(id3);
	            System.out.print("Enter the new cname ");
	            String cname = sc.next();
			updatCustomer.setCustName(cname);
			if(customerController.findOneAndUpdate(id3,updatCustomer)) {
				System.out.println("id:"+id3+"Records Updated");
			}
			break;	
		case 5: 
			System.out.println("Enter Customer Id:");
            int cid = sc.nextInt();
            System.out.println("\nEnter Customer Name:");
            String cname2= sc2.nextLine();
            System.out.println("\nEnter Customer email:");
            String cuemail= sc2.nextLine();
            System.out.println("\nEnter Customer number:");
            String cunum= sc2.nextLine();
            
			final Customer newCustomer=new Customer(cid,cname2,cuemail,cunum);
			if(customerController.createNew(newCustomer)) {
				System.out.println(newCustomer+ " Created in DB");
			}
			break;
		default:
			System.out.println("Please select between 1 to 5 options");
			break;
		}
	}

	private static void printAccounts(CustomerDao dao) throws SQLException {
		final List<Customer> list=dao.findAll();
		for(Customer a: list) {
			System.out.println(a);
		}
	}

}
