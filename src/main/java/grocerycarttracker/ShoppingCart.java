package grocerycarttracker;
import java.util.ArrayList;

public class ShoppingCart {
	private ArrayList<CartItem> items;

	   public ShoppingCart() {
	       items = new ArrayList<>();
	   }

	   public void addItem(CartItem item) {
	       items.add(item);
	   }

	   public void removeItem(String name) {

	       for (CartItem item : items) {
	           if (item.getItem().getName().equalsIgnoreCase(name)) {
	               items.remove(item);
	               System.out.println("Item removed.");
	               return;
	           }
	       }

	       System.out.println("Item not found.");
	   }

	   public double calculateSubtotal() {
	       double subtotal = 0;
	       for (CartItem item : items) {
	           subtotal += item.getTotalPrice();
	       }
	       return subtotal;
	   }

	   public void viewCart() {

	       if (items.isEmpty()) {
	           System.out.println("Cart is empty.");
	           return;
	       }

	       for (CartItem item : items) {
	           System.out.println(item);
	       }

	       System.out.println("Subtotal: $" + calculateSubtotal());
	   }

	   public ArrayList<CartItem> getItems() {
	       return items;
	   }


}
