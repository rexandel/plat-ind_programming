public class Calculator {
	public static void main(String[] args)
	{
		CalculatorEngine calculator = new CalculatorEngine();
		System.out.println("2 + 2 = " + calculator.sum(2,2));
	}
	
	public static class Adder 
	{ 
		private int sum;
		
		public Adder()
		{
			sum = 0;
		}
		
		public Adder(int a)
		{
			this.sum = a;
		}
		
		public void add(int b) 
		{
			sum += b;
		}
		
		public int getSum()
		{
			return sum;
		}
	}
	
	public static class CalculatorEngine 
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
}
