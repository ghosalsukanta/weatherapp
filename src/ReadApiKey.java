import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class ReadApiKey {

	public String getApiKey() throws Exception
	{
		System.out.println("Entering API read class");

		String key="";
		
		File configFile = new File("config.properties");
		 
		try {

		    FileReader reader = new FileReader(configFile);
		    Properties props = new Properties();
		    props.load(reader);
		    key = props.getProperty("key").toString();
		    reader.close();
		    
		    System.out.print("Host name is: " + key);
		    
		} catch (FileNotFoundException ex) {
		    // file does not exist
		} catch (IOException ex) {
		    // I/O error
		}
		 
		if(key.length()<30)
		{
			return null;
		}
			
		else
		    return key;
	}
	
}
