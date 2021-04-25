/*
 @Date: 26-April-2020
 Description: This Class is calling the GetLatLong Class, which is returning the Latitude and Longitude.
              Upon receiving the Lat Long Data, it's Calling weather API to get the weather Data.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import Dto.LatLongDto;
import Dto.WeatherReportListCurrDto;
import Dto.WeatherReportListLocDto;
import Dto.WeatherResultDto;



public class WeatherApiCall {

// http://localhost:8080/RESTfulExample/json/product/get
	public static void main(String[] args) {

		
	  
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public WeatherResultDto weather() throws Exception
	{	
		String result="";
	
		
		WeatherResultDto weatherResult=new WeatherResultDto();
		List <WeatherReportListCurrDto> list = new ArrayList<>();
		List <WeatherReportListLocDto> listLoc = new ArrayList<>();
		
//Calling GetLatLong Class to receive latitude and longitude
		GetLatLong getLatLong=new GetLatLong();
		LatLongDto location=getLatLong.weather();
		
		String latitude=location.getLat().toString();
		String longitude=location.getLon().toString();
		
		ReadApiKey apiKey=new ReadApiKey();
		String weatherAPIKey=apiKey.getApiKey();
		
		System.out.println("KEY->"+weatherAPIKey+"<-Key");
		
		//String weatherAPIKey="4a3fd4c782ae404fae244603202404";
		
		System.out.println("Latitude: "+latitude+"  Longitude: "+longitude+"\n");
		
		
		try {
			
//Calling IBM Weather API 	 
			URL url = new URL("http://api.weatherapi.com/v1/current.json?key="+weatherAPIKey+"&q="+latitude+","+longitude);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				
				//return null;
				throw new RuntimeException("Failed : HTTP error code : "
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
             objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
             weatherResult=objectMapper.readValue(result,WeatherResultDto.class);
             
     	    
//Setting Data for "current"
     	    for (WeatherReportListCurrDto temp : weatherResult.getCurrent()) {
     	    	
     	    	   
     	    	WeatherReportListCurrDto resultList = new WeatherReportListCurrDto();
     	    	resultList.settemp_c(temp.gettemp_c());
     	    	resultList.setHumidity(temp.getHumidity());
     	    	resultList.setfeelslike_c(temp.getfeelslike_c());  	    	       	    	   
     	    	   
     	    	list.add(resultList);

     	    }
     	        	    
     	  weatherResult.setCurrent(list);
     	  
//Setting Data for "Location"
     	  
     	  for (WeatherReportListLocDto tempLoc : weatherResult.getLocation()) {
   	    	
	    	   
   	    	WeatherReportListLocDto resultList = new WeatherReportListLocDto();
   	    	resultList.setName(tempLoc.getName());
   	    	resultList.setRegion(tempLoc.getRegion());	    	       	    	   
   	    	   
   	    	   listLoc.add(resultList);

   	    }
   	    
   	   weatherResult.setLocation(listLoc);

			conn.disconnect();
			

		  } catch (MalformedURLException e) {

			e.printStackTrace();

		  } catch (IOException e) {

			e.printStackTrace();

		  }

		return weatherResult;
	}
}