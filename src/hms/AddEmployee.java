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

public class AddEmployee implements ActionListener 
{
	JPanel p2, p3;
	JButton b1, b2, b3;
	JTextField t1, t2, t3, t4, t5;
	JRadioButton r1, r2;
	ButtonGroup bg;
	JComboBox com1, com2, com3, com4;
	JLabel l1,l2,l3,l4,l5;
	
	
	public AddEmployee() 
	{

//............... Creating Panel for AddEmployee form.........................................
		
		p2=new JPanel();
        p2.setLayout(null);
        p2.setBackground(Color.white);
        p2.setBounds(201, 31, 460, 561);
        
//................Creating Extra Panel for Driver.............................................
        
        p3= new JPanel();
		p3.setLayout(null);
		p3.setBounds(3, 379, 444, 149);
		p3.setBackground(Color.white);
		p2.add(p3);
		p3.setVisible(false);
		
		JLabel car = new JLabel("Car:");
		car.setBounds(27, 9, 50, 50);
		car.setFont(new Font("Tahoma",Font.PLAIN,14));
		p3.add(car);
		
		String carList[] = {"Toyota ","Nissan","Mercedes"};
		
		com2= new JComboBox(carList);
		com2.setBounds(127, 20, 150, 26);
		com2.setBackground(Color.white);
		com2.setFocusable(false);
		p3.add(com2);
		
		JLabel availability = new JLabel("Availability:");
		availability.setBounds(27, 54, 75, 50);
		availability.setFont(new Font("Tahoma",Font.PLAIN,14));
		p3.add(availability);
		
		String availabilityList[] = {"Available ","Unavailable"};
		
		com3= new JComboBox(availabilityList);
		com3.setBounds(127, 66, 150, 26);
		com3.setBackground(Color.white);
		com3.setFocusable(false);
		p3.add(com3);
		
		JLabel location = new JLabel("Location:");
		location.setBounds(27, 100, 75, 50);
		location.setFont(new Font("Tahoma",Font.PLAIN,14));
		p3.add(location);
		
		String locationList[] = {"loc1 ","loc2"};
		
		com4= new JComboBox(locationList);
		com4.setBounds(127, 112, 150, 26);
		com4.setBackground(Color.white);
		com4.setFocusable(false);
		p3.add(com4);
 
		
//...............Extra panel for Driver Ends Here.............................................
		
	
//...............Panel foe all Employees......................................................	
		
		
        JLabel title=new JLabel("Add Employee");
        title.setBounds(100, 0, 150, 50);
        title.setFont(new Font("Tahoma",Font.PLAIN,14));
        p2.add(title);
        
        JLabel name=new JLabel("Name:");
        name.setBounds(30, 40, 50, 50);
        name.setFont(new Font("Tahoma",Font.PLAIN,14));
        p2.add(name);
        
        t1=new JTextField();
        t1.setBounds(130, 51, 120, 28);
        t1.addActionListener(this);
        t1.setFont(com4.getFont());
        p2.add(t1);
        
        l2=new JLabel();
        l2.setBounds(260, 51, 150, 20);
        l2.setOpaque(false);
        l2.setForeground(Color.red);
        l2.setFont(new Font("Verdana",Font.BOLD,10));
        p2.add(l2);
        
        t1.addFocusListener(new FocusAdapter()
        {
        	public void focusLost(FocusEvent fe)
        	{
        		if("".equals(t1.getText()))
        		{
        			l2.setText("Cannot be empty");
        		}
        		else
        		{
        			String pattern="^[0-9]{0,30}$";
            		Pattern patt= Pattern.compile(pattern);
            		Matcher m=patt.matcher(t1.getText().replaceAll("\\s+", ""));
            		
            		String pattern1="^[a-zA-Z0-9]{0,30}$";
            		Pattern patt1= Pattern.compile(pattern1);
            		Matcher m1=patt1.matcher(t1.getText().replaceAll("\\s+", ""));
            		
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
        
        JLabel age=new JLabel("Age:");
        age.setBounds(30, 90, 50, 50);
        age.setFont(new Font("Tahoma",Font.PLAIN,14));
        p2.add(age);

        t2=new JTextField();
        t2.setBounds(130, 101, 120, 28);
        t2.setFont(com4.getFont());
        t2.addActionListener(this);
        p2.add(t2);
        
        l1=new JLabel();
        l1.setBounds(260, 101, 170, 20);
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
        gen.setBounds(30, 140, 60, 50);
        gen.setFont(new Font("Tahoma",Font.PLAIN,14));
        p2.add(gen);
        
        r1 = new JRadioButton("Male");
        r1.setBounds(130,150,60,30);
        r1.setFocusPainted(false);
        r1.setBackground(Color.white);
        r1.setSelected(true);
        p2.add(r1);
        
        r2 = new JRadioButton("Female");
        r2.setBounds(200,150,70,30);
        r2.setFocusPainted(false);
        r2.setBackground(Color.white);
        p2.add(r2);
        
        bg=new ButtonGroup();    
        bg.add(r1);
        bg.add(r2);
        
        
        JLabel job=new JLabel("Job:");
        job.setBounds(30, 190, 60, 50);
        job.setFont(new Font("Tahoma",Font.PLAIN,14));
        p2.add(job);
        
        String jobList[] = {"Front desk clerk","Driver","Porters","Housekeeper","Kitchen staff","Room service","Waiter/Waitress","Manager","Accountant"};
        
        com1=new JComboBox(jobList);
        com1.setBounds(130, 200, 150, 26);
        com1.setBackground(Color.white);
        com1.setFocusable(false);
        com1.addActionListener(this);
        p2.add(com1);
        
        JLabel salary=new JLabel("Salary:");
        salary.setBounds(30, 240, 60, 50);
        salary.setFont(new Font("Tahoma",Font.PLAIN,14));
        p2.add(salary);
        
        t3=new JTextField();
        t3.setBounds(130, 251, 120, 28);
        t3.setFont(com4.getFont());
        t3.addActionListener(this);
        p2.add(t3);
        
        l3=new JLabel();
        l3.setBounds(260, 251, 170, 20);
        l3.setOpaque(false);
        l3.setForeground(Color.red);
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
            		
            		String pattern2="^[0-9]{0,7}$";
            		Pattern patt2= Pattern.compile(pattern2);
            		Matcher m2= patt2.matcher(t3.getText());
            		
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
            			l3.setText("Cannot be more than 7 digits");
            		}
            		else
            		{
            			l3.setText(null);
            		}
        		}
        	}
        });
        
