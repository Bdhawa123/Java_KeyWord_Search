import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import org.xml.sax.SAXException;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Controller {
    private View controllerview;
    private Model controllermodel;
    private Stage stg;
    private  ArrayList<String> topKeywordsList;
    private ToggleGroup radiobutton;
    private int topCount;

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
            splitData(setSearchresult);
        	controllerview.getTextArea().setText(setSearchresult);

        });
        
       
        controllerview.SetRadioBtnListener(controllermodel.RadioBtn(controllerview.groupRadioButton()));
        		
        		
//			@Override
//			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
//				RadioButton selectedRadioButton = (RadioButton) groupRadioButton.getSelectedToggle();
//				if(selectedRadioButton != null)
//				{
//					String s = selectedRadioButton.getText();
//					radioButtonListener(s);
//
//				}
//			}
//		});
        	
       
        

        
        controllerview.BarGraph(e->{
        	String setSearchresult = controllerview.getTxtInp().getText();
        	Group root;
        	if (controllerview.getSelectedRadioButtonValue() != 0)
            {
                //Calling barchat method for restricting keywords and only displaying top keywords
                 root = new Group(controllermodel.topbarChart(setSearchresult,topKeywordsList,controllerview.getSelectedRadioButtonValue()));
            }
            else {
                 root = new Group(controllermodel.barchart(setSearchresult));
            }
        	controllerview.create_BarGraph(root);
        });
        
        controllerview.PieChart(e->{
    		String setSearchresult = controllerview.getTxtInp().getText();
        	//Group Root = new StackPane();
        	Group root ;
        	if (controllerview.getSelectedRadioButtonValue() != 0)
            {
                //Calling piechart method for restricting keywords and only displaying top keywords
                root= new Group(controllermodel.topPieChart(setSearchresult,topKeywordsList,controllerview.getSelectedRadioButtonValue()));
            }
            else
            {
                root= new Group(controllermodel.PieChart(setSearchresult));
            }

        	controllerview.create_BarGraph(root);
        	
        });


    }

    public void setTopCount(int value)
    {
        this.topCount = value;
    }


    /**
     * this method helps to split the stringing and only stores required keywords
     * this method takes search out comes string then breaks into token
     * this method all calls the sorting method for sorting  keywordslist
     */
    public void splitData(String value)
    {
        topKeywordsList = new ArrayList<String>();
        StringTokenizer token = new StringTokenizer(value,"\n");

        while(token.hasMoreTokens())
        {
            String check = token.nextToken();
            if(check.contains("Keywords"))
            {
                StringTokenizer t = new StringTokenizer(check,":");
                t.nextToken();
                String keyword = t.nextToken();
                if(searchForKeywords(keyword)==0)
                    topKeywordsList.add(keyword);
            }
        }
        sortKeywordsArray();
    }
    //find the words in the keywords list
    public int searchForKeywords(String keywords)
    {
        for(int i = 0 ; i< topKeywordsList.size(); i++)
        {
            if(topKeywordsList.get(i).equalsIgnoreCase(keywords)){
                return  i ;
            }
        }
        return 0;

    }
    //bubble sorting method
    public void sortKeywordsArray()
    {
        for (int i = topKeywordsList.size() ; i>=1; i--)
        {
            for (int j =0 ; j <i-1 ; j++)
            {
                int firstIndexValue = controllermodel.getKeywordsData().get(topKeywordsList.get(j).trim());
                int secondIndexValue = controllermodel.getKeywordsData().get(topKeywordsList.get(j+1).trim());
                if (firstIndexValue > secondIndexValue)
                {
                    swap(j,j+1);
                }
            }
        }
    }

    public void swap(int first, int second)
    {
        String temp = topKeywordsList.get(first);
        topKeywordsList.set(first,topKeywordsList.get(second));
        topKeywordsList.set(second,temp);
    }

}
