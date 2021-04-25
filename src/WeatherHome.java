/*
 @Date: 26-April-2020
 Description: This is the Stating Class of the Project. This Class is having the Swing Frame, to show all the Data
              that are being fetched from WeatherApiCall Class.
*/

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Dto.WeatherResultDto;

import java.awt.SystemColor;
import java.awt.Color;

public class WeatherHome {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	
	static String temp;
	static String name;
	static String humidity;
	static String feels_like;
	static String code;
	static String msg;
	static String region;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				
				try {

//Collecting all the data that are coming via weather.com API
					
					WeatherResultDto weatherData=new WeatherResultDto();
					
					WeatherApiCall api = new WeatherApiCall();
					weatherData=api.weather();

					
					float f=Float.parseFloat(weatherData.getCurrent().get(0).gettemp_c().toString());
					int temparature = Math.round(f);
					
					float ft=Float.parseFloat(weatherData.getCurrent().get(0).getfeelslike_c().toString());
					int feeltemp=Math.round(ft);
					
					temp=String.valueOf(temparature);
					name=weatherData.getLocation().get(0).getName().toString();
					region=weatherData.getLocation().get(0).getRegion().toString();
					humidity=weatherData.getCurrent().get(0).getHumidity().toString();
					feels_like=String.valueOf(feeltemp);
					
					if(temparature<21)
					{
						msg="It's Cold Out There,Grab a Coffee";
					}
					else if(temparature<26&&temparature>20)
					{
						msg="Remember to drink Water";
					}
					else if(temparature>25)
					{
						msg="Drink a Glass of Water,Stay Hydrated";
					}
					
					
					//Printing Values in Console.	
					System.out.println("Temparature: "+temp);
					System.out.println("Location: "+name);
					System.out.println("Humidity: "+humidity);
					
					WeatherHome window = new WeatherHome();
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
	public WeatherHome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * Contains the Design Part only.
	 */
	private void initialize() {
		
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(153, 255, 204));
		frame.setBounds(200, 200, 515, 357);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("WeatherReport");
		frame.setResizable(false);
		
		
        JLabel lblCurrentTemparature = new JLabel(temp);
        lblCurrentTemparature.setBackground(SystemColor.controlHighlight);
        lblCurrentTemparature.setFont(new Font("Comic Sans MS", Font.BOLD, 48));
        lblCurrentTemparature.setForeground(SystemColor.control);
        lblCurrentTemparature.setBounds(368, 63, 58, 57);
        frame.getContentPane().add(lblCurrentTemparature);
        
        JLabel lblNewLabel_1 = new JLabel("Humid");
        lblNewLabel_1.setForeground(SystemColor.controlHighlight);
        lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
        lblNewLabel_1.setBounds(117, 148, 120, 31);
        frame.getContentPane().add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel(humidity+"%");
        lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
        lblNewLabel_2.setForeground(SystemColor.controlHighlight);
        lblNewLabel_2.setBounds(25, 146, 86, 33);
        frame.getContentPane().add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("\u00B0C");
        lblNewLabel_3.setForeground(SystemColor.controlHighlight);
        lblNewLabel_3.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
        lblNewLabel_3.setBounds(427, 63, 43, 37);
        frame.getContentPane().add(lblNewLabel_3);
        
        JLabel lblNewLabel_4 = new JLabel("It feels like");
        lblNewLabel_4.setForeground(SystemColor.controlHighlight);
        lblNewLabel_4.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
        lblNewLabel_4.setBounds(25, 188, 141, 31);
        frame.getContentPane().add(lblNewLabel_4);
        
        JLabel lblNewLabel_5 = new JLabel(feels_like+"\u00B0");
        lblNewLabel_5.setForeground(SystemColor.controlHighlight);
        lblNewLabel_5.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
        lblNewLabel_5.setBounds(161, 178, 63, 46);
        frame.getContentPane().add(lblNewLabel_5);
        
        JLabel lblNewLabel_6 = new JLabel(msg);
        lblNewLabel_6.setForeground(SystemColor.controlHighlight);
        lblNewLabel_6.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
        lblNewLabel_6.setBounds(25, 229, 456, 34);
        frame.getContentPane().add(lblNewLabel_6);
        
        JLabel lblPowerdByIbm = new JLabel("Powerd by: IBM Weather.com");
        lblPowerdByIbm.setForeground(SystemColor.controlHighlight);
        lblPowerdByIbm.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        lblPowerdByIbm.setBounds(260, 281, 249, 36);
        frame.getContentPane().add(lblPowerdByIbm);
        
        JLabel lblNewLabel_7 = new JLabel("New label");
        lblNewLabel_7.setIcon(new ImageIcon(WeatherHome.class.getResource("/resources/unnamed.jpg")));
        lblNewLabel_7.setBounds(0, 0, 509, 317);
        frame.getContentPane().add(lblNewLabel_7);
        
       
        
       

	}
}