        JLabel phone=new JLabel("Phone no:");
        phone.setBounds(30, 290, 75, 50);
        phone.setFont(new Font("Tahoma",Font.PLAIN,14));
        p2.add(phone);
        
        
        t4=new JTextField();
        t4.setBounds(130, 301, 120, 28);
        t4.setFont(com4.getFont());
        t4.addActionListener(this);
        p2.add(t4);
        
        l4=new JLabel();
        l4.setBounds(250, 301, 200, 20);
        l4.setOpaque(false);
        l4.setForeground(Color.red);
        l4.setFont(new Font("Verdana",Font.BOLD,10));
        p2.add(l4);
        
        t4.addFocusListener(new FocusAdapter() 
        {
        	public void focusLost(FocusEvent fe)
        	{
        		if("".equals(t4.getText()))
        		{
        			l4.setText("Cannot be empty");
        		}
        		else
        		{
        			String pattern="^[a-zA-Z]{0,30}$";
            		Pattern patt= Pattern.compile(pattern);
            		Matcher m=patt.matcher(t4.getText());
            		
            		String pattern1="^[a-zA-Z0-9]{0,30}$";
            		Pattern patt1= Pattern.compile(pattern1);
            		Matcher m1=patt1.matcher(t4.getText());
            		
            		String pattern2="^[0-9]{10,10}$";
            		Pattern patt2= Pattern.compile(pattern2);
            		Matcher m2= patt2.matcher(t4.getText());
            		
            		if(m.matches())
            		{
            			l4.setText("Cannot contain characters");
            		}
            		else if(!m1.matches())
            		{
            			l4.setText("Cannot contain symbols");
            		}
            		else if(!m2.matches())
            		{
            			l4.setText("Cannot be less/more than 10 digits");
            		}
            		else
            		{
            			l4.setText(null);
            		}
        		}
        	}
		});
        
        JLabel empId=new JLabel("Employee Id:");
        empId.setBounds(30, 340, 85, 50);
        empId.setFont(new Font("Tahoma",Font.PLAIN,14));
        p2.add(empId);
        
        t5=new JTextField();
        t5.setBounds(130, 351, 120, 28);
        t5.setFont(com4.getFont());
        t5.addActionListener(this);
        p2.add(t5);
        
        l5=new JLabel();
        l5.setBounds(260, 351, 170, 20);
        l5.setOpaque(false);
        l5.setForeground(Color.red);
        l5.setFont(new Font("Verdana",Font.BOLD,10));
        p2.add(l5);
        
