package presentation.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class ViewFrame extends AbstractFrame {

	JTable table;
	String[] columns;
	String[][] info;
	JButton backB;
   
	public ViewFrame(String[][] info,String[] columns) {
		super("View");
		JPanel inter=new JPanel();
		contentPanel.setLayout(new FlowLayout());
		backB=new JButton("MENU");
		contentPanel.add(backB);
		inter.setLayout(new FlowLayout());
		contentPanel.add(inter);
		setSize(600, 600);
         this.info=info;
		table = new JTable(info, columns);

		table.setPreferredScrollableViewportSize(new Dimension(500, 500));
		table.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(table);
		inter.add(scrollPane);

	}

	public void setColumns(String[] columns) {
		this.columns = columns;
	}

	public void setInfo(String[][] info) {
		this.info = info;
	}
	
	public void setActionListenerBack(ActionListener a) {
 		this.backB.addActionListener(a);
 	}

}