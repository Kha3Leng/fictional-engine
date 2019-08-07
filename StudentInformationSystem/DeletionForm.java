import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DeletionForm extends JFrame implements ActionListener {
	JPanel p1,btnPanel;
	JLabel lbEntranceNo;
	JTextField tfEntranceNo;
	JButton btnSearch,btnDelete,btnCancel;
	
    String st,s;
    
	public DeletionForm(){
		this.setTitle("Deletion");
		setLayout(new FlowLayout());
		this.setSize(500, 150);
		this.setLocation(700, 100);
		this.setVisible(true);
		
		lbEntranceNo=new JLabel("Entrance No.");		
		tfEntranceNo = new JTextField(15);
		btnSearch = new JButton("Search");
		btnDelete = new JButton("Delete");
		btnDelete.setEnabled(false);
		btnCancel= new JButton("Cancel");
		btnSearch.addActionListener(this);
		btnDelete.addActionListener(this);
		btnCancel.addActionListener(this);
		p1=new JPanel();
		p1.setLayout(new GridLayout(1, 2));
		p1.add(lbEntranceNo);p1.add(tfEntranceNo);
		btnPanel=new JPanel();
		btnPanel.setLayout(new GridLayout(1, 3));
		btnPanel.add(btnSearch);btnPanel.add(btnDelete);btnPanel.add(btnCancel);
		add(p1);add(btnPanel);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new DeletionForm();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSearch) {
			DBConnection dbcon = new DBConnection();
			Connection con = dbcon.getDBConnection("studentinformation");
			try {
				Statement stmt = con.createStatement();
				String query = "Select * from StudentInfoSystem where ENo="+tfEntranceNo.getText();
				String s = null;
				
				ResultSet rs=stmt.executeQuery(query);
				while(rs.next()){
					s=rs.getInt("ENo")+","+rs.getInt("Roll_Number")+","+rs.getString("Student_Name")
							+","+rs.getString("Sex")+","+rs.getString("Father_Name")+","+rs.getString("Address")+","+rs.getString("Year")
							+","+rs.getString("Major")+","+rs.getString("Specialized_Subject");
				}
				if(s==null){
					JOptionPane.showMessageDialog(this,
							"Account was not found!", this.getTitle(),
							JOptionPane.INFORMATION_MESSAGE);
					btnDelete.setEnabled(false);
				}
				else{
					JOptionPane.showMessageDialog(this, "Student Information is\n\n"+s, this.getTitle(),
						JOptionPane.INFORMATION_MESSAGE);
					btnDelete.setEnabled(true);
				}
				
				con.close();
			} catch (SQLException sqle) {
				System.out.println("SQL Exception thrown: " + sqle);
			}			
		}					
		if(e.getSource()==btnDelete){
			DBConnection dbcon = new DBConnection();
			Connection con = dbcon.getDBConnection("studentinformation");
			try {
				Statement stmt = con.createStatement();
			int yn=JOptionPane.showConfirmDialog(this,
					"Are you sure to delete it?", this.getTitle(),
					JOptionPane.YES_NO_OPTION);
			if(yn==0){
				String query = "Delete from StudentInfoSystem where ENo="+tfEntranceNo.getText();
				stmt.executeUpdate(query);
				JOptionPane.showMessageDialog(this,
						"Account Deletion is Successful!", this.getTitle(),
						JOptionPane.INFORMATION_MESSAGE);
			}
			con.close();
			}catch (SQLException sqle) {
				System.out.println("SQL Exception thrown: " + sqle);
			}	
		}
		if (e.getSource() == btnCancel) {
			int yn=JOptionPane.showConfirmDialog(this, "Are you sure to exit?","Confimation",JOptionPane.YES_NO_OPTION);
			if (yn==0) 
				setVisible(false);
				
			}
		
	}
}
