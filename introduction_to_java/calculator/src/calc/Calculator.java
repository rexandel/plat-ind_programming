package calc;

public class Calculator {
	public static void main(String[] args)
	{
		CalculatorEngine calculator = new CalculatorEngine();
		System.out.println("2 + 2 = " + calculator.sum(2,2));
	}
}
