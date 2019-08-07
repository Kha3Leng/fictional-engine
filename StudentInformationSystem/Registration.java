import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//to ask major and specialized sub


public class Registration extends JFrame implements ActionListener,FocusListener{

	JPanel jrbPanel,btnPanel,p,liPanel,all;
	JLabel lblEntranceNo,lblRollNo,lblStuName,lblSex,lblFatherName,lblAddress,lblYear,lblMajor,lblSpecialized;
	JTextField tfEntranceNo,tfRollNo,tfStuName,tfFatherName;
	JTextArea taAddress;
	JComboBox cbYear,cbMajor;
	JList liSpecialized;
	JButton btnRegister,btnClear,btnCancel;
	JRadioButton jrbS1,jrbS2;
	ButtonGroup bgSex;
	
	String sub[]={"Embedded System","Networking","Knowledge Engineering","Database","Software Engineering","Electronic Engineering"};
	String s;
	static int num=4;
	
	public Registration()
	{
		this.setTitle("Student Information");
		this.setLocation(700,100);
		this.setSize(500,500);
		
		
		lblEntranceNo=new JLabel("Entrance No");
		lblRollNo=new JLabel("Roll No");
		lblStuName=new JLabel("Student Name");
		lblSex=new JLabel("Sex");
		lblFatherName=new JLabel("Father Name");
		lblAddress=new JLabel("Address");
		lblYear=new JLabel("Class Year");
		lblMajor=new JLabel("Major");
		lblSpecialized=new JLabel("Specialized Subjects");
		
		
		tfEntranceNo=new JTextField(15);
		tfEntranceNo.setText(""+num);
		
		tfRollNo=new JTextField(15);
		tfRollNo.addFocusListener(this);
		
		tfStuName=new JTextField(15);
		tfStuName.addFocusListener(this);
		
		tfFatherName=new JTextField(15);
		taAddress=new JTextArea(2,15);
		
		bgSex=new ButtonGroup();
		jrbS1=new JRadioButton("Male");
		jrbS1.setSelected(true);
		s=jrbS1.getText();
		jrbS2=new JRadioButton("Female");
		
		bgSex.add(jrbS1);
		bgSex.add(jrbS2);
		
		jrbPanel=new JPanel();
		jrbPanel.add(jrbS1);
		jrbPanel.add(jrbS2);
		
		jrbS1.addActionListener(this);
		jrbS2.addActionListener(this);
			
		JScrollPane sp=new JScrollPane(taAddress);
		
		cbYear=new JComboBox();
		cbYear.addItem("First Year");
		cbYear.addItem("Second Year");
		cbYear.addItem("Third Year");
		cbYear.addItem("Fourth Year");
		cbYear.setSelectedIndex(0);
		
		cbMajor=new JComboBox();
		cbMajor.addItem("Computer Science");
		cbMajor.addItem("Computer Technology");
		cbMajor.setSelectedIndex(0);
		
		liSpecialized=new JList(sub);
		liSpecialized.setVisibleRowCount(3);
		JScrollPane lisp=new JScrollPane(liSpecialized);
		liPanel=new JPanel();
		liPanel.add(lisp);
	
		
		p=new JPanel();
		p.setLayout(new GridLayout(8,2));
		
		p.add(lblEntranceNo);	p.add(tfEntranceNo);
		p.add(lblRollNo);		p.add(tfRollNo);
		p.add(lblStuName);		p.add(tfStuName);
		p.add(lblSex);			p.add(jrbPanel);
		p.add(lblFatherName);	p.add(tfFatherName);
		p.add(lblAddress);		p.add(sp);
		p.add(lblYear);			p.add(cbYear);
		p.add(lblMajor);		p.add(cbMajor);
		
		JPanel p1=new JPanel();
		p1.setLayout(new GridLayout(1,2));
		p1.add(lblSpecialized);	p1.add(liPanel);
		
		btnRegister=new JButton("Register");
		btnClear=new JButton("Clear");
		btnCancel=new JButton("Cancel");
		
		btnRegister.addActionListener(this);
		btnClear.addActionListener(this);
		btnCancel.addActionListener(this);
		
		btnPanel=new JPanel();
	
		btnPanel.add(btnRegister);
		btnPanel.add(btnClear);
		btnPanel.add(btnCancel);
		
		all=new JPanel();
		all.add(p);
		all.add(p1);
		all.add(btnPanel);
		
		this.add(all);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Registration();
	}

	@Override
	public void focusGained(FocusEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==tfRollNo){
			if(tfRollNo.getText().isEmpty()){
				JOptionPane.showMessageDialog(null,"Please fill roll number",this.getTitle(),JOptionPane.WARNING_MESSAGE);
				tfRollNo.grabFocus();
			}
		}	
			if(arg0.getSource()==tfStuName){
				if(tfStuName.getText().isEmpty()){
				JOptionPane.showMessageDialog(null,"Please fill student name",this.getTitle(),JOptionPane.WARNING_MESSAGE);
				tfStuName.grabFocus();
				}
			}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jrbS1)
			s=jrbS1.getLabel();
		if(e.getSource()==jrbS2)
			s=jrbS2.getLabel();
		if(e.getSource()==btnRegister)
		{
			if(tfEntranceNo.getText().isEmpty()||tfRollNo.getText().isEmpty()||tfStuName.getText().isEmpty()||tfFatherName.getText().isEmpty()||taAddress.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null,"Please fill all account information",getTitle(),JOptionPane.WARNING_MESSAGE);
			}
			else
			{
				DBConnection dbcon=new DBConnection();
				Connection conn=dbcon.getDBConnection("studentinformation");
				try{
						Statement stmt=conn.createStatement();
					
						String query = "INSERT INTO StudentInfoSystem VALUES ("
								+ tfEntranceNo.getText() + ",'" + tfRollNo.getText()
								+ "','" + tfStuName.getText()+ "','" +s+ "','" + tfFatherName.getText()
								+ "','" + taAddress.getText()+"','"+cbYear.getSelectedItem()
								+"','"+cbMajor.getSelectedItem()
								+ "'," + liSpecialized.getSelectedIndex() + ")";
						
						stmt.executeUpdate(query);
						
						JOptionPane.showMessageDialog(this,"Student Registration is successful!",this.getTitle(),JOptionPane.INFORMATION_MESSAGE);
						conn.close();
				   }
				catch(SQLException sqle)
				{
					System.out.println("SQL Exception thrown: "+sqle);
				}
				num++;
				tfEntranceNo.setText(""+num);
				tfRollNo.setText("");
				tfStuName.setText("");
				tfFatherName.setText("");
				taAddress.setText(null);
				jrbS1.setSelected(true);
				cbYear.setSelectedIndex(0);
				cbMajor.setSelectedIndex(0);
				
				
				
			}
		}
		if(e.getSource()==btnClear)
		{
			tfEntranceNo.setText(""+num);
			tfRollNo.setText("");
			tfStuName.setText("");
			tfFatherName.setText("");
			taAddress.setText(null);
			jrbS1.setSelected(true);
			cbYear.setSelectedIndex(0);
			cbMajor.setSelectedIndex(0);
			liSpecialized.setSelectedIndex(0);
		}
		if(e.getSource()==btnCancel)
		{
			int yn=JOptionPane.showConfirmDialog(this,"Are you sure to exit?","Confimation",JOptionPane.YES_NO_OPTION);
			if(yn==0)
				setVisible(false);
		}
	}

}
