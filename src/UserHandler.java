import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class UserHandler extends DefaultHandler{
	//boolean movie = false, title,rating,director,genres, writer, country, language,company,cast,keyword;
	boolean movie = false;
	boolean year = false;
	boolean title = false;
	boolean rating = false;
	boolean director = false;
	boolean genres = false;
	boolean writer = false;
	boolean country = false;
	boolean language = false;
	boolean company = false;
	boolean cast = false;
	boolean keyword = false;
	StoreClass store ;
	
	private String name = "";
	private int moviecount = 0;
	
	public UserHandler() {
		store = new StoreClass();
		
	}
	
    @Override
	   public void startElement( String uri, String localName, String qName, Attributes attributes)
	      throws SAXException {
    	//System.out.println(i++);
    	
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
    	switch(name){
    	
    	case "movie":
    		//System.out.println("Movie No "+moviecount);
    		name="";
    		break;
    	case "year":
    		//System.out.println("Year:"+new String(ch,start,length));
    		//store.getYear().add(getString);
    		store.add_Year(getString);
    		name="";
    		break;
    	case "title":
    		//System.out.println("Title :"+new String(ch,start,length));
    		store.add_Title(getString);
    		//store.getTitle().add(getString);
    		name="";
    		break;
    	case "rating":
    		//System.out.println("Rating :"+new String(ch,start,length));
    		store.add_Rating(getString);
    		//store.getRating().add(getString);
    		name="";
    		break;
    	case "director":
    		//System.out.println("Director:"+new String(ch,start,length));
    		name="";
    		break;
    	case "genres":
    		name="";
    		break;
    	case "writer":
    		name="";
    		break;
    	case "country":
    		//System.out.println("Country:"+new String(ch,start,length));
    		
    		store.add_Country(getString);
    		//store.getCountry().add(getString);
    		name="";
    		break;
    	case "language":
    		name="";
    		break;
    	case "company":
    		//System.out.println("Company:"+new String(ch,start,length));
    		store.add_Company(getString);
    		name="";
    		break;
    	case "cast":
    		name="";
    		break;
    	case "kw":
    		//System.out.println("Keywords:"+new String(ch,start,length));
    		store.add_Keyword(getString);
    		name="";
    		break; 
    		
    	case "name":
    		if(director) {
    			//System.out.println("Director:"+new String(ch,start,length));
    			store.add_Director_Name(getString);
    			//store.getDirectorName().add(getString);
    			
    		}else
			if(writer) {
				//System.out.println("Writer:"+new String(ch,start,length));
				store.add_WriterName(getString);
				//store.getWriterName().add(getString);
			}else
    		if(cast) {
    			//System.out.println("Cast:"+new String(ch,start,length));
    			store.add_CastName(getString);
    			//store.getCastName().add(getString);
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
    			//System.out.println("Item:"+new String(ch,start,length));
    			//store.getGenre().add(getString);
    			store.add_Genre(getString);
    			//store.setGenre(store.getGenre().add(getString));
    			
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
    		//System.out.println("User Handler Begin");
    		store.get_keywordreturn(store.getMovieset());
    		String file = store.get_keywordreturn(store.getMovieset());
    		return file;

    	}
    	
    	public String Search(String givenstring) {
    		
    		String return_val = store.get_keywordreturn(store.find(givenstring));
    		return return_val;
    	}
    
	


}
