package equipment;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Sword extends StackPane implements EquipmentInterface{
	private String name;
	private int attack;
	
	public Sword() {
		Rectangle border = new Rectangle(50,110);
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
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	@Override
	public int getValue(int value) {
		return attack;
	}

}
