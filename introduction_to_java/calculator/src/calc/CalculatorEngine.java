package calc;
import calc.operation.Summation;
import calc.operation.Subtraction;
import calc.operation.Multiplication;
import calc.operation.Division;
import calc.operation.IntegerBitwiseShiftRight;
import calc.operation.DoubleBitwiseShiftRight;

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
		try
		{
			Division divider = new Division(terms[0]);
			
			for (int i = 1; i < terms.length; i++)
			{
				if (terms[i] == 0)
				{
					throw new ArithmeticException("Division by zero is not possible!");
				}
				divider.divide(terms[i]);
			}
			return divider.getTotal();
		}
		catch (ArithmeticException e)
		{
			System.err.println("Error: " + e.getMessage());
			System.exit(0);
			return Double.NaN;
		}
	}
	
	public double intBitShift(double term, int shiftCount)
	{
		IntegerBitwiseShiftRight specialOperation = new IntegerBitwiseShiftRight((int) term);
		specialOperation.bitShift(shiftCount);
		return specialOperation.getTotal();
	}
	
	public double doubleBitShift(double term, int shiftCount)
	{
		DoubleBitwiseShiftRight specialOperation = new DoubleBitwiseShiftRight(term);
		specialOperation.bitShift(shiftCount);
		return specialOperation.getTotal();
	}
}
