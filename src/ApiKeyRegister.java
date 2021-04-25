import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.awt.event.ActionEvent;

public class ApiKeyRegister {

	private JFrame frame;
	private JTextField apiKeyValue;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					ReadApiKey readApiKey=new ReadApiKey();
					String apiKey=readApiKey.getApiKey(); 
					if(apiKey==null)
					{
						ApiKeyRegister window = new ApiKeyRegister();
						window.frame.setVisible(true);
					}
					
					else
						WeatherHome.main(null);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ApiKeyRegister() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(153, 255, 204));
		frame.setBounds(200, 200, 515, 357);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("WeatherReport");
		frame.setResizable(false);
		
		JLabel lblNewLabel = new JLabel("Enter Your Weather API Key");
		lblNewLabel.setForeground(SystemColor.controlHighlight);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
	    lblNewLabel.setBounds(31, 16, 463, 52);
	    frame.getContentPane().add(lblNewLabel);
	    
	    apiKeyValue = new JTextField();
	    apiKeyValue.setFont(new Font("IBM Plex Mono SemiBold", Font.BOLD, 18));
        apiKeyValue.setBounds(70, 139, 380, 36);
        frame.getContentPane().add(apiKeyValue);
        apiKeyValue.setColumns(10);
        
        
        
        JButton btnNewButton = new JButton("Register Key");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		
        		
        		File configFile = new File("config.properties");
        		 
        		try {
        		    Properties props = new Properties();
        		    props.setProperty("key", apiKeyValue.getText());
        		    FileWriter writer = new FileWriter(configFile);
        		    props.store(writer, "key settings");
        		    writer.close();
        		} catch (FileNotFoundException ex) {
        		    // file does not exist
        		} catch (IOException ex) {
        		    // I/O error
        		}
        		frame.dispose();
        		WeatherHome.main(null);
        		
        	}
        });
        btnNewButton.setFont(UIManager.getFont("Button.font"));
        btnNewButton.setForeground(SystemColor.textHighlight);
        btnNewButton.setBackground(SystemColor.controlHighlight);
        btnNewButton.setBounds(178, 191, 155, 29);
        frame.getContentPane().add(btnNewButton);
        
        JLabel lblNewLabel_1 = new JLabel("Powered by: IBM Weather.com");
        lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        lblNewLabel_1.setForeground(SystemColor.controlHighlight);
        lblNewLabel_1.setBounds(247, 281, 262, 36);
        frame.getContentPane().add(lblNewLabel_1);
        
        JLabel lblNewLabel_7 = new JLabel("New label");
        lblNewLabel_7.setIcon(new ImageIcon(WeatherHome.class.getResource("/resources/unnamed.jpg")));
        lblNewLabel_7.setBounds(0, 0, 509, 317);
        frame.getContentPane().add(lblNewLabel_7);
        
       
        
       
       

        
        
       
        
		
	}
}
