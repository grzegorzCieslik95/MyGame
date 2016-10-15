package firstGui;

import com.sun.prism.paint.Color;

import Map.Map;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class FirstGui extends Application{
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource("/firstGui/FirstGui.fxml"));
		AnchorPane anchorPane = loader.load();
		anchorPane.getStylesheets().add("firstGui/firstGui.css");
		Scene scene = new Scene(anchorPane);
		
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		
		launch(args);
	}
}
