package calc;

public class Calculator {
	public static void main(String[] args)
	{
		CalculatorEngine calculator = new CalculatorEngine();
		
		System.out.println("Calculator:");
		System.out.println("2 + 2 + 2 = " + calculator.sum(2, 2, 2));
		System.out.println("2 - 2 - 2 = " + calculator.sub(2, 2, 2));
		System.out.println("2 * 2 * 2 = " + calculator.mul(2, 2, 2));
		System.out.println("2 / 2 / 2 = " + calculator.div(2, 2, 2));
		
		System.out.println();
		
		System.out.println("3 + 4 + 2 = " + calculator.sum(3, 4, 2));
		System.out.println("3 - 4 - 2 = " + calculator.sub(3, 4, 2));
		System.out.println("3 * 4 * 2 = " + calculator.mul(3, 4, 2));
		System.out.println("3 / 4 / 2 = " + calculator.div(3, 4, 2));
	}
}
