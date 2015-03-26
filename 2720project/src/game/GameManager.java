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
        

	public GameManager() {
		super();
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
               Tile[][] field;
               int rows = 6;
               int cols = 6;
               
               field = new Tile[rows][cols];
               
               for (int i = 0; i < rows; i++ ){
                   for (int j = 0; j< cols; j++){
                       field[i][j] = new Tile(i, j, true);
                   }
               }
               
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
