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
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UpdateRooms implements ActionListener 
{
	JPanel p2;
	JButton b1, b2, b3;
	JTextField t1,t2;
	JComboBox<String> com1, com3, com4;
	JCheckBox chk;
	public UpdateRooms() 
	{
		p2=new JPanel();
        p2.setLayout(null);
        p2.setBackground(Color.white);
        p2.setBounds(201, 31, 450, 561);
        
        JLabel title=new JLabel("Update Rooms");
        title.setBounds(100, 0, 150, 50);
        title.setFont(new Font("Tahoma",Font.PLAIN,14));
        p2.add(title);
        
        JLabel roomNo=new JLabel("Room No:");
        roomNo.setBounds(30, 40, 100, 50);
        roomNo.setFont(new Font("Tahoma",Font.PLAIN,14));
        p2.add(roomNo);
        
        com1=new JComboBox<String>();
        try
        {
        	ConnectingDatabase conn =new ConnectingDatabase();
        	ResultSet rs = conn.statement.executeQuery("select * from HotelRooms");
        	
        	while(rs.next())
        	{
        		com1.addItem(rs.getString("ROOM_NO"));
        	}
        	
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
        
        com1.setBounds(150, 51, 150, 26);
        com1.setBackground(Color.white);
        com1.setFocusable(false);
        com1.addActionListener(this);
        p2.add(com1);
        
        com1.addMouseListener(new MouseAdapter() 
        {
        	public void mouseClicked(MouseEvent me)
        	{
        		t1.setText("");
        		t2.setText("");
        	}
		});
        
        JLabel guestName = new JLabel("Guest Name:");
        guestName.setBounds(30, 90, 100, 50);
        guestName.setFont(new Font("Tahoma",Font.PLAIN,14));
        p2.add(guestName);
        
        t1=new JTextField();
        t1.setBounds(150, 101, 120, 26);
        t1.setFont(com1.getFont());
        p2.add(t1);
        
        JLabel guestId=new JLabel("Guest Id.:");
        guestId.setBounds(30, 140, 100, 50);
        guestId.setFont(new Font("Tahoma",Font.PLAIN,14));
        p2.add(guestId);

        
        t2=new JTextField();
        t2.setBounds(150, 151, 120, 26);
        t2.setBackground(Color.white);  
        t2.setFont(com1.getFont());
        p2.add(t2);
        
        JLabel availability=new JLabel("Availability Status:");
        availability.setBounds(30, 190, 120, 50);
        availability.setFont(new Font("Tahoma",Font.PLAIN,14));
        p2.add(availability);
                
        String availabilityList []= {"Available","Occupied"};

        
        com3=new JComboBox<String>(availabilityList);
        com3.setBounds(150, 201, 150, 26);
        com3.setBackground(Color.white);
        com3.setFocusable(false);
        p2.add(com3);
        
       
        JLabel hygene=new JLabel("Hygene status:");
        hygene.setBounds(30, 240, 100, 50);
        hygene.setFont(new Font("Tahoma",Font.PLAIN,14));
        p2.add(hygene);
        
        String hygeneList []= {"Cleaned","Uncleaned"};
        
        com4=new JComboBox<String>(hygeneList);
        com4.setBounds(150, 251, 150, 26);
        com4.setBackground(Color.white);
        com4.setFocusable(false);
        p2.add(com4);
        
        chk= new JCheckBox("Remove Rooms");
        chk.setBounds(310, 251, 130, 26);
        chk.setBackground(Color.white);
        chk.setFocusable(false);
        p2.add(chk);
        
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
        		com3.setSelectedIndex(0);
        		com4.setSelectedIndex(0);
        		chk.setSelected(false);
        	}
		});
        
        b3=new JButton("Check");
        b3.setBounds(220, 280, 80, 25);
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
        		String str = (String)com1.getSelectedItem();
        		try
        		{
        			ConnectingDatabase conn = new ConnectingDatabase();
        			ResultSet rs3= conn.statement.executeQuery("select * from CustomerTable where ROOMNO='"+str+"' ");
        			
        			while(rs3.next())
        			{
        				t2.setText(rs3.getString("IDNUMBER"));
            			t1.setText(rs3.getString("NAME"));
        				
        			}
        			rs3.close();
        			
        			try
        			{
        						
        				ResultSet rs4= conn.statement.executeQuery("select * from HotelRooms where ROOM_NO='"+str+"'");
                		while(rs4.next())
                		{
                			com3.setSelectedItem(rs4.getString("AVAILABILITY"));
                			com4.setSelectedItem(rs4.getString("HYGENE_ST"));
                		}
                				
                		rs4.close();
        					
        			}
        			catch(Exception e)
        			{
        				e.printStackTrace();
        			}
        			
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
			
			String getRoomNo=(String) com1.getSelectedItem();
			String getAvailability=(String)com3.getSelectedItem();
			String getHygene=(String)com4.getSelectedItem();
			String str=null;	
			
			ConnectingDatabase conn = new ConnectingDatabase();
			
			if(chk.isSelected())
			{
				try 
				{
					ResultSet rs5= conn.statement.executeQuery("select ROOMNO from CustomerTable where ROOMNO='"+getRoomNo+"' ");
					if(rs5.next())
					{
						JOptionPane.showMessageDialog(null, "Cannot delete a booked room");
						
					}
					else
					{
						str="delete from HotelRooms where ROOM_NO='"+getRoomNo+"'";
						conn.statement.executeQuery(str);
						JOptionPane.showMessageDialog(null, "Room Deleted");
						
					}
					conn.statement.close();
					conn.connection.close();
					rs5.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
			else
			{
				str="update HotelRooms set AVAILABILITY='"+getAvailability+"',HYGENE_ST='"+getHygene+"' where ROOM_NO='"+getRoomNo+"'";
				try 
				{
					conn.statement.executeQuery(str);
					conn.statement.close();
					conn.connection.close();
					JOptionPane.showMessageDialog(null, "Successfully Updated");
				}
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
				
			
			t1.setText("");
	    	com1.setSelectedIndex(0);
	    	t2.setText("");
	    	com3.setSelectedIndex(0);
	    	com4.setSelectedIndex(0);
	    	chk.setSelected(false);
			
			
		}
		
	}

}
