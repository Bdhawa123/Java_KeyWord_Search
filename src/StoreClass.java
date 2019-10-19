import java.util.ArrayList;
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
	public List<String> getGenre() {
		return Genre;
	}

	public void setGenre(List<String> genre) {
		Genre = genre;
	}

	public Map<Integer, Map<String, List<String>>> getMovieset() {
		return Movieset;
	}

	public void setMovieset(Map<Integer, Map<String, List<String>>> movieset) {
		Movieset = movieset;
	}
	

	Map<String, List<String>> Movie = new HashMap<String, List<String>>();
	Map<Integer,Map<String,List<String>>> Movieset= new HashMap<Integer,Map<String,List<String>>>();
	
//	
//	private Map<String, List<String>> Director;
//	private Map<String, List<String>> Genres;
//	private Map<String, List<String>> Writer;
//	private Map<String, List<String>> Cast;	
	
	public boolean search(String contains) {
		boolean return_val = false;
		return return_val;
	}
	
	
	public Map<Integer,Map<String,List<String>>> find(String keyword) {
		int i = 0;
		Map<Integer,Map<String,List<String>>> Moviesetreturn=new HashMap<Integer,Map<String,List<String>>>();;
		for(Map<String, List<String>> mov:Movieset.values()) {
			i++;
			for(List<String> iterator: mov.values()) {
				for(String s:iterator) {
					if (s.toLowerCase().contains(keyword.toLowerCase())||s.equalsIgnoreCase(keyword)) {
						Moviesetreturn.put(i, mov);
					}
				}
			}
			
		}
		return Moviesetreturn;
	}
	
	public void get_keywordreturn(Map<Integer,Map<String,List<String>>> Moviesreturn) {
		//int i = 0;
		for(Map<String, List<String>> mov:Movieset.values()) {
			i++;
			List<String> title = mov.get("Title");
			List<String> year = mov.get("Year");
			List<String> Rating = mov.get("Rating");
			List<String> Country = mov.get("Country");
			List<String> Company = mov.get("Company");
			List<String> Keywords = mov.get("Keywords");
			List<String> Language = mov.get("Language");
			List<String> Director_Name = mov.get("DirectorName");
			List<String> Direcror_Role = mov.get("DirectorRole");
			List<String> Cast_Name = mov.get("CastName");
			List<String> Cast_Role = mov.get("CastRole");
			List<String> Writer_Name = mov.get("WriterName");
			List<String> Writer_Role = mov.get("WriterRole");
			List<String> Genre = mov.get("Genre");
			
			for(String s:title) {
				System.out.println("Title"+s);
			}
			
			for(String s:Company) {
				System.out.println("Company"+s);
			}
			
			for(String s:year) {
				System.out.println("Year"+s);
			}
			
			for(String s:Rating) {
				System.out.println("Rating"+s);
			}
			
			for(String s:Country) {
				System.out.println("Country"+s);
			}
			
			for(String s:Keywords) {
				System.out.println("Keywords"+s);
			}
			
			for(String s:Language) {
				System.out.println("Language"+s);
			}
			
			for(String s:Director_Name) {
				System.out.println("Director Name"+s);
			}
			
			for(String s:Direcror_Role) {
				System.out.println("Director Role"+s);
			}
			
			for(String s:Cast_Name) {
				System.out.println("Cast Name"+s);
			}
			
			for(String s:Cast_Role) {
				System.out.println("Cast Role"+s);
			}
			
			for(String s:Writer_Name) {
				System.out.println("Writer Name"+s);
			}
			
			
			
			for(String s:Writer_Role) {
				System.out.println("Writer Role"+s);
			}
			
			for(String s:Genre) {
				System.out.println("Genre"+s);
			}
						
		}
		
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
	}
	
	public void AddIntoMovie(Integer movie) {
		Movieset.put(movie, Movie);
	}
	

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
		
	}
	
	
	
	public Map<String, List<String>> getMovie() {
		return Movie;
	}
	public void setMovie(Map<String, List<String>> movie) {
		Movie = movie;
	}
	public List<String> getTitle() {
		return Title;
	}
	public void setTitle(List<String> title) {
		Title = title;
	}
	public List<String> getYear() {
		return Year;
	}
	public void setYear(List<String> year) {
		Year = year;
	}
	public List<String> getRating() {
		return Rating;
	}
	public void setRating(List<String> rating) {
		Rating = rating;
	}
	public List<String> getCountry() {
		return Country;
	}
	public void setCountry(List<String> country) {
		Country = country;
	}
	public List<String> getLanguage() {
		return Language;
	}
	public void setLanguage(List<String> language) {
		Language = language;
	}
	public List<String> getCompany() {
		return Company;
	}
	public void setCompany(List<String> company) {
		Company = company;
	}
	public List<String> getKeyword() {
		return Keyword;
	}
	public void setKeyword(List<String> keyword) {
		Keyword = keyword;
	}
		
	public List<String> getDirectorName() {
		return DirectorName;
	}

	public void setDirectorName(List<String> directorName) {
		DirectorName = directorName;
	}
	
	public List<String> getDirectorRole() {
		return DirectorRole;
	}

	public void setDirectorRole(List<String> directorRole) {
		DirectorRole = directorRole;
	}

	public List<String> getCastName() {
		return CastName;
	}

	public void setCastName(List<String> castName) {
		CastName = castName;
	}

	public List<String> getCastRole() {
		return CastRole;
	}

	public void setCastRole(List<String> castRole) {
		CastRole = castRole;
	}
	
	public List<String> getWriterName() {
		return WriterName;
	}

	public void setWriterName(List<String> writerName) {
		WriterName = writerName;
	}

	public List<String> getWriterRole() {
		return WriterRole;
	}

	public void setWriterRole(List<String> writerRole) {
		WriterRole = writerRole;
	}
	
	
		

}