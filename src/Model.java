import java.io.File;

public class Model {
	File selectedFile = new File("");
	
	public File getFile() {
		return selectedFile;
	}
	
	public void SetFile(File fileselect) {
		selectedFile= fileselect;
	}
	
	

}
