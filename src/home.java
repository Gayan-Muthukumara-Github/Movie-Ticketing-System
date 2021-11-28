import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JDesktopPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class home {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void homescreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home window = new home();
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
	public home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1201, 778);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(0, 0, 1187, 97);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Scope Cinema");
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 50));
		lblNewLabel.setBounds(419, 10, 345, 77);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Customer Registration");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
		        {
		            register r = new register();
		            r.cusregister();
		            
		        }
		        catch (Exception ex)
		        {
		            ex.printStackTrace();
		        }
			}
		});
		btnNewButton.setFont(new Font("Roboto", Font.BOLD, 20));
		btnNewButton.setBounds(41, 131, 430, 91);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnViewMovies = new JButton("View Movies");
		btnViewMovies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
		        {
		            movie m = new movie();
		            m.moviebook();
		            
		        }
		        catch (Exception ex)
		        {
		            ex.printStackTrace();
		        }
			}
		});
		btnViewMovies.setFont(new Font("Roboto", Font.BOLD, 20));
		btnViewMovies.setBounds(41, 276, 430, 91);
		frame.getContentPane().add(btnViewMovies);
		
		JButton btnTicketBooking = new JButton("Ticket Booking");
		btnTicketBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
		        {
		            ticket t = new ticket();
		            t.ticketbook();
		            
		        }
		        catch (Exception ex)
		        {
		            ex.printStackTrace();
		        }
			}
		});
		btnTicketBooking.setFont(new Font("Roboto", Font.BOLD, 20));
		btnTicketBooking.setBounds(41, 420, 430, 91);
		frame.getContentPane().add(btnTicketBooking);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Gayan Muthukumara\\Downloads\\wp4016031-cinema-wallpapers.jpg"));
		label.setBounds(0, 95, 1187, 646);
		frame.getContentPane().add(label);
	}
}
