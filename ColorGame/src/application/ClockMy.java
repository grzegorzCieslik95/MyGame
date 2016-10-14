package application;

import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;

public class ClockMy {
	NewTile tile = NewTile.getInstance();
	boolean ifActive;
	int secondsPassed = 0;
	int time;
	
	Timer timer = new Timer();
	TimerTask task = new TimerTask(){
		public void run(){
			if(secondsPassed==time-1 || tile.ifActive==false){
				timer.cancel();
				tile.timeOver=true;
				
			}
			secondsPassed++;
			Platform.runLater(()-> {
				tile.clock.setText("Minęło: "+Integer.toString(secondsPassed)+"sek");
			});
			
			
		}
	};
	
	public void start(){
		timer.scheduleAtFixedRate(task,1000,1000);
	}
	
}
