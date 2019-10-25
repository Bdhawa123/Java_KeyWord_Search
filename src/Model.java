import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
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
import javafx.scene.control.Toggle;
import javafx.scene.chart.PieChart;

public class Model {
	File selectedFile = new File("");
	SAXParserFactory factory = SAXParserFactory.newInstance();
	SAXParser saxParser;
	UserHandler userhandler = new UserHandler();
	private Map<String,Integer> ret_search;
	private  Map<String,Integer> data;

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
		System.out.println("\n\n\n return string");
		userhandler.Prinit_Keyword_counts();
		return userhandler.Show_String();
	}
	
	public String Search_String(String search) {
		
		 ret_search = userhandler.getCount(search);
		return userhandler.Search(search);
	}

	public Map<String,Integer> getKeywordsData()
	{
		 data = userhandler.getKeywordsDeatil();
		return data;
	}
	
	public BarChart<String,Integer> barchart(String search){
		CategoryAxis xAxis = new CategoryAxis();
		NumberAxis yAxis = new NumberAxis();
		xAxis.setLabel("Movie Name");
		yAxis.setLabel("No of Occurences");
		
		BarChart<String,Integer> BarchartBuilder = new BarChart(xAxis,yAxis);
		XYChart.Series<String, Integer> series = new XYChart.Series<>();
		BarchartBuilder.setTitle("Keyword "+search+" Occurences");
		
		Map<String,Integer> ret_search = userhandler.KeywordCount(search);
		for ( String key : ret_search.keySet() ) {
			Integer ld = ret_search.get(key);
			if (ld!=null) {
			series.getData().add(new XYChart.Data(key,ret_search.get(key)));
			}
		    //System.out.println( key+": "+ret_search.get(key));
		}
		BarchartBuilder.getData().add(series);
		
		return BarchartBuilder;
		
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
			//System.out.println( key+": "+ret_search.get(key));
		}
		BarchartBuilder.getData().add(series);

		return BarchartBuilder;

	}

	
	public PieChart PieChart(String search) {
		PieChart piChart = new PieChart();
		ObservableList ListData = FXCollections.observableArrayList(); 
		Map<String,Integer> ret_search = userhandler.KeywordCount(search);
		
		for ( String key : ret_search.keySet() ) {
			Integer ld = ret_search.get(key);
			if (ld!=null) {
				ListData.add(new PieChart.Data(key,ret_search.get(key)));
			}
		}
		piChart.setData(ListData);
		piChart.setLegendSide(Side.LEFT);
		piChart.setTitle("Keywords in Movies"+search);
		
		return  piChart;
	}


	public PieChart topPieChart(String search, ArrayList<String>keywordList,int counts) {
		PieChart piChart = new PieChart();
		ObservableList ListData = FXCollections.observableArrayList();


		for ( int i = 0; i<counts; i++ ) {
			Integer ld = data.get(keywordList.get(i).trim());
			if (ld!=null) {
				ListData.add(new PieChart.Data(keywordList.get(i),ld));
			}
		}
		piChart.setData(ListData);
		piChart.setLegendSide(Side.LEFT);
		piChart.setTitle("Keywords in Movies"+search);

		return  piChart;
	}
	
	//radio btn 
	public ChangeListener<Toggle> RadioBtn(int selectedno) {
		System.out.println("selected no "+ selectedno);
		 ChangeListener<Toggle> ChangeListener = new  ChangeListener<Toggle>() {
			 
			@Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
//				RadioButton selectedRadioButton = (RadioButton) groupRadioButton.getSelectedToggle();
//				if(selectedRadioButton != null)
//				{
//					String s = selectedRadioButton.getText();
//					radioButtonListener(s);
//
//				}
			}
		};
		
		return ChangeListener;
	}
	
	
	
	
	

}
