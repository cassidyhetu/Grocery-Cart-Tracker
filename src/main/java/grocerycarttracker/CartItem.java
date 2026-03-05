package grocerycarttracker;
public class CartItem {
	 private Item item;
	   private int quantity;

	   public CartItem(Item item, int quantity) {
	       this.item = item;
	       this.quantity = quantity;
	   }

	   public double getTotalPrice() {
	       return item.getPrice() * quantity;
	   }

	   public Item getItem() {
	       return item;
	   }

	   public String toString() {
	       return item.getName() + " | $" + item.getPrice() +
	              " | Qty: " + quantity +
	              " | Total: $" + getTotalPrice();
	   }


}
