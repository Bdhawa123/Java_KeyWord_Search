import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
/**
 * Parse XML file and store them in an index
 * 
 * @author Binay
 *
 */
public class UserHandler extends DefaultHandler{
	boolean director = false;
	boolean genres = false;
	boolean writer = false;
	boolean cast = false;
	StoreClass store ;
	private String name = "";
	private int moviecount = 0;
	
	/**
	 * Constructor for UserHandler
	 */
	public UserHandler() {
		store = new StoreClass();
		
	}
	
    @Override
	   public void startElement( String uri, String localName, String qName, Attributes attributes)
	      throws SAXException { 
    	switch(qName){
    	case "movie":
    		name ="movie";
    		moviecount++;
    		break;
    	case "year": case "title": case "rating":case "country":case "language": case "company":case "kw":case "name":case "role": case "item":
    		name =qName;
    		break;
    	case "director":
    		name ="director";
    		director = true;
    		break;
    	case "genres":
    		name ="genres";
    		genres = true;
    		break;
    	case "writer":
    		name ="writer";
    		writer = true;
    		break;
    	case "cast":
    		name ="cast";
    		cast = true;
    		break;
    	} 
    	
    }
    
    @Override
	   public void characters(char ch[], int start, int length) throws SAXException {
    	String getString = new String(ch,start,length);
    	
		if(getString.trim()!=""||getString.trim()==null) {
			store.createIndex(getString);
		}
		
		
		switch(name){
			case "director": case "genres": case "writer":case "language": case "cast":
	    		name="";
	    		break;
	    		
	    	case "movie":
	    		name="";
	    		break;
	    		
	    	case "year":
	    		store.add_Year(getString);
	    		name="";
	    		break;
	    		
	    	case "title":
	    		store.add_Title(getString);
	    		name="";
	    		break;
	    		
	    	case "rating":
	    		store.add_Rating(getString);
	    		name="";
	    		break;
	    	
	    	case "country":
	    		store.add_Country(getString);
	    		name="";
	    		break;
	    		
	    	case "company":
	    		store.add_Company(getString);
	    		name="";
	    		break;
	    		
	    	case "kw":
	    		store.add_Keyword(getString);
	    		name="";
	    		break; 
	    		
	    	case "name":
	    		if(director) {
	    			store.add_Director_Name(getString);
	    		}else
				if(writer) {
					store.add_WriterName(getString);			
				}else
	    		if(cast) {
	    			store.add_CastName(getString);	
	    		}
	    		name="";
	    		break;
	    		
	    	case "role":
	    		if (director) {
	    			store.add_Director_Role(getString);
	    		}else
				if(writer) {
					store.add_WriterName(getString);
				}else
	    		if(cast) {
	    			store.add_CastRole(getString);
	    		}
	    		name="";
	    		break;
	    		
	    	case "item":
	    		if(genres) {
	    			store.add_Genre(getString);
	    		}
	    		name="";
	    		break;
		}    	
    }
   
    @Override
	   public void endElement(String uri, String localName, String qName) throws SAXException {
    	
    	switch(qName){
	    	
	    	case "movie":
	    		store.fillAddMovie();
	    		store.AddIntoMovie(moviecount);
	    		break;		    		
	    	case "year":case "title":case "rating":case "country":case "language":case "company":case "keyword":case "name":
	    		break;
	    	case "director":
	    		director = false;
	    		break;
	    	case "genres":
	    		genres= false; 		
	    		break;
	    	case "writer":
	    		writer = false;
	    		break;
	    	case "cast":
	    		cast = false;
	    		break;
	    	}	     
	   }

    	
   
    
    	/**
    	 * Returns the Parsed file database in a user readable format
    	 * 
    	 * @return String 
    	 */
    	public String Show_String() {
    		store.get_keywordreturn(store.getMovieset());
    		String file = store.get_keywordreturn(store.getMovieset());
    		return file;

    	}
    	
    	/**
    	 * Returns the String of parsed file data that contains the find keyword 
    	 * 
    	 * @param givenstring keyword to search for within the database
    	 * @return String
    	 */
    	public String Search(String givenstring) {
    		String return_val = store.get_keywordreturn(store.find(givenstring));
    		return return_val;
    	}
    	
    	/**
    	 * Returns HashMap of the found keyword 
    	 *  
    	 * @param keyword User Input String for finding keyword
    	 * @return Map HashMap containing movies that contain the given keyword
    	 */
    	public Map<String,Integer> getCount(String keyword) {
    		
    		int count; int i=0;
    		Map<Integer, Map<String, List<String>>> Moviesetreturn = store.find(keyword);
    		Map<String,Integer> return_count= new HashMap<String, Integer>();
    		
    		for(Map<String, List<String>> mov:Moviesetreturn.values()) {
    			i++; count =0; String Title = "";
    			for(List<String> iterator: mov.values()) {
    				for(String s:iterator) {
    					if (s.toLowerCase().contains(keyword.toLowerCase())||s.equalsIgnoreCase(keyword)) {
    						count++;
    					}
    				}
    				for(String title:mov.get("Title")) {
    					Title = title;
    				}
    			}
    			
    			return_count.put(Title, count);
    		}
    	
    		
    		return return_count;
    	}
    	
    	
    	/**
    	 * Returns HashMap of the found keyword with their occurences in the file
    	 * @param keyword UserInput Keyword
    	 * @return Map A HashMap
    	 */
    	public  Map<String,Integer> KeywordCount(String keyword) {
    		
    		Map<Integer, Map<String, List<String>>> Moviesetreturn = store.find(keyword);
    		Map<String,Integer> return_count= new HashMap<String, Integer>();

    		for(Map<String, List<String>> mov:Moviesetreturn.values()) {
    			for(List<String> iterator: mov.values()) {
    				for(String s:iterator) {
    					if(store.getIndex().get(s)!=null) {
    						return_count.put(s,store.getIndex().get(s));
    					}
    				}
    			}
    		}
    		return return_count;
    	}
    	

}
