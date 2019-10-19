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
