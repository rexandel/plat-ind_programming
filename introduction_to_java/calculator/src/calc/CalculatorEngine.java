package calc;
import calc.operation.Summation;
import calc.operation.Subtraction;
import calc.operation.Multiplication;
import calc.operation.Division;


public class CalculatorEngine 
{
	public double sum(double... terms)
	{
		Summation summator = new Summation(terms[0]);
		for (int i = 1; i < terms.length; i++)
		{
			summator.plus(terms[i]);
		}
		return summator.getTotal();
	}
	
	public double sub(double... terms)
	{
		Subtraction subtractor = new Subtraction(terms[0]);
		for (int i = 1; i < terms.length; i++)
		{
			subtractor.minus(terms[i]);
		}
		return subtractor.getTotal();
	}
	
	public double mul(double... terms)
	{
		Multiplication multiplicator = new Multiplication(terms[0]);
		for (int i = 1; i < terms.length; i++)
		{
			multiplicator.multiply(terms[i]);
		}
		return multiplicator.getTotal();
	}
	
	public double div(double... terms)
	{
		Division divider = new Division(terms[0]);
		for (int i = 1; i < terms.length; i++)
		{
			divider.divide(terms[i]);
		}
		return divider.getTotal();
	}
}
