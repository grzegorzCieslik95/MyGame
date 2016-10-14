package monster;

import item.Item;

public interface MonsterInterface {
	Item getItem();
	int getAttack();
	int getHp();
	void setHp(int hp);
}
