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
            Player p1 = new Player(1);
            Player p2 = new Player(2);
            playerList.add(p1);
            playerList.add(p2);
            unitSelection(p1,1);
            getField()[0][3].setUnit(p1.getUnit(0));
            p1.getUnit(0).setPos(0, 3);
            p1.getUnit(0).setImage("res/Warrior-purple.png");
            unitSelection(p2,2);
            getField()[5][3].setUnit(p2.getUnit(0));
            p2.getUnit(0).setPos(5, 3);
            p2.getUnit(0).setImage("res/Warrior-green.png");
            for (int i=0; i<1; i++)
            {
                turnOrder.add(p1.getUnit(i));
                turnOrder.add(p2.getUnit(i));
            }
            currUnit = turnOrder.getFirst();
        }
    
        private void unitSelection(Player p, int num)
        {
            Unit testWar = new Warrior(num);
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
            markTileAbility(new int[] {pos[0]-1,pos[1]},spd-1,active);
            markTileAbility(new int[] {pos[0]+1,pos[1]},spd-1,active);
            markTileAbility(new int[] {pos[0],pos[1]-1},spd-1,active);
            markTileAbility(new int[] {pos[0],pos[1]+1},spd-1,active);
        }
    }

    public void showAbilityRange(Ability selectedAbility, boolean active) 
    {
        int range = selectedAbility.getMaxRange()+1;
        int min = selectedAbility.getMinRange();
        int[] pos = currUnit.getPos();
        //System.out.println("showAbilities");
        if (active && min > 1)
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
        else if(active && min <= 1)
        {
            markTileAbility(new int[] {pos[0]-1,pos[1]},range-1,active);
            markTileAbility(new int[] {pos[0]+1,pos[1]},range-1,active);
            markTileAbility(new int[] {pos[0],pos[1]-1},range-1,active);
            markTileAbility(new int[] {pos[0],pos[1]+1},range-1,active);
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
        LinkedList<Unit> units = new LinkedList<Unit>();
        showAbilityRange(selectedAbility,false);
        if (selectedAbility.getArea().getShape().equals("Square"))
        {
            if (tile.hasUnit())
            {
                units.add(tile.getUnit());
            }
            for(int i = tile.getY()-selectedAbility.getArea().getRadius();
                    i <= tile.getY()+selectedAbility.getArea().getRadius();i++)
            {
                for(int j = tile.getX()-selectedAbility.getArea().getRadius();
                        j <= tile.getX()+selectedAbility.getArea().getRadius();j++)
                {
                    if (j>=0 && j < 6 && i>=0 && i < 6 && field[j][i].hasUnit() && (tile.getY()!=i && tile.getX()!=j))
                    {
                        units.add(field[j][i].getUnit());
                    }
                }
            }
        }
        else if (selectedAbility.getArea().getShape().equals("Cross"))
        {
            if (tile.hasUnit())
            {
                units.add(tile.getUnit());
            }
            int x = tile.getX(); 
            int y = tile.getY();
            for(int j = tile.getX()-selectedAbility.getArea().getRadius();
                    j < tile.getX()+selectedAbility.getArea().getRadius();j++)
            {
                if (j>=0 && j < 6 && y>=0 && y < 6 && field[j][y].hasUnit() && j!=x)
                {
                    units.add(field[j][y].getUnit());
                }
            }
            for(int j = tile.getY()-selectedAbility.getArea().getRadius();
                    j < tile.getY()+selectedAbility.getArea().getRadius();j++)
            {
                if (j>=0 && j < 6 && x>=0 && x < 6 && field[x][j].hasUnit() && j!=y)
                {
                    units.add(field[x][j].getUnit());
                }
            }
        }
        while (!units.isEmpty())
        {
            Unit u = units.removeFirst();
            //System.out.println("P"+u.getPlayer()+" "+u.getName());
            if(selectedAbility.isMiss() && u != null)
            {
                Random rand = new Random();
                int hit = rand.nextInt(currUnit.getAttack() - 0 +1)+1;
                //System.out.println("Attacking: "+hit+" vs defense: "+u.getDefense());
                if (u.getDefense() <= hit)
                {
                    int damage = ((int)floor((currUnit.getAttack()*selectedAbility.getPowerMod())))
                            +(selectedAbility.getPowerBonus());
                    u.setCurrHp(u.getCurrHp()-damage);
                    //System.out.println("Attack: "+damage);
                }
                
            }
            else if (u != null)
            {
                int damage = ((int)floor((currUnit.getAttack()*selectedAbility.getPowerMod())))
                            +(selectedAbility.getPowerBonus());
                    u.setCurrHp(u.getCurrHp()-damage);
                    //System.out.println("Broken: "+damage);
            }
        }
        currUnit.setAbilitied(true);
        clearUnits();
    }
    
    void clearUnits()
    {
        
        for (Tile[] tile: field)
        {
            for (Tile t: tile)
            {
                if (t.hasUnit() && t.getUnit().getCurrHp()<=0)
                {
                    turnOrder.remove(t.getUnit());
                    t.setUnit(null);
                }
            }
        }
        for (int i=0;i<playerList.size();i++)
        {
            Player p = playerList.get(i);
            boolean flag = true;
            for (int j=0;j<p.getSize();j++)
            {
                //System.out.println(p.getUnit(j).getCurrHp());
                if (p.getUnit(j).getCurrHp()<=0)
                {
                    p.killUnit(j);
                }
            }
        }
    }

    public boolean isLoss() {
        for (int i=0;i<2;i++)
        {
            Player p = playerList.get(i);
            if (p.lose())
            {
                playerList.remove(p);
                return true;
            }
        }
        return false;
    }

    public String getWinner() {
        if (playerList.size()==1)
        {
            return "Player " + playerList.getFirst().getPlayer();
        }
        else
        {
            return "None";
        }
    }
}
