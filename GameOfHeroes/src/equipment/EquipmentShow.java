package equipment;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class EquipmentShow {
	private static EquipmentShow instance = null;
	private Stage stage;
	private Sword sword;
	private Armor armor;
	private EquipmentShow(){
		Pane root = new Pane();
		stage = new Stage();
		Scene scene2 = new Scene(root);
		root.setPrefSize(200,200);
		sword = new Sword();
		sword.setLayoutX(5);
		sword.setLayoutY(25);
		sword.setStyle("-fx-background-image: url('image/sword.png')");
		root.getChildren().add(sword);
		armor = new Armor();
		armor.setLayoutX(60);
		armor.setLayoutY(35);
		armor.setStyle("-fx-background-image: url('image/armor.png')");
		root.getChildren().add(armor);
		root.setStyle("-fx-background-image: url('image/warrior.jpg')");
		stage.setX(780);
		stage.setY(190);
		stage.initStyle(StageStyle.UNDECORATED);
		stage.setScene(scene2);
	}
	
	public static synchronized EquipmentShow getInstance() {
		if (instance == null)
			instance = new EquipmentShow();
		return instance;

	}
	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public Armor getArmor() {
		return armor;
	}

	public void setArmor(Armor armor) {
		this.armor = armor;
	}
}
