

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class MainPage extends JFrame implements ActionListener, ItemListener{
	JMenu mnuInfo,mnuTrans,mnuHelp;
	JMenuItem RegiItem,deleteItem,exitItem, SearchEntItem, SearchNameItem, UpdateItem,aboutItem;
	JMenuBar mmb;
	JPanel pp;
	public  MainPage () {
		super("Student Information System");
		RegiItem=new JMenuItem("Registration");
		deleteItem=new JMenuItem("Deletion");
		exitItem=new JMenuItem("Exit");
		RegiItem.setFont(new Font("Serif",Font.BOLD,17));
		deleteItem.setFont(new Font("Serif",Font.BOLD,17));
		exitItem.setFont(new Font("Serif",Font.BOLD,17));
		
		mnuInfo = new JMenu("Student Information ");
		mnuInfo.setMnemonic(KeyEvent.VK_R);
		mnuInfo.add(RegiItem);
		mnuInfo.add(deleteItem);
		mnuInfo.addSeparator();
		mnuInfo.add(exitItem);
			
		
		RegiItem.addActionListener(this);
		deleteItem.setMnemonic(KeyEvent.VK_D);
		deleteItem.addActionListener(this);
		exitItem.setAccelerator(
		KeyStroke.getKeyStroke(KeyEvent.VK_E, Event.CTRL_MASK));		
		exitItem.setMnemonic(KeyEvent.VK_E);
		exitItem.addActionListener(this);
		
		SearchEntItem=new JMenuItem("Search By Student Entrance Number");
		SearchNameItem=new JMenuItem("Search By Student Name");
		UpdateItem=new JMenuItem("Update Student Information");
		SearchEntItem.setFont(new Font("Serif",Font.BOLD,17));
		SearchNameItem.setFont(new Font("Serif",Font.BOLD,17));
		UpdateItem.setFont(new Font("Serif",Font.BOLD,17));
	
		
		mnuTrans = new JMenu("Transaction");
		mnuTrans.setMnemonic(KeyEvent.VK_T);
		mnuTrans.add(SearchEntItem);
		mnuTrans.add(SearchNameItem);
		mnuTrans.addSeparator();
		mnuTrans.add(UpdateItem);	
		
		SearchEntItem.setMnemonic(KeyEvent.VK_N);
		SearchEntItem.addActionListener(this);
		SearchNameItem.setMnemonic(KeyEvent.VK_S);
		SearchNameItem.addActionListener(this);
		UpdateItem.setMnemonic(KeyEvent.VK_U);
		UpdateItem.addActionListener(this);
		
	
		aboutItem=new JMenuItem("About the System");
		aboutItem.setFont(new Font("Serif",Font.BOLD,17));
		mnuHelp = new JMenu("Help");
		mnuHelp.setMnemonic(KeyEvent.VK_H);
		mnuHelp.add(aboutItem);
		
		aboutItem.setMnemonic(KeyEvent.VK_A);
		aboutItem.addActionListener(this);
		
		
		
		
		mmb = new JMenuBar();
		mmb.add(mnuInfo);
		mmb.add(mnuTrans);
		mmb.add(mnuHelp);
		mnuInfo.setFont(new Font("Serif",Font.BOLD,20));
		mnuInfo.setForeground(Color.BLACK);
		mnuTrans.setFont(new Font("Serif",Font.BOLD,20));
		mnuTrans.setForeground(Color.BLACK);
		mnuHelp.setFont(new Font("Serif",Font.BOLD,20));
		mnuHelp.setForeground(Color.BLACK);
		mmb.setBackground(Color.PINK);
		
		setJMenuBar(mmb);
		JPanel panel=new JPanel();
		panel.setLayout(new GridLayout(3,1));
		JLabel label1=new JLabel("***********************************");
		JLabel label2=new JLabel("Student Information");
		JLabel label3=new JLabel("       System");
		label1.setFont(new Font("Serif",Font.BOLD,75));
		label1.setForeground(Color.RED);
		label2.setFont(new Font("Comic Sans Ms",Font.BOLD,60));
		label2.setForeground(Color.RED);
		label3.setFont(new Font("Comic Sans Ms",Font.BOLD,60));
		label3.setForeground(Color.RED);
		panel.add(label2);
		panel.add(label3);
		panel.add(label1);
		panel.setBackground(Color.WHITE);
		add(panel);
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setSize(getMaximumSize());
		setVisible(true);
	
		
		
	}
	public static void main(String[] args) {
		new  MainPage ();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==exitItem)
		    System.exit(0);
	if(e.getSource()==RegiItem)
	new Registration();
		if(e.getSource()==deleteItem)
			new DeletionForm();
		if(e.getSource()== SearchEntItem)
			new Search_By_Entrance_number();
		if(e.getSource()==SearchNameItem)
			new SearchByName();
		if(e.getSource()==UpdateItem)
			new UpdateForm();
		if(e.getSource()==aboutItem)
			new AboutTheSystem();
	}
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	

}
