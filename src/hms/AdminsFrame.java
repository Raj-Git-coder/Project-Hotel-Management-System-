package hms;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AdminsFrame extends JFrame implements ActionListener
{

	private static final long serialVersionUID = 1L;
	
	JPanel topPanel1, menuPanel, rightFrameBorder1, leftFrameBorder1, bottomFrameBorder1;
	JButton addEmp, updateEmp, viewEmp, addRooms, removeRooms, updateRooms, viewRooms, logout, exit1;
	
	
	AddEmployee addEmployeeClass;			//Declaring object of the class containing panel to add employee details
	
	AddRooms addRoomsClass;
	AllEmployeeInfo allEmployeeInfoClass;
	SearchRooms searchRoomsClass;
	UpdateEployee updateEployeeClass;
	UpdateRooms updateRoomsClass;
	public AdminsFrame() 
	{

		addEmployeeClass=new AddEmployee();						//Calling the external class
		add(addEmployeeClass.p2);								//Adding the panel from the external class AddEmployee
		addEmployeeClass.p2.setVisible(false);					//Panel wont be visible until setVisible is true
		
		addRoomsClass=new AddRooms();						//Calling the external class
		add(addRoomsClass.p2);								//Adding the panel from the external class AddRooms
		addRoomsClass.p2.setVisible(false);					//Panel wont be visible until setVisible is true
		
		allEmployeeInfoClass=new AllEmployeeInfo();					//Calling the external class
		add(allEmployeeInfoClass.p2);								//Adding the panel from the external class AddEmployee
		allEmployeeInfoClass.p2.setVisible(false);					//Panel wont be visible until setVisible is true
		
		searchRoomsClass=new SearchRooms();						//Calling the external class
		add(searchRoomsClass.p2);								//Adding the panel from the external class AddEmployee
		searchRoomsClass.p2.setVisible(false);				//Panel wont be visible until setVisible is true
		
		updateEployeeClass=new UpdateEployee();					//Calling the external class
		add(updateEployeeClass.p2);								//Adding the panel from the external class AddEmployee
		updateEployeeClass.p2.setVisible(false);				//Panel wont be visible until setVisible is true
		
		updateRoomsClass=new UpdateRooms();							//Calling the external class
		add(updateRoomsClass.p2);									//Adding the panel from the external class AddRooms
		updateRoomsClass.p2.setVisible(false);						//Panel wont be visible until setVisible is true
		
//...........Adding BackGroundImage .....................
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("codes/Icon1/main.jpg"));
		JLabel imageLabel = new JLabel(i1);
		imageLabel.setBounds(200,30,1043,563);
		add(imageLabel);
		

		
//...........Adding TopPanel.........................
		
		topPanel1= new JPanel();
		topPanel1.setLayout(null);
		topPanel1.setBounds(0, 0, 1250, 26);
		topPanel1.setBackground(Color.black);
		add(topPanel1);
		
		JLabel title=new JLabel("Admin's Dashboard");
		title.setBounds(5, 0, 130, 26);
		title.setForeground(Color.white);
		topPanel1.add(title);
		
		
		
		
//.........Adding Menu Panel...............
		
		menuPanel = new JPanel();
		menuPanel.setBounds(3, 29, 193, 565);
		menuPanel.setLayout(null);
		menuPanel.setBackground(Color.black);
		this.add(menuPanel);
		

		
		//.........Adding Add Employee Button.............
		
		addEmp =new JButton("Add Employee");
		addEmp.setBounds(0, 4, 190, 40);
		addEmp.setBackground(Color.DARK_GRAY);
		addEmp.setForeground(Color.white);
		addEmp.setFocusPainted(false);
		addEmp.setBorderPainted(false);
		addEmp.addActionListener(this);
		menuPanel.add(addEmp);
				
		addEmp.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent me)
			{
				addRoomsClass.p2.setVisible(false);
				allEmployeeInfoClass.p2.setVisible(false);
				searchRoomsClass.p2.setVisible(false);
				updateEployeeClass.p2.setVisible(false);
				updateRoomsClass.p2.setVisible(false);
				addEmployeeClass.p2.setVisible(true);
			}
		});
		
		
		//.....Adding Update Employee Button.........
		
		updateEmp=new JButton("Update Employee");
		updateEmp.setBounds(0, 44, 190, 40);
		updateEmp.setBackground(new Color(200,200,200));
		updateEmp.setForeground(Color.black);
		updateEmp.setFocusPainted(false);
		updateEmp.setBorderPainted(false);
		updateEmp.addActionListener(this);
		menuPanel.add(updateEmp);
		
		updateEmp.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent me)
			{
				addRoomsClass.p2.setVisible(false);
				allEmployeeInfoClass.p2.setVisible(false);
				searchRoomsClass.p2.setVisible(false);
				addEmployeeClass.p2.setVisible(false);
				updateRoomsClass.p2.setVisible(false);
				updateEployeeClass.p2.setVisible(true);
				
			}
		});
		
		
	
		//......Adding View Employees Button.............
		
		viewEmp =new JButton("View Employees");
		viewEmp.setBounds(0, 84, 190, 40);
		viewEmp.setBackground(Color.DARK_GRAY);
		viewEmp.setForeground(Color.white);
		viewEmp.setFocusPainted(false);
		viewEmp.setBorderPainted(false);
		viewEmp.addActionListener(this);
		menuPanel.add(viewEmp);
		
		viewEmp.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent me)
			{
				AdminsFrame a=new AdminsFrame();
				dispose();
				a.allEmployeeInfoClass.p2.setVisible(true);

			}
			
		});
		
		
		//......Adding Add Rooms Option.............
		
		addRooms =new JButton("Add Rooms");
		addRooms.setBounds(0, 124, 190, 40);
		addRooms.setBackground(new Color(200,200,200));
		addRooms.setForeground(Color.black);
		addRooms.setFocusPainted(false);
		addRooms.setBorderPainted(false);
		addRooms.addActionListener(this);
		menuPanel.add(addRooms);
		
		
		addRooms.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent me)
			{
				addEmployeeClass.p2.setVisible(false);
				allEmployeeInfoClass.p2.setVisible(false);
				searchRoomsClass.p2.setVisible(false);
				updateEployeeClass.p2.setVisible(false);
				updateRoomsClass.p2.setVisible(false);
				addRoomsClass.p2.setVisible(true);
			
			}
		});
		
		//......Adding Update and remove Rooms Option.............
		
		updateRooms =new JButton("Update Rooms");
		updateRooms.setBounds(0, 164, 190, 40);
		updateRooms.setBackground(Color.DARK_GRAY);
		updateRooms.setForeground(Color.white);
		updateRooms.setFocusPainted(false);
		updateRooms.setBorderPainted(false);
		menuPanel.add(updateRooms);
		
		updateRooms.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent me)
			{
				addEmployeeClass.p2.setVisible(false);
				allEmployeeInfoClass.p2.setVisible(false);
				searchRoomsClass.p2.setVisible(false);
				updateEployeeClass.p2.setVisible(false);
				addRoomsClass.p2.setVisible(false);
				updateRoomsClass.p2.setVisible(true);
			
			}
		});
		
		
		//.....Adding View Rooms Option.............
		
		viewRooms =new JButton("View Rooms");
		viewRooms.setBounds(0, 204, 190, 40);
		viewRooms.setBackground(new Color(200,200,200));
		viewRooms.setForeground(Color.black);
		viewRooms.setFocusPainted(false);
		viewRooms.setBorderPainted(false);
		viewRooms.addActionListener(this);
		menuPanel.add(viewRooms);

		viewRooms.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent me)
			{
				AdminsFrame a=new AdminsFrame();
				dispose();
				a.searchRoomsClass.p2.setVisible(true);
			
			}
		});
		
		//.........\Adding Logout Button..............
		
		logout =new JButton("Logout");
		logout.setBounds(0, 244, 190, 40);
		logout.setBackground(Color.DARK_GRAY);
		logout.setForeground(Color.white);
		logout.setFocusPainted(false);
		logout.setBorderPainted(false);
		logout.addActionListener(this);
		menuPanel.add(logout);
		
		logout.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e)
			{
				try 
				{
					
					new HotelManagementSystem();
					dispose();
				} 
				catch (FontFormatException e1) 
				{
					
					e1.printStackTrace();
				} 
				catch (IOException e1) 
				{
					
					e1.printStackTrace();
				}
			}
		});
		
