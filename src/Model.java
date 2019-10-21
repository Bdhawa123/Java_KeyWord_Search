import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.PieChart;

public class Model {
	File selectedFile = new File("");
	SAXParserFactory factory = SAXParserFactory.newInstance();
	SAXParser saxParser;
	UserHandler userhandler = new UserHandler();
	
	public File getFile() {
		return selectedFile;
	}
	
	public void SetFile(File fileselect) {
		selectedFile= fileselect;
	}
	
	
	
	public void ParseXML() {
		
		try {
			saxParser = factory.newSAXParser();
			saxParser.parse(selectedFile,userhandler);
			
		} catch (ParserConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SAXException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	public String ReturnString() {
		return userhandler.Show_String();
	}
	
	public String Search_String(String search) {
		
		Map<String,Integer> ret_search = userhandler.getCount(search);
		return userhandler.Search(search);
	}
	
	public BarChart<String,Integer> barchart(String search){
		CategoryAxis xAxis = new CategoryAxis();
		NumberAxis yAxis = new NumberAxis();
		xAxis.setLabel("Movie Name");
		yAxis.setLabel("No of Occurences");
		
		BarChart<String,Integer> BarchartBuilder = new BarChart(xAxis,yAxis);
		XYChart.Series<String, Integer> series = new XYChart.Series<>();
		BarchartBuilder.setTitle("Keyword "+search+" Occurences");
		
		Map<String,Integer> ret_search = userhandler.getCount(search);
		for ( String key : ret_search.keySet() ) {
			series.getData().add(new XYChart.Data(key,ret_search.get(key)));
		    //System.out.println( key+": "+ret_search.get(key));
		}
		BarchartBuilder.getData().add(series);
		
		return BarchartBuilder;
		
	}
	
	
	
	public PieChart PieChart(String search) {
		PieChart piChart = new PieChart();
		ObservableList ListData = FXCollections.observableArrayList(); 
		Map<String,Integer> ret_search = userhandler.getCount(search);
		for ( String key : ret_search.keySet() ) {
			ListData.add(new PieChart.Data(key,ret_search.get(key)));
		}
		piChart.setData(ListData);
		return  piChart;
	}
	
	
	
	
	
	
	

}
