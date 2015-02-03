package tempcalc.gui;
//Successful


 import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TCFrame extends JFrame 
{
	static final long serialVersionUID = 1;
	private TCPanel currentPanel;									//fetching predefined structure from TCPanel
	
	public void start()												//initial conditions for the window
	{
		this.setVisible(true);
		this.setSize(475,400);
		this.setTitle("Temp-Calc 1.4");
		this.setResizable(false);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() 					//confirm exit
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				  try
				  {
					  int confirm = JOptionPane.showConfirmDialog(null,"Do you want to exit TempCalc ? ","Confirm Exit",JOptionPane.YES_NO_OPTION);
					  if( confirm == JOptionPane.YES_OPTION )
						  dispose();
			
				  }catch(Exception E)
				  {
					  dispose();
				  }
			}
		});
	
	}
	
	public TCFrame()												//instantiate the TCpanel
	{
		currentPanel = new TCPanel();
		setupFrame();
	}
	private void setupFrame()
	{
		this.setContentPane(currentPanel);						 	 //replace blank pane with fetched panel
	}

}