//..........Adding Left Right Bottom Borders to JFrame.............		
		
		rightFrameBorder1=new JPanel();
		rightFrameBorder1.setBounds(1247, 0, 3, 1224);
		rightFrameBorder1.setBackground(Color.black);
		add(rightFrameBorder1);
		
		leftFrameBorder1=new JPanel();
		leftFrameBorder1.setBounds(0, 26, 3, 1224);
		leftFrameBorder1.setBackground(Color.black);
		add(leftFrameBorder1);
		
		bottomFrameBorder1 = new JPanel();
		bottomFrameBorder1.setBounds(0, 597, 1250, 3);
		bottomFrameBorder1.setBackground(Color.black);
		add(bottomFrameBorder1);
		
		
		
//.........Adding close Frame button to JFrame................		
		
		exit1= new JButton("X");
		exit1.setBounds(1200, 4, 53, 20);
		exit1.setFont(new Font("SAN_SERIF",Font.BOLD,13));
		exit1.setBackground(topPanel1.getBackground());
		exit1.setForeground(Color.white);
		exit1.setBorder(null);
		exit1.setFocusPainted(false);
		exit1.addActionListener(this);
		topPanel1.add(exit1);
		
		exit1.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent me)
			{
				System.exit(0);
			}
		});
		
		
		
		
		
//.........Setting JFrame..........................		
		
		setBounds(170, 100, 1250, 600);
		
		setLayout(null);
		setUndecorated(true);
		setVisible(true);
	}

	public static void main(String[] args) 
	{
		new AdminsFrame();

	}

	public void actionPerformed(ActionEvent ae) 
	{
		

	}

}
