import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class SimulatorFrame extends JFrame{

JPanel contentPanel;
	
	
	public SimulatorFrame(String title)
	{
		super(title);
	
		
		setSize(600, 600);
 		setLayout(new BorderLayout());
 		setLocationRelativeTo(null);
 		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		contentPanel = new JPanel();
 		add(contentPanel);
		setVisible(true);
		
    }
	//panel pentru fiecare task 
	
	void displayData(Task[] tasks)
	{
		contentPanel.removeAll();
		contentPanel.revalidate();
		JList<Task> list=new JList<Task>(tasks);
		JScrollPane sp=new JScrollPane(list);
		contentPanel.add(sp);
		contentPanel.repaint();
	    contentPanel.revalidate();	
	}
}
