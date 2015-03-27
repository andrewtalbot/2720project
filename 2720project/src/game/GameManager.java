/**
 * 
 */
package game;

import java.util.*;

/**
 * @author Andrew
 *
 */
public class GameManager implements Runnable {
        
        private Tile[][] field;
        private Queue<Player> playerList;
        private Queue<Unit> turnOrder;
        private Unit currUnit;

	public GameManager() {
            super();
            field = new Tile[6][6];
            playerList = new LinkedList();
            turnOrder = new LinkedList();
               
            for (int i = 0; i < 6; i++ ){
                for (int j = 0; j< 6; j++){
                    field[i][j] = new Tile(i, j, true);
                }
            }
	}
        
        public Unit getCurrUnit()
        {
            return currUnit;
        }
        
        public Tile[][] getField(){
            return field;
        }
        
        public void initGame()
        {
            playerList.clear();
            Player p1 = new Player();
            Player p2 = new Player();
            playerList.add(p1);
            playerList.add(p2);
            unitSelection(p1);
            getField()[0][3].setUnit(p1.getUnit(0));
            p1.getUnit(0).setPos(0, 3);
            p1.getUnit(0).setImage("res/Warrior-purple.png");
            unitSelection(p2);
            getField()[5][3].setUnit(p2.getUnit(0));
            p2.getUnit(0).setPos(5, 3);
            p2.getUnit(0).setImage("res/Warrior-green.png");
            for (int i=0; i<1; i++)
            {
                turnOrder.add(p1.getUnit(i));
                turnOrder.add(p2.getUnit(i));
            }
            currUnit = turnOrder.remove();
        }
    
        private void unitSelection(Player p)
        {
            ArrayList<Ability> abilityList = new ArrayList<Ability>();
            Unit testWar = new Warrior();
            p.addUnit((Unit) testWar);
        }
        
        public void moveRange(boolean active)
        {
            int spd = currUnit.getSpeed();
            int[] pos = currUnit.getPos();
            markTile(new int[] {pos[0]-1,pos[1]},spd,active);
            markTile(new int[] {pos[0]+1,pos[1]},spd,active);
            markTile(new int[] {pos[0],pos[1]-1},spd,active);
            markTile(new int[] {pos[0],pos[1]+1},spd,active);
        }

    @Override
    public void run() {
        
    }

    public void turn() {
        currUnit.setMoved(false);
        currUnit.setAbilitied(false);
        turnOrder.add(currUnit);
        currUnit = turnOrder.remove();
        
    }
    
    public void move(Tile tile)
    {
        if(tile.isInRange())
        {
            moveRange(false);
            field[currUnit.getPos()[0]][currUnit.getPos()[1]].setUnit(null);
            currUnit.setPos(tile.getX(), tile.getY());
            tile.setUnit(currUnit);
            currUnit.setMoved(true);
        }
    }

    private void markTile(int[] pos, int spd, boolean active) {
        if (pos[0] <= 5 && pos[0] >= 0 && pos[1] <= 5 && pos[1] >= 0 && spd > 0 
                && !field[pos[0]][pos[1]].hasUnit())
        {
            field[pos[0]][pos[1]].setInRange(active);
            markTile(new int[] {pos[0]-1,pos[1]},spd-1,active);
            markTile(new int[] {pos[0]+1,pos[1]},spd-1,active);
            markTile(new int[] {pos[0],pos[1]-1},spd-1,active);
            markTile(new int[] {pos[0],pos[1]+1},spd-1,active);
        }
    }

}
