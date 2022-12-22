import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ProductDeatils {

	private int id;
	private String Pname;
	private int Pprice;
	private String Pdescription;
	ArrayList<ProductDeatils> ad =new ArrayList<ProductDeatils>();
	
	
	ProductDeatils(int id,String pname,int pprice,String Pdescription)
	{
		this.id=id;
		this.Pname=pname;
		this.Pprice=pprice;
		this.Pdescription=Pdescription;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPname() {
		return Pname;
	}
	public void setPname(String pname) {
		Pname = pname;
	}
	public int getPprice() {
		return Pprice;
	}
	public void setPprice(int pprice) {
		Pprice = pprice;
	}
	public String getPdescription() {
		return Pdescription;
	}
	public void setPdescription(String pdescription) {
		Pdescription = pdescription;
	}
	
	
	public String toString() 
	{
		return id+" "+Pname+" "+Pprice+" "+Pdescription;
	}
	public void StoreProduct() {
		//ArrayList<ProductDeatils> ad=new  ArrayList<ProductDeatils>();
	
		Scanner sc =new Scanner(System.in);
		Scanner sc2 =new Scanner(System.in);
		
		System.out.print("Enter Product id");
		int id=sc.nextInt();
		
		System.out.print("Enter Product Name");
		String Pname=sc2.nextLine();
		
		System.out.print("Enter Product Price");
		int Pprice=sc.nextInt();
		
		System.out.print("Enter Product Description");
		String Pdescription=sc2.nextLine();
		
		//ad.add(new ProductDeatils(id,Pname,Pprice,Pdescription));
		ad.add(new ProductDeatils(id,Pname,Pprice,Pdescription));
		
		System.out.println("Product Addes Successfully");
		
		
	}
	
	public void display() {
		Iterator<ProductDeatils> itr=ad.iterator();
		while(itr.hasNext())
			{
			System.out.println("***************************");
			ProductDeatils pr=itr.next();
			System.out.println("Product Data");
			System.out.println(pr);
			}	
			System.out.println("***************************");
			
		
	}
	
	public void displaybyid(int id) {
		Iterator<ProductDeatils> itr=ad.iterator();
		while(itr.hasNext())
			{
			System.out.println("***************************");
			ProductDeatils pr=itr.next();
			if(pr.id ==id) {
				System.out.println("serch by id");
				System.out.println(pr);
			}
			else {
				System.out.println("Product not found");
			}
			}	
			System.out.println("***************************");
			
		
	}//
	public void displaybyname(String name) {
		Iterator<ProductDeatils> itr=ad.iterator();
		while(itr.hasNext())
			{
			System.out.println("***************************");
			ProductDeatils pr=itr.next();
			if(pr.Pname.equals(name)) {
				System.out.println("serch by name");
				System.out.println(pr);
			}
			else {
				System.out.println("Product not found");
			}
			}	
			System.out.println("***************************");
			
		
	}
	

	
	
	

}
