package calc.operation;

public class Multiplication
{
	private double total;
	
	public Multiplication(double seed)
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
	
	public void multiply(double x) 
	{
		total *= x;
	}
}
