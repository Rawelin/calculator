import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorControler 
{
	private CalculatorGui theView;
	private CalculatorModel theModel;
	
	public CalculatorControler(CalculatorGui theView, CalculatorModel theModel)
	{
		this.theView = theView;
		this.theModel = theModel;
		
		
		this.theView.addEqualListener(new CalculateListener());
		
	}
	class CalculateListener implements ActionListener
	{

		public void actionPerformed(ActionEvent e) 
		{
			double left = 0;
			double right = 0;
			
			try
			{
				left = theView.getLeft();
				right = theView.getRight();
				
				theModel.addNum(left, right);
				
				theView.setCalcSolution(theModel.getScore());
			}
			catch(NumberFormatException ex)
			{
				
			}
			
		}
		
	}
	
}
