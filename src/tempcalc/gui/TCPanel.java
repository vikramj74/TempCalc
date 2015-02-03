package tempcalc.gui;
//Successful


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;

import javax.swing.SwingConstants;
import javax.swing.JOptionPane;

public class TCPanel extends JPanel 
{
	//declaration for every element in the panel
	static final long serialVersionUID = 0;
	private JLabel Label1 , Label2, Label3, Label4, Label5, Label6 ;
	private JButton Button1, Button2;
	private JFormattedTextField Field1, Field2 , Field3, Field4 ;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnFarenhieght , rdbtnKelvin , rdbtnCelcius;
	String HelpString = "\nTemp-Calc is a program which allows you to convert one temprature from one unit into two other units."
						+ "\nThe Three temprature units are degree celcius , farenhiet and Kelvin.\n\nSTEPS TO USE Temp-Calc : "
						+ "\n  1. Choose the input unit from the 'Choose input unit ' section."
						+ "\n  2. Input the temprature in selecteed unit into the 'Input Temprature Here ' field."
						+ "\n  3. Click on the 'CALCULATE' button."
						+ "\n  4. The corresponding tempratures can be noted down under the respective labels.\n" ;
	
	
	public TCPanel() 
	{
		
		//radio button init
		rdbtnFarenhieght = new JRadioButton("Farenhiet");
		rdbtnKelvin = new JRadioButton("Kelvin");
		rdbtnCelcius = new JRadioButton("Celsius");
		
		//label init
		Label1 = new JLabel("Input Temprature Here : ");
		Label2 = new JLabel("Kelvin");
		Label3 = new JLabel("Celcius");
		Label4 = new JLabel("Farenhiet");
		Label5 = new JLabel("Choose input unit :");
		Label6 = new JLabel("DEVELOPED AND TESTED BY : Vikram Jaswal");
		
		
		//button init
		Button1 = new JButton("CALCULATE");
		Button2 = new JButton("Help");
		
		
		
		//text field init
		Field1 = new JFormattedTextField("temprature here");
		Field2 = new JFormattedTextField("output in kelvin");
		Field3 = new JFormattedTextField("output in celcius");
		Field4 = new JFormattedTextField("output in farenhiet");
		
		
		//setup operations
		setupButtonGroup();
		setupPanel();
		setupLayout();
		setupListeners();
		setupEditable();
	
	}
	private void setupEditable()
	{
		Field2.setEditable(false);
		Field3.setEditable(false);
		Field4.setEditable(false);
		
	}
	private void setupListeners()
	{
		//CALCULATE
		Button1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
			 try{
				 

			  calculate();										//operates logic
			 }catch (Exception E)
			 {
				 
				 //awesome error message
				 Field2.setText("INPUT");
				 Field3.setText("IS NOT");
				 Field4.setText("VALID");
			 }
			}
		});
		
		//Help
		Button2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				
				try
				  { 
					JOptionPane.showMessageDialog(null,HelpString,"Temp-Calc Help",JOptionPane.INFORMATION_MESSAGE);
				  }catch(Exception E)
				  {
					JOptionPane.showMessageDialog(null, "Error");
				  }
			
			}
		});
	
	
	}
	private void setupLayout()
	{
		
		//radio buttons
		rdbtnFarenhieght.setBounds(58, 80, 121, 23);
		rdbtnKelvin.setBounds(58, 144, 83, 36);
		rdbtnCelcius.setBounds(58, 115, 107, 36);
		rdbtnCelcius.setVerticalAlignment(SwingConstants.TOP);
		
		//labels
		Label1.setBounds(44, 20, 154, 14);
		Label2.setBounds(47, 215, 51, 14);
		Label3.setBounds(175, 215, 51, 14);
		Label4.setBounds(301, 215, 76, 14);
		Label5.setBounds(44, 59, 135, 14);
		Label6.setBounds(190,285,304,20);
		
		//buttons
		Button1.setBounds(280, 115, 115, 23);
		Button2.setSize(59, 23);
		Button2.setLocation(335, 16);
		
		//text fields
		Field1.setBounds(189, 17, 115, 20);
		Field2.setBounds(20, 240, 105, 20);
		Field3.setBounds(146, 240, 105, 20);
		Field4.setBounds(280, 240, 115, 20);
		
		
		
		
	}
	private void setupButtonGroup()
	{
		buttonGroup.add(rdbtnFarenhieght);
		buttonGroup.add(rdbtnKelvin);
		buttonGroup.add(rdbtnCelcius);
	}
	private void setupPanel()
	{
		setLayout(null);
		this.add(rdbtnFarenhieght);
		this.add(rdbtnCelcius);
		this.add(rdbtnKelvin);
		this.add(Label1);
		this.add(Field1);
		this.add(Label2);
		this.add(Label3);
		this.add(Label4);
		this.add(Field2);
		this.add(Field3);
		this.add(Field4);
		this.add(Button1);
		this.add(Button2);
		this.add(Label5);
		this.add(Label6);
		rdbtnFarenhieght.setSelected(true);
		
	}
	private void calculate()
	{
		
		
		//actual logic for the application
		
		double input = Double.parseDouble(Field1.getText());
		double celcius = 0  , farenhiet = 0 , kelvin = 0;
		if(rdbtnCelcius.isSelected())
		{
			celcius = input;
			kelvin = celcius + 273.15;
			farenhiet =  (celcius*1.8) + 32;
		}
		if(rdbtnFarenhieght.isSelected())
		{
			farenhiet = input;
			celcius = (farenhiet - 32)/1.8;
			kelvin = celcius + 273.15;
		}
		if(rdbtnKelvin.isSelected())
		{
			kelvin = input ;
			celcius = kelvin - 273.15 ;
			farenhiet = (celcius*1.8) +32;
		}
		
		//rounding off to 5 decimal places
		DecimalFormat p5 = new DecimalFormat("#.#####");
		String CelS = p5.format(celcius);
		String FarS = p5.format(farenhiet);
		String KelS = p5.format(kelvin);
		
		Field2.setText(KelS);
		Field3.setText(CelS);
		Field4.setText(FarS);
	}

}