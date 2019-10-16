import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
        	System.out.println("This is not working");
        });
        
        controllerview.addFileOpenListener(e->{
        	BufferedReader reader = null;
        	try {
				reader = new BufferedReader(new FileReader(mod.selectedFile.getPath()));
				String line = reader.readLine();
				//read file
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        		
        });
    
        
    }


}
