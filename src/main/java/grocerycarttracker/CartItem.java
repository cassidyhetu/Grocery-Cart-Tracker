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
		   return "Item: " + item.getName() +
		           "\nPrice: $" + item.getPrice() +
		           "\nQuantity: " + quantity +
		           "\nTotal: $" + getTotalPrice() +
		           "\n---------------------";
	   }


}
