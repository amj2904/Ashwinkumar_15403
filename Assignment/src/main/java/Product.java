import java.util.ArrayList;

import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

public class Product {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProductDeatils pd =new ProductDeatils(0,"",0, "");
		
	
	    
	    Scanner sc =new Scanner(System.in);
Scanner sc2 =new Scanner(System.in);		
		
		
		
		int ch;
		do {
			System.out.println("1 ADD");
			System.out.println("2 DISPLAY ");
			System.out.println("3 SEARCH BY ID");
			System.out.println("4 SEARCH BY NAME");
			System.out.println("5 delete BY id");
			System.out.println("0 Exit");
			System.out.println("ENTER YOUR CHOICE");
			ch=sc.nextInt();
			
			switch (ch) {
			case 1:
				pd.StoreProduct();
				break;
			case 2:
				pd.display();
					break;
					
			case 3:
				System.out.println("Enter Product id");
				int id=sc.nextInt();
				pd.displaybyid(id);
				break;
			case 4:
				System.out.println("Enter Product name");
				String name=sc2.nextLine();
				//pd.displaybyid(name);
				try {
					pd.displaybyname(name);
				} catch (Exception e) {
					System.out.println("Product not found");
					//e.printStackTrace();
				}
				
			case 5:
				System.out.println("enter id");
				int did=sc.nextInt();
				pd.DeleteById(did);
				
				break;
				
				
			}
			
		}while(ch!=0);
//***************************
	}

}
