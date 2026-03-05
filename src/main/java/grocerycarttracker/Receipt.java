package grocerycarttracker;
public class Receipt {
	  private TaxCalculator taxCalculator;

	   public Receipt(TaxCalculator taxCalculator) {
	       this.taxCalculator = taxCalculator;
	   }

	   public void printReceipt(ShoppingCart cart, Budget budget) {

	       double subtotal = cart.calculateSubtotal();
	       double tax = taxCalculator.calculateTax(subtotal);
	       double total = subtotal + tax;

	       System.out.println("\n===== Receipt =====");

	       for (CartItem item : cart.getItems()) {
	           System.out.println(item);
	       }

	       System.out.println("---------------------");
	       System.out.println("Subtotal: $" + subtotal);
	       System.out.println("Tax: $" + tax);
	       System.out.println("Total: $" + total);

	       if (budget.getBudgetLimit() > 0) {
	           System.out.println("Remaining Budget: $" +
	                   budget.getRemaining(total));

	           if (budget.isOverBudget(total)) {
	               System.out.println("Warning: Over budget!");
	           }
	       }

	       System.out.println("=====================");
	  }

}
