import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;

public class movie {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void moviebook() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					movie window = new movie();
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
	public movie() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1157, 498);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(0, 0, 1143, 102);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Movie");
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 50));
		lblNewLabel.setBounds(492, 23, 379, 69);
		panel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 112, 1123, 339);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Roboto", Font.PLAIN, 10));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Movie Name", "Show Time", "Show Date"
			}
		));
		scrollPane.setViewportView(table);
		try
		{ 
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scope_cinema", "root", "");
			String sql = "select * from movie";
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
}
