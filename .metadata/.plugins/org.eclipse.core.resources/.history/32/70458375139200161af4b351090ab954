package finishGame;

import Map.Map;

public class FinishGame {
	Map map = Map.getInstance();
	private int control=0;
	public boolean finishGame(){
		for(int i=0;i<12;i++){
			for (int j=0;j<12;j++){
				if(map.pixel[i][j].getMonster()!=null){
					control++;
				}
			}
		}
		if(control==0){
			return true;
		}else{
			return false;
		}
	}
}