        t5.addFocusListener(new FocusAdapter() 
        {
        	public void focusLost(FocusEvent fe)
        	{
        		if("".equals(t5.getText()))
        		{
        			l5.setText("Cannot be empty");
        		}
        		else
        		{
        			String pattern="^[a-zA-Z]{0,30}$";
            		Pattern patt= Pattern.compile(pattern);
            		Matcher m=patt.matcher(t5.getText());
            		
            		String pattern1="^[a-zA-Z0-9]{0,30}$";
            		Pattern patt1= Pattern.compile(pattern1);
            		Matcher m1=patt1.matcher(t5.getText());
            		
            		String pattern2="^[0-9]{0,3}$";
            		Pattern patt2= Pattern.compile(pattern2);
            		Matcher m2= patt2.matcher(t5.getText());
            		
            		if(m.matches())
            		{
            			l5.setText("Cannot contain characters");
            		}
            		else if(!m1.matches())
            		{
            			l5.setText("Cannot contain symbols");
            		}
            		else if(!m2.matches())
            		{
            			l5.setText("Cannot be more than 3 digits");
            		}
            		else if(!m.matches() || m1.matches() || m2.matches())
            		{
            			ConnectingDatabase conn=new ConnectingDatabase();
    					try 
    					{
    						ResultSet rs=conn.statement.executeQuery("select EMPID from HotelEmployees where EMPID='"+t5.getText()+"'");
    						if(rs.next())
    						{
    							l5.setText("Id already exists");
    						}
    						else
    						{
    							l5.setText(null);
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
        		t4.setText("");
        		t5.setText("");
        		l1.setText(null);
        		l2.setText(null);
        		l3.setText(null);
        		l4.setText(null);
        		l5.setText(null);
        		
        		r1.setSelected(true);
        		com1.setSelectedItem("Front desk clerk");
        		b1.setLocation(50, 410);
    			b2.setLocation(150, 410);
    			p3.setVisible(false);
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
			if("".equals(t1.getText()) || "".equals(t2.getText()))
			{
				JOptionPane.showMessageDialog(null, "Please fill all details correctly");
			}
			else
			{
				if(l1.getText()!=null || l2.getText()!=null || l3.getText()!=null || l4.getText()!=null || l5.getText()!=null )
				{
					JOptionPane.showMessageDialog(null, "Please fill all details correctly");
				}
				else
				{
					if(com1.getSelectedItem()!="Driver")
					{
						String getNameFromTextField=t1.getText();
						String getAgeFromTextField=t2.getText();
						String getPhoneFromTextField=t4.getText();
						String getAdhaarFromTextField=t5.getText();
						String getSalaryFromTextField=t3.getText();
						String getGender=null;
						
						if(r1.isSelected())
						{
							getGender="Male";
						}
						else if(r2.isSelected())
						{
							getGender="Female";
						}
						
						String getJob=(String)com1.getSelectedItem();
						
						ConnectingDatabase conn = new ConnectingDatabase();
						String str="insert into HotelEmployees values('"+getNameFromTextField+"','"+getAdhaarFromTextField+"','"+getAgeFromTextField+"','"+getGender+"','"+getJob+"','"+getSalaryFromTextField+"','"+getPhoneFromTextField+"')";
						
						try
						{
						
							conn.statement.executeQuery(str);
							JOptionPane.showMessageDialog(null, "Employee Added"); 
							 
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
			    		t4.setText("");
			    		t5.setText("");
			    		
			    		r1.setSelected(true);
			    		com1.setSelectedIndex(0);

					
					}
					
					if(com1.getSelectedItem()=="Driver")
					{
						String getNameFromTextField=t1.getText();
						String getAgeFromTextField=t2.getText();
						String getPhoneFromTextField=t4.getText();
						String getAdhaarFromTextField=t5.getText();
						String getSalaryFromTextField=t3.getText();
						String getGender=null;
						
						if(r1.isSelected())
						{
							getGender="Male";
						}
						else if(r2.isSelected())
						{
							getGender="Female";
						}
						
						
						String getJob=(String)com1.getSelectedItem();
						String getCar=(String)com2.getSelectedItem();
						String getAvailability=(String)com3.getSelectedItem();
						String getLocation=(String)com4.getSelectedItem();
						
						
						ConnectingDatabase conn = new ConnectingDatabase();
						String str="insert into HotelEmployees values('"+getNameFromTextField+"','"+getAdhaarFromTextField+"','"+getAgeFromTextField+"','"+getGender+"','"+getJob+"','"+getSalaryFromTextField+"','"+getPhoneFromTextField+"')";
						String str1="insert into DriversTable values('"+getNameFromTextField+"','"+getAdhaarFromTextField+"','"+getCar+"','"+getAvailability+"','"+getLocation+"')";

						try
						{
							 conn.statement.executeQuery(str);
							 conn.statement.executeQuery(str1);
							 JOptionPane.showMessageDialog(null, "Employee Added");
							 
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
			    		t4.setText("");
			    		t5.setText("");
			    		
			    		r1.setSelected(true);
			    		com1.setSelectedIndex(0);
					}
				}
			}
		}
		
		
		
		if(ae.getSource()==com1 && com1.getSelectedItem()=="Driver")
		{
			b1.setLocation(50, 531);
			b2.setLocation(150, 531);
			p3.setVisible(true);
			
			
		
		}
		if(ae.getSource()==com1 && com1.getSelectedItem()!="Driver")
		{
			b1.setLocation(50, 410);
			b2.setLocation(150, 410);
			p3.setVisible(false);
		}
		
    	
	}
}
