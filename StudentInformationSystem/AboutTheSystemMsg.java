

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class AboutTheSystemMsg extends JFrame{
	
	JPanel msgPanel;
	JTextArea taMsg;
	
	public AboutTheSystemMsg(){
		this.setTitle("Help about the Student Information System");
		this.setSize(550, 550);
		this.setLocation(700, 80);
		this.setVisible(true);
		taMsg=new JTextArea();
		
		msgPanel=new JPanel();
		msgPanel.setLayout(new FlowLayout(3));
		add(msgPanel);
		taMsg.append("1.Student  information System");
		taMsg.append("\n1.1Registration");
		taMsg.append("\nYou first fill the registration form and click the Registerbutton ;your account will be registered.");					
		taMsg.append("\n\n1.2 Deletion");
		taMsg.append("\nEnter the entrance number that you want to delete and click the Delete button.");						
		taMsg.append("\n\n2. Transaction");						
		taMsg.append("\n2.1 Search by entrance number");							
		taMsg.append("\nEnter the entrance number that you want to search and click the Search button,");						
		taMsg.append("\nYour account information will appear on the message box.");								
		taMsg.append("\n\n2.2 Search by name");						
		taMsg.append("\nEnter your name that you want to search and click the Search button,");						
		taMsg.append("\nYour account information will appear on the message box.");						
		taMsg.append("\n\n2.3 Update");						
		taMsg.append("\nEnter your  entrance no");						
		taMsg.append("\nWhen the cursor is focused out Entrance No.textfield ,your information will be displayed .");						
		taMsg.append("\nClick the Update button and enter your new address.");						
		taMsg.append("\nClick OK button and your new address will update.	");
		taMsg.setFont(new Font("Serif",Font.BOLD,20));
		JScrollPane addressScrollPane = new JScrollPane(taMsg);
		add(addressScrollPane);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AboutTheSystemMsg();
	}

}
