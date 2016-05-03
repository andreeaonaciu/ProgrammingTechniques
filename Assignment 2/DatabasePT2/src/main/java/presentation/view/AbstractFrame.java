package presentation.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class AbstractFrame extends JFrame{
	JPanel contentPanel;
	
	
	public AbstractFrame(String title)
	{
		super(title);
	
		
		setSize(300, 100);
 		setLayout(new BorderLayout());
 		setLocationRelativeTo(null);
 		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		
 		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBackground(Color.CYAN);
		add(contentPanel, BorderLayout.CENTER);
		
		setVisible(true);
		
    }
}
