import java.io.File;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import java.awt.Graphics2D;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class View {
	private GridPane view;
	private Button ChooseXML;
	private Button LoadXML;
	private Button Search;
	private TextArea txtR;
	private TextField txtInp;
	private Label lblSource;
	private Button Bar_Chart;
	private Button Pie_Chart;
	private Stage StageChart;
	private RadioButton top3RButton;
	private RadioButton top5RButton;
	private RadioButton top8RButton;
	private RadioButton top10RButton;
	private ToggleGroup groupRadioButton;
	
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
	
	public TextField getTxtInp() {
		return txtInp;
	}

	public void setTxtInp(TextField txtInp) {
		this.txtInp = txtInp;
	}
	
	public Button getBar_Chart() {
		return Bar_Chart;
	}

	public void setBar_Chart(Button bar_Chart) {
		Bar_Chart = bar_Chart;
	}

	public Button getPie_Chart() {
		return Pie_Chart;
	}

	public void setPie_Chart(Button pie_Chart) {
		Pie_Chart = pie_Chart;
	}
	
	

	
	
	public void createAndConfigurePane() {
		view = new GridPane();
		view.setPadding(new Insets(10,10,10,10));
		view.setMinSize(10,60);
		view.setHgap(30);
		view.setVgap(20);
		view.setAlignment(Pos.CENTER);			
	}
	
	public void create_BarGraph(Group root ) {
		
		Scene sc = new Scene(root,500,400);
		StageChart = new Stage();
		StageChart.setTitle("Bar-Chart");
		StageChart.setScene(sc);
		StageChart.show();
		
	}
	
	public void createAndLayoutControls() {

		ChooseXML= new Button("Choose XML file");
	 	lblSource = new Label("");
	 	lblSource.setAlignment(Pos.CENTER);
	 	HBox hboxSource = new HBox(ChooseXML,lblSource );
	 	
	 	//txtInp = new TextField();
	 	txtInp = new TextField();
	 	//txtInp.setPrefWidth(50);
	 	Text SearchLabel = new Text("Search: ");
	 	SearchLabel.setFont(Font.font(" ",FontWeight.BOLD,15));
	 	
	 	Search = new Button("Find");
	 	HBox TextField = new HBox(SearchLabel,txtInp,Search);
	 	txtInp.setMaxWidth(150);
	 	TextField.setAlignment(Pos.TOP_RIGHT);

		groupRadioButton = new ToggleGroup();

	 	top3RButton= new RadioButton();
	 	top3RButton.setText("Top 3 correlated keywords");
	 	top3RButton.setToggleGroup(groupRadioButton);

	 	top5RButton = new RadioButton();
	 	top5RButton.setText("Top 5 correlated keywords");
	 	top5RButton.setToggleGroup(groupRadioButton);

	 	top8RButton = new RadioButton();
	 	top8RButton.setText("Top 8 correlated keywords");
	 	top8RButton.setToggleGroup(groupRadioButton);

	 	top10RButton = new RadioButton();
	 	top10RButton.setText("Top 10 correlated keywords");
	 	top10RButton.setToggleGroup(groupRadioButton);

	 	VBox vContainer = new VBox(top3RButton,top5RButton,top8RButton,top10RButton);

		groupRadioButton.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			@Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
				RadioButton selectedRadioButton = (RadioButton) groupRadioButton.getSelectedToggle();
				if(selectedRadioButton != null)
				{
					String s = selectedRadioButton.getText();
					radioButtonListener(s);

				}
			}
		});

	 	Bar_Chart= new Button("Bar Chart");
	 	Pie_Chart= new Button("Pie Chart");
	 	HBox ChartRow = new HBox(Bar_Chart,Pie_Chart);
	 	ChartRow.setSpacing(50);
	 	ChartRow.setMinHeight(10);
	 	ChartRow.setAlignment(Pos.CENTER);
		
	 	LoadXML = new Button("Parse XML");
	 	HBox hbox = new HBox(LoadXML);
		hbox.setAlignment(Pos.CENTER); 
		hbox.setMinHeight(30);
		txtR = new TextArea();
	
		view.addRow(0,hboxSource);
		view.addRow(1, lblSource);
		view.addRow(2, TextField);
		view.addRow(3,hbox);
		view.addRow(4, txtR);
		view.addRow(5, vContainer  );
		view.addRow(6, ChartRow);
		
	}

	public void addFileListener(EventHandler<ActionEvent> listener){
		ChooseXML.setOnAction(listener);
	}
	
	public void addFileOpenListener(EventHandler<ActionEvent> listener) {
		LoadXML.setOnAction(listener);
		
	}
	
	public void addSearchListener(EventHandler<ActionEvent> listener) {
		Search.setOnAction(listener);
		
	}
	public void BarGraph(EventHandler<ActionEvent> listener) {
		Bar_Chart.setOnAction(listener);
		
	}
	public void PieChart(EventHandler<ActionEvent> listener) {
		Pie_Chart.setOnAction(listener);
		
	}


	public void radioButtonListener(String value)
	{
		if(value.equalsIgnoreCase("Top 3 correlated keywords"))
		{

		}
//		Alert a = new Alert(Alert.AlertType.CONFIRMATION);
//		a.setContentText(value);
//		a.show();
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
