package firstGui;

import application.NewTile;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;

public class FirstGuiController {
	Stage stage;
	boolean ifOpen=true;

	@FXML
	private Label labelSec;

	@FXML
	private Label labelSize;

	@FXML
	private Button startButton;

	@FXML
	private ChoiceBox<Integer> choiceBox;

	@FXML
	private ChoiceBox<Integer> choiceBoxSize;

	@FXML
	private Pane backgroundPane;

	@FXML
	private Label orangeLabel;

	@FXML
	private Label yellowLabel;

	@FXML
	private Label pinkLabel;

	@FXML
	private Label greenLabel;

	@FXML
	private Label redLabel;

	@FXML
	private Label blueLabel;

	@FXML
	void StartButtonAction(ActionEvent event) {
		Stage primaryStage = new Stage();
		NewTile tile = NewTile.getInstance();
		try {
			tile.sek = choiceBox.getValue();
			tile.size = choiceBoxSize.getValue();
		} catch (NullPointerException e) {
			return;
		}
		Parent parent = tile.createContent();
		Scene scene = new Scene(parent);
		primaryStage.setTitle("Color Game");
		primaryStage.setScene(scene);
		primaryStage.initModality(Modality.WINDOW_MODAL);
		scene.getStylesheets().add("firstGui/fxml/StyleGame.css");
		primaryStage.initOwner(stage);
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			public void handle(WindowEvent event) {
				tile.ifActive = false;

			}

		});
		primaryStage.show();
	}

	@FXML
	void initialize() {
		ObservableList<Integer> list = FXCollections.observableArrayList();
		for (int i = 10; i < 120; i = i + 10) {
			list.add(i);
		}
		choiceBox.setItems(list);

		list = FXCollections.observableArrayList();
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(8);
		list.add(10);
		list.add(12);
		choiceBoxSize.setItems(list);
		
		//Obroty kwadratów
		//blue label
		TranslateTransition translate = new TranslateTransition();
		translate.setDuration(Duration.seconds(2.30));
		translate.setNode(blueLabel);
		translate.setToX(200);
		translate.setToY(-200);
		translate.setAutoReverse(true);
		translate.setCycleCount(100);
		translate.play();
		
		TranslateTransition translate1 = new TranslateTransition();
		translate1.setDuration(Duration.seconds(3.75));
		translate1.setNode(redLabel);
		translate1.setToX(0);
		translate1.setToY(150);
		translate1.setAutoReverse(true);
		translate1.setCycleCount(100);
		translate1.play();

		TranslateTransition translate2 = new TranslateTransition();
		translate2.setDuration(Duration.seconds(3));
		translate2.setNode(yellowLabel);
		translate2.setToX(-50);
		translate2.setToY(50);
		translate2.setAutoReverse(true);
		translate2.setCycleCount(100);
		translate2.play();
		
		TranslateTransition translate3 = new TranslateTransition();
		translate3.setDuration(Duration.seconds(3.45));
		translate3.setNode(pinkLabel);
		translate3.setToX(75);
		translate3.setToY(120);
		translate3.setAutoReverse(true);
		translate3.setCycleCount(100);
		translate3.play();
		
		TranslateTransition translate4 = new TranslateTransition();
		translate4.setDuration(Duration.seconds(2.11));
		translate4.setNode(orangeLabel);
		translate4.setToX(10);
		translate4.setToY(-160);
		translate4.setAutoReverse(true);
		translate4.setCycleCount(100);
		translate4.play();
		
		TranslateTransition translate5 = new TranslateTransition();
		translate5.setDuration(Duration.seconds(2.54));
		translate5.setNode(greenLabel);
		translate5.setToX(10);
		translate5.setToY(-160);
		translate5.setAutoReverse(true);
		translate5.setCycleCount(100);
		translate5.play();
		
		
		
		
		
		
		

	}
}
