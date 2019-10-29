import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * Main class for starting the application
 * 
 * @author Binay
 *
 */
public class main extends Application {
		
		public static void main(String[] args) {			
			launch();
		}
		/**
		 * Start Stage
		 */
		@Override
		public void start(Stage stage)throws Exception{
			View view = new View();	
			Model mod = new Model();
			Controller control = new Controller(view,mod,stage);
				
			Scene scene = new Scene(view.getParent(),500,600);
			stage.setScene(scene);
			stage.setTitle("Open File System");
			stage.show();
		}
	}

