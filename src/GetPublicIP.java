/*
 @Date: 26-April-2020
 Description: This Class is making a http call to "bot.whatismyipaddress.com" to get public IP.
*/

import java.net.*; 
import java.io.*; 


public class GetPublicIP 
{ 
	public static void main(String args[]) throws Exception 
	{ 
		/*GetPublicIP gp=new GetPublicIP();
		gp.getIP();*/
	} 
	
	public String getIP() throws Exception 
	{

				// Find public IP address 
				String systemipaddress = ""; 
				try
				{ 
					URL url_name = new URL("http://bot.whatismyipaddress.com"); 

					BufferedReader sc = 
					new BufferedReader(new InputStreamReader(url_name.openStream())); 

					//reads system IPAddress 
					systemipaddress = sc.readLine().trim(); 
				} 
				catch (Exception e) 
				{ 
					systemipaddress=null; 
				} 

		
				return systemipaddress;
	}
} 
