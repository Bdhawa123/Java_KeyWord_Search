import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StoreClass {
	private List<String> Title;
	private List<String> Year;
	private List<String> Rating;
	private List<String> Country;
	private List<String> Language;
	private List<String> Company;
	private List<String> Keyword;
	private List<String> DirectorName;
	private List<String> DirectorRole;
	private List<String> CastName;
	private List<String> CastRole;
	private List<String> WriterName;
	private List<String> WriterRole;
	private List<String> Genre;
	private Map<String,Integer> Index;
	private int count;
	

	Map<String, List<String>> Movie = new HashMap<String, List<String>>();
	Map<Integer,Map<String,List<String>>> Movieset= new HashMap<Integer,Map<String,List<String>>>();
	String[] ignoreStrings = {"(screenplay)","(novel)","(written by)","(story)"};
	
	
public StoreClass() {
		
		Title= new ArrayList<String>();
		Year= new ArrayList<String>();
		Rating= new ArrayList<String>();
		Country= new ArrayList<String>();
		Language= new ArrayList<String>();
		Company= new ArrayList<String>();
		Keyword= new ArrayList<String>(); 
		DirectorName= new ArrayList<String>();
		DirectorRole = new ArrayList<String>();
		CastName = new ArrayList<String>();
		CastRole = new ArrayList<String>();
		Genre = new ArrayList<String>();
		WriterName = new ArrayList<String>();
		WriterRole = new ArrayList<String>();
		Index = new HashMap<String,Integer>();
		
		
	}
	
	public Map<String,Integer> getIndex() {
		return Index;
	}
	
	public void add_Title(String title) {
		Title.add(title);
		
	}
	public void add_Year(String year) {
		Year.add(year);
		
	}
	public void add_Rating(String rating) {
		Rating.add(rating);
	}
	public void add_Country(String country) {
		Country.add(country);
	}
	public void add_Language(String language) {
		Language.add(language);
	}
	
	public void add_Company(String company) {
		Company.add(company);
	
	}
	public void add_Keyword(String keyword) {
		Keyword.add(keyword);
	}
	public void add_Director_Name(String director_name) {
		DirectorName.add(director_name); 
	}
	public void add_Director_Role(String director_role) {
		DirectorRole.add(director_role); 
	}
	public void add_CastName(String name) {
		CastName.add(name); 
	}
	
	public void add_CastRole(String role) {
		CastRole.add(role);
	}
	
	public void add_WriterName(String name) {
		WriterName.add(name);
	}
	public void add_WriterRole(String role) {
		WriterName.add(role);
	}
	
	public void add_Genre(String role) {
		Genre.add(role);
	}
	
	public List<String> getGenre() {
		return Genre;
	}

	public Map<Integer, Map<String, List<String>>> getMovieset() {
		return Movieset;
	}
	
	public Map<String, List<String>> getMovie() {
		return Movie;
	}	
	
	
	public Map<Integer,Map<String,List<String>>> find(String keyword) {
		int i = 0; count=0;
		Map<Integer,Map<String,List<String>>> Moviesetreturn=new HashMap<Integer,Map<String,List<String>>>();;
		
		for(Map<String, List<String>> mov:Movieset.values()) {
			i++;
			for(List<String> iterator: mov.values()) {
				for(String s:iterator) {
					if (s.toLowerCase().contains(keyword.toLowerCase())||s.equalsIgnoreCase(keyword)) {
						Moviesetreturn.put(i, mov);
						count++;
					}
				}
			}			
		}
		return Moviesetreturn;
	}
	
	public String get_keywordreturn(Map<Integer,Map<String,List<String>>> Moviesreturn) {
		int i = 0;
		String getString ="";
		for(Map<String, List<String>> mov:Moviesreturn.values()) {
			i++;
			getString+="Movie "+i+"\n";
			List<String> title = mov.get("Title");
			List<String> year = mov.get("Year");
			List<String> Rating = mov.get("Rating");
			List<String> Country = mov.get("Country");
			List<String> Company = mov.get("Company");
			List<String> Keywords = mov.get("Keyword");
			List<String> Language = mov.get("Language");
			List<String> Director_Name = mov.get("DirectorName");
			List<String> Direcror_Role = mov.get("DirectorRole");
			List<String> Cast_Name = mov.get("CastName");
			List<String> Cast_Role = mov.get("CastRole");
			List<String> Writer_Name = mov.get("WriterName");
			List<String> Writer_Role = mov.get("WriterRole");
			List<String> Genre = mov.get("Genre");
			
			for(String s:title) {
				if (s!="") {
				getString+="Title: "+s+"\n";
				}
			}
			for(String s:Company) {
				if (s!="") {
				getString+="Company: "+s+"\n";
				}
			}
			
			for(String s:year) {
				if (s!="") {
				getString+="Year: "+s+"\n";
				}
			}
			
			for(String s:Rating) {
				if (s!="") {
				
				getString+="Rating: "+s+"\n";
				}
			}
			
			for(String s:Country) {
				if (s!="") {
				//System.out.println("Country"+s);
				getString+="Country: "+s+"\n";
				}
			}
			
			for(String s:Keywords) {
				if (s!="") {
				getString+="Keywords: "+s+"\n";
				}
			}
			
			for(String s:Language) {
				if (s!="") {
				
				getString+="Language: "+s+"\n";
				}
			}
			
			for(String s:Director_Name) {
				if (s!="") {
				
				getString+="Director Name: "+s+"\n";
				}
			}
			
			for(String s:Direcror_Role) {
				if (!s.equalsIgnoreCase("")) {
				
				getString+="Director Role: "+s+"\n";
				}
			}
			
			for(String s:Cast_Name) {
				if (s!="") {
				
				getString+="Cast Name: "+s+"\n";
				}
			}
			
			for(String s:Cast_Role) {
				if (s!="") {
				
				getString+="Cast Role: "+s+"\n";
				}
			}
			
			for(String s:Writer_Name) {
				if (s!="") {
				getString+="Writer Name: "+s+"\n";
				}
			}
			
			
			
			for(String s:Writer_Role) {
				if (s!="") {
				getString+="Writer Role: "+s+"\n";
				}
			}
			
			for(String s:Genre) {
				if (s!="") {
				getString+="Genre: "+s+"\n";
				}
			}
			getString+="\n";
		}
		
		return getString;
		
	}
	
	public void fillAddMovie() {
		Movie.put("Title",Title);
		Movie.put("Year",Year);
		Movie.put("Rating",Rating);
		Movie.put("Country",Country);
		Movie.put("Language",Language);
		Movie.put("Company",Company);
		Movie.put("Keyword",Keyword);
		Movie.put("DirectorName",DirectorName);
		Movie.put("DirectorRole",DirectorRole);
		Movie.put("CastName",CastName);
		Movie.put("CastRole",CastRole);
		Movie.put("WriterName",WriterName);
		Movie.put("WriterRole",WriterRole);
		Movie.put("Genre",Genre);
		
		Title= new ArrayList<String>();
		Year= new ArrayList<String>();
		Rating= new ArrayList<String>();
		Country= new ArrayList<String>();
		Language= new ArrayList<String>();
		Company= new ArrayList<String>();
		Keyword= new ArrayList<String>(); 
		DirectorName= new ArrayList<String>();
		DirectorRole = new ArrayList<String>();
		CastName = new ArrayList<String>();
		CastRole = new ArrayList<String>();
		Genre = new ArrayList<String>();
		WriterName = new ArrayList<String>();
		WriterRole = new ArrayList<String>();
	}
	
	public void AddIntoMovie(Integer movie) {
		Movieset.put(movie, Movie);
		Movie =new HashMap<String, List<String>>();
	}
	
	
	
	public void createIndex(String indexbuilder) {
		char[] ch = indexbuilder.toCharArray();
		boolean val = false;
		for(char c:ch) {
			if (Character.getNumericValue(c)!=-1) {
				val=true;
			}
				
		}
		if(val) {
			if(Arrays.stream(ignoreStrings).anyMatch(indexbuilder::equals)) {
				val =false;
			}		
			if(val) {
				indexbuilder = indexbuilder.toLowerCase();
				if (Index.isEmpty()) {
					
					Index.put(indexbuilder, 1);
				}
				else {
					if(Index.get(indexbuilder)==null) {
						Index.put(indexbuilder, 1);
					}
					else {
						int newindex = Index.get(indexbuilder)+1;
						Index.put(indexbuilder, newindex);
					}
				}
			}
		}
	
	}
		
}