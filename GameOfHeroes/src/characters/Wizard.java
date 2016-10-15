package characters;

import Map.Map;
import bag.BagShow;
import hero.Hero;
import item.Gem;
import item.Stone;
import item.Wood;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class Wizard {
	private String name = "Wizard";
	Map map = Map.getInstance();
	BagShow bag = BagShow.getInstance();

	public void WizardActive(int x, int y) {
		System.out.println(x + " " + y);
		map.pixel[x][y].setOnMouseEntered(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				map.comunication.setText("Ten czarodziej może cię uleczyć!!! \nPotrzeba: \n3kamienie \n3drewna \n2klejnoty");

			}
		});

		map.pixel[x][y].setOnMouseExited(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				map.comunication.setText("Komunikaty");
			}
		});
	}

	public void WizardMagic(Hero hero) {
		int wood = 0, stone = 0, gem = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				try {
					if (hero.getBag()[i][j].getItem().getClass() == Wood.class) {
						wood = hero.getBag()[i][j].getValue();
					}
					if (hero.getBag()[i][j].getItem().getClass() == Gem.class) {
						gem = hero.getBag()[i][j].getValue();
					}
					if (hero.getBag()[i][j].getItem().getClass() == Stone.class) {
						stone = hero.getBag()[i][j].getValue();
					}
				} catch (NullPointerException e) {

				}
			}
		}
		if (stone >= 3 && wood >= 3 && gem >= 2) {
			hero.setHp(5000);
			map.hpValueLabel.setText(Integer.toString(hero.getHp()));
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					try {
						if (hero.getBag()[i][j].getItem().getClass() == Wood.class) {
							hero.getBag()[i][j].setValue(wood - 3);
						}
					} catch (NullPointerException e) {
					}
					try {
						if (hero.getBag()[i][j].getItem().getClass() == Gem.class) {
							hero.getBag()[i][j].setValue(gem - 2);
						}
					} catch (NullPointerException e) {
					}
					try {
						if (hero.getBag()[i][j].getItem().getClass() == Stone.class) {
							hero.getBag()[i][j].setValue(stone - 3);
						}
					} catch (NullPointerException e) {
					}
					if (hero.getBag()[i][j].getValue() <= 0) {

						bag.getBag()[i][j].setStyle(null);
						bag.getBag()[i][j].setItem(null);

					}

					hero.getBag()[i][j].getShowValue().setText(Integer.toString(hero.getBag()[i][j].getValue()));

				}
			}
			bag.setBagX(0);
			bag.setBagY(0);
			map.comunication.setText("Uleczanie przebiegło pomyślnie!!!");
		} else {
			map.comunication.setText("Nie masz wszystkich materiałów\nStan:\nKamień: " + stone + "/3\nKlejnoty: " + gem
					+ "/2\nDrewno: " + wood + "/3");
		}
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				try{
				System.out.println(hero.getBag()[i][j].getItem().getName());
				}catch(NullPointerException e){}
			}
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
