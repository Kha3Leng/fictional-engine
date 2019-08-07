
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.sql.Statement;




public class Search_By_Entrance_number extends JFrame implements ActionListener{
	JLabel lblEno;
	JTextField tfEno;
	JButton btnSearch,btnClear,btnCancel;
	JPanel jpnEno,jpnButton;
	
	public Search_By_Entrance_number(){
		this.setTitle("Search By Entrance No ..");
		setLayout(new FlowLayout());
		this.setSize(500, 150);
		this.setVisible(true);
		this.setLocation(700,100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lblEno=new JLabel("Enter Entrance No : ");
		tfEno=new JTextField(15);
		btnSearch=new JButton("Search");
		btnClear=new JButton("Clear");
		btnCancel=new JButton("Cancel");

		jpnEno=new JPanel();
		jpnEno.setLayout(new GridLayout(1,2));
		jpnEno.add(lblEno);     
		jpnEno.add(tfEno);
		
		jpnButton=new JPanel();
		jpnButton.setLayout(new GridLayout(1,3));
		jpnButton.add(btnSearch);
		jpnButton.add(btnClear);
		jpnButton.add(btnCancel);
		
		add(jpnEno);
		add(jpnButton);
		
		btnSearch.addActionListener(this);
		btnClear.addActionListener(this);
		btnCancel.addActionListener(this);
		this.setVisible(true);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Search_By_Entrance_number();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==btnSearch){
			DBConnection dbConn=new DBConnection();
			Connection conn=dbConn.getDBConnection("studentinformation");
			try{
				Statement stmt=conn.createStatement();
				String query="SELECT * FROM studentinfosystem WHERE Eno="+tfEno.getText();
				ResultSet rs;
				String s = null;
				rs=stmt.executeQuery(query);
				while(rs.next()){
					s="Entrance Number = "+rs.getInt("Eno")+"\n"+
						"Roll Number = "+rs.getInt("Roll_Number")+"\n"+
						"Student Name = "+rs.getString("Student_Name")+"\n"+
						"Gender = "+rs.getString("Sex")+"\n"+
						"Father Name = "+rs.getString("Father_Name")+"\n"+
						"Address = "+rs.getString("Address")+"\n"+
						"Year = "+rs.getString("Year")+"\n"+
						"Major = "+rs.getString("Major")+"\n"+
						"Specilized Subject = "+rs.getString("Specialized_Subject");
				}
				if(s==null){
					JOptionPane.showMessageDialog(this, "Account Not Found !! ",this.getTitle(),JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					JOptionPane.showMessageDialog(this,s,this.getTitle(),JOptionPane.INFORMATION_MESSAGE);
				}
				conn.close();
			}
			catch(SQLException sqle){
				System.out.println("SQL Exception thrown: " + sqle);
			}
		}
		if(e.getSource()==btnClear){
			tfEno.setText("");
		}
		if (e.getSource() == btnCancel) {
			int yn=JOptionPane.showConfirmDialog(this, "Are you sure to exit?","Confimation",JOptionPane.YES_NO_OPTION);
			if (yn==0) 
				setVisible(false);
				
			}
	}

}
