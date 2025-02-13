package calc.operation;

public class IntegerBitwiseShiftRight
{
	private int total;
	
	public IntegerBitwiseShiftRight(int seed)
	{
		this.total = seed;
	}
	
	private void setTotal(int total)
	{
		this.total = total;
	}
	
	public int getTotal()
	{
		return total;
	}
	
	public void bitShift(int x) 
	{
		int totalAfterShift = total >> x;
		total = totalAfterShift;
	}
}
