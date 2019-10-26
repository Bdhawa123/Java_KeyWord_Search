import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedSet;
import java.util.TreeSet;
import static java.util.stream.Collectors.*;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.chart.PieChart;

public class Model {
	File selectedFile = new File("");
	SAXParserFactory factory = SAXParserFactory.newInstance();
	SAXParser saxParser;
	UserHandler userhandler = new UserHandler();
	private int keyword_occurence = 5;
	private Map<String,Integer> ret_search;
	private  Map<String,Integer> data;
	
	
	public void setgetKeyword_occ(String string) {
		keyword_occurence= Integer.parseInt(string);
	}
	
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
		
		 ret_search = userhandler.getCount(search);
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
		
		Map<String,Integer> ret_search = Sort(userhandler.KeywordCount(search));		
		
//		System.out.println("Sort begin");
//		System.out.println("**************************************");
		int i =0;
		for ( String key : ret_search.keySet() ) {
			if(i<keyword_occurence) {
				series.getData().add(new XYChart.Data(key,ret_search.get(key)));
				//System.out.println(key+" "+ret_search.get(key));
				i++;
			}
			else {
				break;
			}
		}
	 
		BarchartBuilder.getData().add(series);
		return BarchartBuilder;	
	}
	
	public Map<String, Integer> Sort(Map<String, Integer> str){
		Map<String, Integer> sorted = str.entrySet()
				  .stream()
				  .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
				  .collect(toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2,
				                LinkedHashMap::new));
		return sorted;
		
	}

	public BarChart<String,Integer> topbarChart(String search, ArrayList<String> keywordList, int times){
		CategoryAxis xAxi = new CategoryAxis();
		NumberAxis yAxi = new NumberAxis();
		xAxi.setLabel("Movie Name");
		yAxi.setLabel("No of Occurences");

		BarChart<String,Integer> BarchartBuilder = new BarChart(xAxi,yAxi);
		XYChart.Series<String, Integer> series = new XYChart.Series<>();
		BarchartBuilder.setTitle("Keyword "+search+" Occurences");


		for (int i = 0; i<times ; i++ ) {

			Integer ld = data.get(keywordList.get(i).trim());
			if (ld!=null) {
				series.getData().add(new XYChart.Data(keywordList.get(i),ld));
			}
		}
		BarchartBuilder.getData().add(series);

		return BarchartBuilder;

	}

	
	public PieChart PieChart(String search) {
		PieChart piChart = new PieChart();
		ObservableList ListData = FXCollections.observableArrayList(); 
		Map<String,Integer> ret_search = Sort(userhandler.KeywordCount(search));		
		int i =0;
		for ( String key : ret_search.keySet() ) {
			if(i<keyword_occurence) {
				ListData.add(new PieChart.Data(key,ret_search.get(key)));
				System.out.println(key+" "+ret_search.get(key));
				i++;
			}
			else {
				break;
			}
		}
		
		piChart.setData(ListData);
		piChart.setLegendSide(Side.LEFT);
		piChart.setTitle("Keywords in Movies"+search);
		
		return  piChart;
	}		
	
	
	

}
