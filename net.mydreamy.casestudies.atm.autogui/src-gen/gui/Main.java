package gui;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			TabPane root = (TabPane) FXMLLoader.load(getClass().getResource("Prototype.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("Prototype.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Prototype Atm");
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
	
