package calc.operation;

public class Summation
{
	private double total;

	public Summation(double seed)
	{
		this.total = seed;
	}
	
	private void setTotal(double total)
	{
		this.total = total;
	}
	
	public double getTotal()
	{
		return total;
	}
	
	public void plus(double x) 
	{
		total += x;
	}
}
