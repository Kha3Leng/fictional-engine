

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class AboutTheSystem extends JFrame implements ActionListener {
	JPanel aboutPanel, componentPanel;
	JButton btnHelp;
	JLabel lblSearch;

	public AboutTheSystem() {
		this.setTitle("About the Student Information System");
		this.setSize(400, 100);
		this.setLocation(700, 100);
		this.setVisible(true);
		
		componentPanel = new JPanel();
		componentPanel.setLayout(new FlowLayout());
		lblSearch=new JLabel("Click Here if you want help");
		componentPanel.add(lblSearch);
		btnHelp = new JButton("Help");
		btnHelp.setMnemonic(KeyEvent.VK_H);
		btnHelp.addActionListener(this);
		componentPanel.add(btnHelp);
		add(componentPanel);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnHelp) 
			setVisible(false);
			new AboutTheSystemMsg();
		
	}
		
		
	

	public static void main(String args[]) {
		new AboutTheSystem();
	}

}