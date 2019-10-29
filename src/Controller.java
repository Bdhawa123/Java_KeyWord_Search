
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * Controller for the program
 * 
 * @author Binay Dhawa
 */
public class Controller {
    private View controllerview;
    private Model controllermodel;
    
    /**
     * Constructor with view, model and stage set for the java fx
     * 
     * @param view The View to be worked on for the model
     * @param mod The Model of the whole model view container
     * @param set The selected stage of the mvc 
     */
	public Controller (View view, Model mod, Stage set) {
        this.controllermodel = mod;
        this.controllerview = view;
        controllerview.addFileListener(e->{
        	FileChooser file = new FileChooser();
        	mod.selectedFile = file.showOpenDialog(set);
        	mod.ParseXML();
        });
        
        
        /**
         * Event listener binding to the file open button at view
         */
        controllerview.addFileOpenListener(e->{
        	controllerview.getTextArea().setText(controllermodel.ReturnString());

		});
        
        /**
         * Event listener binding to the Search button at view
         */
        controllerview.addSearchListener(e->{
        	String setSearchresult = controllermodel.Search_String(controllerview.getTxtInp().getText());
        	controllerview.getTextArea().setText(setSearchresult);

        });
        
        /**
         * Event listener binding to the Radio button at view toggle
         */
        controllerview.SetRadioBtnListener(new  ChangeListener<Toggle>() {
			 @Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
					RadioButton ID = (RadioButton)newValue.getToggleGroup().getSelectedToggle();
					controllermodel.setgetKeyword_occ(ID.getId());
			}
		});
        
        
        /**
         * Event listener binding to the BarChart button at view
         */
        controllerview.BarGraph(e->{
        	String setSearchresult = controllerview.getTxtInp().getText();
        	
        	Group root = new Group(controllermodel.barchart(setSearchresult));
        	controllerview.create_BarGraph(root);
        	
        });
        
        /**
         * Event listener binding to the PieChart button at view
         */        
        controllerview.PieChart(e->{
    		String setSearchresult = controllerview.getTxtInp().getText();
        	Group root = new Group(controllermodel.PieChart(setSearchresult));
        	controllerview.create_BarGraph(root);
        	
        });


    }

}
