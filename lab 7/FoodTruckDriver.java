import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FoodTruckDriver {

    public static void main(String[] args) {
        ArrayList<MenuItem> menuItems = loadMenuItems("products.txt");

        if (menuItems.isEmpty()) {
            System.out.println("Menu is empty. Exiting...");
            return;
        }

        // Process multiple orders
        for (int i = 1; i <= 2; i++) {
            System.out.println("Processing Order #" + i);
            processOrder(menuItems);
        }
    }

    public static ArrayList<MenuItem> loadMenuItems(String filename) {
        ArrayList<MenuItem> menuItems = new ArrayList<>();
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String name = parts[0].trim();
                    double price = Double.parseDouble(parts[1].trim());
                    int calories = Integer.parseInt(parts[2].trim());
                    menuItems.add(new MenuItem(name, price, calories));
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
        return menuItems;
    }

    public static void processOrder(ArrayList<MenuItem> menuItems) {
        // Prompt customer for information
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter customer information:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Phone: ");
        String phone = scanner.nextLine();

        Customer customer = new Customer(name, email, phone);
        Order order = new Order(customer);

        // Display menu
        System.out.println("Menu:");
        printMenu(menuItems);

        // Add items to the order
        while (true) {
            System.out.print("Enter item name to order (or 'done' to finish): ");
            String itemName = scanner.nextLine();
            if (itemName.equalsIgnoreCase("done")) {
                break;
            }
            MenuItem item = findMenuItem(menuItems, itemName);
            if (item != null) {
                System.out.print("Enter quantity: ");
                int quantity = scanner.nextInt();
                order.addItem(item, quantity);
            } else {
                System.out.println("Item not found in menu.");
            }
        }

        // Calculate total and tax
        double total = order.calculateTotal();
        double tax = order.calculateTax(total);
        double grandTotal = total + tax;

        // Write receipt to file
        writeReceiptToFile(order, total, tax, grandTotal);
    }

    public static void printMenu(ArrayList<MenuItem> menuItems) {
        for (MenuItem item : menuItems) {
            System.out.println(item);
        }
    }

    public static MenuItem findMenuItem(ArrayList<MenuItem> menuItems, String name) {
        for (MenuItem item : menuItems) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

    public static void writeReceiptToFile(Order order, double total, double tax, double grandTotal) {
        String filename = order.getInvoiceID() + ".txt";
        try (PrintWriter writer = new PrintWriter(filename)) {
            writer.println("Customer: " + order.getCustomer().getName());
            writer.println("Invoice Number: " + order.getInvoiceID());
            writer.println("Date: " + order.getDate());
            writer.println("Item Quant Price Total");
            writer.println("====================================");
            for (OrderItem item : order.getCart()) {
                MenuItem menuItem = item.getMenuItem();
                int quantity = item.getQuantity();
                double price = menuItem.getPrice();
                double itemTotal = price * quantity;
                writer.printf("%-20s %d $%.2f $%.2f%n", menuItem.getName(), quantity, price, itemTotal);
            }
            writer.println("====================================");
            writer.printf("Subtotal  $%.2f%n", total);
            writer.printf("Tax (6%%)  $%.2f%n", tax);
            writer.printf("Order Total $%.2f%n", grandTotal);
        } catch (FileNotFoundException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
        System.out.println("Receipt saved to file: " + filename);
    }
}
