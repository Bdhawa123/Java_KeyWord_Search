
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Controller {
    private View controllerview;
    private Model controllermodel;

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
        
      
        controllerview.SetRadioBtnListener(new  ChangeListener<Toggle>() {
			 @Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
					RadioButton ID = (RadioButton)newValue.getToggleGroup().getSelectedToggle();
					controllermodel.setgetKeyword_occ(ID.getId());
			}
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
