
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




public class SearchByName extends JFrame implements ActionListener{
JLabel label;
JTextField fieldname;
JButton search,clear,cancel;
JPanel p,p1;
public SearchByName(){
	label=new JLabel("Enter Name");
	fieldname=new JTextField(20);
	search=new JButton("Search");
	search.addActionListener(this);
	clear=new JButton("Clear");
	clear.addActionListener(this);
	cancel=new JButton("Cancel");
	cancel.addActionListener(this);
	
	p=new JPanel();
	p.setLayout(new GridLayout(1,2));
	p.add(label);
	p.add(fieldname);
	
	p1=new JPanel();
	p1.setLayout(new GridLayout(1,3));
	p1.add(search); 
	p1.add(clear); 
	p1.add(cancel);
	
	add(p);
	add(p1);
	
	setTitle("Search By Name");
	setLayout(new FlowLayout());
	setVisible(true);
	setSize(500,150);
	setLocation(700,100);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
new SearchByName();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==search){
			DBConnection conn=new DBConnection();
			Connection con=conn.getDBConnection("studentinformation");
			String query="SELECT * FROM studentinfosystem where Student_Name="+"'"+fieldname.getText()+"'";
			String res="";
			ResultSet rs;
			try{
				Statement stmt=con.createStatement();
				rs=stmt.executeQuery(query);
				while(rs.next()){
					res+="Entrance number="+rs.getInt("Eno")+"\n"+"Roll number="+rs.getInt("Roll_Number")+"\n"+"Student Name="+rs.getString("Student_Name")+"\n"+"Gender="+rs.getString("Sex")+"\n"+"Father Name="+rs.getString("Father_Name")+"\n"+"Address="+rs.getString("Address")+"\n"+"Year="+rs.getString("Year")+"\n"+"Major="+rs.getString("Major")+"\n"+"Specialized_Subject="+rs.getString("Specialized_Subject")+"\n";
					
				}
				
				if(res.isEmpty())	
				{JOptionPane.showMessageDialog(this,"Student Information was not Found!",this.getTitle(),JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					JOptionPane.showMessageDialog(this, res,this.getTitle(),JOptionPane.INFORMATION_MESSAGE);			
				}
				con.close();	
			}catch(SQLException sqle){
				System.out.println("Error in  SQL Statement!" + sqle);
				
			}
			}
		if(e.getSource()==clear){
			fieldname.setText(" ");
		}
		if (e.getSource() == cancel) {
			int yn=JOptionPane.showConfirmDialog(this, "Are you sure to exit?","Confimation",JOptionPane.YES_NO_OPTION);
			if (yn==0) 
				setVisible(false);
				
			}
	}

}
