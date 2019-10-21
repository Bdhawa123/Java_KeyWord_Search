import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class Model {
	File selectedFile = new File("");
	SAXParserFactory factory = SAXParserFactory.newInstance();
	SAXParser saxParser;
	UserHandler userhandler = new UserHandler();
	
	public File getFile() {
		return selectedFile;
	}
	
	public void SetFile(File fileselect) {
		selectedFile= fileselect;
	}
	
	
	
	public void ParseXML() {
		
		try {
			saxParser = factory.newSAXParser();
			saxParser.parse(selectedFile,userhandler);
			
		} catch (ParserConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SAXException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	public String ReturnString() {
		return userhandler.Show_String();
	}
	
	public String Search_String(String search) {
		return userhandler.Search(search);
	}
	
	
	
	
	
	
	

}
