/**
 * 
 */
package game;

import java.util.*;

/**
 * @author Andrew
 *
 */
public class GameManager {
        
        private Tile[][] field;

	public GameManager() {
            super();
            field = new Tile[6][6];
               
            for (int i = 0; i < 6; i++ ){
                for (int j = 0; j< 6; j++){
                    field[i][j] = new Tile(i, j, true);
                }
            }
	}

        public Tile[][] getField(){
            return field;
        }

	public void runGame() {
		// TODO Auto-generated method stub                  
               
               Queue<Player> playerList = new LinkedList();
               for (int i =0; i< 2; i++) playerList.add(new Player(field));
               
               Player currentPlayer = playerList.remove();
               
               while(!currentPlayer.lose()){
                   currentPlayer.turn();
                   playerList.add(currentPlayer);
                   currentPlayer= playerList.remove();
               }
	}

}
