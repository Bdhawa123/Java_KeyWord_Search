import java.io.File;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class View {
	private GridPane view;
	private Button ChooseXML;
	private Button LoadXML;
	private TextArea txtR;
	private Label lblSource;
	
	public Label getLabelSource() {
		return lblSource;
	}
	
	public View() {
		createAndConfigurePane();
		createAndLayoutControls();
	}

	public Parent getParent(){
		return view;
	}
	
	public TextArea getTextArea() {
		return txtR;
	}
	
	
	
	public void createAndConfigurePane() {
		view = new GridPane();
		view.setPadding(new Insets(10,10,10,10));
		view.setMinSize(10,60);
		view.setHgap(20);
		view.setVgap(10);
		view.setAlignment(Pos.CENTER);			
	}
	
	public void createAndLayoutControls() {

		ChooseXML= new Button("Choose XML file");
	 	lblSource = new Label("");
	 	lblSource.setAlignment(Pos.CENTER);
	 	HBox hboxSource = new HBox(ChooseXML,lblSource );
	 	
		
	 	LoadXML = new Button("Parse XML");
	 	HBox hbox = new HBox(LoadXML);
		hbox.setAlignment(Pos.CENTER); 
		
		txtR = new TextArea();
	
		
		
		
		view.addRow(0,hboxSource);
		view.addRow(1, lblSource);
		view.addRow(2,hbox);
		view.addRow(3, txtR);
	}
	
	
	

	public void addFileListener(EventHandler<ActionEvent> listener){
		ChooseXML.setOnAction(listener);
	}
	
	public void addFileOpenListener(EventHandler<ActionEvent> listener) {
		LoadXML.setOnAction(listener);
		
	}


	// @Override
	// public void start(Stage stage)throws Exception{
		
	// 	Button btnSource = new Button("Choose Source");
	// 	Label lblSource = new Label("");
	// 	HBox hboxSource = new HBox(btnSource,lblSource );
				
			
	
	// 	//File open to set source
	// 	btnSource.setOnAction(event->{
	// 		FileChooser file = new FileChooser();
	// 		file.setTitle("Open File");
	// 		selectedFile = file.showOpenDialog(stage);
	// 		lblSource.setText(selectedFile.getName());
			
	// 	});
		
		
	// 	Button btnSearch = new Button("Load Text");
	// 	btnSearch.setMinWidth(100);
		
		
	// 	btnSearch.setOnAction(event->{
			
	// 	});
		
		
		
	// 	HBox hbox = new HBox(btnSearch);
	// 	hbox.setAlignment(Pos.CENTER); 
		
	// 	TextArea txtR = new TextArea();
	// 	txtR.setText(selectedFile.getName());
		
	// 	grdPane.setPadding(new Insets(10,10,10,10));
	// 	grdPane.setMinSize(10, 60);
	// 	grdPane.setHgap(60);
	// 	grdPane.setVgap(90);
	// 	grdPane.setAlignment(Pos.CENTER);
		
	// 	grdPane.addRow(0,hboxSource);
	// 	grdPane.addRow(1,hbox);
	// 	grdPane.addRow(2, txtR);
				
	// 	Scene scene = new Scene(grdPane,500,600);
	// 	stage.setScene(scene);
	// 	stage.setTitle("Open File System");
	// 	stage.show();
	// }
	
	// public void start() {
	// 	launch();
	// }
	
	
}
