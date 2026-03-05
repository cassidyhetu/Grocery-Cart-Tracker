package grocerycarttracker;
public class TaxCalculator {
	private static final double TAX_RATE = 0.0625;

	   public double calculateTax(double subtotal) {
	       return subtotal * TAX_RATE;
	   }
}
