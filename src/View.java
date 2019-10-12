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
	private File SelectedFile;
	private Button ChooseXML;
	private Button LoadXML;
	File selectedFile = new File("");
	
	public View() {
		createAndConfigurePane();
		createAndLayoutControls();
	}

	public Parent getParent(){
		return view;
	}
	
	public void createAndConfigurePane() {
		view = new GridPane();
		view.setPadding(new Insets(10,10,10,10));
		view.setMinSize(10,60);
		view.setHgap(60);
		view.setVgap(90);
		view.setAlignment(Pos.CENTER);			
	}
	
	public void createAndLayoutControls() {

		LoadXML= new Button("Parse XML");
	 	Label lblSource = new Label("");
	 	HBox hboxSource = new HBox(LoadXML,lblSource );
	 	
		
	 	ChooseXML = new Button("Choose XML file");
	 	HBox hbox = new HBox(ChooseXML);
		hbox.setAlignment(Pos.CENTER); 
		
		TextArea txtR = new TextArea();
		txtR.setText(selectedFile.getName());
		GridPane grdPane = new GridPane();
		
		view.setPadding(new Insets(10,10,10,10));
		view.setMinSize(10, 60);
		view.setHgap(60);
		view.setVgap(90);
		view.setAlignment(Pos.CENTER);
		
		view.addRow(0,hboxSource);
		view.addRow(1,hbox);
		view.addRow(2, txtR);
	}
	

	public File SelectedFile(){
		return SelectedFile;
	}

	public void addFileListener(EventHandler<ActionEvent> listener){
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
	// 	GridPane grdPane = new GridPane();
		
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
