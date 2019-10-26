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


/**
 * View for the program
 * 
 * @author Binay Dhawa
 */
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
		
	
	/**
	 * Returns Label to Set for Movie Name
	 * @return Label
	 */
	public Label getLabelSource() {
		return lblSource;
	}
	
	/**
	 * 	Create initial view
	 */
	
	public View() {
		createAndConfigurePane();
		createAndLayoutControls();
	}

	
	/**
	 * Get the Current view
	 * 
	 * @return Selected view return
	 */
	public Parent getParent(){
		return view;
	}
	
	/**
	 * Get the Selected Text Area
	 * 
	 * @return Selected TextArea
	 */
	public TextArea getTextArea() {
		return txtR;
	}

	/**
	 * Return the User Text Input
	 * 
	 * @return Text Input 
	 */
	public TextField getTxtInp() {
		return txtInp;
	}
	
	/**
	 * Set desired string on the text area
	 * 
	 * @param txtInp Set string on the Text field 
	 */
	public void setTxtInp(TextField txtInp) {
		this.txtInp = txtInp;
	}
	

	/**
	 * 
	 * @return Get the Bar_Chart
	 */
	public Button getBar_Chart() {
		return Bar_Chart;
	}
	
	/**
	 * Allows to alter the design of the Barchart to be built
	 * 
	 * @param bar_Chart Set the BarChart to the View
	 */
	public void setBar_Chart(Button bar_Chart) {
		Bar_Chart = bar_Chart;
	}
	
	/**
	 * Returns the selected Pie Chart
	 * 
	 * @return PieChart
	 */
	public Button getPie_Chart() {
		return Pie_Chart;
	}
	
	
	/**
	 * Set Pie Chart at output
	 * 
	 * @param pie_Chart Set the desired Pie Chart on Output
	 */
	public void setPie_Chart(Button pie_Chart) {
		Pie_Chart = pie_Chart;
	}
	
	

	
	/**
	 * Create initial layout for the GUI
	 */
	public void createAndConfigurePane() {
		view = new GridPane();
		view.setPadding(new Insets(10,10,10,10));
		view.setMinSize(10,60);
		view.setHgap(30);
		view.setVgap(20);
		view.setAlignment(Pos.CENTER);			
	}
	
	/**
	 * Set the desired Root to the layout
	 * 
	 * @param root Root Consisting of either bar or Pie Chart 
	 */
	public void create_BarGraph(Group root ) {
		
		Scene sc = new Scene(root,500,400);
		StageChart = new Stage();
		StageChart.setTitle("Chart");
		StageChart.setScene(sc);
		StageChart.show();
		
	}
	
	
	/**
	 * Create configuration panels and buttons for the GUI
	 */
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
	
	/**
	 * Add Event Handler to the Button ChooseXML
	 * 
	 * @param listener EventHandler to bind to button
	 */
	public void addFileListener(EventHandler<ActionEvent> listener){
		ChooseXML.setOnAction(listener);
	}
	
	/**
	 * Add Event Handler to the Button LoadXML for loading xml file
	 * 
	 * @param listener EventHandler to bind to button
	 */
	public void addFileOpenListener(EventHandler<ActionEvent> listener) {
		LoadXML.setOnAction(listener);
		
	}
	
	
	/**
	 * Add Event Handler to the Button Search Button
	 * 
	 * @param listener EventHandler to bind to button
	 */
	public void addSearchListener(EventHandler<ActionEvent> listener) {
		Search.setOnAction(listener);
		
	}
	
	/**
	 * Add Event Handler to the Button Bar Chart Button
	 * 
	 * @param listener EventHandler to bind to button
	 */
	public void BarGraph(EventHandler<ActionEvent> listener) {
		Bar_Chart.setOnAction(listener);
		
	}
	
	/**
	 * Add Event Handler to the Button Pie Chart Button
	 * 
	 * @param listener EventHandler to bind to button
	 */
	public void PieChart(EventHandler<ActionEvent> listener) {
		Pie_Chart.setOnAction(listener);
		
	}
	
	/**
	 * Add Event Handler to the Radio Button for toggling functionality
	 * 
	 * @param listener ChangeListener to bind to button
	 */
	public void SetRadioBtnListener(ChangeListener<Toggle> listener) {
		groupRadioButton.selectedToggleProperty().addListener(listener);
		
	}
	
}
