package foodRestaurentSystem;

import java.util.ArrayList;
import java.util.Scanner;

class Food{
	int id;
	String dishName;
	double price;
	
	public Food(int id, String dishName, double price) {
		super();
		this.id = id;
		this.dishName = dishName;
		this.price = price;
	}
	void display() {
		System.out.println(id +"." + dishName+" ₹" + price);
	}
}
public class FoodApp {

	public static void main(String[] args) {
		ArrayList<Food> menu = new ArrayList<>();
		menu.add(new Food(1, "Burger", 160));
		menu.add(new Food(2, "Sandwich", 120));
		menu.add(new Food(3, "Shawarma", 100));
		menu.add(new Food(4, "Pasta", 220));
		menu.add(new Food(5, "Mango shake", 120));
		
		System.out.println("-----MENU-----");
		for(Food f:menu) {
			f.display();
		}
		ArrayList<Food> orders = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		String continueOrder = "yes";
		while(continueOrder.equalsIgnoreCase("yes")) {
			
		
		System.out.println("Enter food name");
		String searchFood = sc.nextLine();
		
		Food selectedFood = null;
		
		for(Food f:menu) {
		if(f.dishName.equalsIgnoreCase(searchFood)) {
			selectedFood =f;
			break;
		}
		}
		if(selectedFood != null) {
			System.out.println("Food found:");
			selectedFood.display();
			
			System.out.println("Total price: ₹"+selectedFood.price);
			System.out.println("Do you want to order this?(yes/no):");
			String choice = sc.nextLine();
			
			if(choice.equalsIgnoreCase("yes")) {
				orders.add(selectedFood);
				System.out.println("Item added to Order!");
			} else {
				System.out.println("All food items:");
				for(Food f: menu) {
					f.display();
				}
			}
		} else {
			System.out.println("Food not found");
		}
		
	
		System.out.println("Do you want to order more?(yes/no):");
		continueOrder = sc.nextLine();
		}
		
		System.out.println("-----YOUR ORDERS-----");
		double total =0;
		for(Food f :orders) {
			f.display();
			total += f.price;
		}
		System.out.println("Total Bill: "+ total);
		sc.close();
	}

}
