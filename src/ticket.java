import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.mindfusion.common.DateTime;
import com.mindfusion.pdf.PdfWriter;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;

import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.DefaultComboBoxModel;

public class ticket {

	private JFrame frame;
	private JTextField txtsubtotal;
	private JTable table;
	private JTextField txtdate;
	private static String USER_PASSWORD = "1234567";  
	private static String OWNER_PASSWORD = "javatpoint";  

	/**
	 * Launch the application.
	 */
	DefaultTableModel model = new DefaultTableModel();
	public static void ticketbook() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ticket window = new ticket();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ticket() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBounds(100, 100, 1239, 706);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(0, 0, 1225, 95);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ticket Booking");
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 50));
		lblNewLabel.setBounds(450, 10, 342, 68);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 105, 447, 323);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JComboBox txtmoviename = new JComboBox();
		txtmoviename.setModel(new DefaultComboBoxModel(new String[] {"", "Bad Boys for Life\t", "Sonic the Hedgehog\t", "Birds of Prey\t"}));
		txtmoviename.setBounds(172, 42, 232, 21);
		panel_1.add(txtmoviename);
		
		JLabel lblNewLabel_1 = new JLabel("Movie Name");
		lblNewLabel_1.setFont(new Font("Roboto", Font.BOLD, 20));
		lblNewLabel_1.setBounds(31, 41, 166, 17);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Date");
		lblNewLabel_1_1.setFont(new Font("Roboto", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(31, 94, 166, 17);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Time");
		lblNewLabel_1_2.setFont(new Font("Roboto", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(31, 149, 166, 17);
		panel_1.add(lblNewLabel_1_2);
		
		JComboBox txttime = new JComboBox();
		txttime.setModel(new DefaultComboBoxModel(new String[] {"", "10.00 AM", "2.30 PM", "6.00 PM", "10.00 PM"}));
		txttime.setBounds(172, 150, 232, 21);
		panel_1.add(txttime);
		
		JLabel lblNewLabel_1_3 = new JLabel("Seat Type");
		lblNewLabel_1_3.setFont(new Font("Roboto", Font.BOLD, 20));
		lblNewLabel_1_3.setBounds(31, 257, 166, 17);
		panel_1.add(lblNewLabel_1_3);
		
		JSpinner s_count = new JSpinner();
		s_count.setFont(new Font("Tahoma", Font.PLAIN, 10));
		s_count.setBounds(322, 259, 82, 20);
		panel_1.add(s_count);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Ticket Type");
		lblNewLabel_1_2_1.setFont(new Font("Roboto", Font.BOLD, 20));
		lblNewLabel_1_2_1.setBounds(31, 205, 166, 17);
		panel_1.add(lblNewLabel_1_2_1);
		
		txtdate = new JTextField();
		txtdate.setBounds(172, 96, 232, 19);
		panel_1.add(txtdate);
		txtdate.setColumns(10);
		
		JComboBox txtttype = new JComboBox();
		txtttype.setModel(new DefaultComboBoxModel(new String[] {"", "adult", "child"}));
		txtttype.setBounds(172, 206, 232, 21);
		panel_1.add(txtttype);
		
		JComboBox txtstype = new JComboBox();
		txtstype.setModel(new DefaultComboBoxModel(new String[] {"", "ODC", "Balcony", "Box"}));
		txtstype.setBounds(172, 258, 140, 21);
		panel_1.add(txtstype);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(467, 105, 748, 475);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Movie Name", "Date", "Time", "Ticket Type", "Qty", "Total"
			}
		));
		scrollPane.setViewportView(table);
				
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 438, 447, 221);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnadd = new JButton("ADD");
		btnadd.setBounds(22, 22, 396, 68);
		panel_2.add(btnadd);
		btnadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sum=0;
				int qty = 0;
				int total = 0;
				String t_type = txtttype.getSelectedItem().toString();
				String s_type = txtstype.getSelectedItem().toString();
				String movie_name = txtmoviename.getSelectedItem().toString();
                String date = txtdate.getText();
                String time = txttime.getSelectedItem().toString();
                int S_count = Integer.parseInt(s_count.getValue().toString());
                
                
                Select Price = SelectFactory.getSelect(s_type);
        		
                if(t_type =="adult")
				{
                	if(s_type=="ODC")
                	{
    					qty = Integer.parseInt(s_count.getValue().toString());
    					total = 600 * qty; 
    					
    				}
    				if(s_type=="Balcony")
    				{
    					qty = Integer.parseInt(s_count.getValue().toString());
    					total = 600 * qty; 
    					
    				}
    				if(s_type=="Box")
    				{
    					qty = Integer.parseInt(s_count.getValue().toString());
    					total = 600 * qty;
    					
    				}
				}
                if(t_type =="child")
				{
                	if(s_type=="ODC")
                	{
    					qty = Integer.parseInt(s_count.getValue().toString());
    					total = 400 * qty; 
    					
    				}
    				if(s_type=="Balcony")
    				{
    					qty = Integer.parseInt(s_count.getValue().toString());
    					total = 400 * qty; 
    					
    				}
    				if(s_type=="Box")
    				{
    					qty = Integer.parseInt(s_count.getValue().toString());
    					total = 400 * qty;
    					
    				}
				}
                
                for (int i=0;i<table.getRowCount();i++) {
					sum = sum + Integer.parseInt(table.getValueAt(i, 6).toString());
				}
				txtsubtotal.setText(String.valueOf(sum));
                
                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/scope_cinema", "root", "");

                    String query = "INSERT INTO ticket values('" + movie_name + "','" + date + "','" + time + "','" + t_type + "','" + s_type + "','" + qty + "','" + total + "')";

                    Statement sta = connection.createStatement();
                    int x = sta.executeUpdate(query);
                    if (x == 0) {
                        JOptionPane.showMessageDialog(null, "Ticket issue faild");
                    } else {
                        JOptionPane.showMessageDialog(null,
                            "Ticket issue sucessfully");
                    }
                    connection.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                model = (DefaultTableModel)table.getModel();
				model.addRow(new Object[]
						{
								movie_name,
								date,
								time,
								t_type,
								s_type,
								qty,
								total
								
						});
			}
		});
		btnadd.setFont(new Font("Roboto", Font.BOLD, 20));
		
		JButton btnrefresh = new JButton("Refresh Table");
		btnrefresh.setBounds(22, 131, 396, 68);
		panel_2.add(btnrefresh);
		btnrefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnrefresh.setFont(new Font("Roboto", Font.BOLD, 20));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(467, 590, 748, 69);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		txtsubtotal = new JTextField();
		txtsubtotal.setBounds(544, 24, 194, 24);
		panel_3.add(txtsubtotal);
		txtsubtotal.setColumns(10);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Sub Total");
		lblNewLabel_1_2_1_1.setBounds(428, 24, 166, 17);
		panel_3.add(lblNewLabel_1_2_1_1);
		lblNewLabel_1_2_1_1.setFont(new Font("Roboto", Font.BOLD, 20));
		
		
	}
}
