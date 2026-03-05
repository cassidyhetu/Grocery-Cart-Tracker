package grocerycarttracker;
public class Budget {
	 private double budgetLimit;

	   public void setBudget(double amount) {
	       budgetLimit = amount;
	   }

	   public double getRemaining(double total) {
	       return budgetLimit - total;
	   }

	   public boolean isOverBudget(double total) {
	       return total > budgetLimit;
	   }

	   public double getBudgetLimit() {
	       return budgetLimit;
	   }

}
