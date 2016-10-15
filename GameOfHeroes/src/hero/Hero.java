package hero;



import Map.Map;
import bag.Bag;
import item.Item;



public class Hero {

	private int hp, attack, posX, posY, exp, lvl;
	private String name;
	private Bag[][] bag = new Bag[4][4];
	Map map = Map.getInstance();

	public Hero() {
		posX = 0;
		posY = 0;
	

	}

	public void removeHero() {
		map.pixel[posX][posY].getPicture().setStyle("-fx-background-image:url(\"image/grass.gif\"); ");
	}

	

	public void addItem(Item item){
		int[] slot = map.findWood(item.getName());
		int controlBagX = slot[0];
		int controlBagY = slot[1];
		getBag()[controlBagX][controlBagY].setStyle("-fx-background-image:url(\"image/" + item.getName() + ".png\"); ");
		int newValue = getBag()[controlBagX][controlBagY].getValue();
		newValue = newValue + 1;
		getBag()[controlBagX][controlBagY].setValue(newValue);
		getBag()[controlBagX][controlBagY].getShowValue().setText(Integer.toString(newValue));
		map.comunication.setText("Znaleziono " + item.getName());
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

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getLvl() {
		return lvl;
	}

	public void setLvl(int lvl) {
		this.lvl = lvl;
	}

	public Bag[][] getBag() {
		return bag;
	}

	public void setBag(Bag[][] bag) {
		this.bag = bag;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("Wykonuje");
		this.name = name;
	}

}
