package hms;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class HotelManagementSystem extends JFrame implements ActionListener 
{
	
	private static final long serialVersionUID = 1L;
	
	JPanel topPanel;
	JButton loginButton, registerButton, exit;
	JTextField usernameTextField;
	JPasswordField passwordField;
	JComboBox<String> combox;
	


	public HotelManagementSystem() throws FontFormatException, IOException 
	{
		
//................Adding Image to login screen.................................
		
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hms/icns/hotel.jpg"));
		JLabel l1 = new JLabel(i1);
		l1.setBounds(0,0,1250,500);
		add(l1);
		
		
		
//.................Adding TopPanel (Title,Minimize,Maximize,Close Buttons)...........
		
		topPanel=new JPanel();
		topPanel.setLayout(null);
		topPanel.setBounds(0, 0, 1250, 26);
		topPanel.setBackground( Color.black);
		l1.add(topPanel);
		
		
		//............Adding Title........................
		
		
		JLabel l3=new JLabel("Login Window");
		l3.setFont(new Font("SERIF",Font.BOLD,15));
		l3.setBounds(15, 4, 150, 17);
		l3.setForeground(Color.white);
		topPanel.add(l3);
		
		//...........Adding exit button...............
		
		exit = new JButton("X");
		exit.setBounds(1200, 4, 53, 20);
		exit.setFont(new Font("SAN_SERIF",Font.BOLD,13));
		exit.setBackground(topPanel.getBackground());
		exit.setForeground(Color.white);
		exit.setBorder(null);
		exit.setFocusPainted(false);
		
		exit.addActionListener(this);
		
		
		topPanel.add(exit);
		
			//.......Adding closing function on x button with action listner..............
		
		exit.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent me)
			{
				System.exit(0);
			}
		});
	
		
//.............Adding Username label ................
		
		JLabel usernameLabel= new JLabel("Username");
		usernameLabel.setBounds(100, 150, 100, 60);
		usernameLabel.setFont(new Font("Tahoma",Font.PLAIN,17));
		usernameLabel.setForeground(Color.white);
		l1.add(usernameLabel);
//.................Adding textbox for username................
		
		usernameTextField=new JTextField();
		usernameTextField.setBounds(250, 171, 130, 24);
		usernameTextField.setForeground(Color.black);
		
		Border border = BorderFactory.createLineBorder(Color.black);				//Creating border to textField
	    usernameTextField.setBorder(border);										//Setting border to textField
		
	    l1.add(usernameTextField);
//............Adding Password Label......................
		
		JLabel passwordLabel= new JLabel("Password");
		passwordLabel.setBounds(100, 230, 100, 60);
		passwordLabel.setFont(new Font("Tahoma",Font.PLAIN,17));
		passwordLabel.setForeground(Color.white);
		l1.add(passwordLabel);
//..........Adding Password field......................
		
		passwordField=new JPasswordField();
		passwordField.setBounds(250, 248, 130, 24);

	    passwordField.setBorder(border);									//Setting border to textField
	    
		l1.add(passwordField);
		
		
//............Adding option to login as Admin or Receptionist............
		
		
		JLabel comboxLabel= new JLabel("Login as:");
		comboxLabel.setBounds(100, 302, 100, 60);
		comboxLabel.setFont(new Font("Tahoma",Font.PLAIN,15));
		comboxLabel.setForeground(Color.white);
		l1.add(comboxLabel);
		
		combox=new JComboBox<String>();
		combox.addItem("Receptionist");
		combox.addItem("Admin");
		combox.setBounds(250,320,130,25);
		combox.setBackground(Color.white);
		combox.setForeground(Color.black);
		combox.setBorder(null);
		combox.setFocusable(false);
		passwordField.setFont(combox.getFont());
		usernameTextField.setFont(combox.getFont());
		l1.add(combox);
		
//...........Adding Login button..................
		
		loginButton=new JButton("Login");
		loginButton.setBounds(95, 400, 130, 28);
		loginButton.setBackground(Color.black);
		loginButton.setForeground(Color.white);
		loginButton.setBorder(null);
		loginButton.setFocusPainted(false);
		loginButton.addActionListener(this);
		l1.add(loginButton);
		
//............Adding Register Button..............
		
		registerButton=new JButton("Register");
		registerButton.setBounds(250, 400, 130, 28);
		registerButton.setBackground(Color.black);
		registerButton.setForeground(Color.white);
		registerButton.setBorder(null);
		registerButton.setFocusPainted(false);
		registerButton.addActionListener(this);
		l1.add(registerButton);
		
//...............Adding custom font.........................
		
		InputStream is = HotelManagementSystem.class.getResourceAsStream("/hms/CustomFont/VeganStyle.ttf");
		Font font = Font.createFont(Font.TRUETYPE_FONT, is);
		Font sizedFont = font.deriveFont(25f);
		
