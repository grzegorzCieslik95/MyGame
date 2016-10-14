package monster;

import Map.Map;
import item.Item;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class Devil implements MonsterInterface{
	private int attack=60;
	private int hp=800;
	private Item item;
	Map map = Map.getInstance();
	
	public void DevilAction(int x,int y){
		map.pixel[x][y].setOnMouseEntered(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				map.comunication.setText("Przerażający Diabeł!!! \nMożesz z niego zdobyć Klejnot\nMoc: "+attack+"\nŻycie: "+hp);

			}
		});
		
		map.pixel[x][y].setOnMouseExited(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				map.comunication.setText("Komunikaty");
			}
		});
	}
	
	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	@Override
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}
