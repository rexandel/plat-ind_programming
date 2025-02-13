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
		
		System.out.println();
		
		System.out.println("Special operations:");
		System.out.println("3.124 >d> 2 = " + calculator.doubleBitShift(3.124, 2));
		System.out.println("3.124 >i> 0 = " + calculator.intBitShift(3.124, 0));
		System.out.println("128.146 >i> 3 = " + calculator.intBitShift(128.146, 3));
		System.out.println("56.12 >i> 2 = " + calculator.intBitShift(56.12, 2));
		
		System.out.println();
		
		System.out.println("An attempt to divide by zero:");
		System.out.println("3 / 4 / 0 = " + calculator.div(3, 4, 0));
	}
}
