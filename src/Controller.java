import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import javafx.scene.Group;
import javafx.scene.layout.StackPane;
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
        	controllerview.getTextArea().setText(controllermodel.ReturnString());

		});
        
        controllerview.addSearchListener(e->{
        	String setSearchresult = controllermodel.Search_String(controllerview.getTxtInp().getText());
        	controllerview.getTextArea().setText(setSearchresult);
        });
        
        controllerview.BarGraph(e->{
        	String setSearchresult = controllerview.getTxtInp().getText();
        	
        	Group root = new Group(controllermodel.barchart(setSearchresult));
        	controllerview.create_BarGraph(root);
        	
        });
        
        controllerview.PieChart(e->{
    		String setSearchresult = controllerview.getTxtInp().getText();
        	//Group Root = new StackPane();
        	Group root = new Group(controllermodel.PieChart(setSearchresult));
        	controllerview.create_BarGraph(root);
        	
        });
        
        
      
		
		
    
        
    }


}
