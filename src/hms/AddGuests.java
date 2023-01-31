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

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AddGuests implements ActionListener 
{
	
	JPanel p2;
	JButton b1, b2;
	JTextField t1, t2, t3;
	JRadioButton r1, r2;
	ButtonGroup bg;
	JComboBox<String> com1, com2, com3;
	JLabel l1,l2,l3;
	
	public AddGuests() 
	{
		p2=new JPanel();
        p2.setLayout(null);
        p2.setBackground(Color.white);
        p2.setBounds(201, 31, 450, 561);
        
        JLabel title=new JLabel("Add Guest");
        title.setBounds(100, 0, 150, 50);
        title.setFont(new Font("Tahoma",Font.PLAIN,14));
        p2.add(title);
        
        JLabel idType=new JLabel("Id Type:");
        idType.setBounds(30, 40, 100, 50);
        idType.setFont(new Font("Tahoma",Font.PLAIN,14));
        p2.add(idType);
        
        String idList[]={"Adhaar","Pan","Voter ID","Passport","Driving License"};
        
        com1=new JComboBox<String>(idList);
        com1.setBounds(150, 51, 150, 26);
        com1.setBackground(Color.white);
        com1.setFocusable(false);
        p2.add(com1);
        
        JLabel idNumber=new JLabel("Id Number:");
        idNumber.setBounds(30, 90, 100, 50);
        idNumber.setFont(new Font("Tahoma",Font.PLAIN,14));
        p2.add(idNumber);

        t1=new JTextField();
        t1.setBounds(150, 101, 120, 28);
        t1.setBackground(Color.white);    
        t1.setFont(com1.getFont());
        t1.addActionListener(this);
        p2.add(t1);
        
        l1=new JLabel();
        l1.setBounds(280, 101, 170, 20);
        l1.setForeground(Color.red);
        l1.setOpaque(false);
        l1.setFont(new Font("Verdana",Font.BOLD,10));
        p2.add(l1);
        
        t1.addFocusListener(new FocusAdapter() 
        {
        	public void focusLost(FocusEvent fe)
        	{
        		if("".equals(t1.getText()))
        		{
        			l1.setText("Cannot be empty");
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
            		Matcher m2= patt2.matcher(t1.getText());
            		
            		if(m.matches())
            		{
            			l1.setText("Cannot contain characters");
            		}
            		else if(!m1.matches())
            		{
            			l1.setText("Cannot contain symbols");
            		}
            		else if(!m2.matches())
            		{
            			l1.setText("Cannot be more than 3 digits");
            		}
            		else if(!m.matches() || m1.matches() || m2.matches())
            		{
            			ConnectingDatabase conn=new ConnectingDatabase();
    					try 
    					{
    						ResultSet rs=conn.statement.executeQuery("select IDNumber from CustomerTable where IDNumber='"+t1.getText()+"'");
    						if(rs.next())
    						{
    							l1.setText("Id already exists");
    						}
    						else
    						{
    							l1.setText(null);
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
        
        JLabel name=new JLabel("Name:");
        name.setBounds(30, 140, 120, 50);
        name.setFont(new Font("Tahoma",Font.PLAIN,14));
        p2.add(name);
        
        
        t2=new JTextField();
        t2.setBounds(150, 151, 120, 26);
        t2.setBackground(Color.white);
        t2.setFont(com1.getFont());
        t2.addActionListener(this);
        p2.add(t2);
        
        l2=new JLabel();
        l2.setBounds(280, 151, 150, 20);
        l2.setOpaque(false);
        l2.setForeground(Color.red);
        l2.setFont(new Font("Verdana",Font.BOLD,10));
        p2.add(l2);
        
        t2.addFocusListener(new FocusAdapter() 
        {
        	public void focusLost(FocusEvent fe)
        	{
        		if("".equals(t2.getText()))
        		{
        			l2.setText("Cannot be empty");
        		}
        		else
        		{
        			String pattern="^[0-9]{0,30}$";
            		Pattern patt= Pattern.compile(pattern);
            		Matcher m=patt.matcher(t2.getText().replaceAll("\\s+", ""));
            		
            		String pattern1="^[a-zA-Z0-9]{0,30}$";
            		Pattern patt1= Pattern.compile(pattern1);
            		Matcher m1=patt1.matcher(t2.getText().replaceAll("\\s+", ""));
            		
            		if(m.matches())
            		{
            			l2.setText("Cannot contain numbers");
            		}
            		else if(!m1.matches())
            		{
            			l2.setText("Cannot contain symbols");
            		}
            		else
            		{
            			l2.setText(null);
            		}
        		}
        	}
		});
       
        JLabel gen=new JLabel("Gender:");
        gen.setBounds(30, 190, 70, 50);
        gen.setFont(new Font("Tahoma",Font.PLAIN,14));
        p2.add(gen);
        
        r1=new JRadioButton("Male");
        r1.setBounds(145, 201, 60, 28);
        r1.setBackground(Color.white);
        r1.setSelected(true);
        p2.add(r1);
        
        r2=new JRadioButton("Female");
        r2.setBounds(215, 201, 70, 28);
        r2.setBackground(Color.white);
        p2.add(r2);

        bg=new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        
        JLabel allocatedRoomNo=new JLabel("Room no.:");
        allocatedRoomNo.setBounds(30, 240, 70, 50);
        allocatedRoomNo.setFont(new Font("Tahoma",Font.PLAIN,14));
        p2.add(allocatedRoomNo);
       
        com2=new JComboBox<String>();
        
  
//...............Retrieving data from HotelRooms Table to add Room numbers in the com2........
        
        
        try
        {
        	ConnectingDatabase conn = new ConnectingDatabase();								
        	String str1 = "select * from HotelRooms where AVAILABILITY='Available'";
        	ResultSet rs = conn.statement.executeQuery(str1);
        	
        	while(rs.next())
        	{
        		com2.addItem(rs.getString("ROOM_NO"));
        	}
        	
        	rs.close();
        	conn.statement.close();
        	conn.connection.close();
        	
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
        
        com2.setBounds(150, 251, 150, 26);
        com2.setBackground(Color.white);
        com2.setFocusable(false);
        p2.add(com2);
        
        JLabel checkInStatus=new JLabel("Check-in status:");
        checkInStatus.setBounds(30, 290, 130, 50);
        checkInStatus.setFont(new Font("Tahoma",Font.PLAIN,14));
        p2.add(checkInStatus);
        
        String checkInList[] = {"checked in","checked out"};
        
        com3=new JComboBox<String>(checkInList);
        com3.setBounds(150, 301, 150, 26);
        com3.setBackground(Color.white);
        com3.setFocusable(false);
        p2.add(com3);
        
        JLabel deposit=new JLabel("Deposit:");
        deposit.setBounds(30, 340, 130, 50);
        deposit.setFont(new Font("Tahoma",Font.PLAIN,14));
        p2.add(deposit);
        
        t3=new JTextField();
        t3.setBounds(150, 351, 120, 26);
        t3.setBackground(Color.white);
        t3.setFont(com1.getFont());
        t3.addActionListener(this);
        p2.add(t3);
        
        l3=new JLabel();
        l3.setBounds(280,351,150,20);
		l3.setForeground(Color.red);
		l3.setOpaque(false);
		l3.setFont(new Font("Verdana",Font.BOLD,10));
		p2.add(l3);
		
		t3.addFocusListener(new FocusAdapter()
		{
			public void focusLost(FocusEvent fe)
			{
				if("".equals(t3.getText()))
				{
					l3.setText("Cannot be empty");
				}
        		else
        		{
        			String pattern="^[a-zA-Z]{0,30}$";
            		Pattern patt= Pattern.compile(pattern);
            		Matcher m=patt.matcher(t3.getText());
            		
            		String pattern1="^[a-zA-Z0-9]{0,30}$";
            		Pattern patt1= Pattern.compile(pattern1);
            		Matcher m1=patt1.matcher(t3.getText());
            		
            		if(m.matches())
            		{
            			l3.setText("Cannot contain characters");
            		}
            		else if(!m1.matches())
            		{
            			l3.setText("Cannot contain symbols");
            		}
            		else if(!m.matches() || m1.matches())
            		{
            			String price=null;
            			ConnectingDatabase conn=new ConnectingDatabase();
    					try 
    					{
    						ResultSet rs=conn.statement.executeQuery("select PRICE from HotelRooms where ROOM_NO='"+com2.getSelectedItem()+"'");
    						while(rs.next())
    						{
    							price=rs.getString("PRICE");
    							if(Integer.parseInt(t3.getText())>Integer.parseInt(price))
    							{
    								l3.setText("Cannot be more than"+price);
    							}
    							else
        						{
        							l3.setText(null);
        						}
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
        b2.setBackground(new Color	(175,0,27));
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
        		t3.setText("");
        		l1.setText(null);
        		l2.setText(null);
        		l3.setText(null);
        		r1.setSelected(true);
        		com1.setSelectedIndex(0);
        		com2.setSelectedItem("");
        		com3.setSelectedIndex(0);
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
		
//...............Adding the Add function To the b1 button.....................................		
		
		
		if(ae.getSource()==b1)
		{
			if("".equals(t1.getText()) || "".equals(t2.getText()) || "".equals(t3.getText()))
			{
				JOptionPane.showMessageDialog(null, "Please fill all details correctly");
			}
			else
			{
				if(l1.getText()!=null || l2.getText()!=null || l3.getText()!=null)
				{
					JOptionPane.showMessageDialog(null, "Please fill all details correctly");
				}
				else
				{
					String getIdType=(String)com1.getSelectedItem();
					String getIdNumber=t1.getText();
					String getName=t2.getText();
					String getGender = null;
					if(r1.isSelected())
					{
						getGender="Male";
					}
					else if(r2.isSelected())
					{
						getGender="Female";
					}
					
					
					String getRoomNo=(String)com2.getSelectedItem();
					String getCheckinStatus=(String)com3.getSelectedItem();
					String getDeposit=t3.getText();
					
					ConnectingDatabase conn = new ConnectingDatabase();
					
					String str="insert into CustomerTable values('"+getIdType+"','"+getIdNumber+"','"+getName+"','"+getGender+"','"+getRoomNo+"','"+getCheckinStatus+"','"+getDeposit+"')";
					String str2="update HotelRooms set 	AVAILABILITY = 'Occupied' where ROOM_NO = '"+getRoomNo+"'";
					try
					{
						 conn.statement.executeQuery(str);
						 conn.statement.executeQuery(str2);
						 JOptionPane.showMessageDialog(null, "Guest Added");
						 
				        	conn.statement.close();
				        	conn.connection.close();
						 
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					
					t1.setText("");
		    		t2.setText("");
		    		t3.setText("");
		    		r1.setSelected(true);
		    		com1.setSelectedIndex(0);
		    		com2.setSelectedItem("");
		    		com3.setSelectedIndex(0);
				}
			}
		}
		
	}

}
