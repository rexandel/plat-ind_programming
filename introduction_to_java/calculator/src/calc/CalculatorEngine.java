package calc;
import calc.operation.Adder;

public class CalculatorEngine 
{
	public int sum(int... a)
	{
		Adder adder = new Adder();
		for (int i:a)
		{
			adder.add(i);
		}
		return adder.getSum();
	}
}
