/*
 @Date: 26-April-2020
 Description: This Class is calling the GetPublicIP class to get the Public IP of the network.
              Upon receiving the IP, it's calling the open API for Latitude and Loingitude 
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import Dto.LatLongDto;


public class GetLatLong {


	public static void main(String[] args) throws Exception {	
	  
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public LatLongDto weather() throws Exception
	{	
		String result="";
		LatLongDto latLong=new LatLongDto();
		
		GetPublicIP getIP=new GetPublicIP();
	
		try {
			
			String ip=getIP.getIP();
			System.out.println("Public IP Address: "+ip);
			
			if(ip==null)
			{
				String[] args= {"Chech Your Internet Connection Now"};
				ErrorClass.main(args);
			}
		
		
			 
			URL url = new URL("http://ip-api.com/json/"+ip);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed ip-API: HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

			 StringBuilder sb = new StringBuilder();
             String line;
             while ((line = br.readLine()) != null) {
                 sb.append(line+"\n");
             }
             br.close();
             result= sb.toString();
             
            
             ObjectMapper objectMapper = new ObjectMapper();
             objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
             latLong=objectMapper.readValue(result,LatLongDto.class);
             
             
			conn.disconnect();
			

		  } catch (MalformedURLException e) {

			e.printStackTrace();

		  } catch (IOException e) {

			e.printStackTrace();

		  }

		return latLong;
	}
}