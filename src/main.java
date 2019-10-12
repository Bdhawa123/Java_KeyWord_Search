import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class main extends Application {
	
		public static void main(String[] args) {			
			
			//set gui launch 
			launch();
		}

		@Override
		public void start(Stage stage)throws Exception{
			View view = new View();
			

			Scene scene = new Scene(view.getParent(),500,600);
			stage.setScene(scene);
			stage.setTitle("Open File System");
			stage.show();
		}
	}

