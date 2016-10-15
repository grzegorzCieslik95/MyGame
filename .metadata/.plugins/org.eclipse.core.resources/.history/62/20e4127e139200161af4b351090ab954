package equipment;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Armor extends StackPane implements EquipmentInterface {
	private String name;
	private int hp;
	
	public Armor() {
		Rectangle border = new Rectangle(100,100);
		border.setStroke(Color.BLACK);
		setAlignment(Pos.CENTER);
		border.setFill(null);
		getChildren().addAll(border);
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	@Override
	public int getValue(int value) {
		return hp;
	}
	

}
