package hms;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class AddPickupService implements ActionListener 
{

	JPanel p2, panelForJTable, panelForJTable1, panelForJTable2;
	JTable table, table1, passTable, table2;
	
	JComboBox<String> com1;
	JButton b1,b2;
	JCheckBox chk1;
	JScrollPane scrollPane, scrollPane1;
	
	public AddPickupService() 
	{
		p2=new JPanel();
        p2.setLayout(null);
        p2.setBackground(Color.white);
        p2.setBounds(201, 31, 946, 561);
        
        panelForJTable=new JPanel(new GridLayout());
        panelForJTable.setBounds(3, 225, 939, 333);
        panelForJTable.setBackground(Color.white);
        p2.add(panelForJTable);
        
        panelForJTable1=new JPanel(new GridLayout());
        panelForJTable1.setBounds(3, 225, 939, 333);
        panelForJTable1.setBackground(Color.black);
        panelForJTable1.setVisible(false);
        p2.add(panelForJTable1);
        
        panelForJTable2=new JPanel(new GridLayout());
        panelForJTable2.setBounds(3, 225, 939, 333);
        panelForJTable2.setBackground(Color.black);
        panelForJTable2.setVisible(false);
        p2.add(panelForJTable2);
        
        JLabel title=new JLabel("Add Pickup Service");
        title.setBounds(100, 0, 150, 50);
        title.setFont(new Font("Tahoma",Font.PLAIN,14));
        p2.add(title);
        
        JLabel empId=new JLabel("Employee Id:");
        empId.setBounds(30, 40, 100, 50);
        empId.setFont(new Font("Tahoma",Font.PLAIN,14));
        p2.add(empId);
        
        com1=new JComboBox<String>();
        com1.addItem("");
        try
        {
        	ConnectingDatabase conn =new ConnectingDatabase();
        	ResultSet rs = conn.statement.executeQuery("select * from DriversTable order by EMPID");
        	
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
        com1.setBounds(135, 51, 150, 26);
        com1.setBackground(Color.white);
        com1.setBorder(null);
        com1.setFocusable(false);
        
        p2.add(com1);
        
        chk1=new JCheckBox("Show all Available");
        chk1.setBounds(295, 51, 250, 30);
        chk1.setBackground(Color.white);
        chk1.setFocusable(false);
        chk1.addActionListener(this);
        p2.add(chk1);
        
        b1=new JButton("Search");
        b1.setBounds(30, 160, 75, 25);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setFocusPainted(false);
        b1.setBorderPainted(false);
        b1.addActionListener(this);
        p2.add(b1);
        
        b2=new JButton("Clear");
        b2.setBounds(140, 160, 75, 25);
        b2.setBackground(new Color	(175,0,27));
        b2.setForeground(Color.white);
        b2.setFocusPainted(false);
        b2.setBorderPainted(false);
        b2.addActionListener(this);
        p2.add(b2);
        
        
        b2.addMouseListener(new MouseAdapter() 
        {
        	public void mouseClicked(MouseEvent me)
        	{
        		com1.setSelectedIndex(0);
        		chk1.setSelected(false);
        		panelForJTable1.setVisible(false);
        		panelForJTable2.setVisible(false);
        		p2.add(panelForJTable);
        		
        	}
		});
        
//...........Adding Employee info from database to JPanel..........................
        
        
        try
        {
        	
        	ConnectingDatabase conn=new ConnectingDatabase();
        	Vector<String> columnNames=new Vector<String>();
        	Vector<Vector<Object>> data=new Vector<Vector<Object>>();
        	Vector<Object> rows = null;
        	String str="select * from DriversTable order by EMPID";
        	ResultSet rs= conn.statement.executeQuery(str);
        	ResultSetMetaData rsmd=rs.getMetaData();
        	int columns =rsmd.getColumnCount();
        	
        	for(int i=1;i<=columns;i++)
        	{
        		columnNames.addElement(rsmd.getColumnName(i));
        	}
        	
        	while(rs.next())
        	{
        		rows=new Vector<Object>(columns);
        		
        		for(int i=1;i<=columns;i++)
        		{
        			rows.addElement(rs.getObject(i));
        		}
        		data.addElement(rows);
        	}
        	
        	
        	rs.close();
        	conn.statement.close();
        	conn.connection.close();
       
//............Creating Table structure for the database values...................
        	
        	table=new JTable(data,columnNames)
        	{
        		
				private static final long serialVersionUID = 1L;

				public Class<?> getColumnClass(int column)
        		{
        			for(int row=0; row<table.getRowCount(); row++)
        			{
        				Object o=table.getValueAt(row,column);
        				
        				if(o!=null)
        				{
        					return o.getClass();
        				}
        			}
        			return Object.class;
        		}
				
				public Component prepareRenderer(TableCellRenderer renderer, int row, int column) 
				{
		            Component comp = super.prepareRenderer(renderer, row, column);
		            Color alternateColor = new Color(200,244,239);
		            Color whiteColor = new Color(181,231,228);
		            if(!comp.getBackground().equals(getSelectionBackground())) 
		            {
		               Color c = (row % 2 == 0 ? alternateColor : whiteColor);
		               comp.setBackground(c);
		               c = null;
		            }
		            return comp;
		         }
        	};
        
        	DefaultTableCellRenderer MyHeaderRender = new DefaultTableCellRenderer();
            MyHeaderRender.setBackground(Color.decode("#696B9E"));
            MyHeaderRender.setForeground(Color.decode("#FCE7FC"));

            for(int i=0; i < table.getColumnCount(); i++)
            {
            	table.getTableHeader().getColumnModel().getColumn(i).setHeaderRenderer(MyHeaderRender);
            }
            
            DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
            rightRenderer.setHorizontalAlignment(JLabel. LEFT);
            table.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
            
        	table.setRowHeight(30);
        	table.setBackground(Color.white);
        	table.setFont(new Font("Tahoma",Font.PLAIN,14));
        	table.setForeground(Color.black);
        	table.setShowGrid(true);
            table.setGridColor(new Color(190,237,233));
        	table.setEnabled(false);
        	scrollPane = new JScrollPane(table);
        	
        	
        	panelForJTable.add(scrollPane);
        
        }
        catch(Exception e)
        {
        	
        }
        
        JPanel leftFrameBorder=new JPanel();
		leftFrameBorder.setBounds(0, 0, 3, 561);
		leftFrameBorder.setBackground(Color.black);
		p2.add(leftFrameBorder);
		
		JPanel bottomFrameBorder = new JPanel();
		bottomFrameBorder.setBounds(3, 558, 946, 3);
		bottomFrameBorder.setBackground(Color.black);
		p2.add(bottomFrameBorder);
		
		JPanel rightFrameBorder = new JPanel();
		rightFrameBorder.setBounds(942, 0, 4, 561);
		rightFrameBorder.setBackground(Color.black);
		p2.add(rightFrameBorder);
		
		JPanel topFrameBorder = new JPanel();
		topFrameBorder.setBounds(0, 0, 946, 3);
		topFrameBorder.setBackground(Color.black);
		p2.add(topFrameBorder);
		

	}

	public void tableCall()
    {
		try
		{
			if(passTable==table1)
			{
				panelForJTable1.add(passTable);
				
			}
			else if(passTable==table2)
			{
				panelForJTable2.add(passTable);
				
			}
		}
		
		catch(Exception e)
		{
     	
		}
    }


	public void actionPerformed(ActionEvent ae) 
	{
		
		if(ae.getSource()==b1)
		{	
			if(com1.getSelectedItem()==com1.getSelectedItem())
			{
				tableCall();
				p2.remove(panelForJTable);
				p2.remove(panelForJTable2);
				p2.revalidate();
				p2.repaint();
				panelForJTable1.removeAll();
				
				
				try
			    {
					ConnectingDatabase conn=new ConnectingDatabase();
					Vector<String> columnNames=new Vector<String>();
					Vector<Vector<Object>> data=new Vector<Vector<Object>>();
					Vector<Object> rows = null;
			       	String str=null;
			        	
			       	if(chk1.isSelected())
			       	{
			       		str="select * from DriversTable where AVAILABILITY like 'Available%' order by EMPID";
			       	}
			       	else
			       	{
			       		str="select * from DriversTable where EMPID='"+com1.getSelectedItem()+"' order by EMPID";
			       	}
			        	
			       	ResultSet rs= conn.statement.executeQuery(str);
			       	ResultSetMetaData rsmd=rs.getMetaData();
			       	int columns =rsmd.getColumnCount();
			        	
			       	for(int i=1;i<=columns;i++)
			       	{
			       		columnNames.addElement(rsmd.getColumnName(i));
			       	}
			        	
			       	while(rs.next())
			       	{
			       		rows=new Vector<Object>(columns);
			        		
			       		for(int i=1;i<=columns;i++)
			       		{
			       			rows.addElement(rs.getObject(i));
			       		}
			        	data.addElement(rows);
			       	}
			        	
			        	
			       	rs.close();
			       	conn.statement.close();
			       	conn.connection.close();
			        	
			//............Creating Table structure for the database values...................
			        	
			       	table1=new JTable(data,columnNames)
			       	{
			        		
						private static final long serialVersionUID = 1L;

						public Class<?> getColumnClass(int column)
			       		{
			       			for(int row=0; row<table1.getRowCount(); row++)
			       			{
			       				Object o=table1.getValueAt(row,column);
			        				
			        			if(o!=null)
			       				{
			       					return o.getClass();
			        			}
			       			}
			        		return Object.class;
			        		}
							
						public Component prepareRenderer(TableCellRenderer renderer, int row, int column) 
						{
				            Component comp = super.prepareRenderer(renderer, row, column);
				            Color alternateColor = new Color(200,244,239);
				            Color whiteColor = new Color(181,231,228);
				            if(!comp.getBackground().equals(getSelectionBackground())) 
				            {
				            	Color c = (row % 2 == 0 ? alternateColor : whiteColor);
					            comp.setBackground(c);
					            c = null;
					        }
					        return comp;
					    }
			        };
			        
			        DefaultTableCellRenderer MyHeaderRender = new DefaultTableCellRenderer();
			        MyHeaderRender.setBackground(Color.decode("#696B9E"));
		            MyHeaderRender.setForeground(Color.decode("#FCE7FC"));

		            for(int i=0; i < table1.getColumnCount(); i++)
		            {
			           	table1.getTableHeader().getColumnModel().getColumn(i).setHeaderRenderer(MyHeaderRender);
		            }
			            
			        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
			        rightRenderer.setHorizontalAlignment(JLabel. LEFT);
			        table1.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
			     
			        	
			       	table1.setRowHeight(30);
			       	table1.setBackground(Color.white);
			       	table1.setFont(new Font("Tahoma",Font.PLAIN,14));
			       	table1.setForeground(Color.black);
			       	table1.setShowGrid(true);
			       	table1.setGridColor(new Color(190,237,233));
			      	table1.setEnabled(false);
			      	scrollPane = new JScrollPane(table1);
			       	panelForJTable1.add(scrollPane);
			       	panelForJTable1.setVisible(true);
			       	passTable = table1;
			       	
			    }
			    catch(Exception e)
			    {
			        e.printStackTrace();	
			    }
			}
		}
	}
}
