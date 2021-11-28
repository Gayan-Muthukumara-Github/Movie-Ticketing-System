import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import com.toedter.calendar.JDayChooser;

import net.proteanit.sql.DbUtils;

import com.toedter.calendar.JDateChooser;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class register {

	private JFrame frame;
	private JTextField txtnic;
	private JTextField txtname;
	private JTable table;
	private JTextField txtdate;

	/**
	 * Launch the application.
	 */
	DefaultTableModel model = new DefaultTableModel();
	public static void cusregister() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					register window = new register();
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
	public register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
			}
		});
		frame.setBounds(100, 100, 1293, 499);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(0, 0, 1279, 94);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Customer Registration");
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 50));
		lblNewLabel.setBounds(401, 10, 751, 79);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Customer Name");
		lblNewLabel_1.setFont(new Font("Roboto", Font.BOLD, 20));
		lblNewLabel_1.setBounds(37, 129, 176, 24);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("NIC");
		lblNewLabel_1_1.setFont(new Font("Roboto", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(37, 172, 176, 24);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		txtnic = new JTextField();
		txtnic.setFont(new Font("Roboto", Font.PLAIN, 20));
		txtnic.setColumns(10);
		txtnic.setBounds(223, 172, 392, 25);
		frame.getContentPane().add(txtnic);
		
		JLabel lblNewLabel_1_2 = new JLabel("Birth Date");
		lblNewLabel_1_2.setFont(new Font("Roboto", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(37, 217, 176, 24);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Address");
		lblNewLabel_1_3.setFont(new Font("Roboto", Font.BOLD, 20));
		lblNewLabel_1_3.setBounds(37, 262, 176, 24);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		JTextArea txtaddress = new JTextArea();
		txtaddress.setFont(new Font("Roboto", Font.PLAIN, 20));
		txtaddress.setBounds(223, 260, 392, 94);
		frame.getContentPane().add(txtaddress);
		
		JButton btnsave = new JButton("Save");
		btnsave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtname.getText();
                String nic = txtnic.getText();
                String address = txtaddress.getText();
                String bdate = txtdate.getText();

                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/scope_cinema", "root", "");

                    String query = "INSERT INTO user values('" + name + "','" + nic + "','" + bdate + "','" + address + "')";

                    Statement sta = connection.createStatement();
                    int x = sta.executeUpdate(query);
                    if (x == 0) {
                        JOptionPane.showMessageDialog(null, "User registration faild");
                    } else {
                        JOptionPane.showMessageDialog(null,
                            "User registration sucessfully");
                        txtname.setText("");
        				txtaddress.setText("");
        				txtdate.setText("");
        				txtnic.setText("");
                    }
                    connection.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                model = (DefaultTableModel)table.getModel();
				model.addRow(new Object[]
						{
								name,
								nic,
								bdate,
								address
								
						});
			}
		});
		btnsave.setFont(new Font("Roboto", Font.BOLD, 20));
		btnsave.setBounds(37, 395, 176, 33);
		frame.getContentPane().add(btnsave);
		
		JButton btnreset = new JButton("Reset");
		btnreset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtname.setText("");
				txtaddress.setText("");
				txtdate.setText("");
				txtnic.setText("");
				}
		});
		btnreset.setFont(new Font("Roboto", Font.BOLD, 20));
		btnreset.setBounds(240, 395, 176, 33);
		frame.getContentPane().add(btnreset);
		
		txtname = new JTextField();
		txtname.setFont(new Font("Roboto", Font.PLAIN, 20));
		txtname.setColumns(10);
		txtname.setBounds(223, 129, 392, 25);
		frame.getContentPane().add(txtname);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(625, 129, 644, 299);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Roboto", Font.PLAIN, 10));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "NIC", "Birth Date", "Address"
			}
		));
		scrollPane.setViewportView(table);
		try
		{ 
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scope_cinema", "root", "");
			String sql = "select * from user";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			int i =0;
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
			JOptionPane.ERROR_MESSAGE);
		}
		
		txtdate = new JTextField();
		txtdate.setFont(new Font("Roboto", Font.PLAIN, 20));
		txtdate.setColumns(10);
		txtdate.setBounds(223, 216, 392, 25);
		frame.getContentPane().add(txtdate);
		
		JButton btnshowdata = new JButton("Refresh");
		btnshowdata.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{ 
					
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scope_cinema", "root", "");
					String sql = "select * from user";
					PreparedStatement ps = con.prepareStatement(sql);
					ResultSet rs = ps.executeQuery();
					int i =0;
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
					JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnshowdata.setFont(new Font("Roboto", Font.BOLD, 20));
		btnshowdata.setBounds(439, 395, 176, 33);
		frame.getContentPane().add(btnshowdata);
	}
}
