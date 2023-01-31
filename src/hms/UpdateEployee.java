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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UpdateEployee implements ActionListener 
{
	JPanel p2, p3;
	JButton b1, b2, b3;
	JTextField t1, t2, t3, t5, t6, t7;
	ButtonGroup bg;
	JComboBox<String> com1, com2, com3, com4,com;
	JCheckBox chk;
	JLabel l1,l2;
	
	
	public UpdateEployee() 
	{

		p2=new JPanel();
        p2.setLayout(null);
        p2.setBackground(Color.white);
        p2.setBounds(201, 31, 450, 561);
        
        p3= new JPanel();
		p3.setLayout(null);
		p3.setBounds(3, 379, 285, 149);
		p3.setBackground(Color.white);
		p2.add(p3);
		p3.setVisible(false);
		
        JLabel title=new JLabel("Update Employee");
        title.setBounds(100, 0, 150, 50);
        title.setFont(new Font("Tahoma",Font.PLAIN,14));
        p2.add(title);
        
        JLabel empId=new JLabel("Employee Id.:");
        empId.setBounds(30, 40, 90, 50);
        empId.setFont(new Font("Tahoma",Font.PLAIN,14));
        p2.add(empId);
        com1=new JComboBox<String>();
        try
        {
        	ConnectingDatabase conn =new ConnectingDatabase();
        	ResultSet rs = conn.statement.executeQuery("select * from HotelEmployees");
        	
        	while(rs.next())
        	{
        		com1.addItem(rs.getString("EMPID"));
        	}
        	conn.statement.close();
        	conn.connection.close();
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
        com1.setBounds(130, 51, 120, 28);
        com1.setBackground(Color.white);
        com1.setFocusable(false);
        p2.add(com1);
        
        JLabel name=new JLabel("Name:");
        name.setBounds(30, 90, 75, 50);
        name.setFont(new Font("Tahoma",Font.PLAIN,14));
        p2.add(name);
        
        t1=new JTextField();
        t1.setBounds(130, 101, 120, 28);
        t1.setFont(com1.getFont());
        p2.add(t1);
                
        JLabel age=new JLabel("Age:");
        age.setBounds(30, 140, 50, 50);
        age.setFont(new Font("Tahoma",Font.PLAIN,14));
        p2.add(age);

        t2=new JTextField();
        t2.setBounds(130, 151, 120, 28);
        t2.setFont(com1.getFont());
        t2.addActionListener(this);
        p2.add(t2);
        
        l1=new JLabel();
        l1.setBounds(260, 151, 170, 20);
        l1.setForeground(Color.red);
        l1.setOpaque(false);
        l1.setFont(new Font("Verdana",Font.BOLD,10));
        p2.add(l1);
        
        t2.addFocusListener(new FocusAdapter() 
        {
        	public void focusLost(FocusEvent fe)
        	{
        		if("".equals(t2.getText()))
        		{
        			l1.setText("Cannot be empty");
        		}
        		else
				{
					
					String pattern="^[a-zA-Z]{0,30}$";
            		Pattern patt= Pattern.compile(pattern);
            		Matcher m=patt.matcher(t2.getText());
            		
            		String pattern1="^[a-zA-Z0-9]{0,30}$";
            		Pattern patt1= Pattern.compile(pattern1);
            		Matcher m1=patt1.matcher(t2.getText());
            		
            		String pattern2="^[0-9]{0,2}$";
            		Pattern patt2= Pattern.compile(pattern2);
            		Matcher m2=patt2.matcher(t2.getText());
            		
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
            			l1.setText("cannot be more than 2 digits");
            		}
            		else
            		{
            			l1.setText(null);
            		}
				}
        		
        	}
		});
        
        JLabel gen=new JLabel("Gender:");
        gen.setBounds(30, 190, 60, 50);
        gen.setFont(new Font("Tahoma",Font.PLAIN,14));
        p2.add(gen);
        
        t3=new JTextField();
        t3.setBounds(130, 200, 120, 28);
        t3.setFont(com1.getFont());
        p2.add(t3);

        JLabel job=new JLabel("Job:");
        job.setBounds(30, 240, 60, 50);
        job.setFont(new Font("Tahoma",Font.PLAIN,14));
        p2.add(job);
        
        String jobList[] = {"Front desk clerk","Driver","Porters","Housekeeper","Kitchen staff","Room service","Waiter/Waitress","Manager","Accountant"};
        
        com=new JComboBox<String>(jobList);
        com.setBounds(130, 251, 150, 26);
        com.setBackground(Color.white);
        com.setFocusable(false);
        com.addActionListener(this);
        p2.add(com);
        
        JLabel salary=new JLabel("Salary:");
        salary.setBounds(30, 290, 60, 50);
        salary.setFont(new Font("Tahoma",Font.PLAIN,14));
        p2.add(salary);
        
        t5=new JTextField();
        t5.setBounds(130, 301, 120, 28);
        t5.setFont(com1.getFont());
        t5.addActionListener(this);
        p2.add(t5);
        
        l2=new JLabel();
        l2.setBounds(260, 301, 170, 20);
        l2.setOpaque(false);
        l2.setForeground(Color.red);
        l2.setFont(new Font("Verdana",Font.BOLD,10));
        p2.add(l2);
        
        t5.addFocusListener(new FocusAdapter()
        {
        	public void focusLost(FocusEvent fe)
        	{
        		if("".equals(t5.getText()))
        		{
        			l2.setText("Cannot be empty");
        		}
        		else
        		{
        			String pattern="^[a-zA-Z]{0,30}$";
            		Pattern patt= Pattern.compile(pattern);
            		Matcher m=patt.matcher(t5.getText());
            		
            		String pattern1="^[a-zA-Z0-9]{0,30}$";
            		Pattern patt1= Pattern.compile(pattern1);
            		Matcher m1=patt1.matcher(t5.getText());
            		
            		String pattern2="^[0-9]{0,7}$";
            		Pattern patt2= Pattern.compile(pattern2);
            		Matcher m2= patt2.matcher(t5.getText());
            		
            		if(m.matches())
            		{
            			l2.setText("Cannot contain characters");
            		}
            		else if(!m1.matches())
            		{
            			l2.setText("Cannot contain symbols");
            		}
            		else if(!m2.matches())
            		{
            			l2.setText("Cannot be more than 7 digits");
            		}
            		else
            		{
            			l2.setText(null);
            		}
        		}
        	}
        });
        
        
        JLabel phone=new JLabel("Phone no:");
        phone.setBounds(30, 340, 75, 50);
        phone.setFont(new Font("Tahoma",Font.PLAIN,14));
        p2.add(phone);
        
        
        t6=new JTextField();
        t6.setBounds(130, 351, 120, 28);
        t6.setFont(com1.getFont());
        p2.add(t6);
        
        
        chk=new JCheckBox("Remove Employee");
        chk.setBounds(258, 351, 140, 28);
        chk.setBackground(Color.white);
        chk.setFocusable(false);
        p2.add(chk);
        
        JLabel car = new JLabel("Car:");
		car.setBounds(27, 9, 50, 50);
		car.setFont(new Font("Tahoma",Font.PLAIN,14));
		p3.add(car);
		
		String carList[] = {"Toyota ","Nissan","Mercedes","Abc","Xyz","Pqr","Lmn","Manager","Accountant"};
		
		com2= new JComboBox<String>(carList);
		com2.setBounds(127, 20, 150, 26);
		com2.setBackground(Color.white);
		com2.setFocusable(false);
		p3.add(com2);
		
		JLabel availability = new JLabel("Availability:");
		availability.setBounds(27, 54, 75, 50);
		availability.setFont(new Font("Tahoma",Font.PLAIN,14));
		p3.add(availability);
		
		String availabilityList[] = {"Available ","Unavailable"};
		
		com3= new JComboBox<String>(availabilityList);
		com3.setBounds(127, 66, 150, 26);
		com3.setBackground(Color.white);
		com3.setFocusable(false);
		p3.add(com3);
		
		JLabel location = new JLabel("Location:");
		location.setBounds(27, 100, 75, 50);
		location.setFont(new Font("Tahoma",Font.PLAIN,14));
		p3.add(location);
		
		String locationList[] = {"loc1 ","loc2"};
		
		com4= new JComboBox<String>(locationList);
		com4.setBounds(127, 112, 150, 26);
		com4.setBackground(Color.white);
		com4.setFocusable(false);
		p3.add(com4);
        
        b3=new JButton("Check");
        b3.setBounds(291, 410, 80, 25);
        b3.setBackground(Color.black);
        b3.setForeground(Color.white);
        b3.setFocusPainted(false);
        b3.setBorderPainted(false);
        b3.addActionListener(this);
        p2.add(b3);
        

        b1=new JButton("Commit");
        b1.setBounds(50, 410, 80, 25);
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
        		com.setSelectedIndex(0);
        		t5.setText("");
        		t6.setText("");
        		l1.setText(null);
        		l2.setText(null);
        		com1.setSelectedIndex(0);
        		com2.setSelectedIndex(0);
        		com3.setSelectedIndex(0);
        		com4.setSelectedIndex(0);
        		b1.setLocation(50, 410);
    			b2.setLocation(150, 410);
    			chk.setSelected(false);
    			p3.setVisible(false);
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
		
		if(ae.getSource()==b3)
		{
			l2.setText(null);
			l1.setText(null);
			try
			{
				ConnectingDatabase conn = new ConnectingDatabase();
    			ResultSet rs= conn.statement.executeQuery("select * from HotelEmployees where EMPID='"+com1.getSelectedItem()+"'");
    			
    			while(rs.next())
    			{
    				com.setSelectedItem(rs.getString("JOB"));
    				
    			}
    			if( com.getSelectedItem()=="Driver")
    			{
    				b1.setLocation(50, 531);
    				b2.setLocation(150, 531);

    				p3.setVisible(true);
    				try
    				{
    					ResultSet rs1= conn.statement.executeQuery("select * from DriversTable where EMPID='"+com1.getSelectedItem()+"'");
    					while(rs1.next())
    	    			{
    	    				t1.setText(rs1.getString("NAME"));
    	    				com2.setSelectedItem(rs1.getString("CAR"));
    	    				com3.setSelectedItem(rs1.getString("AVAILABILITY"));
    	    				com4.setSelectedItem(rs1.getString("LOCATION"));
    	    				ResultSet rs3= conn.statement.executeQuery("select * from HotelEmployees where EMPID='"+com1.getSelectedItem()+"'");
    	    				while(rs3.next())
    	    				{
    	    					t2.setText(rs3.getString("AGE"));
    	    					t3.setText(rs3.getString("GENDER"));
    	    					t5.setText(rs3.getString("SALARY"));
    	    					t6.setText(rs3.getString("PHONE"));
    	    				}
    	    				
    	    			}
    					rs1.close();
    					conn.statement.close();
    					conn.connection.close();
    				}
    				catch(Exception e)
    				{
    					e.printStackTrace();
    				}
    			}
    			else
    			{
    				b1.setLocation(50, 410);
    				b2.setLocation(150, 410);
    				p3.setVisible(false);
    				try
    				{
    					ConnectingDatabase conn1 = new ConnectingDatabase();
    					ResultSet rs2= conn.statement.executeQuery("select * from HotelEmployees where EMPID='"+com1.getSelectedItem()+"'");
    					while(rs2.next())
    	    			{
    	    				t1.setText(rs2.getString("NAME"));
    	    				t2.setText(rs2.getString("AGE"));
    	    				t3.setText(rs2.getString("GENDER"));
    	    				t5.setText(rs2.getString("SALARY"));
    	    				t6.setText(rs2.getString("PHONE"));
    	    			}
    					conn1.statement.close();
    	    			conn1.connection.close();
    				}
    				catch(Exception e)
    				{
    					e.printStackTrace();
    				}
    			}
    			
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
  
		}
		
		
		
		if(ae.getSource()==b1 && com.getSelectedItem()=="Driver")
		{
			if("".equals(t5.getText())|| "".equals(t2.getText()))
			{
				JOptionPane.showMessageDialog(null, "Please fill all the details");
			}
			
			else
			{
				b1.setLocation(50, 531);
				b2.setLocation(150, 531);
				p3.setVisible(true);
				if(l1.getText()!=null || l2.getText()!=null)
				{
					JOptionPane.showMessageDialog(null, "Please fill required details");
				}
				
				else
				{
					if(chk.isSelected())
					{
						ConnectingDatabase conn2 = new ConnectingDatabase();
						String str="DELETE FROM DriversTable WHERE EMPID='"+com1.getSelectedItem()+"'";
						String str1="DELETE FROM HotelEmployees WHERE EMPID='"+com1.getSelectedItem()+"'";
						
						try
						{
							 conn2.statement.executeQuery(str);
							 conn2.statement.executeQuery(str1);
							 JOptionPane.showMessageDialog(null, "Employee Removed");
							 
							 conn2.statement.close();
							 conn2.connection.close();
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
						t1.setText("");
			    		t2.setText("");
			    		t3.setText("");
			    		t5.setText("");
			    		t6.setText("");
			    		com1.setSelectedIndex(0);
			    		com.setSelectedIndex(0);
			    		com2.setSelectedIndex(0);
			    		com3.setSelectedIndex(0);
			    		com4.setSelectedIndex(0);
			    		b1.setLocation(50, 410);
						b2.setLocation(150, 410);
						chk.setSelected(false);
						p3.setVisible(false);
						
					}
					else
					{
						ConnectingDatabase conn3 = new ConnectingDatabase();
						String str="update HotelEmployees set AGE='"+t2.getText()+"',SALARY='"+t5.getText()+"' where EMPID='"+com1.getSelectedItem()+"'";
						String str1="update DriversTable set CAR='"+com2.getSelectedItem()+"',AVAILABILITY='"+com3.getSelectedItem()+"',LOCATION='"+com4.getSelectedItem()+"' where EMPID='"+com1.getSelectedItem()+"'";

						try
						{
							 
							 conn3.statement.executeQuery(str);
							 conn3.statement.executeQuery(str1);
							 JOptionPane.showMessageDialog(null, "Employee Updated");
							 
							 conn3.statement.close();
							 conn3.connection.close();
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
						t1.setText("");
			    		t2.setText("");
			    		t3.setText("");
			    		t5.setText("");
			    		t6.setText("");
			    		com1.setSelectedIndex(0);
			    		com2.setSelectedIndex(0);
			    		com3.setSelectedIndex(0);
			    		com4.setSelectedIndex(0);
			    		b1.setLocation(50, 410);
						b2.setLocation(150, 410);
						chk.setSelected(false);
						p3.setVisible(false);
					}
				}
			}
		}
		else if(ae.getSource()==b1 && com.getSelectedItem()!="Driver")
		{
			if("".equals(t5.getText()) || "".equals(t2.getText()))
			{
				JOptionPane.showMessageDialog(null, "Please fill required details");
			}
			else
			{
				if(l1.getText()!=null || l2.getText()!=null)
				{
					JOptionPane.showMessageDialog(null, "Please fill required details");
				}
				else
				{
					if(chk.isSelected())
					{
						ConnectingDatabase conn4 = new ConnectingDatabase();
						String str1="DELETE FROM HotelEmployees WHERE EMPID='"+com1.getSelectedItem()+"'";
						
						try
						{
							 conn4.statement.executeQuery(str1);
							 JOptionPane.showMessageDialog(null, "Employee Removed");
							 
							 conn4.statement.close();
							 conn4.connection.close();
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
						t1.setText("");
			    		t2.setText("");
			    		t3.setText("");
			    		t5.setText("");
			    		t6.setText("");
			    		com1.setSelectedIndex(0);
			    		com.setSelectedIndex(0);
			    		com2.setSelectedIndex(0);
			    		com3.setSelectedIndex(0);
			    		com4.setSelectedIndex(0);
			    		chk.setSelected(false);
					}

					else
					{
						ConnectingDatabase conn5 = new ConnectingDatabase();
						String str="update HotelEmployees set AGE='"+t2.getText()+"',SALARY='"+t5.getText()+"' where EMPID='"+com1.getSelectedItem()+"'";
						
						try
						{
							 conn5.statement.executeQuery(str);
							 JOptionPane.showMessageDialog(null, "Employee Updated");
							 
							 conn5.statement.close();
							 conn5.connection.close();
							 
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
						t1.setText("");
			    		t2.setText("");
			    		t3.setText("");
			    		t5.setText("");
			    		t6.setText("");
			    		com1.setSelectedIndex(0);
			    		com2.setSelectedIndex(0);
			    		com.setSelectedIndex(0);
			    		com3.setSelectedIndex(0);
			    		com4.setSelectedIndex(0);
			    		chk.setSelected(false);
			    		
					}
				}
			}
		}
	}
}
