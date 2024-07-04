/*
 * This class is the driver class for the Food Truck application.
 * 
 * You have been provided with a bit of starter code to help you get started.
 * You are only responsible for completing one single order.
 * If you'd like to process multiple orders, you can do so in the main method.
 */

 import java.io.File;
 import java.io.FileNotFoundException;
 import java.util.ArrayList;
 import java.util.Date;
 import java.util.Scanner;
 
 public class Driver {
 
	 public static void main(String[] args) {
		 // TO DO: call the loadMenuItems method and store the returned ArrayList in a variable
		 ArrayList<MenuItem> menuItems = loadMenuItems("products.txt");
 
		 // TO DO: Instantiate a Date object to store the Date of the order
		 Date orderDate = new Date();
 
		 // TO DO: Create a simple system to process an order. Decompose the problem into smaller steps/methods
		 // You can use the following steps as a guide:
		 // 1. Print a welcome message
		 // 2. Prompt the user to enter their information (should be a method that returns a Customer object)
		 // 3. Prompt the user to enter the items they'd like to order (should be a method that returns an ArrayList of MenuItems)
		 //    a. Create an ArrayList to store the items the user has ordered (shopping cart)
		 //    b. The shopping cart should hold MenuItems
		 // 4. Print the order (should be a method that takes the Customer object, the ArrayList of MenuItems, and the Date object)
 
		 // 1. Print a welcome message
		 System.out.println("Welcome to the Food Truck App!");
 
		 // 2. Prompt the user to enter their information
		 Customer customer = getCustomerInformation();
 
		 // 3. Prompt the user to enter the items they'd like to order
		 ArrayList<MenuItem> orderedItems = chooseItemsFromMenu(menuItems);
 
		 // 4. Print the order
		 printReceipt(orderedItems, customer, orderDate);
	 }
 
	 public static ArrayList<MenuItem> loadMenuItems(String filename) {
		 ArrayList<MenuItem> menuItems = new ArrayList<>();
		 try {
			 File file = new File(filename);
			 Scanner scanner = new Scanner(file);
			 while (scanner.hasNextLine()) {
				 String[] parts = scanner.nextLine().split(",");
				 String name = parts[0];
				 double price = Double.parseDouble(parts[1]);
				 int calories = Integer.parseInt(parts[2]);
				 menuItems.add(new MenuItem(name, price, calories));
			 }
			 scanner.close();
		 } catch (FileNotFoundException e) {
			 System.out.println("File not found: " + filename);
		 }
		 return menuItems;
	 }
 
	 public static void printMenu(ArrayList<MenuItem> menuItems) {
		 System.out.println("Food Truck Menu");
		 System.out.println("================");
		 for (MenuItem item : menuItems) {
			 System.out.println(item);
		 }
	 }
 
	 public static Customer getCustomerInformation() {
		 Scanner scanner = new Scanner(System.in);
		 System.out.println("Please enter your information:");
		 System.out.print("Name: ");
		 String name = scanner.nextLine();
		 System.out.print("Email: ");
		 String email = scanner.nextLine();
		 System.out.print("Phone: ");
		 String phone = scanner.nextLine();
		 scanner.close();
		 return new Customer(name, email, phone);
	 }
 
	 public static ArrayList<MenuItem> chooseItemsFromMenu(ArrayList<MenuItem> menuItems) {
		 // For simplicity, let's assume the customer chooses the first two items from the menu
		 ArrayList<MenuItem> chosenItems = new ArrayList<>();
		 chosenItems.add(menuItems.get(0));
		 chosenItems.add(menuItems.get(1));
		 return chosenItems;
	 }
 
	 public static void printReceipt(ArrayList<MenuItem> orderedItems, Customer customer, Date orderDate) {
		 System.out.println("Customer: " + customer.getName());
		 System.out.println("Date of Order: " + orderDate);
		 System.out.println("Ordered Items:");
		 for (MenuItem item : orderedItems) {
			 System.out.println(item.getName() + " - $" + item.getPrice());
		 }
		 // Add more details as per the receipt format specified
	 }
 }
 