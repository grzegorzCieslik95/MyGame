package fight;

import java.util.Random;

import Map.Map;
import finishGame.FinishGame;
import hero.Hero;
import monster.MonsterInterface;

public class Fight {
	Map map = Map.getInstance();
	Random generator = new Random();

	int returnRandomAttackHero(Hero hero) {
		int k = generator.nextInt(hero.getAttack() - 10) + 20;
		return k;
	}

	int returnRandomAttackMonster(MonsterInterface monster) {
		int k = generator.nextInt(monster.getAttack() - 10) + 20;
		return k;

	}

	public void fight(Hero hero, MonsterInterface monster, int x, int y) {
		int heroAttack, monsterAttack;
		System.out.println(monster.getClass().toString());
		while (hero.getHp() > 0 && monster.getHp() > 0) {
			heroAttack = returnRandomAttackHero(hero);
			monster.setHp(monster.getHp() - heroAttack);
			System.out.println("Zaatakował bohater: " + heroAttack);
			monsterAttack = returnRandomAttackMonster(monster);
			hero.setHp(hero.getHp() - monsterAttack);
			System.out.println("Zaatakował potwór: " + monsterAttack);
			System.out.println("Potór ma: " + monster.getHp());

		}
		if (monster.getHp() < 0) {
			if (monster.getItem() != null)
				map.getHero().addItem(monster.getItem());
			map.printMap(x, y);
			map.pixel[x][y].setMonster(null);
			map.hpValueLabel.setText(Integer.toString(hero.getHp()));
			FinishGame finishGame = new FinishGame();
			if (finishGame.finishGame() == true) {
				map.comunication.setText("GRATULACJE!! WYGRAŁEŚ!!!");
				map.getHero().removeHero();
				map.live = false;
			}
		} else {
			map.comunication.setText("PRZEGRAŁEŚ!!!");
			map.getHero().removeHero();
			map.live = false;
			map.hpValueLabel.setText(Integer.toString(hero.getHp()));
		}
	}
}
