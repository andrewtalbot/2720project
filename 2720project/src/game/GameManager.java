/**
 * 
 */
package game;

import static java.lang.Math.floor;
import java.util.*;

/**
 * @author Andrew
 *
 */
public class GameManager implements Runnable {
        
        private Tile[][] field;
        private LinkedList<Player> playerList;
        private LinkedList<Unit> turnOrder;
        private Unit currUnit;

    public LinkedList<Unit> getTurnOrder() {
        return turnOrder;
    }

	public GameManager() {
            super();
            field = new Tile[6][6];
            playerList = new LinkedList();
            turnOrder = new LinkedList();
               
            for (int i = 0; i < 6; i++ ){
                for (int j = 0; j< 6; j++){
                    field[j][i] = new Tile(j, i, true);
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
        turnOrder.removeFirst();
        turnOrder.addLast(currUnit);
        currUnit = turnOrder.getFirst();
        
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
    
    private void markTileAbility(int[] pos, int spd, boolean active) {
        if (pos[0] <= 5 && pos[0] >= 0 && pos[1] <= 5 && pos[1] >= 0 && spd > 0)
        {
            field[pos[0]][pos[1]].setInRange(active);
            markTile(new int[] {pos[0]-1,pos[1]},spd-1,active);
            markTile(new int[] {pos[0]+1,pos[1]},spd-1,active);
            markTile(new int[] {pos[0],pos[1]-1},spd-1,active);
            markTile(new int[] {pos[0],pos[1]+1},spd-1,active);
        }
    }

    public void showAbilityRange(Ability selectedAbility, boolean active) 
    {
        int range = selectedAbility.getMaxRange();
        int min = selectedAbility.getMinRange();
        int[] pos = currUnit.getPos();
        if (active)
        {
            markTileAbility(new int[] {pos[0]-1,pos[1]},range-1,active);
            markTileAbility(new int[] {pos[0]+1,pos[1]},range-1,active);
            markTileAbility(new int[] {pos[0],pos[1]-1},range-1,active);
            markTileAbility(new int[] {pos[0],pos[1]+1},range-1,active);
            markTileAbility(new int[] {pos[0]-1,pos[1]},min-1,false);
            markTileAbility(new int[] {pos[0]+1,pos[1]},min-1,false);
            markTileAbility(new int[] {pos[0],pos[1]-1},min-1,false);
            markTileAbility(new int[] {pos[0],pos[1]+1},min-1,false);
        }
        else
        {
            markTileAbility(new int[] {pos[0]-1,pos[1]},range-1,active);
            markTileAbility(new int[] {pos[0]+1,pos[1]},range-1,active);
            markTileAbility(new int[] {pos[0],pos[1]-1},range-1,active);
            markTileAbility(new int[] {pos[0],pos[1]+1},range-1,active);
        }
    }

    public void useAbility(Ability selectedAbility, Tile tile) {
        ArrayList<Unit> units = new ArrayList<Unit>();
        if (selectedAbility.getArea().getShape().equals("Square"))
        {
            units.add(tile.getUnit());
            for(int i = tile.getY()-selectedAbility.getArea().getRadius();
                    i < tile.getY()+selectedAbility.getArea().getRadius();i++)
            {
                for(int j = tile.getX()-selectedAbility.getArea().getRadius();
                        j < tile.getX()+selectedAbility.getArea().getRadius();j++)
                {
                    if (j>=0 && j < 6 && i>=0 && i < 6 && field[j][i].hasUnit())
                    {
                        units.add(field[j][i].getUnit());
                    }
                }
            }
        }
        else if (selectedAbility.getArea().getShape().equals("Cross"))
        {
            units.add(tile.getUnit());
            int x = tile.getX(); 
            int y = tile.getY();
            for(int j = tile.getX()-selectedAbility.getArea().getRadius();
                    j < tile.getX()+selectedAbility.getArea().getRadius();j++)
            {
                if (j>=0 && j < 6 && y>=0 && y < 6 && field[j][y].hasUnit())
                {
                    units.add(field[j][y].getUnit());
                }
            }
            for(int j = tile.getY()-selectedAbility.getArea().getRadius();
                    j < tile.getY()+selectedAbility.getArea().getRadius();j++)
            {
                if (j>=0 && j < 6 && x>=0 && x < 6 && field[x][j].hasUnit())
                {
                    units.add(field[x][j].getUnit());
                }
            }
        }
        for (Unit u: units)
        {
            if(selectedAbility.isMiss())
            {
                Random rand = new Random();
                int hit = rand.nextInt(currUnit.getAttack() - 0 +1)+1;
                
                if (u.getDefense() <= hit)
                {
                    int damage = ((int)floor((currUnit.getAttack()*selectedAbility.getPowerMod())))
                            +(selectedAbility.getPowerBonus());
                }
                
            }
            else
            {
                int damage = ((int)floor((currUnit.getAttack()*selectedAbility.getPowerMod())))
                            +(selectedAbility.getPowerBonus());
            }
        }
    }

}