//..............Adding Title of the Project(Accomodation-hms).......................		
		
		JLabel l2=new JLabel("Accomodation A Hotel Management System");
		l2.setBounds(100,50,1000,50);
		l2.setFont(sizedFont);
		l2.setForeground(new Color(255,255,255,255));
		l1.add(l2);
		
//....................Creating border for jframe............
		
		JPanel leftFrameBorder=new JPanel();
		leftFrameBorder.setBounds(0, 26, 3, 1224);
		leftFrameBorder.setBackground(Color.black);
		l1.add(leftFrameBorder);
		
		JPanel bottomFrameBorder = new JPanel();
		bottomFrameBorder.setBounds(1, 497, 1250, 3);
		bottomFrameBorder.setBackground(Color.black);
		l1.add(bottomFrameBorder);
		
		JPanel rightFrameBorder = new JPanel();
		rightFrameBorder.setBounds(1247, 26, 3, 1224);
		rightFrameBorder.setBackground(Color.black);
		l1.add(rightFrameBorder);
		
		
//................Setting JFrame....................................		
		setBounds(25, 100, 1250, 500);
		setLayout(null);
		setUndecorated(true);
		setVisible(true);
		
	}
	
	
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent ae) 
	{
		
		if(ae.getSource()==loginButton)
		{
			if("".equals(usernameTextField.getText()) || "".equals(passwordField.getText()))
			{
				JOptionPane.showMessageDialog(null, "Username or password is invalid");
				usernameTextField.setText(null);
				passwordField.setText(null);
			}
			else
			{
				if(combox.getSelectedItem()=="Admin")
				{
					String username = usernameTextField.getText();
					String password =new String(passwordField.getPassword());       //don't use toString()
					ConnectingDatabase conn = new ConnectingDatabase();
				
					String str = "select * from AdminsData where Username = '"+username+"' and Password = '"+password+"'";
				
					try
					{
				
						ResultSet rs=conn.statement.executeQuery(str);
					
						if(rs.next())
						{
							new AdminsFrame();
							this.setVisible(false);
						}
						else if(!rs.next())
						{
							JOptionPane.showMessageDialog(null, "Username or password is invalid");
							new HotelManagementSystem();
						
						}
						
						rs.close();
			        	conn.statement.close();
			        	conn.connection.close();
					
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				
				else if(combox.getSelectedItem()=="Receptionist")
				{
					String username1 = usernameTextField.getText();
					String password1 =new String(passwordField.getPassword());       //don't use toString()
					ConnectingDatabase conn = new ConnectingDatabase();
				
					String str1 = "select * from ReceptionistData where Username = '"+username1+"' and Password = '"+password1+"'";
				
					try
					{
				
						ResultSet rs1=conn.statement.executeQuery(str1);
					
						if(rs1.next())
						{
							new ReceptionistsFrame();
							this.setVisible(false);
						}
						else if(!rs1.next())
						{
							JOptionPane.showMessageDialog(null, "Username or password is invalid");
							new HotelManagementSystem();
						
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
			}
			
		}
		else if(ae.getSource()==registerButton)
		{
			
			if("".equals(usernameTextField.getText()) || "".equals(passwordField.getText()))
			{
				JOptionPane.showMessageDialog(null, "Username or password is invalid");
				usernameTextField.setText(null);
				passwordField.setText(null);
			}
			else
			{
				ConnectingDatabase conn = new ConnectingDatabase();
				String password1 =new String(passwordField.getPassword());  
				
				try 
				{
					if(combox.getSelectedItem()=="Admin")
					{
						ResultSet rs=conn.statement.executeQuery("select Username from AdminsData where Username='"+usernameTextField.getText()+"'");
						if(rs.next())
						{
							JOptionPane.showMessageDialog(null, "User Already Exists");
						}
						else
						{
							conn.statement.executeQuery("insert into AdminsData values('"+usernameTextField.getText()+"','"+password1+"')");
							JOptionPane.showMessageDialog(null, "Registered as Admin");
						}
					}
					else if(combox.getSelectedItem()=="Receptionist")
					{
						ResultSet rs=conn.statement.executeQuery("select Username from ReceptionistData where Username='"+usernameTextField.getText()+"'");
						if(rs.next())
						{
							JOptionPane.showMessageDialog(null, "User Already Exists");
						}
						else
						{
							conn.statement.executeQuery("insert into ReceptionistData values('"+usernameTextField.getText()+"','"+password1+"')");
							JOptionPane.showMessageDialog(null, "Registered as Receptionist");
						}
					}
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
				
				usernameTextField.setText("");
				passwordField.setText("");
				combox.setSelectedIndex(0);
			}
		}
		
	}

	
	public static void main(String[] args) throws FontFormatException, IOException 
	{
		new HotelManagementSystem();
	}


	

}
