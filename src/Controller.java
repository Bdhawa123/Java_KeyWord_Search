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
        controllerview.addFileListener(e->{
        	FileChooser file = new FileChooser();
        	mod.selectedFile = file.showOpenDialog(set);
        	mod.ParseXML();
        });
        
        controllerview.addFileOpenListener(e->{
        	view.getTextArea().setText(mod.ReturnString());

		});
        
        controllerview.addSearchListener(e->{
        	//
        	String setSearchresult = mod.Search_String(controllerview.getTxtInp().getText());
        	view.getTextArea().setText(setSearchresult);
        });
        
      
		
		
    
        
    }


}
