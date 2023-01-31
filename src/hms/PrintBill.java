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
import javax.swing.JTextField;

public class PrintBill implements ActionListener 
{
	JPanel p2;
	JButton b1, b2, b3;
	JTextField t1,t2,t3,t4,t5;
	JComboBox<String> com1;
	JLabel l1;
	public PrintBill() 
	{
		p2=new JPanel();
        p2.setLayout(null);
        p2.setBackground(Color.white);
        p2.setBounds(201, 31, 450, 561);
        
        JLabel title=new JLabel("Bill Details");
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
        
        JLabel checkInStatus=new JLabel("Check-in Status:");
        checkInStatus.setBounds(30, 190, 120, 50);
        checkInStatus.setFont(new Font("Tahoma",Font.PLAIN,14));
        p2.add(checkInStatus);

        t3=new JTextField();
        t3.setBounds(150, 201, 120, 26);
        t3.setBackground(Color.white);
        t3.setFont(com1.getFont());
        p2.add(t3);
        
       
        JLabel amountPaid=new JLabel("Amount Paid:");
        amountPaid.setBounds(30, 240, 100, 50);
        amountPaid.setFont(new Font("Tahoma",Font.PLAIN,14));
        p2.add(amountPaid);
        
        
        t4=new JTextField();
        t4.setBounds(150, 251, 120, 26);
        t4.setBackground(Color.white);
        t4.setFont(com1.getFont());
        t4.addActionListener(this);
        p2.add(t4);
        
        l1=new JLabel();
        l1.setBounds(280,251,150,20);
		l1.setForeground(Color.red);
		l1.setOpaque(false);
		l1.setFont(new Font("Verdana",Font.BOLD,10));
		p2.add(l1);
        
		t4.addFocusListener(new FocusAdapter()
		{
			public void focusLost(FocusEvent fe)
			{
				if("".equals(t4.getText()))
				{
					l1.setText("Cannot be empty");
				}
        		else
        		{
        			String pattern="^[a-zA-Z]{0,30}$";
            		Pattern patt= Pattern.compile(pattern);
            		Matcher m=patt.matcher(t4.getText());
            		
            		String pattern1="^[a-zA-Z0-9]{0,30}$";
            		Pattern patt1= Pattern.compile(pattern1);
            		Matcher m1=patt1.matcher(t4.getText());
            		
            		if(m.matches())
            		{
            			l1.setText("Cannot contain characters");
            		}
            		else if(!m1.matches())
            		{
            			l1.setText("Cannot contain symbols");
            		}
            		else if(!m.matches() || m1.matches())
            		{
            			String price=null;
            			ConnectingDatabase conn=new ConnectingDatabase();
    					try 
    					{
    						ResultSet rs=conn.statement.executeQuery("select PRICE from HotelRooms where ROOM_NO='"+t2.getText()+"'");
    						while(rs.next())
    						{
    							price=rs.getString("PRICE");
    							if(Integer.parseInt(t4.getText())>Integer.parseInt(price))
    							{
    								l1.setText("Cannot be more than "+price);
    							}
    							else
        						{
        							l1.setText(null);
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
		
        JLabel pendingAmount=new JLabel("Amount Pending:");
        pendingAmount.setBounds(30, 290, 120, 50);
        pendingAmount.setFont(new Font("Tahoma",Font.PLAIN,14));
        p2.add(pendingAmount);
        
        
        t5=new JTextField();
        t5.setBounds(150, 301, 120, 26);
        t5.setBackground(Color.white);
        t5.setFont(com1.getFont());
        p2.add(t5);
        
        b1=new JButton("Update");
        b1.setBounds(90, 410, 80, 25);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setFocusPainted(false);
        b1.setBorderPainted(false);
        b1.addActionListener(this);
        p2.add(b1);
  
        
          
        b2=new JButton("Clear");
        b2.setBounds(190, 410, 80, 25);
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
        		t4.setText("");
        		t5.setText("");
        		l1.setText(null);
        	}
		});
        
        b3=new JButton("Print");
        b3.setBounds(190, 340, 80, 25);
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
        		l1.setText(null);
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
        				t3.setText(rs3.getString("STATUS"));
        				t4.setText(rs3.getString("DEPOSIT"));
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
        					t5.setText("No Amount Pending");
        				}
        				else if(pendingAmt>0)
        				{
        					t5.setText(Integer.toString(pendingAmt));
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
			if("".equals(t4.getText()))
			{
				JOptionPane.showMessageDialog(null, "Please fill required details");
			}
			else
			{
				if(l1.getText()!=null)
				{
					JOptionPane.showMessageDialog(null, "Please fill required details");
				}
				else
				{
					ConnectingDatabase conn = new ConnectingDatabase();
					
					String str="update CustomerTable set DEPOSIT='"+t4.getText()+"' where IDNUMBER='"+com1.getSelectedItem()+"'";
					
					try
					{
						 conn.statement.executeQuery(str);
						 JOptionPane.showMessageDialog(null, "Amount Updated Successfuly");
						 
				        	conn.statement.close();
				        	conn.connection.close();
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					t1.setText("");
		    		com1.setSelectedIndex(0);
		    		t2.setText("");
		    		t3.setText("");
		    		t4.setText("");
		    		t5.setText("");
		    		l1.setText(null);
				}
			}
		}
	}
}
