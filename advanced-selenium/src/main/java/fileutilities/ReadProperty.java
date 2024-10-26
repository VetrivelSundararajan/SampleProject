package fileutilities;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class ReadProperty {
	FileInputStream fis;
	public String fetchProperty(String key)
	{
		try 
			{
				fis = new FileInputStream("./src/test/resources/demo.properties");
			} 
		catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			}
		Properties pb=new Properties();
		
		try 
			{
				pb.load(fis);
			}	 
		catch (IOException e) 
			{
				e.printStackTrace();
			}
		String data=pb.getProperty(key);
		return data;
	}

}
