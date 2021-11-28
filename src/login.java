import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

public class login {

	private JFrame frame;
	private JTextField txtuser;
	private JPasswordField txtpassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
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
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBackground(Color.GRAY);
		frame.getContentPane().setForeground(Color.CYAN);
		frame.setBounds(0, -25, 715, 361);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBounds(491, 249, 118, 33);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username =  txtuser.getText();
				String pass =  txtpassword.getText();
				if(username.equalsIgnoreCase("admin") && pass.equalsIgnoreCase("admin123")) {
					home h = new home();
		            h.homescreen();
		            frame.setVisible(false);
				}
				else {
					
					JOptionPane.showMessageDialog(null,"Invaild user name or password");
				}
			}
		});
		frame.getContentPane().setLayout(null);
		btnNewButton.setFont(new Font("Roboto", Font.BOLD, 20));
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("User Name");
		lblNewLabel.setBounds(87, 130, 118, 24);
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 20));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(87, 186, 118, 24);
		lblPassword.setFont(new Font("Roboto", Font.BOLD, 20));
		frame.getContentPane().add(lblPassword);
		
		txtuser = new JTextField();
		txtuser.setBounds(242, 129, 367, 25);
		txtuser.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtuser.setColumns(10);
		frame.getContentPane().add(txtuser);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 701, 89);
		panel_1.setForeground(Color.ORANGE);
		panel_1.setBackground(Color.ORANGE);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Scope Cinema Login");
		lblNewLabel_1.setBounds(134, 10, 482, 71);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setBackground(Color.YELLOW);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Roboto", Font.BOLD, 50));
		
		txtpassword = new JPasswordField();
		txtpassword.setBounds(242, 186, 367, 25);
		frame.getContentPane().add(txtpassword);
	}
}
