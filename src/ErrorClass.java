import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class ErrorClass {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					String errorMessage=args[0].toString();
					ErrorClass window = new ErrorClass(errorMessage);
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
	public ErrorClass(String errorMessage) {
		initialize(errorMessage);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String errorMessage) {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(153, 255, 204));
		frame.setBounds(200, 200, 515, 357);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("WeatherReport");
		frame.setResizable(false);
		
		JLabel lblNewLabel = new JLabel("Error !!!!");
		lblNewLabel.setForeground(SystemColor.controlHighlight);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
	    lblNewLabel.setBounds(197, 73, 162, 52);
	    frame.getContentPane().add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Powered by: IBM Weather.com");
        lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        lblNewLabel_1.setForeground(SystemColor.controlHighlight);
        lblNewLabel_1.setBounds(247, 281, 262, 36);
        frame.getContentPane().add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel(errorMessage);
        lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
        lblNewLabel_2.setBackground(new Color(240, 240, 240));
        lblNewLabel_2.setForeground(SystemColor.controlHighlight);
        lblNewLabel_2.setBounds(40, 187, 443, 36);
        frame.getContentPane().add(lblNewLabel_2);
        
        JLabel lblNewLabel_7 = new JLabel("New label");
        lblNewLabel_7.setIcon(new ImageIcon(WeatherHome.class.getResource("/resources/unnamed.jpg")));
        lblNewLabel_7.setBounds(0, 0, 509, 317);
        frame.getContentPane().add(lblNewLabel_7);
        

	}

}
