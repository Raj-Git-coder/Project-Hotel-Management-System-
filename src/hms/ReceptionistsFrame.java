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

public class ReceptionistsFrame extends JFrame implements ActionListener
{

	private static final long serialVersionUID = 1L;
	
	JPanel topPanel1, menuPanel, rightFrameBorder1, leftFrameBorder1, bottomFrameBorder1;
	JButton addCustomer, searchRooms, checkOut, updateEmp, viewEmp, viewGuests, printBill, addPickup, logout, exit1;
	
	AddEmployee addEmployeeClass;			//Declaring object of the class containing panel to add employee details
	AddRooms addRoomsClass;
	AddPickupService addPickupServiceClass;
	AllEmployeeInfo allEmployeeInfoClass;
	
	AddGuests addGuestClass;
	CustomerInfo customerInfoClass;
	UpdateRooms updateRoomsClass;
	PrintBill printBillClass;
	CheckOutDetails checkOutDetailsClass;
	SearchRooms searchRoomsClass;
	public ReceptionistsFrame() 
	{

		addEmployeeClass=new AddEmployee();							//Calling the external class
		add(addEmployeeClass.p2);									//Adding the panel from the external class AddEmployee
		addEmployeeClass.p2.setVisible(false);						//Panel wont be visible until setVisible is true
			
		addRoomsClass=new AddRooms();								//Calling the external class
		add(addRoomsClass.p2);										//Adding the panel from the external class AddRooms
		addRoomsClass.p2.setVisible(false);							//Panel wont be visible until setVisible is true
		
		addPickupServiceClass=new AddPickupService();				//Calling the external class
		add(addPickupServiceClass.p2);								//Adding the panel from the external class AddRooms
		addPickupServiceClass.p2.setVisible(false);					//Panel wont be visible until setVisible is true
		
		allEmployeeInfoClass=new AllEmployeeInfo();					//Calling the external class
		add(allEmployeeInfoClass.p2);								//Adding the panel from the external class AddRooms
		allEmployeeInfoClass.p2.setVisible(false);					//Panel wont be visible until setVisible is true
		
		
		addGuestClass=new AddGuests();								//Calling the external class
		add(addGuestClass.p2);										//Adding the panel from the external class AddRooms
		addGuestClass.p2.setVisible(false);							//Panel wont be visible until setVisible is true
		
		customerInfoClass=new CustomerInfo();						//Calling the external class
		add(customerInfoClass.p2);									//Adding the panel from the external class AddRooms
		customerInfoClass.p2.setVisible(false);						//Panel wont be visible until setVisible is true
		
		updateRoomsClass=new UpdateRooms();							//Calling the external class
		add(updateRoomsClass.p2);									//Adding the panel from the external class AddRooms
		updateRoomsClass.p2.setVisible(false);						//Panel wont be visible until setVisible is true
		
		printBillClass=new PrintBill();							//Calling the external class
		add(printBillClass.p2);									//Adding the panel from the external class AddRooms
		printBillClass.p2.setVisible(false);						//Panel wont be visible until setVisible is true
		
		checkOutDetailsClass=new CheckOutDetails();							//Calling the external class
		add(checkOutDetailsClass.p2);									//Adding the panel from the external class AddRooms
		checkOutDetailsClass.p2.setVisible(false);						//Panel wont be visible until setVisible is true
		
		searchRoomsClass=new SearchRooms();							//Calling the external class
		add(searchRoomsClass.p2);									//Adding the panel from the external class AddRooms
		searchRoomsClass.p2.setVisible(false);						//Panel wont be visible until setVisible is true
		
//...........Adding BackGroundImage .....................
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hms/icns/main.jpg"));
		JLabel imageLabel = new JLabel(i1);
		imageLabel.setBounds(200,30,1043,563);
		add(imageLabel);
		

		
//...........Adding TopPanel.........................
		
		topPanel1= new JPanel();
		topPanel1.setLayout(null);
		topPanel1.setBounds(0, 0, 1250, 26);
		topPanel1.setBackground(Color.black);
		add(topPanel1);
		
		JLabel title=new JLabel("Receptionist's Dashboard");
		title.setBounds(5, 0, 180, 26);
		title.setForeground(Color.white);
		topPanel1.add(title);
		
		
		
//.........Adding Menu Panel...............
		
		menuPanel = new JPanel();
		menuPanel.setBounds(3, 29, 193, 565);
		menuPanel.setLayout(null);
		menuPanel.setBackground(Color.black);
		add(menuPanel);
		
		
		
		//.........Adding Add Customer Button.............
		
		addCustomer =new JButton("Add Guests");
		addCustomer.setBounds(0, 4, 190, 40);
		addCustomer.setBackground(Color.DARK_GRAY);
		addCustomer.setForeground(Color.white);
		addCustomer.setFocusPainted(false);
		addCustomer.setBorderPainted(false);
		addCustomer.addActionListener(this);
		menuPanel.add(addCustomer);
		
		//Adding ActionListner to make the form visible on button click
		
		addCustomer.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent me)
			{
				customerInfoClass.p2.setVisible(false);
				addEmployeeClass.p2.setVisible(false);
				addRoomsClass.p2.setVisible(false);
				addPickupServiceClass.p2.setVisible(false);
				allEmployeeInfoClass.p2.setVisible(false);
				checkOutDetailsClass.p2.setVisible(false);
				printBillClass.p2.setVisible(false);
				updateRoomsClass.p2.setVisible(false);
				searchRoomsClass.p2.setVisible(false);
				addGuestClass.p2.setVisible(true);
			}
		});
		
		//.....Adding Update Employee Button.........
		
		searchRooms=new JButton("View Rooms");
		searchRooms.setBounds(0, 44, 190, 40);
		searchRooms.setBackground(new Color(200,200,200));
		searchRooms.setForeground(Color.black);
		searchRooms.setFocusPainted(false);
		searchRooms.setBorderPainted(false);
		searchRooms.addActionListener(this);
		menuPanel.add(searchRooms);
		
		searchRooms.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent me)
			{
				ReceptionistsFrame rr=new ReceptionistsFrame();
				dispose();
				rr.searchRoomsClass.p2.setVisible(true);
			}
		});
		
		
		//......Adding View Employees Button.............
		
		viewEmp =new JButton("Employee Info");
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
				ReceptionistsFrame r=new ReceptionistsFrame();
				dispose();
				r.allEmployeeInfoClass.p2.setVisible(true);
				
			}
			
		});
		
		
		//......Adding View Guests  Option.............
		
		viewGuests =new JButton("View Guests");
		viewGuests.setBounds(0, 124, 190, 40);
		viewGuests.setBackground(new Color(200,200,200));
		viewGuests.setForeground(Color.black);
		viewGuests.setFocusPainted(false);
		viewGuests.setBorderPainted(false);
		viewGuests.addActionListener(this);
		menuPanel.add(viewGuests);
		
		
		viewGuests.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent me)
			{
				ReceptionistsFrame r1=new ReceptionistsFrame();
				dispose();
				r1.customerInfoClass.p2.setVisible(true);
			}
		});
		
		//......Adding Remove Rooms Option.............
		
		printBill =new JButton("Print Bill");
		printBill.setBounds(0, 164, 190, 40);
		printBill.setBackground(Color.DARK_GRAY);
		printBill.setForeground(Color.white);
		printBill.setFocusPainted(false);
		printBill.setBorderPainted(false);
		printBill.addActionListener(this);
		menuPanel.add(printBill);
		
		printBill.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent me)
			{
				customerInfoClass.p2.setVisible(false);
				addEmployeeClass.p2.setVisible(false);
				addRoomsClass.p2.setVisible(false);
				addPickupServiceClass.p2.setVisible(false);
				allEmployeeInfoClass.p2.setVisible(false);
				addGuestClass.p2.setVisible(false);
				updateRoomsClass.p2.setVisible(false);
				checkOutDetailsClass.p2.setVisible(false);
				searchRoomsClass.p2.setVisible(false);
				printBillClass.p2.setVisible(true);
			}
		});
		
		
		//.....Adding View Rooms Option.............
		
		checkOut =new JButton("Check-out");
		checkOut.setBounds(0, 204, 190, 40);
		checkOut.setBackground(new Color(200,200,200));
		checkOut.setForeground(Color.black);
		checkOut.setFocusPainted(false);
		checkOut.setBorderPainted(false);
		checkOut.addActionListener(this);
		menuPanel.add(checkOut);
		
		checkOut.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent me)
			{
				customerInfoClass.p2.setVisible(false);
				addEmployeeClass.p2.setVisible(false);
				addRoomsClass.p2.setVisible(false);
				addPickupServiceClass.p2.setVisible(false);
				allEmployeeInfoClass.p2.setVisible(false);
				addGuestClass.p2.setVisible(false);
				printBillClass.p2.setVisible(false);
				updateRoomsClass.p2.setVisible(false);
				searchRoomsClass.p2.setVisible(false);
				checkOutDetailsClass.p2.setVisible(true);
			}
		});
		
		//.....Adding Pickup Service Option..............
		
		addPickup =new JButton("Add Pickup");
		addPickup.setBounds(0, 244, 190, 40);
		addPickup.setBackground(Color.DARK_GRAY);
		addPickup.setForeground(Color.white);
		addPickup.setFocusPainted(false);
		addPickup.setBorderPainted(false);
		addPickup.addActionListener(this);
		menuPanel.add(addPickup);
		
		addPickup.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent me)
			{
				ReceptionistsFrame r1=new ReceptionistsFrame();
				dispose();
				r1.addPickupServiceClass.p2.setVisible(true);
				
			
			}
		});
		
//..........Adding Logout Button.........................
		
		logout =new JButton("Logout");
		logout.setBounds(0, 284, 190, 40);
		logout.setBackground(new Color(200,200,200));
		logout.setForeground(Color.black);
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
				} catch (IOException e1) 
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
		
		setBounds(25, 100, 1250, 600);
		
		setLayout(null);
		setUndecorated(true);
		setVisible(true);
	}

	public static void main(String[] args) 
	{
		new ReceptionistsFrame();

	}

	public void actionPerformed(ActionEvent arg0) 
	{
		
		
	}

}
