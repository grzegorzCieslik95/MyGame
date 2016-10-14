package Map;

import java.util.Random;

import Pixel.Pixel;
import bag.BagShow;
import characters.Wizard;
import equipment.EquipmentShow;
import fight.Fight;
import ground.Dirt;
import ground.Grass;
import hero.Hero;
import item.Gem;
import item.Stone;
import item.Wood;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import monster.Devil;
import monster.DevilBoss;

public class Map {
	private static Map instance = null;
	public boolean live = true;
	Scene scene;
	public String nameHero;
	private Hero hero;
	private Wizard wizard;
	public Pixel[][] pixel;
	public Label hpValueLabel, attackValueLabel, comunication, expValueLabel, lvlValueLabel;
	public Button actionButton, warButton, hellerButton;
	public Stage stage;
	BagShow bagShow = BagShow.getInstance();
	EquipmentShow equipmentShow = EquipmentShow.getInstance();
	public Pane root;

	public Parent createMap() {
		root = new Pane();
		root.setPrefSize(880, 600);
		pixel = new Pixel[12][12];
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 12; j++) {
				pixel[j][i] = new Pixel();
				pixel[j][i].setTranslateX(j * (50));
				pixel[j][i].setTranslateY(i * (50));
				root.getChildren().add(pixel[j][i]);
				pixel[j][i].setX(j);
				pixel[j][i].setY(i);

			}
		}

		generateColorMap();
		CreateRoad();
		hero = new Hero();
		hero.setHp(2000);
		hero.setAttack(60);
		hero.setBag(bagShow.getBag());
		hero.setName(nameHero);
		pixel[0][0].getPicture().setStyle("-fx-background-image:url(\"image/character/"+hero.getName()+"Front.png\"); ");
		
		/*
		 * Build player panel
		 * 
		 * 
		 */
		// helloLabel
		Label helloLabel = new Label("Panel gracza");
		helloLabel.setLayoutX(630);
		helloLabel.setLayoutY(20);
		helloLabel.setId("helloLabel");
		helloLabel.getStylesheets().add("css/PlayerPanelCss.css");
		// comunication
		comunication = new Label("Komunikaty");
		comunication.setLayoutX(620);
		comunication.setLayoutY(240);
		comunication.getStylesheets().add("css/PlayerPanelCss.css");

		Label lvlCommunicateLabel = new Label("LVL: ");
		lvlCommunicateLabel.setLayoutX(810);
		lvlCommunicateLabel.setLayoutY(30);
		lvlCommunicateLabel.getStylesheets().add("css/PlayerPanelCss.css");

		// hpLabelValue
		lvlValueLabel = new Label();
		lvlValueLabel.setText(Integer.toString(hero.getLvl()));
		lvlValueLabel.setLayoutX(850);
		lvlValueLabel.setLayoutY(30);
		lvlValueLabel.getStylesheets().add("css/PlayerPanelCss.css");

		// hpLabelCommunicate
		Label hpCommunicateLabel = new Label("Twoje hp: ");
		hpCommunicateLabel.setLayoutX(615);
		hpCommunicateLabel.setLayoutY(70);
		hpCommunicateLabel.getStylesheets().add("css/PlayerPanelCss.css");
		// hpLabelValue
		hpValueLabel = new Label();
		hpValueLabel.setText(Integer.toString(hero.getHp()));
		hpValueLabel.setLayoutX(680);
		hpValueLabel.setLayoutY(70);
		hpValueLabel.getStylesheets().add("css/PlayerPanelCss.css");

		// attackLabel
		Label attackCommunicateLabel = new Label("Twój atak: ");
		attackCommunicateLabel.setLayoutX(615);
		attackCommunicateLabel.setLayoutY(95);
		attackCommunicateLabel.getStylesheets().add("css/PlayerPanelCss.css");
		// AttackValue
		attackValueLabel = new Label();
		attackValueLabel.setText(Integer.toString(hero.getAttack()));
		attackValueLabel.setLayoutX(680);
		attackValueLabel.setLayoutY(95);
		attackValueLabel.getStylesheets().add("css/PlayerPanelCss.css");

		// ExpComunication
		Label expCommunicationLabel = new Label("Ilość doś: ");
		expCommunicationLabel.setLayoutX(615);
		expCommunicationLabel.setLayoutY(120);
		expCommunicationLabel.getStylesheets().add("css/PlayerPanelCss.css");
		// hpLabelValue
		expValueLabel = new Label();
		expValueLabel.setText(Integer.toString(hero.getExp()));
		expValueLabel.setLayoutX(680);
		expValueLabel.setLayoutY(120);
		expValueLabel.getStylesheets().add("css/PlayerPanelCss.css");

		Label heroImage = new Label();
		heroImage.setStyle("-fx-background-image: url('image//character/"+hero.getName()+"Front.png')");
		heroImage.setMinSize(50, 50);
		heroImage.setLayoutX(720);
		heroImage.setLayoutY(70);
		heroImage.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				stage = equipmentShow.getStage();
				stage.show();
			}
		});
		;
		heroImage.setOnMouseExited(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				stage = equipmentShow.getStage();
				stage.close();
			}
		});

		Label bagImage = new Label();
		bagImage.setStyle("-fx-background-image: url('image/bag.jpg')");
		bagImage.setMinSize(73, 41);
		bagImage.setLayoutX(780);
		bagImage.setLayoutY(80);
		bagImage.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				stage = bagShow.getStage();
				stage.show();

			}
		});
		bagImage.setOnMouseExited(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				stage = bagShow.getStage();
				stage.close();

			}
		});

		actionButton = new Button("Zbierz surowiec!");
		actionButton.setLayoutX(610);
		actionButton.setLayoutY(150);
		actionButton.setDisable(true);
		actionButton.setOnMouseClicked(event -> {
			try {
				if (pixel[hero.getPosX()][hero.getPosY() - 1].getItem() != null) {
					makeAction(hero.getPosX(), hero.getPosY() - 1);
					actionButton.setDisable(true);
				}
			} catch (ArrayIndexOutOfBoundsException e) {

			}
			try {
				if (pixel[hero.getPosX()][hero.getPosY() + 1].getItem() != null) {
					makeAction(hero.getPosX(), hero.getPosY() + 1);
					actionButton.setDisable(true);
				}
			} catch (ArrayIndexOutOfBoundsException e) {

			}
			try {
				if (pixel[hero.getPosX() + 1][hero.getPosY()].getItem() != null) {
					makeAction(hero.getPosX() + 1, hero.getPosY());
					actionButton.setDisable(true);
				}
			} catch (ArrayIndexOutOfBoundsException e) {

			}
			try {
				if (pixel[hero.getPosX() - 1][hero.getPosY()].getItem() != null) {
					makeAction(hero.getPosX() - 1, hero.getPosY());
					actionButton.setDisable(true);
				}
			} catch (ArrayIndexOutOfBoundsException e) {

			}

		});

		warButton = new Button("Stocz walkę!");
		warButton.setLayoutX(750);
		warButton.setLayoutY(150);
		warButton.setDisable(true);
		warButton.setOnMouseClicked(event -> {
			Fight fight = new Fight();
			try {
				if (pixel[hero.getPosX()][hero.getPosY() - 1].getMonster() != null) {
					fight.fight(hero, pixel[hero.getPosX()][hero.getPosY() - 1].getMonster(), hero.getPosX(),
							hero.getPosY() - 1);
					warButton.setDisable(true);
				}
			} catch (ArrayIndexOutOfBoundsException e) {

			}
			try {
				if (pixel[hero.getPosX()][hero.getPosY() + 1].getMonster() != null) {

					fight.fight(hero, pixel[hero.getPosX()][hero.getPosY() + 1].getMonster(), hero.getPosX(),
							hero.getPosY() + 1);
					warButton.setDisable(true);
				}
			} catch (ArrayIndexOutOfBoundsException e) {

			}
			try {
				if (pixel[hero.getPosX() + 1][hero.getPosY()].getMonster() != null) {
					fight.fight(hero, pixel[hero.getPosX() + 1][hero.getPosY()].getMonster(), hero.getPosX() + 1,
							hero.getPosY());
					warButton.setDisable(true);
				}
			} catch (ArrayIndexOutOfBoundsException e) {

			}
			try {
				if (pixel[hero.getPosX() - 1][hero.getPosY()].getMonster() != null) {
					fight.fight(hero, pixel[hero.getPosX() - 1][hero.getPosY()].getMonster(), hero.getPosX() - 1,
							hero.getPosY());
					warButton.setDisable(true);
				}
			} catch (ArrayIndexOutOfBoundsException e) {

			}

		});
		hellerButton = new Button("Ulecz się!");
		hellerButton.setLayoutX(610);
		hellerButton.setLayoutY(190);
		hellerButton.setDisable(true);
		hellerButton.setOnMouseClicked(event -> {
			try {
				if (pixel[hero.getPosX()][hero.getPosY() - 1].getWizard() != null) {
					wizard.WizardMagic(hero);
					hellerButton.setDisable(true);
				}
			} catch (ArrayIndexOutOfBoundsException e) {

			}
			try {
				if (pixel[hero.getPosX()][hero.getPosY() + 1].getWizard() != null) {
					wizard.WizardMagic(hero);
					hellerButton.setDisable(true);
				}
			} catch (ArrayIndexOutOfBoundsException e) {

			}
			try {
				if (pixel[hero.getPosX() - 1][hero.getPosY()].getWizard() != null) {
					wizard.WizardMagic(hero);
					hellerButton.setDisable(true);
				}
			} catch (ArrayIndexOutOfBoundsException e) {

			}
			try {
				if (pixel[hero.getPosX() + 1][hero.getPosY()].getWizard() != null) {
					wizard.WizardMagic(hero);
					hellerButton.setDisable(true);
				}
			} catch (ArrayIndexOutOfBoundsException e) {

			}

		});

		root.getChildren().add(hellerButton);
		root.getChildren().add(warButton);
		root.getChildren().add(lvlCommunicateLabel);
		root.getChildren().add(lvlValueLabel);
		root.getChildren().add(expCommunicationLabel);
		root.getChildren().add(expValueLabel);
		root.getChildren().add(bagImage);
		root.getChildren().add(comunication);
		root.getChildren().add(actionButton);
		root.getChildren().add(heroImage);
		root.getChildren().add(attackCommunicateLabel);
		root.getChildren().add(attackValueLabel);
		root.getChildren().add(hpValueLabel);
		root.getChildren().add(hpCommunicateLabel);
		root.getChildren().add(helloLabel);

		return root;

	}

	// MOVE
	public Scene returnScene() {
		scene = new Scene(createMap());
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent keyEvent) {
				comunication.setText("Komunikaty");
				if (live == true) {
					if (keyEvent.getCode() == KeyCode.UP) {
						int x = hero.getPosX();
						int y = hero.getPosY();
						if (y - 1 >= 0 && pixel[x][y - 1].getItem() == null && pixel[x][y - 1].getMonster() == null
								&& pixel[x][y - 1].getWizard() == null) {
							printMap(x, y);
							y = y - 1;
							hero.setPosY(y);
								pixel[x][y].getPicture()
										.setStyle("-fx-background-image: url('image/character/"+hero.getName()+"Back.png')");
							actionButton.setDisable(true);
							warButton.setDisable(true);
							hellerButton.setDisable(true);
						}
						try {
							if (pixel[x][y - 1].getItem() != null) {
								actionButton.setDisable(false);

							} else if (pixel[x][y - 1].getMonster() != null) {
								warButton.setDisable(false);

							} else if (pixel[x][y - 1].getWizard() != null) {
								hellerButton.setDisable(false);

							}
							pixel[x][y].getPicture()
									.setStyle("-fx-background-image: url('image/character/"+hero.getName()+"Back.png')");
						} catch (ArrayIndexOutOfBoundsException e) {

						}
					}
					if (keyEvent.getCode() == KeyCode.DOWN) {
						
						int x = hero.getPosX();
						int y = hero.getPosY();
						if (y + 1 < 12 && pixel[x][y + 1].getItem() == null && pixel[x][y + 1].getMonster() == null
								&& pixel[x][y + 1].getWizard() == null) {
							printMap(x, y);
							y = y + 1;
							hero.setPosY(y);
							
								pixel[x][y].getPicture()
										.setStyle("-fx-background-image: url('image/character/"+hero.getName()+"Front.png')");

							actionButton.setDisable(true);
							warButton.setDisable(true);
							hellerButton.setDisable(true);

						}
						try {
							if (pixel[x][y + 1].getItem() != null) {
								actionButton.setDisable(false);
							} else if (pixel[x][y + 1].getMonster() != null) {
								warButton.setDisable(false);
							} else if (pixel[x][y + 1].getWizard() != null) {
								hellerButton.setDisable(false);
							}
							pixel[x][y].getPicture()
							.setStyle("-fx-background-image: url('image/character/"+hero.getName()+"Front.png')");
						} catch (ArrayIndexOutOfBoundsException e) {

						}

					}
					if (keyEvent.getCode() == KeyCode.RIGHT) {
						int x = hero.getPosX();
						int y = hero.getPosY();
						if (x + 1 < 12 && pixel[x + 1][y].getItem() == null && pixel[x + 1][y].getMonster() == null
								&& pixel[x + 1][y].getWizard() == null) {
							printMap(x, y);
							x = x + 1;
							hero.setPosX(x);
							
								pixel[x][y].getPicture()
										.setStyle("-fx-background-image: url('image/character/"+hero.getName()+"Right.png')");
							actionButton.setDisable(true);
							warButton.setDisable(true);
							hellerButton.setDisable(true);
						}
						try {
							if (pixel[x + 1][y].getItem() != null) {
								actionButton.setDisable(false);
							} else if (pixel[x + 1][y].getMonster() != null) {
								warButton.setDisable(false);							
							} else if (pixel[x + 1][y].getWizard() != null) {
								hellerButton.setDisable(false);
							}
							pixel[x][y].getPicture()
							.setStyle("-fx-background-image: url('image/character/"+hero.getName()+"Right.png')");
						} catch (ArrayIndexOutOfBoundsException e) {

						}
					}
					if (keyEvent.getCode() == KeyCode.LEFT) {
						int x = hero.getPosX();
						int y = hero.getPosY();
						if (x - 1 >= 0 && pixel[x - 1][y].getItem() == null && pixel[x - 1][y].getMonster() == null
								&& pixel[x - 1][y].getWizard() == null) {
							printMap(x, y);
							x = x - 1;
							hero.setPosX(x);
							
								pixel[x][y].getPicture()
										.setStyle("-fx-background-image: url('image/character/"+hero.getName()+"Left.png')");
							actionButton.setDisable(true);
							warButton.setDisable(true);
							hellerButton.setDisable(true);
						}
						try {
							if (pixel[x - 1][y].getItem() != null) {
								actionButton.setDisable(false);
							} else if (pixel[x - 1][y].getMonster() != null) {
								warButton.setDisable(false);
							}
							else if (pixel[x - 1][y].getWizard() != null) {
								hellerButton.setDisable(false);
							}
							pixel[x][y].getPicture()
							.setStyle("-fx-background-image: url('image/character/"+hero.getName()+"Left.png')");
						} catch (ArrayIndexOutOfBoundsException e) {

						}
					}
				}
			}
		});

		return scene;
	}

	public void generateColorMap() {
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 12; j++) {
				Grass grass = new Grass();
				pixel[i][j].setGround(grass);
				pixel[i][j].setStyle("-fx-background-image:url(\"image/grass.gif\"); ");

			}
		}
	}

	public void CreateRoad() {
		Random rand = new Random();
		int i = 0, j = 0;
		while (i != 11 || j != 11) {
			int k = rand.nextInt(12);
			int l = rand.nextInt(12);
			if (i + k < 12) {
				for (int p = i; p < i + k; p++) {
					Dirt dirt = new Dirt();
					pixel[p][j].setGround(dirt);
					pixel[p][j].setStyle("-fx-background-image:url(\"image/dirt.gif\"); ");
				}
				i = i + k;
			}
			if (j + l < 12) {
				for (int p = j; p < j + l; p++) {
					Dirt dirt = new Dirt();
					pixel[i][p].setGround(dirt);
					pixel[i][p].setStyle("-fx-background-image:url(\"image/dirt.gif\"); ");
				}
				j = j + l;
			}
		}
		Dirt dirt = new Dirt();
		pixel[11][11].setGround(dirt);
		pixel[11][11].setStyle("-fx-background-image:url(\"image/dirt.gif\");");
		int k = 0;
		while (k < 4) {
			int p = rand.nextInt(12);
			int l = rand.nextInt(12);
			if (pixel[p][l].getGround().getClass() == Grass.class && pixel[p][l].getItem() == null) {
				Wood wood = new Wood();
				pixel[p][l].getPicture().setStyle("-fx-background-image:url(\"image/oldtree.png\"); ");
				pixel[p][l].setItem(wood);
				k++;
			}
		}
		
		k = 0;
		while (k < 4) {
			int p = rand.nextInt(12);
			int l = rand.nextInt(12);
			if (pixel[p][l].getGround().getClass() == Grass.class && pixel[p][l].getItem() == null) {
				Stone stone = new Stone();
				pixel[p][l].getPicture().setStyle("-fx-background-image:url(\"image/rock.gif\"); ");
				pixel[p][l].setItem(stone);
				k++;
			}
		}
		k = 0;
		while (k < 3) {
			int p = rand.nextInt(12);
			int l = rand.nextInt(12);
			if (pixel[p][l].getGround().getClass() == Grass.class && pixel[p][l].getItem() == null
					&& pixel[p][l].getMonster() == null) {
				Devil devil = new Devil();
				devil.DevilAction(p, l);
				Gem gem = new Gem();
				devil.setItem(gem);
				pixel[p][l].getPicture().setStyle("-fx-background-image:url(\"image/devil.png\"); ");
				pixel[p][l].setMonster(devil);
				k++;
			}
		}
		k = 0;
		while (k < 1) {
			int p = rand.nextInt(12);
			int l = rand.nextInt(12);
			if (pixel[p][l].getGround().getClass() == Grass.class && pixel[p][l].getItem() == null
					&& pixel[p][l].getMonster() == null) {
				wizard = new Wizard();
				wizard.WizardActive(p, l);
				pixel[p][l].getPicture().setStyle("-fx-background-image:url(\"image/Wizard.png\"); ");
				pixel[p][l].setWizard(wizard);
				k++;
			}
		}

		k = 0;
		while (k < 1) {
			int p = rand.nextInt(12);
			int l = rand.nextInt(12);
			if (pixel[p][l].getGround().getClass() == Grass.class && pixel[p][l].getItem() == null
					&& pixel[p][l].getMonster() == null) {
				DevilBoss devilBoss = new DevilBoss();
				devilBoss.SuperDevilAction(p, l);
				pixel[p][l].getPicture().setStyle("-fx-background-image:url(\"image/DevilBoss2.png\"); ");
				pixel[p][l].setMonster(devilBoss);
				k++;
			}
		}

	}

	public void printMap(int x, int y) {
		// hero.printHero(x, y);
		pixel[x][y].getPicture().setStyle(null);

	}

	public void makeAction(int x, int y) {
		String name = pixel[x][y].getItem().getName();
		int[] location = findWood(name);
		int controlBagX = location[0];
		int controlBagY = location[1];
		pixel[x][y].setStyle("-fx-background-image:url(\"image/grass.gif\"); ");
		pixel[x][y].setItem(null);
		pixel[x][y].getPicture().setStyle(null);
		bagShow.getBag()[controlBagX][controlBagY].setStyle("-fx-background-image:url(\"image/" + name + ".png\"); ");
		int newValue = bagShow.getBag()[controlBagX][controlBagY].getValue();
		newValue = newValue + 1;
		bagShow.getBag()[controlBagX][controlBagY].setValue(newValue);
		bagShow.getBag()[controlBagX][controlBagY].getShowValue().setText(Integer.toString(newValue));
		comunication.setText("Znaleziono " + name);

	}

	public int[] findWood(String name) {
		int[] woodLocalization = new int[2];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				try {
					if (bagShow.getBag()[i][j].getItem().getName().equals(name)) {
						woodLocalization[0] = i;
						woodLocalization[1] = j;
						return woodLocalization;
					}
				} catch (NullPointerException e) {

				}
			}
		}
		woodLocalization[0] = bagShow.getBagX();
		woodLocalization[1] = bagShow.getBagY();
		if (hero.getBag()[woodLocalization[0]][woodLocalization[1]].getItem() != null) {
			while (hero.getBag()[woodLocalization[0]][woodLocalization[1]].getItem() != null) {
				// System.out.println(woodLocalization[0]+"
				// "+woodLocalization[1]);
				if (woodLocalization[0] == 3) {
					if (woodLocalization[1] != 3) {
						woodLocalization[0] = 0;
						woodLocalization[1]++;

					}
				} else {
					woodLocalization[0] = woodLocalization[0] + 1;
					System.out.println(woodLocalization[0] + " " + woodLocalization[1]);
				}
			}
		}
		if (woodLocalization[0] == 3) {
			if (woodLocalization[1] != 3) {
				bagShow.setBagX(0);
				bagShow.setBagY(bagShow.getBagY() + 1);
			} else {
				return null;
			}
		} else {
			bagShow.setBagX(bagShow.getBagX() + 1);
		}
		if (name.equals("wood")) {
			Wood wood = new Wood();
			bagShow.getBag()[woodLocalization[0]][woodLocalization[1]].setItem(wood);
		}
		if (name.equals("stone")) {
			Stone stone = new Stone();
			bagShow.getBag()[woodLocalization[0]][woodLocalization[1]].setItem(stone);
		}
		if (name.equals("Gem")) {
			Gem gem = new Gem();
			bagShow.getBag()[woodLocalization[0]][woodLocalization[1]].setItem(gem);
		}

		return woodLocalization;

	}

	public static synchronized Map getInstance() {
		if (instance == null)
			instance = new Map();
		return instance;

	}

	public Hero getHero() {
		return hero;
	}

	public void setHero(Hero hero) {
		this.hero = hero;
	}

}
