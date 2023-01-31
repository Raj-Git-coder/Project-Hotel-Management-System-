package hms;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CheckOutDetails implements ActionListener 
{
	JPanel p2;
	JButton b1, b2, b3;
	JTextField t1, t2, t3;
	JComboBox<String> com1;
	public CheckOutDetails() 
	{
		p2=new JPanel();
        p2.setLayout(null);
        p2.setBackground(Color.white);
        p2.setBounds(201, 31, 450, 561);
        
        JLabel title=new JLabel("Check-out Details");
        title.setBounds(100, 0, 150, 50);
        title.setFont(new Font("Tahoma",Font.PLAIN,14));
        p2.add(title);
        
        JLabel guestId=new JLabel("Guest Id:");
        guestId.setBounds(30, 40, 100, 50);
        guestId.setFont(new Font("Tahoma",Font.PLAIN,14));
        p2.add(guestId);
        
        com1=new JComboBox<String>();
        try
        {
        	ConnectingDatabase conn =new ConnectingDatabase();
        	ResultSet rs = conn.statement.executeQuery("select * from CustomerTable");
        	
        	while(rs.next())
        	{
        		com1.addItem(rs.getString("IDNUMBER"));
        	}
        	conn.statement.close();
        	conn.connection.close();
        	
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
        
        com1.setBounds(150, 51, 150, 26);
        com1.setBackground(Color.white);
        com1.setFocusable(false);
        p2.add(com1);
        
        JLabel guestName = new JLabel("Guest Name:");
        guestName.setBounds(30, 90, 100, 50);
        guestName.setFont(new Font("Tahoma",Font.PLAIN,14));
        p2.add(guestName);
        
        t1=new JTextField();
        t1.setBounds(150, 101, 120, 26);
        t1.setFont(com1.getFont());
        p2.add(t1);
        
        JLabel roomNo=new JLabel("Room no.:");
        roomNo.setBounds(30, 140, 100, 50);
        roomNo.setFont(new Font("Tahoma",Font.PLAIN,14));
        p2.add(roomNo);

        
        t2=new JTextField();
        t2.setBounds(150, 151, 120, 26);
        t2.setBackground(Color.white);  
        t2.setFont(com1.getFont());
        p2.add(t2);
        
        
        JLabel pendingAmount=new JLabel("Pending Amount:");
        pendingAmount.setBounds(30, 190, 120, 50);
        pendingAmount.setFont(new Font("Tahoma",Font.PLAIN,14));
        p2.add(pendingAmount);
        
        t3=new JTextField();
        t3.setBounds(150, 201, 120, 26);
        t3.setBackground(Color.white);  
        t3.setFont(com1.getFont());
        p2.add(t3);
        
        b1=new JButton("Update");
        b1.setBounds(50, 410, 80, 25);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setFocusPainted(false);
        b1.setBorderPainted(false);
        b1.addActionListener(this);
        p2.add(b1);
  
        
          
        b2=new JButton("Clear");
        b2.setBounds(150, 410, 80, 25);
        b2.setBackground(new Color(228,52,52));
        b2.setForeground(Color.white);
        b2.setFocusPainted(false);
        b2.setBorderPainted(false);
        b2.addActionListener(this);
        p2.add(b2);
        
        b2.addMouseListener(new MouseAdapter() 
        {
        	public void mouseClicked(MouseEvent e)
        	{
        		t1.setText("");
        		com1.setSelectedIndex(0);
        		t2.setText("");
        		t3.setText("");
        	}
		});
        
        b3=new JButton("Check");
        b3.setBounds(190, 233, 80, 25);
        b3.setBackground(new Color(13,116,231));
        b3.setForeground(Color.white);
        b3.setFocusPainted(false);
        b3.setBorderPainted(false);
        b3.addActionListener(this);
        p2.add(b3);
        
        b3.addMouseListener(new MouseAdapter() 
        {
        	public void mouseClicked(MouseEvent me)
        	{
        		String str = (String) com1.getSelectedItem();
        		String str1 = null;
        		String paidAmt=null;
        		int pendingAmt;
        		String roomCharges=null;
        		try
        		{
        			ConnectingDatabase conn = new ConnectingDatabase();
        			ResultSet rs3= conn.statement.executeQuery("select * from CustomerTable where IDNUMBER='"+str+"'");
        			while(rs3.next())
        			{
        				t2.setText(rs3.getString("ROOMNO"));
        				t1.setText(rs3.getString("NAME"));
        				str1 = (String) t2.getText();
        				paidAmt=rs3.getString("DEPOSIT");
        			}
        			
        			ResultSet rs4= conn.statement.executeQuery("select * from HotelRooms where ROOM_NO='"+str1+"'");
        			while(rs4.next())
        			{
        				roomCharges=rs4.getString("PRICE");
        				pendingAmt=Integer.parseInt(roomCharges) - Integer.parseInt(paidAmt);
        				
        				if(pendingAmt==0 || pendingAmt<=0)
        				{
        					t3.setText("No Amount Pending");
        				}
        				else if(pendingAmt>0)
        				{
        					t3.setText(Integer.toString(pendingAmt));
        				}
        			}
        			
        			rs3.close();
        			rs4.close();
                	conn.statement.close();
                	conn.connection.close();
        			
        		}
        		catch(Exception e)
        		{
        			e.printStackTrace();
        		}
        	}
		});
        
        
        JPanel leftFrameBorder=new JPanel();
		leftFrameBorder.setBounds(0, 0, 3, 561);
		leftFrameBorder.setBackground(Color.black);
		p2.add(leftFrameBorder);
		
		JPanel bottomFrameBorder = new JPanel();
		bottomFrameBorder.setBounds(3, 558, 450, 3);
		bottomFrameBorder.setBackground(Color.black);
		p2.add(bottomFrameBorder);
		
		JPanel rightFrameBorder = new JPanel();
		rightFrameBorder.setBounds(447, 0, 3, 561);
		rightFrameBorder.setBackground(Color.black);
		p2.add(rightFrameBorder);
		
		JPanel topFrameBorder = new JPanel();
		topFrameBorder.setBounds(0, 0, 450, 3);
		topFrameBorder.setBackground(Color.black);
		p2.add(topFrameBorder);
		
	}

	public void actionPerformed(ActionEvent ae) 
	{
		if(ae.getSource()==b1)
		{
			
			if("".equals(t1.getText()) || "".equals(t2.getText()) || "".equals(t3.getText()))
			{
				JOptionPane.showMessageDialog(null, "Please Press The Check Button To Fill All Details");
			}
			else if("No Amount Pending".equals(t3.getText()))
			{
				String getRoomNo=(String) t2.getText();
				
				ConnectingDatabase conn = new ConnectingDatabase();
				
				
				ResultSet rs5;
				try 
				{
					rs5 = conn.statement.executeQuery("select * from CustomerTable where IDNUMBER='"+com1.getSelectedItem()+"'");
					while(rs5.next())
	    			{
	    				conn.statement.executeQuery("insert into CheckedOutGuests values('"+rs5.getString("IDType")+"','"+rs5.getString("IDNumber")+"','"+rs5.getString("Name")+"','"+rs5.getString("Gender")+"','"+rs5.getString("RoomNo")+"')");
	    			}
					rs5.close();
				}
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
				
				
				String str="update HotelRooms set AVAILABILITY='Available',HYGENE_ST='Uncleaned' where ROOM_NO='"+getRoomNo+"'";
				String str1="DELETE FROM CustomerTable WHERE ROOMNO='"+getRoomNo+"'";
				
				try
				{
					conn.statement.executeQuery(str);
					conn.statement.executeQuery(str1);
					
					conn.statement.close();
					conn.connection.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(null, "Successful");
				
    			t1.setText("");
	    		com1.setSelectedIndex(0);
	    		t2.setText("");
	    		t3.setText("");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Unable to check out while Amount is Pending");
			}
			
		}
		
	}

}
