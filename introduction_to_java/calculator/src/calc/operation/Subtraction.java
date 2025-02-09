package calc.operation;

public class Subtraction
{
	private double total;
	
	public Subtraction(double seed)
	{
		this.total = seed;
	}
	
	public void setTotal(double total)
	{
		this.total = total;
	}
	
	public double getTotal()
	{
		return total;
	}
	
	public void minus(double x) 
	{
		total -= x;
	}
}
