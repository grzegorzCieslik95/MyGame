package bag;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class BagShow {
	private Bag[][] bag = new Bag[4][4];
	private int bagX,bagY;
	private static BagShow instance = null;
	private Stage stage;
	
	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	
	private BagShow(){
	Pane root = new Pane();
	stage = new Stage();
	Scene scene2 = new Scene(root);
	root.setPrefSize(200,200);
	for(int i = 0;i<4;i++)
	{
		for (int j = 0; j < 4; j++) {
			bag[j][i] = new Bag();
			bag[j][i].setTranslateX(j * (50));
			bag[j][i].setTranslateY(i * (50));
			root.getChildren().add(bag[j][i]);
			bag[j][i].setX(j);
			bag[j][i].setY(i);

		}
	}
	stage.setX(880);
	stage.setY(180);
	stage.initStyle(StageStyle.UNDECORATED);
	stage.setTitle("Twój ekwipunek");
	stage.setScene(scene2);
}

	public static synchronized BagShow getInstance() {
		if (instance == null)
			instance = new BagShow();
		return instance;

	}

	public int getBagX() {
		return bagX;
	}

	public void setBagX(int bagX) {
		this.bagX = bagX;
	}

	public int getBagY() {
		return bagY;
	}

	public void setBagY(int bagY) {
		this.bagY = bagY;
	}
	
	public Bag[][] getBag() {
		return bag;
	}

	public void setBag(Bag[][] bag) {
		this.bag = bag;
	}

}
