package application;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class NewTile {
	private static NewTile instance = null;
	Label labelColor,labelComment,labelPoint,labelPointComment,clock;
	//do sterowania
	int i,j;
	public int sek;
	public int size;
	int randi,randj;
	boolean timeOver;
	public boolean ifActive,buttonActive ;
	Button button;
	Tile[][] board;
	
	private NewTile(){
		
	}

	public Parent createContent() {

		
		Pane root = new Pane();
		button = new Button("Rozpoczynamy!!");
		labelComment = new Label("Naciśnij taki kolor");
		labelComment.setLayoutX(630);
		labelComment.setTranslateY(110);
		labelComment.setVisible(false);
		labelColor = new Label("");
		labelColor.setMinSize(100, 30);
		labelColor.setLayoutX(640);
		labelColor.setTranslateY(150);
		labelPoint = new Label("0");
		labelPoint.setLayoutX(755);
		labelPoint.setTranslateY(190);
		labelPoint.setVisible(false);
		labelPointComment = new Label("Twój wynik to: ");
		labelPointComment.setLayoutX(630);
		labelPointComment.setTranslateY(190);
		labelPointComment.setVisible(false);
		clock = new Label("Start");
		clock.setLayoutX(630);
		clock.setTranslateY(220);
		clock.setVisible(false);
		button.setTranslateX(620);
		button.setTranslateY(100);
		root.setPrefSize(800, 600);
		 board = new Tile[size][size];
		for (i = 0; i < size; i++) {
			for (j = 0; j < size; j++) {
				board[i][j] = new Tile();
				board[i][j].setTranslateX(j * (600/size));
				board[i][j].setTranslateY(i * (600/size));
				root.getChildren().add(board[i][j]);
				board[i][j].x=i;
				board[i][j].y=j;
				
			}
		}
		
		button.setOnMouseClicked(event -> {
			ChangeColor();
			timeOver = false;
			ifActive=true;
			button.setVisible(false);
			labelComment.setVisible(true);
			labelPoint.setVisible(true);
			labelPointComment.setVisible(true);
			labelColor.setVisible(true);
			clock.setVisible(true);
			labelPoint.setText("0");
			clock.setText("Start");
			clock.setTextFill(Color.BLACK);
			buttonActive = true;
			MyClock(sek);
		});
		root.getChildren().add(button);
		root.getChildren().add(labelColor);
		root.getChildren().add(labelComment);
		root.getChildren().add(labelPoint);
		root.getChildren().add(labelPointComment);
		root.getChildren().add(clock);
		
		return root;
	}
	

	public void CheckCorrectCollor(Tile tile) {
		int r = (int) (Math.random() * 256);
		int g = (int) (Math.random() * 256);
		int b = (int) (Math.random() * 256);
		Color color = Color.rgb(r, g, b);
		Background background = new Background(
				new BackgroundFill(color, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY));
		tile.setBackground(background);
	}

	public void ChangeColor() {
		randi = (int) (Math.random()*size);
		randj = (int) (Math.random()*size);
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				int r = (int) (Math.random() * 256);
				int g = (int) (Math.random() * 256);
				int b = (int) (Math.random() * 256);
				Color color = Color.rgb(r, g, b);
				Background background = new Background(
						new BackgroundFill(color, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY));
				board[j][i].setBackground(background);
				if(randi==i && randj==j)
				labelColor.setBackground(background);
			}
		}

	}
	
	public void MyClock(int sek){
		ClockMy my = new ClockMy();
		my.secondsPassed=0;
		my.time=sek;
		my.start();
		
		
	}
		
	public static synchronized NewTile getInstance(){
		if(instance == null)
			instance = new NewTile();
		return instance;
		
	}
	
	
}
