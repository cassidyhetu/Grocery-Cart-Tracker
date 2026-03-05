package grocerycarttracker;
import java.util.Scanner;

public class InputValidator {
	public int getValidInt(Scanner scanner) {

	       while (!scanner.hasNextInt()) {
	           System.out.print("Invalid input. Enter a number: ");
	           scanner.next();
	       }

	       return scanner.nextInt();
	   }

	   public double getValidDouble(Scanner scanner) {

	       while (!scanner.hasNextDouble()) {
	           System.out.print("Invalid input. Enter a number: ");
	           scanner.next();
	       }

	       return scanner.nextDouble();
	   }

}
