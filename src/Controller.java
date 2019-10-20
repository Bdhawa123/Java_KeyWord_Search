import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Controller {
    private View controllerview;
    private Model controllermodel;
    private Stage stg;

    
	public Controller (View view, Model mod, Stage set) {
        this.controllermodel = mod;
        this.controllerview = view;
        UserHandler userhandler = new UserHandler();
        controllerview.addFileListener(e->{
        	FileChooser file = new FileChooser();
        	mod.selectedFile = file.showOpenDialog(set);
        	if (mod.selectedFile!=null) {
				view.getLabelSource().setText(mod.selectedFile.getName());
        	}
				SAXParserFactory factory = SAXParserFactory.newInstance();
				SAXParser saxParser;
				
				try {
					saxParser = factory.newSAXParser();
					saxParser.parse(mod.selectedFile,userhandler);
					
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
				
        	
			
			
        });
        
        controllerview.addFileOpenListener(e->{
        	BufferedReader reader = null;
        	try {
				reader = new BufferedReader(new FileReader(mod.selectedFile.getPath()));
				String line = reader.readLine();
				
				while(line!=null) {
					view.getTextArea().setText(userhandler.Show_String());
					line = reader.readLine();
				}
				
				reader.close();
				//read file
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        		
		});
		
		
    
        
    }


}
