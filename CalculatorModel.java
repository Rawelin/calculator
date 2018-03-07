
public class CalculatorModel
{
	private double score;
		
    public void addNum(double left, double right)
    {
    	score = left + right;
    }
		   
   public double getScore()
   {
      return score;
   }

}
