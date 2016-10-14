package Pixel;


import characters.Wizard;
import ground.Ground;
import item.Item;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import monster.MonsterInterface;

public class Pixel extends StackPane{
	private int x,y;
	private Item item;
	private Ground ground;
	private MonsterInterface monster;
	private Wizard wizard;
	private Label picture;
	public Pixel(){
		Rectangle border = new Rectangle(600/12,600/12);
		border.setStroke(Color.BLACK);
		setAlignment(Pos.CENTER);
		border.setFill(null);
		picture = new Label();
		picture.setPrefSize(50, 50);
		getChildren().add(picture);
		getChildren().addAll(border);
		
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
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Ground getGround() {
		return ground;
	}
	public void setGround(Ground ground) {
		this.ground = ground;
	}
	public MonsterInterface getMonster() {
		return monster;
	}
	public void setMonster(MonsterInterface monster) {
		this.monster = monster;
	}
	public Wizard getWizard() {
		return wizard;
	}
	public void setWizard(Wizard wizard) {
		this.wizard = wizard;
	}

	public Label getPicture() {
		return picture;
	}

	public void setPicture(Label picture) {
		this.picture = picture;
	}
	
}
