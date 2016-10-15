package monster;

import Map.Map;
import item.Item;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class DevilBoss implements MonsterInterface {
	private int attack=100;
	private int hp=2500;
	private Item item;
	Map map = Map.getInstance();
	
	public void SuperDevilAction(int x,int y){
		map.pixel[x][y].setOnMouseEntered(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				map.comunication.setText("Boss Diabłów!!!\nMusisz mieć dużo Hp \naby z nim wygrać!!\nMoc: "+attack+"\nŻycie: "+hp);

			}
		});
		
		map.pixel[x][y].setOnMouseExited(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				map.comunication.setText("Komunikaty");
			}
		});
	}
	@Override
	public Item getItem() {
		return item;
	}

	@Override
	public int getAttack() {
		return attack;
	}

	@Override
	public int getHp() {
		return hp;
	}

	@Override
	public void setHp(int hp) {
		this.hp = hp;

	}

}
