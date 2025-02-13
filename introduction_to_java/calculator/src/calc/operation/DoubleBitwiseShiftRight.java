package calc.operation;

public class DoubleBitwiseShiftRight
{
	private double total;
	
	public DoubleBitwiseShiftRight(double seed)
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
	
	public void bitShift(int x) 
	{
		long bits = Double.doubleToLongBits(total);
		long bitsAfterShift = bits >> x;
		total = Double.longBitsToDouble(bitsAfterShift);
	}
}
