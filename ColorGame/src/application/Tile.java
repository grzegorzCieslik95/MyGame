package application;

import javafx.geometry.Pos;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class Tile extends StackPane {
	int x;
	int y;

	public Tile() {
		NewTile tile = NewTile.getInstance();
		javafx.scene.shape.Rectangle border = new javafx.scene.shape.Rectangle(600 / (tile.size), 600 / (tile.size));
		border.setStroke(Color.BLACK);
		setAlignment(Pos.CENTER);
		border.setFill(null);
		getChildren().addAll(border);
		setOnMouseClicked(event -> {
			if (event.getButton() == MouseButton.PRIMARY) {
				if (tile.buttonActive == true) {
					if (tile.timeOver == false) {
						try {
							if (tile.board[x][y].getBackground().equals(tile.labelColor.getBackground())) {
								int point = Integer.parseInt(tile.labelPoint.getText());
								point = point + 1;
								tile.labelPoint.setText(Integer.toString(point));
							} else {

							}
						} catch (NullPointerException e) {

						}
						tile.ChangeColor();
					} else {
						tile.clock.setTextFill(Color.RED);
						tile.clock.setText("Koniec czasu");
						tile.buttonActive=false;
						tile.button.setVisible(true);
						tile.labelColor.setVisible(false);
						tile.labelComment.setVisible(false);
						tile.labelPoint.setVisible(true);
						tile.labelPointComment.setVisible(true);
						tile.clock.setVisible(true);
					}
				}
			}
		});

	}

	int returnX(int x) {
		return x;
	}

	int returnY(int y) {
		return y;
	}

}