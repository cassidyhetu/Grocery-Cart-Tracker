package grocerycarttracker;

import java.util.ArrayList;
import java.util.Scanner; 


public class GroceryCartTrackerMain {
	static class Item { 

		String name; 
		double price; 
		int quantity; 

	

	Item(String name, double price, int quantity) { 

		this.name = name; 

		this.price = price; 

		this.quantity = quantity; 

		} 

		 

		double total() { 

		return price * quantity; 

		} 

	} 

		 

	public static void main(String[] args) { 

	Scanner scanner = new Scanner(System.in); 

		ArrayList<Item> cart = new ArrayList<>(); 

		double budget, taxRate, runningTotal = 0; 

		 

		System.out.println("Welcome to Grocery Cart Tracker!"); 

		System.out.print("Enter your budget: $"); 

		budget = scanner.nextDouble(); 

		 

		System.out.print("Enter tax rate (as a percentage, e.g., 7.5): "); 

		taxRate = scanner.nextDouble() / 100.0; 

		 

		scanner.nextLine(); 

		 

		while (true) { 

			System.out.print("Enter item name (or 'done' to finish): "); 

			String name = scanner.nextLine();  

		 

		if (name.equalsIgnoreCase("done")) break; 

		 

		System.out.print("Enter item price: $"); 

		double price = scanner.nextDouble(); 

		 

		System.out.print("Enter quantity: "); 

		int quantity = scanner.nextInt(); 

		 

		scanner.nextLine();  

		 

		Item item = new Item(name, price, quantity); 

		cart.add(item); 

		runningTotal += item.total(); 

		 

		double totalWithTax = runningTotal * (1 + taxRate); 

		 

		if (totalWithTax > budget) { 

		System.out.println("WARNING: You have exceeded your budget!"); 

		} else { 

		System.out.printf("Current total with tax: $%.2f\n", totalWithTax); 

		} 

	} 

		 

		System.out.println("\n**********************************"); 

		System.out.println(" GROCERY RECEIPT "); 

		System.out.println("**********************************"); 

		 

		for (Item item : cart) { 

		System.out.printf("%-20s %2dx $%.2f = $%.2f\n", 

		item.name, item.quantity, item.price, item.total()); 

		} 

		 

		double subtotal = runningTotal; 

		double taxAmount = subtotal * taxRate; 

		double finalTotal = subtotal + taxAmount; 

		 

		System.out.println("----------------------------------"); 

		System.out.printf("Subtotal: $%.2f\n", subtotal); 

		System.out.printf("Tax: $%.2f\n", taxAmount); 

		System.out.printf("Total: $%.2f\n", finalTotal); 

		System.out.printf("Budget Remaining: $%.2f\n", budget - finalTotal); 

		System.out.println("**********************************"); 

		 

		scanner.close(); 

		} 

}