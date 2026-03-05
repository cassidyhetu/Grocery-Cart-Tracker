package java;
import grocerycarttracker.Budget;
import grocerycarttracker.CartItem;
import grocerycarttracker.Item;
import grocerycarttracker.ShoppingCart;
import grocerycarttracker.TaxCalculator;

public class TestRunner {
	public static void main(String[] args) {

		System.out.println("===== RUNNING TEST CASES =====\n");

			testTaxCalculator();
			testCartItemTotal();
			testShoppingCartSubtotal();
			testBudgetUnderLimit();
			testBudgetOverLimit();

		System.out.println("\n===== TESTING COMPLETE =====");
			}

			// Test 1: Tax Calculation
		private static void testTaxCalculator() {

			TaxCalculator taxCalc = new TaxCalculator();
			double subtotal = 100.00;
			double expectedTax = 6.25; // 100 × 0.0625
			double actualTax = taxCalc.calculateTax(subtotal);

			if (Math.abs(expectedTax - actualTax) < 0.0001) {
				System.out.println("TestTaxCalculator: PASS");
			} else {
				System.out.println("TestTaxCalculator: FAIL");
			}
		}

			// Test 2: CartItem Total
		private static void testCartItemTotal() {

			Item item = new Item("Milk", 3.50, "Dairy");
			CartItem cartItem = new CartItem(item, 2);

			double expected = 7.00;
			double actual = cartItem.getTotalPrice();

			if (Math.abs(expected - actual) < 0.0001) {
				System.out.println("TestCartItemTotal: PASS");
			} else {
				System.out.println("TestCartItemTotal: FAIL");
			}
		}

			// Test 3: ShoppingCart Subtotal
		private static void testShoppingCartSubtotal() {

			ShoppingCart cart = new ShoppingCart();

			Item apples = new Item("Apples", 2.00, "Fruit");
			Item bread = new Item("Bread", 4.00, "Bakery");

			cart.addItem(new CartItem(apples, 3)); // 6
			cart.addItem(new CartItem(bread, 2)); // 8

			double expected = 14.00;
			double actual = cart.calculateSubtotal();

			if (Math.abs(expected - actual) < 0.0001) {
				System.out.println("TestShoppingCartSubtotal: PASS");
			} else {
				System.out.println("TestShoppingCartSubtotal: FAIL");
			}
		}

			// Test 4: Budget Under Limit
		private static void testBudgetUnderLimit() {

			Budget budget = new Budget();
			budget.setBudget(50.00);

			double total = 20.00;

			if (!budget.isOverBudget(total)) {
				System.out.println("TestBudgetUnderLimit: PASS");
			} else {
				System.out.println("TestBudgetUnderLimit: FAIL");
			}
		}



			// Test 5: Budget Over Limit
		private static void testBudgetOverLimit() {

			Budget budget = new Budget();
			budget.setBudget(10.00);

			double total = 20.00;

			if (budget.isOverBudget(total)) {
				System.out.println("TestBudgetOverLimit: PASS");
			} else {
				System.out.println("TestBudgetOverLimit: FAIL");
			}
		}
	}
