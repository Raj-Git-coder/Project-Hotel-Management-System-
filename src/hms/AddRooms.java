package hms;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AddRooms implements ActionListener 
{
	JPanel p2;
	JButton b1,b2;
	JTextField t1, t2;
	JRadioButton r1, r2;
	JComboBox<?> com1, com2, com3, com4;
	JLabel l3, l4;
	public AddRooms() 
	{
		p2=new JPanel();
        p2.setLayout(null);
        p2.setBackground(Color.white);
        p2.setBounds(201, 31, 460, 561);
        
        JLabel title=new JLabel("Add Rooms");
        title.setBounds(100, 0, 150, 50);
        title.setFont(new Font("Tahoma",Font.PLAIN,14));
        p2.add(title);
        
        JLabel roomNumber=new JLabel("Room Number:");
        roomNumber.setBounds(30, 40, 100, 50);
        roomNumber.setFont(new Font("Tahoma",Font.PLAIN,14));
        p2.add(roomNumber);
        
        t1=new JTextField();
        t1.setBounds(150, 51, 120, 28);
        t1.addActionListener(this);
        p2.add(t1);
        
        l3=new JLabel();
		l3.setBounds(280,51,170,20);
		l3.setForeground(Color.red);
		l3.setOpaque(false);
		l3.setFont(new Font("Verdana",Font.BOLD,10));
		p2.add(l3);
        
        t1.addFocusListener(new FocusAdapter() 
		{
			public void focusLost(FocusEvent e)
			{
				if("".equals(t1.getText()))
				{
					l3.setText("Cannot be empty");
				}
				else
				{
					
					String pattern="^[a-zA-Z]{0,30}$";
            		Pattern patt= Pattern.compile(pattern);
            		Matcher m=patt.matcher(t1.getText());
            		
            		String pattern1="^[a-zA-Z0-9]{0,30}$";
            		Pattern patt1= Pattern.compile(pattern1);
            		Matcher m1=patt1.matcher(t1.getText());
            		
            		String pattern2="^[0-9]{0,3}$";
            		Pattern patt2= Pattern.compile(pattern2);
            		Matcher m2=patt2.matcher(t1.getText());
            		
            		if(m.matches())
            		{
            			l3.setText("Cannot contain characters");
            		}
            		else if(!m1.matches())
            		{
            			l3.setText("Cannot contain symbols");
            		}
            		else if(!m2.matches())
            		{
            			l3.setText("Cannot be more than 3 digits");
            		}
            		else if(!m.matches() || m1.matches() || m2.matches())
            		{
            			ConnectingDatabase conn=new ConnectingDatabase();
    					try 
    					{
    						ResultSet rs=conn.statement.executeQuery("select ROOM_NO from HotelRooms where ROOM_NO='"+t1.getText()+"'");
    						if(rs.next())
    						{
    							l3.setText("Room already exists");
    						}
    						else
    						{
    							l3.setText(null);
    						}
    						rs.close();
    						conn.statement.close();
    						conn.connection.close();
    					} 
    					catch (SQLException e1) 
    					{
    						e1.printStackTrace();
    					}
            		}
					
					
					
				}
				
			}
		});
        
        JLabel availability=new JLabel("Availability:");
        availability.setBounds(30, 90, 100, 50);
        availability.setFont(new Font("Tahoma",Font.PLAIN,14));
        p2.add(availability);

        String availabilityList[]={"Available","Occupied"};
        
        com1=new JComboBox<Object>(availabilityList);
        com1.setBounds(150, 101, 150, 28);
        com1.setBackground(Color.white);    
        com1.setFocusable(false);
        p2.add(com1);
        
        JLabel hygeneStatus=new JLabel("Hygene Status:");
        hygeneStatus.setBounds(30, 140, 120, 50);
        hygeneStatus.setFont(new Font("Tahoma",Font.PLAIN,14));
        p2.add(hygeneStatus);
        
        String hygeneList[] = {"Cleaned","Uncleaned"};
        
        com2=new JComboBox<Object>(hygeneList);
        com2.setBounds(150, 151, 150, 26);
        com2.setBackground(Color.white);
        com2.setFocusable(false);
        p2.add(com2);
        
       
        JLabel price=new JLabel("Price:");
        price.setBounds(30, 190, 40, 50);
        price.setFont(new Font("Tahoma",Font.PLAIN,14));
        p2.add(price);
        
        t2=new JTextField();
        t2.setBounds(150, 201, 120, 28);
        t2.setFont(com1.getFont());
        t1.setFont(com1.getFont());
        t2.addActionListener(this);
        p2.add(t2);
        
        l4=new JLabel();
        l4.setBounds(290,201,150,20);
		l4.setForeground(Color.red);
		l4.setOpaque(false);
		l4.setFont(new Font("Verdana",Font.BOLD,10));
		p2.add(l4);
        
        t2.addFocusListener(new FocusAdapter() 
        {
        	public void focusLost(FocusEvent fe)
        	{
        		if("".equals(t2.getText()))
				{
					l4.setText("Cannot be empty");
				}
        		else
        		{
        			String pattern="^[a-zA-Z]{0,30}$";
            		Pattern patt= Pattern.compile(pattern);
            		Matcher m=patt.matcher(t2.getText());
            		
            		String pattern1="^[a-zA-Z0-9]{0,30}$";
            		Pattern patt1= Pattern.compile(pattern1);
            		Matcher m1=patt1.matcher(t2.getText());
            		
            		if(m.matches())
            		{
            			l4.setText("Cannot contain characters");
            		}
            		else if(!m1.matches())
            		{
            			l4.setText("Cannot contain symbols");
            		}
            		else
            		{
            			l4.setText(null);
            		}
        		}
        	}
		});
        
        JLabel bedType=new JLabel("Bed Type:");
        bedType.setBounds(30, 240, 80, 50);
        bedType.setFont(new Font("Tahoma",Font.PLAIN,14));
        p2.add(bedType);
        
        String bedList[] = {"Single Bed","Double Bed"};
        
        com3=new JComboBox<Object>(bedList);
        com3.setBounds(150, 251, 120, 28);
        com3.setBackground(Color.white);
        com3.setFocusable(false);
        p2.add(com3);
        
        JLabel roomType=new JLabel("Room Type:");
        roomType.setBounds(30, 290, 80, 50);
        roomType.setFont(new Font("Tahoma",Font.PLAIN,14));
        p2.add(roomType);
        
        String roomList[] = {"Executive","Deluxe","Super Deluxe","Non-AC"};
        
        com4=new JComboBox<Object>(roomList);
        com4.setBounds(150, 301, 120, 28);
        com4.setBackground(Color.white);
        com4.setFocusable(false);
        p2.add(com4);
        
        
        b1=new JButton("Add");
        b1.setBounds(50, 410, 60, 25);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setFocusPainted(false);
        b1.setBorderPainted(false);
        b1.addActionListener(this);
        p2.add(b1);
  
        
          
        b2=new JButton("Clear");
        b2.setBounds(150, 410, 80, 25);
        b2.setBackground(new Color(175,0,27));
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
        		t2.setText("");
        		com1.setSelectedIndex(0);
        		com2.setSelectedIndex(0);
        		com3.setSelectedIndex(0);
        		com4.setSelectedIndex(0);
        		l3.setText(null);
        		l4.setText(null);
        	}
		});
        
        
        JPanel leftFrameBorder=new JPanel();
		leftFrameBorder.setBounds(0, 0, 3, 561);
		leftFrameBorder.setBackground(Color.black);
		p2.add(leftFrameBorder);
		
		JPanel bottomFrameBorder = new JPanel();
		bottomFrameBorder.setBounds(3, 558, 460, 3);
		bottomFrameBorder.setBackground(Color.black);
		p2.add(bottomFrameBorder);
		
		JPanel rightFrameBorder = new JPanel();
		rightFrameBorder.setBounds(457, 0, 3, 561);
		rightFrameBorder.setBackground(Color.black);
		p2.add(rightFrameBorder);
		
		JPanel topFrameBorder = new JPanel();
		topFrameBorder.setBounds(0, 0, 460, 3);
		topFrameBorder.setBackground(Color.black);
		p2.add(topFrameBorder);
		
	}

	public void actionPerformed(ActionEvent ae) 
	{
		if(ae.getSource()==b1)
		{
			if("".equals(t1.getText())|| "".equals(t2.getText()))
			{
				JOptionPane.showMessageDialog(null, "Please fill all details correctly");
			}
			
			else
			{
				if(l3.getText()!=null || l4.getText()!=null)
				{
					JOptionPane.showMessageDialog(null, "Please fill all details correctly");
				}
				else
				{
					String getRoomNumber=t1.getText();
					String getPrice=t2.getText();

					
					
					String getAvailability=(String)com1.getSelectedItem();
					String getHygeneStatus=(String)com2.getSelectedItem();
					String getBedType=(String)com3.getSelectedItem();
					
					
					ConnectingDatabase conn = new ConnectingDatabase();
					
					String str="insert into HotelRooms values('"+getRoomNumber+"','"+getAvailability+"','"+getHygeneStatus+"','"+getPrice+"','"+getBedType+"','"+com4.getSelectedItem()+"')";
					
					try
					{
						 conn.statement.executeQuery(str);
						 JOptionPane.showMessageDialog(null, "Room Added");

						 conn.statement.close();
						 conn.connection.close();
						 
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					
					t1.setText("");
		    		t2.setText("");
		    		com1.setSelectedIndex(0);
		    		com2.setSelectedIndex(0);
		    		com3.setSelectedIndex(0);
					com4.setSelectedIndex(0);
				}
				
			}
		}
		
	}

}
