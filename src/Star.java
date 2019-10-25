import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;

public class Star extends Application {

	@Override
	public void start(Stage stage) {
		//Creating a Path object
		Path path = new Path();
		
		//Moving to the starting point
		MoveTo moveTo = new MoveTo(108, 71); 
				
		//Creating the first line
		LineTo line1 = new LineTo(321, 161);
				
		//Creating the second line
		LineTo line2 = new LineTo(126, 232);
				
		//Creating the third line
		LineTo line3 = new LineTo(232, 52);
				
		//Creating the fourth line
		LineTo line4 = new LineTo(269, 250);
				
		//Creating the fifth line
		LineTo line5 = new LineTo(108, 71);
				
		//Adding the path elements to the Observable list of the Path 
		path.getElements().add(moveTo);
		
		path.getElements().addAll(line1, line2, line3, line4, line5);
		//path.setStroke(Color.BLUE);
		//path.setFill(Color.ALICEBLUE);
		
		//Creating a Group
		Group root1 = new Group(path);
		
		//Creating a Scene 
		Scene scene1 = new Scene(root1, 600, 300);
		
		//Setting title to the scene
		stage.setTitle("Drawing an arc through a path");
		
		//Adding the scene to the stage
		stage.setScene(scene1);
		
		//Displaying the contents of the stage
		stage.show();
	}
		
	
	public static void main(String[] args) {
		launch(args);
	}
}
