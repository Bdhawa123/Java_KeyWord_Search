import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Collections;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class VisualisationTask extends Application {

	File selectedFile = new File(""); 
	
	@Override
	public void start(Stage stage)throws Exception{
		
		Button btnSource = new Button("Choose Source");
		Label lblSource = new Label("");
		HBox hboxSource = new HBox(btnSource,lblSource );
		
		
		btnSource.setOnAction(e -> { 
			FileChooser  file = new FileChooser();
			file.setTitle("Open File");		
			selectedFile = file.showOpenDialog(stage); 
			lblSource.setText(selectedFile.getName()); 
		});
		
		Button btnSearch = new Button("Load Text");
		btnSearch.setMinWidth(100);
		HBox hbox = new HBox(btnSearch);
		hbox.setAlignment(Pos.CENTER); 
		
		TextArea txtR = new TextArea();
		txtR.setText(selectedFile.getName());
						
		btnSearch.setOnAction(e -> {
			BufferedReader reader = null;
			try
			{
				txtR.setText("");
				reader = new BufferedReader(new FileReader(selectedFile.getPath()));
				String line = reader.readLine();
				
				while(line != null ) {					
					txtR.setText(txtR.getText() + line + "\n");	
					line = reader.readLine();
				}
				
				reader.close();				
				
			}catch(Exception er)
			{
				er.printStackTrace();				
			}
			
		});
		
		Button btnBarChart = new Button("Bar Chart");
		btnBarChart.setMinWidth(100);
		Button btnPieChart = new Button("Pie Chart");
		btnPieChart.setMinWidth(100);
		
		HBox hboxChart = new HBox(10, btnBarChart, btnPieChart);
		hboxChart.setAlignment(Pos.CENTER); 
		
		GridPane grdPane = new GridPane();
		
		grdPane.setPadding(new Insets(10,10,10,10));
		
		grdPane.setHgap(10);
		grdPane.setVgap(10);
		grdPane.setAlignment(Pos.CENTER);
		
		grdPane.addRow(0,hboxSource);
		grdPane.addRow(1,hbox);
		grdPane.addRow(2, txtR);
		grdPane.addRow(3, hboxChart);
		
		Scene scene = new Scene(grdPane,300,400);
		stage.setScene(scene);
		stage.setTitle("Open File System");
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
}
