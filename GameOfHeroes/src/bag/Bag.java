package bag;

import item.Item;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Bag extends StackPane{
	private int x,y,value;
	private Label showValue;
	private Item item;
	
	public Bag(){
		Rectangle border = new Rectangle(40,40);
		border.setStroke(Color.BLACK);
		setAlignment(Pos.CENTER);
		border.setFill(null);
		getChildren().addAll(border);
		showValue = new Label();
		showValue.setTextFill(Color.WHITE);
		showValue.setLayoutX(38);
		showValue.setLayoutY(38);
		showValue.setVisible(true);
		getChildren().add(showValue);
		
		
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public Label getShowValue() {
		return showValue;
	}
	public void setShowValue(Label showValue) {
		this.showValue = showValue;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
}
