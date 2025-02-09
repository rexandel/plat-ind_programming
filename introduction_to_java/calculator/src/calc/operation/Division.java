package calc.operation;

public class Division
{
	private double total;
	
	public Division(double seed)
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
	
	public void divide(double x) 
	{
		total /= x;
	}
}
