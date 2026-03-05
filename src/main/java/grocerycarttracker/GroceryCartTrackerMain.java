package grocerycarttracker;
import java.util.Scanner;

public class GroceryCartTrackerMain {

	private ShoppingCart cart;
    private Budget budget;
    private Menu menu;
    private InputValidator validator;
    private Scanner scanner;

    public GroceryCartTrackerMain() {
        cart = new ShoppingCart();
        budget = new Budget();
        menu = new Menu();
        validator = new InputValidator();
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        GroceryCartTrackerMain app = new GroceryCartTrackerMain();
        app.run();
    }

    public void run() {

        int choice;

        do {

            menu.display();
            choice = validator.getValidInt(scanner);

            switch (choice) {

                case 1:
                    addItem();
                    break;

                case 2:
                    removeItem();
                    break;

                case 3:
                    cart.viewCart();
                    break;

                case 4:
                    setBudget();
                    break;

                case 5:
                    checkout();
                    break;

                case 6:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid option.");
            }

        } while (choice != 6);
    }

    private void addItem() {

        scanner.nextLine(); // clear buffer before reading text

        System.out.print("Enter item name: ");
        String name = scanner.nextLine();

        System.out.print("Enter price: ");
        double price = validator.getValidDouble(scanner);

        System.out.print("Enter quantity: ");
        int quantity = validator.getValidInt(scanner);

        scanner.nextLine(); // clear buffer again

        System.out.print("Enter category: ");
        String category = scanner.nextLine();

        Item item = new Item(name, price, category);
        CartItem cartItem = new CartItem(item, quantity);

        cart.addItem(cartItem);

        System.out.println("Item added successfully.");
    }

    private void removeItem() {

        scanner.nextLine();

        System.out.print("Enter item name to remove: ");
        String name = scanner.nextLine();

        cart.removeItem(name);
    }

    private void setBudget() {

        System.out.print("Enter budget amount: ");
        double amount = validator.getValidDouble(scanner);

        budget.setBudget(amount);

        System.out.println("Budget set.");
    }

    private void checkout() {

        Receipt receipt = new Receipt(new TaxCalculator());
        receipt.printReceipt(cart, budget);
    }
}

