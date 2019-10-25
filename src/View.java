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
	public ToggleGroup groupRadioButton;
	private int selectedRadioButtonValue ;
	
	
	public int groupRadioButton() {
//		RadioButton selectedRadioButton = (RadioButton) groupRadioButton.getSelectedToggle();
//		return Integer.parseInt(selectedRadioButton.getId());
		//RadioButton selectedRadioButton = (RadioButton) groupRadioButton.getSelectedToggle();
		RadioButton radio= (RadioButton) groupRadioButton.getSelectedToggle();
		if (radio !=null) {
			System.out.println("radio button finally");
			return getIntRadioGroup(radio.getText());
			
		}
		else
			return 5;
	}
	
	public ToggleGroup getToggleGroup() {
		return groupRadioButton;
	}
	
	public int getIntRadioGroup(String value) {
		if(value.equalsIgnoreCase("Top 3 correlated keywords"))
		{
			return 3;
		}
		else if (value.equalsIgnoreCase("Top 5 correlated keywords"))
		{
			return  5;
		}
		else if (value.equalsIgnoreCase("Top 8 correlated keywords"))
		{
			return 8;
		}
		else
		{
			return 10;
		}
		
	}
	
	
	public Label getLabelSource() {
		return lblSource;
	}
	
	public View() {
		createAndConfigurePane();
		createAndLayoutControls();
		this.selectedRadioButtonValue = 0;
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
	 	top3RButton.setId("3");
	 	top3RButton.setText("Top 3 correlated keywords");
	 	top3RButton.setToggleGroup(groupRadioButton);

	 	top5RButton = new RadioButton();
	 	top5RButton.setId("5");
	 	top5RButton.setText("Top 5 correlated keywords");
	 	top5RButton.setToggleGroup(groupRadioButton);

	 	top8RButton = new RadioButton();
	 	top8RButton.setId("8");
	 	top8RButton.setText("Top 8 correlated keywords");
	 	top8RButton.setToggleGroup(groupRadioButton);

	 	top10RButton = new RadioButton();
	 	top10RButton.setText("Top 10 correlated keywords");
	 	top10RButton.setId("10");
	 	top10RButton.setToggleGroup(groupRadioButton);

	 	HBox vContainer = new HBox(top3RButton,top5RButton,top8RButton,top10RButton);
	 	
		//toggle listener for the radio button
	 	
//		groupRadioButton.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
//			@Override
//			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
//				RadioButton selectedRadioButton = (RadioButton) groupRadioButton.getSelectedToggle();
//				if(selectedRadioButton != null)
//				{
//					String s = selectedRadioButton.getText();
//					System.out.println(s);
//					//radioButtonListener(s);
//
//				}
//			}
//		});

	 

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
		view.addRow(5, vContainer);
		view.addRow(6, ChartRow);
		
	}
    public String radioButtonAction(ActionEvent action)
	{
		return groupRadioButton.getSelectedToggle().getUserData().toString();
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
	//set toggle for the Radio btn
	public void SetRadioBtnListener(ChangeListener<Toggle> listener) {
		//groupRadioButton.selectedToggleProperty().addListener(listener);
		groupRadioButton.selectedToggleProperty().addListener(listener);
		//RadioButton selectedRadioButton = (RadioButton) groupRadioButton.getSelectedToggle();
		//System.out.println(selectedRadioButton.getText());
	}
	
	
	
	

	// getter method for returning the variable
	public int getSelectedRadioButtonValue()
	{
		return  selectedRadioButtonValue;
	}
	// decide which radio button has selected and then sets the value to selectedradiobuttonvalue variable
	public void radioButtonListener(String value)
	{
		if(value.equalsIgnoreCase("Top 3 correlated keywords"))
		{
			this.selectedRadioButtonValue = 3;
		}
		else if (value.equalsIgnoreCase("Top 5 correlated keywords"))
		{
			this.selectedRadioButtonValue = 5;
		}
		else if (value.equalsIgnoreCase("Top 8 correlated keywords"))
		{
			this.selectedRadioButtonValue = 8;
		}
		else
		{
			this.selectedRadioButtonValue = 10;
		}
		
	}	
	
}
