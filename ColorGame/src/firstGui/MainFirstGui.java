package firstGui;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class MainFirstGui extends Application{
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		primaryStage.setTitle("Ustaw parametry");
		loader.setLocation(this.getClass().getResource("fxml/FirstGui.fxml"));
		StackPane stackPane = loader.load();
		FirstGuiController controller = loader.getController();
		controller.stage=primaryStage;
		primaryStage.setResizable(false);
		Scene scene = new Scene(stackPane);
		scene.getStylesheets().add("firstGui/fxml/style.css");
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			public void handle(WindowEvent event) {
				System.out.println("hello");

			}

		});
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
