import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class CalculatorGui extends JFrame
{
    private JPanel jPanel;
    private JTextField lcdScreen;
    private JButton one, two, three, four, five, six, seven, eight,
            nine, zero, addition, substraction, multiplication, division, equal, 
            comma, clear, sign, sqrt;
    
    
    private String stringNumber;
    private String stringScore;
    private char operation;
    private double left, right, score;
    private boolean isLeft;
    private boolean signFlag;
    private boolean commaFlag;

    
    public double getLeft()
    {
    	return left;
    }
    public double getRight()
    {
    	return right;
    }
    public char getChar()
    {
    	return operation;
    }
    
    public void setCalcSolution(double solution)
    {
    	lcdScreen.setText(Double.toString(solution));
    }
    
	public CalculatorGui()
	{
		createGui();
	}
	
	public void createGui()
	{
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 this.setLocationRelativeTo(null);
		 this.setResizable(false);
		 this.setTitle("Kalkulator");
		
		 stringNumber = "";
		 operation = ' ';
		 left = 0;
		 right = 0;
		 score = 0;
		 isLeft = false;
		 signFlag = false;
		 commaFlag = false;
			 
		 Font font = new Font("Digital", Font.BOLD, 20);
		 
		 jPanel = new JPanel();
		 jPanel.setLayout(new GridBagLayout());
		
		 
		 lcdScreen = new JTextField(20);
		// lcdScreen.setPreferredSize(new Dimension(100,20));
		 lcdScreen.setHorizontalAlignment(JTextField.RIGHT);
		 //lcdScreen.getText().length();
		 lcdScreen.setText("0");
		 lcdScreen.setCaretColor(Color.WHITE);
		 lcdScreen.setFont(font);
		 lcdScreen.setEditable(false);
		 
		 NumberListener numberListener = new NumberListener();
		 OperationListener operationListener = new OperationListener();
		 ClearListener clearListener = new ClearListener();
		 EqualListener equalListener = new EqualListener();
		 SpecialSignListener specialSignListener = new SpecialSignListener();
		 
		 addComp(jPanel, lcdScreen, 0, 0, 6, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		
		 seven = new JButton("7");
		 seven.addActionListener(numberListener);
		 addComp(jPanel, seven, 0, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
	    
		 eight = new JButton("8");
	     eight.addActionListener(numberListener);
     	 addComp(jPanel, eight, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		
     	 nine = new JButton("9");
     	 nine.addActionListener(numberListener);
		 addComp(jPanel, nine, 2, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		
		 division = new JButton("/");
		 division.addActionListener(operationListener);
		 addComp(jPanel, division, 3, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		 
		 four = new JButton("4");
		 four.addActionListener(numberListener);
		 
		 addComp(jPanel, four, 0, 2, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		
		 five = new JButton("5");
		 five.addActionListener(numberListener);
		 addComp(jPanel, five, 1, 2, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		
		 six = new JButton("6");
		 six.addActionListener(numberListener);
		 addComp(jPanel, six, 2, 2, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		
		 multiplication = new JButton("*");
		 multiplication.addActionListener(operationListener);
		 addComp(jPanel, multiplication, 3 ,2, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		
		 three = new JButton("3");
		 addComp(jPanel, three, 2, 3, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		 three.addActionListener(numberListener);
		 
		 two = new JButton("2");
		 addComp(jPanel, two, 1, 3, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		 two.addActionListener(numberListener);
		
		 one = new JButton("1");
		 addComp(jPanel, one, 0, 3, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		 one.addActionListener(numberListener);
		
		 substraction = new JButton("-");
		 addComp(jPanel, substraction, 3, 3, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		 substraction.addActionListener(operationListener);
		
		 clear = new JButton("C");
		 addComp(jPanel, clear, 2, 4, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);	
		 clear.addActionListener(clearListener);
		 
		 equal = new JButton("=");
		 addComp(jPanel, equal, 4, 3, 1, 2, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		 equal.addActionListener(equalListener);
		 addEqualListener(equalListener);
		
		 zero = new JButton("0");
		 addComp(jPanel, zero, 0, 4, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		 zero.addActionListener(numberListener);
		 
		 addition = new JButton("+");
		 addComp(jPanel, addition, 3, 4, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		 addition.addActionListener(operationListener);
		// addCalculationListener(operationListener);
		 
		 sign = new JButton("+/-");
		 addComp(jPanel, sign, 4,1, 1, 1,  GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		 sign.addActionListener(specialSignListener);
		 
		 comma = new JButton(",");
		 addComp(jPanel, comma, 1,4, 1, 1,  GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		 comma.addActionListener(specialSignListener);
		 
		 sqrt = new JButton("sqr");
		 addComp(jPanel, sqrt, 4,2, 1, 1,  GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		 sqrt.addActionListener(specialSignListener);
		 		 
		 framePosition();
		 this.add(jPanel);
		 this.setVisible(true);
	}
	
	private void framePosition()
	{
		Dimension screenSize = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
		this.setPreferredSize(new Dimension(250, 350));
		 
	    Dimension windowSize = new Dimension(this.getPreferredSize());
		
		int wdwLeft =  screenSize.width / 2 - windowSize.width / 2;
	    int wdwTop = screenSize.height / 2 - windowSize.height / 2;
	    
	    this.pack();   
	    this.setLocation(wdwLeft, wdwTop);
	}
	
	private void addComp(JPanel thePanel, JComponent comp, int xPos, int yPos, int compWidth, int compHeight, int place, int stretch)
	{
		GridBagConstraints gridConstraints = new GridBagConstraints();
		
		gridConstraints.gridx = xPos;
		gridConstraints.gridy = yPos;
		gridConstraints.gridwidth = compWidth;
		gridConstraints.gridheight = compHeight;
		gridConstraints.weightx = 50;
		gridConstraints.weighty = 100;
		gridConstraints.insets = new Insets(1,1,1,1);
		gridConstraints.anchor = place;
		gridConstraints.fill = stretch;
		
		thePanel.add(comp, gridConstraints);
	}
	
	
	private void leftAssignation()
	{
		
		if(!isLeft && signFlag)
		{
			isLeft = true;
			left = Double.parseDouble(lcdScreen.getText());
			
			stringNumber = "";	
		}		
	}
	
	private void cls()
	{
		stringNumber = "";
		operation = ' ';
		left = 0;
		right = 0;
		score = 0;
		isLeft = false;
		signFlag = false;
		commaFlag = false;
	}
	
	
	
	private void diagnostic()
	{
		System.out.println("isLeft: " + isLeft);
		System.out.println("left: " + left);
		System.out.println("right: " + right);
		System.out.println("score: " + score);
		System.out.println("stringscore: " + stringScore);
		System.out.println("stringNumber: " + stringNumber);
		System.out.println("sign: " + operation);
	}
	
	private String removeZeroDecimal(String stringNumber)
	{
		if(stringNumber.substring(stringNumber.length()-2).equals(".0")) 
	    {
	    	stringNumber=stringNumber.substring(0, stringNumber.length()-2);
	    }
		return stringNumber;
	}
	
	private void calculation()
	{
		if(!isLeft)
			return;
		
		
		if(!stringNumber.isEmpty())
			right = Double.parseDouble(stringNumber);	
	
			
		
        if(operation != ' ' && (!stringNumber.isEmpty()))
        {
        	switch(operation)
    		{
    			case '+':
    				score = left + right;
    				stringNumber = "" + score;
				   
    				stringScore = removeZeroDecimal(stringNumber);		
    				lcdScreen.setText(stringScore);
    			break;
    			case '-':
    				score = left - right;
    				stringNumber = "" + score;
				   
    				stringScore = removeZeroDecimal(stringNumber);		
    				lcdScreen.setText(stringScore);
    				
    			break;
    			case '*':
    					
    				score = left * right;
    				
    				stringNumber = "" + score;
				   
    				stringScore = removeZeroDecimal(stringNumber);	;				
    				lcdScreen.setText(stringScore);
    			break;
    			case '/':
    				if(right == 0 && left == 0)
    				{
    					lcdScreen.setText("0");
    				}
    				if(right == 0)
    				{
    					lcdScreen.setText("Operacja niedozwolona");
    					left = 0;
    					right = 0;
    				}
    				else
    				{
    					score = left / right;
    					stringNumber = "" + score;
    				   
        				stringScore = removeZeroDecimal(stringNumber);	
    					lcdScreen.setText(stringScore);
    					operation = ' ';
    				}
    					
    			break;
    		
    		}
    		 	  
    		//DecimalFormat df = new DecimalFormat("###.#");
    	  
    		stringNumber = "";
    		stringScore = " ";
    	    operation = ' ';
    	    
    	    left = 0;
    	    right = 0;
    	 
    	    isLeft = false;
    	   // diagnostic();
    		
        }    
	}
	private class SpecialSignListener implements ActionListener
	{

	
		public void actionPerformed(ActionEvent e) 
		{
			
			if(e.getSource() == comma)
			{
				if(!commaFlag)
				{
					stringNumber += ".";
					lcdScreen.setText(stringNumber);
					commaFlag = true;
				}	
			}
			if(e.getSource() == sign)
			{
				double digits = Double.parseDouble(lcdScreen.getText());
				
				
				if(digits != 0)
				{
					digits *= -1;
					
					stringNumber = "" + digits;
				    if(stringNumber.substring(stringNumber.length()-2).equals(".0")) 
				    {
				    	stringNumber=stringNumber.substring(0, stringNumber.length()-2);
				    }
					
					
			         lcdScreen.setText(stringNumber);
				}
				
			}
			
			if(e.getSource() == sqrt)
			{
				double digits = Double.parseDouble(lcdScreen.getText());
					
				if(digits >= 0)
				{
					digits = Math.sqrt(digits);
					
					stringNumber = "" + digits;
				    if(stringNumber.substring(stringNumber.length()-2).equals(".0")) 
				    {
				    	stringNumber=stringNumber.substring(0, stringNumber.length()-2);
				    }
					
			        lcdScreen.setText(stringNumber);
				}
				else
					lcdScreen.setText("Nieprawid³owe dane");
							
			}
			
		}
		
	}
	
	
	private class OperationListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			if(signFlag == true)
			{
				if(e.getSource() == division)
				{
					calculation();	
					operation = '/';
					leftAssignation();
				}
				if(e.getSource() == multiplication)
				{			
					calculation();	
					operation = '*';
					leftAssignation();
					
				}
				if(e.getSource() == substraction)
				{
					calculation();	
					operation = '-';
					leftAssignation();
				}
				if(e.getSource() == addition)
				{
					calculation();	
					operation = '+';
					leftAssignation();	
				}
				if(e.getSource() == equal)
				{
					calculation();	
				}
				commaFlag = false;
			}
			
		}
			
	}
	
	private class EqualListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			if(e.getSource() == equal)
			{
				calculation();			
			}
			
		}
		
	}
	
	private class ClearListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			
			if(e.getSource() == clear)
			{
				cls();
				lcdScreen.setText("0");
			}
		}
		
	}
	
    private class NumberListener implements ActionListener
    {
		public void actionPerformed(ActionEvent e) 
		{
			
			if(stringNumber.length() < 15)
			{
				if(e.getSource() == one)
				{
					stringNumber += "1";
					lcdScreen.setText(stringNumber);	
				}
				else if(e.getSource() == two)
				{
					stringNumber += "2";
					lcdScreen.setText(stringNumber);
				}
				else if(e.getSource() == three)
				{
					stringNumber += "3";
					lcdScreen.setText(stringNumber);
				}
				else if(e.getSource() == four)
				{
					stringNumber += "4";
					lcdScreen.setText(stringNumber);	
				}
				else if(e.getSource() == five)
				{
					stringNumber += "5";
					lcdScreen.setText(stringNumber);
				}
				else if(e.getSource() == six)
				{
					stringNumber += "6";
					lcdScreen.setText(stringNumber);
				}
				else if(e.getSource() == seven)
				{
					stringNumber += "7";
					lcdScreen.setText(stringNumber);
				}
				else if(e.getSource() == eight)
				{
					stringNumber += "8";
					lcdScreen.setText(stringNumber);
				}
				else if(e.getSource() == nine)
				{
					stringNumber += "9";
					lcdScreen.setText(stringNumber);
				}
				else if(e.getSource() == zero)
				{
					stringNumber += "0";
					lcdScreen.setText(stringNumber);
				}	
			}
			signFlag = true;
		
		}	
    }
    public void addEqualListener(ActionListener listenForCalcButton)
    {
    	
    	equal.addActionListener(listenForCalcButton);
    		
    }
    public void addCalculationListener(ActionListener listenForCalcButton)
    {
    	
    	addition.addActionListener(listenForCalcButton);
    		
    }
}
