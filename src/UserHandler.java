import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class UserHandler extends DefaultHandler{
	boolean director = false;
	boolean genres = false;
	boolean writer = false;
	boolean cast = false;
	StoreClass store ;
	
	private String name = "";
	private int moviecount = 0;
	
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
    	case "year":
    		name ="year";
    		break;
    	case "title":
    		name ="title";
    		break;
    	case "rating":
    		name ="rating";
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
    	case "country":
    		name ="country";
    		break;
    	case "language":
    		name ="language";
    		break;
    	case "company":
    		name ="company";
    		break;
    	case "cast":
    		name ="cast";
    		cast = true;
    		break;
    	case "kw":
    		name ="kw";
    		break;
    	case "name":
    		name ="name";
    		break;
    	case "role":
    		name="role";
    		break;
    	case "item":
    		name = "item";
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
    	case "director":
    		name="";
    		break;
    	case "genres":
    		name="";
    		break;
    	case "writer":
    		name="";
    		break;
    	case "country":
    		store.add_Country(getString);
    		name="";
    		break;
    	case "language":
    		name="";
    		break;
    	case "company":
    		
    		store.add_Company(getString);
    		name="";
    		break;
    	case "cast":
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
    			//System.out.println("Role:"+new String(ch,start,length));
    			store.add_Director_Role(getString);
    			//store.getDirectorRole().add(getString);
    		}else
			if(writer) {
				//System.out.println("Writer role:"+new String(ch,start,length));
				store.add_WriterName(getString);
				//store.getWriterRole().add(getString);
			}else
    		if(cast) {
    			//System.out.println("Cast role:"+new String(ch,start,length));
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
	    	case "year":
	    		
	    		break;
	    		
	    	case "title":
	    		
	    		break;
	    		
	    	case "rating":
	    		
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
	    	case "country":
	    		
	    		break;
	    	case "language":
	    		
	    		break;
	    	case "company":
	    		
	    		break;
	    	case "cast":
	    		cast = false;
	    		
	    		break;
	    	case "keyword":
	    		
	    		break;
	    	case "name":
	    		
	    		break;	    
	    	}	     
		   }
    
    	public String Show_String() {
    		store.get_keywordreturn(store.getMovieset());
    		String file = store.get_keywordreturn(store.getMovieset());
    		return file;

    	}
    	
    	public String Search(String givenstring) {
    		String return_val = store.get_keywordreturn(store.find(givenstring));
    		return return_val;
    	}
    	
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
//    		System.out.println("KeyWord Count");
//    		for(String s:return_count.keySet()) {
//    			System.out.println(s+"\t"+return_count.get(s));
//    		}
    		return return_count;
    	}

    	public void Prinit_Keyword_counts(){
    		Map<String,Integer> index = store.getIndex();
    		for(String key:index.keySet()) {
    			System.out.println(key+" "+index.get(key));
    		}

    	}
		public Map<String,Integer> getKeywordsDeatil()
		{
			return  store.getIndex();
		}


}
