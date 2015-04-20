/**
 *
 */
package game;

import static java.lang.Math.floor;
import java.util.*;

/**
 * @author Andrew Class which manages the actions of the game behind the scenes.
 */
public class GameManager implements Runnable {

    private Tile[][] field;
    private LinkedList<Player> playerList;
    private LinkedList<Unit> turnOrder;
    private Unit currUnit;
    private GameInitializer gi;

    /**
     * Constructor for the GameManager, it initializes all the variables it will need to 
     * keep track of so the GUI can do it's job.
     */
    public GameManager(GameInitializer gin) {
        super();
        field = new Tile[6][6];
        playerList = new LinkedList();
        turnOrder = new LinkedList();
        gi = gin;

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                field[j][i] = new Tile(j, i, true);
            }
        }
    }

    /**
     * Method to get the turn order.
     *
     * @return the turn order
     */
    public LinkedList<Unit> getTurnOrder() {
        return turnOrder;
    }

    /**
     * Method to get the unit which is currently taking its turn.
     * @return the active unit
     */
    public Unit getCurrUnit() {
        return currUnit;
    }
    
    /**
     * Method to get the field of tiles which acts as a battlefield.
     * @return the field of tiles.
     */
    public Tile[][] getField() {
        return field;
    }

    /**
     * Method to initialize a game. It currently creates the units and arranges them
     * in a default pattern, calls the method from another class.
     */
    public void initGame() {
        gi.initGame(playerList,turnOrder,field);
        currUnit = turnOrder.getFirst();
    }

    /**
     * Method to generate the units, calls the method from another class.
     * @param p the player who is currently getting units.
     * @param num the player's number.
     */
    private void unitSelection(Player p, int num) {
        gi.unitSelection(p, num);
    }

    /**
     * Method to generate the indicator for movement range.
     * It calls another, recursive method.
     * @param active are you activating or deactivating the indicator.
     */
    public void moveRange(boolean active) {
        int spd = currUnit.getSpeed();
        int[] pos = currUnit.getPos();
        markTile(new int[]{pos[0] - 1, pos[1]}, spd, active);
        markTile(new int[]{pos[0] + 1, pos[1]}, spd, active);
        markTile(new int[]{pos[0], pos[1] - 1}, spd, active);
        markTile(new int[]{pos[0], pos[1] + 1}, spd, active);
    }

    @Override
    public void run() {

    }

    /**
     * Method to change who is currently taking a turn.
     */
    public void turn() {
        currUnit.setMoved(false);
        currUnit.setAbilitied(false);
        turnOrder.removeFirst();
        turnOrder.addLast(currUnit);
        currUnit = turnOrder.getFirst();

    }

    /**
     * Method to actually move the unit from one tile to another.
     * @param tile target tile for movement.
     */
    public void move(Tile tile) {
        if (tile.isInRange()) {
            moveRange(false);
            field[currUnit.getPos()[0]][currUnit.getPos()[1]].setUnit(null);
            currUnit.setPos(tile.getX(), tile.getY());
            tile.setUnit(currUnit);
            currUnit.setMoved(true);
        }
    }

    /**
     * Recursive method for toggling the movement range indicator.
     * @param pos position of the tile.
     * @param spd the remaining movement range points.
     * @param active the toggle boolean.
     */
    private void markTile(int[] pos, int spd, boolean active) {
        if (pos[0] <= 5 && pos[0] >= 0 && pos[1] <= 5 && pos[1] >= 0 && spd > 0
                && !field[pos[0]][pos[1]].hasUnit()) {
            field[pos[0]][pos[1]].setInRange(active);
            markTile(new int[]{pos[0] - 1, pos[1]}, spd - 1, active);
            markTile(new int[]{pos[0] + 1, pos[1]}, spd - 1, active);
            markTile(new int[]{pos[0], pos[1] - 1}, spd - 1, active);
            markTile(new int[]{pos[0], pos[1] + 1}, spd - 1, active);
        }
    }

    /**
     * A method similar to the markTile method, but specific for abilities.
     * @param pos position of the tile.
     * @param spd the remaining movement range points.
     * @param active the toggle boolean.
     */
    private void markTileAbility(int[] pos, int spd, boolean active) {
        if (pos[0] <= 5 && pos[0] >= 0 && pos[1] <= 5 && pos[1] >= 0 && spd > 0) {
            field[pos[0]][pos[1]].setInRange(active);
            markTileAbility(new int[]{pos[0] - 1, pos[1]}, spd - 1, active);
            markTileAbility(new int[]{pos[0] + 1, pos[1]}, spd - 1, active);
            markTileAbility(new int[]{pos[0], pos[1] - 1}, spd - 1, active);
            markTileAbility(new int[]{pos[0], pos[1] + 1}, spd - 1, active);
        }
    }

    /**
     * Method to generate the indicator for an abilities range,
     * @param selectedAbility the abilities to check the range of.
     * @param active the toggle boolean
     */
    public void showAbilityRange(Ability selectedAbility, boolean active) {
        int range = selectedAbility.getMaxRange();
        int min = selectedAbility.getMinRange();
        int[] pos = currUnit.getPos();
        if (active && min >= 1) {
            {
                markTileAbility(new int[]{pos[0] - 1, pos[1]}, range, active);
                markTileAbility(new int[]{pos[0] + 1, pos[1]}, range, active);
                markTileAbility(new int[]{pos[0], pos[1] - 1}, range, active);
                markTileAbility(new int[]{pos[0], pos[1] + 1}, range, active);
            }
            {
                markTileAbility(new int[]{pos[0] - 1, pos[1]}, min, false);
                markTileAbility(new int[]{pos[0] + 1, pos[1]}, min, false);
                markTileAbility(new int[]{pos[0], pos[1] - 1}, min, false);
                markTileAbility(new int[]{pos[0], pos[1] + 1}, min, false);
            }
        } else if (active && min < 1) {
            markTileAbility(new int[]{pos[0] - 1, pos[1]}, range, active);
            markTileAbility(new int[]{pos[0] + 1, pos[1]}, range, active);
            markTileAbility(new int[]{pos[0], pos[1] - 1}, range, active);
            markTileAbility(new int[]{pos[0], pos[1] + 1}, range, active);
        } else {
            markTileAbility(new int[]{pos[0] - 1, pos[1]}, range, active);
            markTileAbility(new int[]{pos[0] + 1, pos[1]}, range, active);
            markTileAbility(new int[]{pos[0], pos[1] - 1}, range, active);
            markTileAbility(new int[]{pos[0], pos[1] + 1}, range, active);
        }
    }

    /**
     * Method to actually process an abilities effects.
     * @param selectedAbility the ability used.
     * @param tile the target tile of the ability.
     */
    public void useAbility(Ability selectedAbility, Tile tile) {
        LinkedList<Unit> units = new LinkedList<Unit>();
        showAbilityRange(selectedAbility, false);
        if (selectedAbility.getArea().getShape().equals("Square")) {
            if (tile.hasUnit()) {
                units.add(tile.getUnit());
            }
            for (int i = tile.getY() - selectedAbility.getArea().getRadius();
                    i <= tile.getY() + selectedAbility.getArea().getRadius(); i++) {
                for (int j = tile.getX() - selectedAbility.getArea().getRadius();
                        j <= tile.getX() + selectedAbility.getArea().getRadius(); j++) {
                    if (j >= 0 && j < 6 && i >= 0 && i < 6 && field[j][i].hasUnit() && (tile.getY() != i && tile.getX() != j)) {
                        units.add(field[j][i].getUnit());
                    }
                }
            }
        } else if (selectedAbility.getArea().getShape().equals("Cross")) {
            if (tile.hasUnit()) {
                units.add(tile.getUnit());
            }
            int x = tile.getX();
            int y = tile.getY();
            for (int j = tile.getX() - selectedAbility.getArea().getRadius();
                    j <= tile.getX() + selectedAbility.getArea().getRadius(); j++) {
                if (j >= 0 && j < 6 && y >= 0 && y < 6 && field[j][y].hasUnit() && j != x) {
                    units.add(field[j][y].getUnit());
                }
            }
            for (int i = tile.getY() - selectedAbility.getArea().getRadius();
                    i <= tile.getY() + selectedAbility.getArea().getRadius(); i++) {
                if (i >= 0 && i < 6 && x >= 0 && x < 6 && field[x][i].hasUnit() && i != y) {
                    units.add(field[x][i].getUnit());
                }
            }
        }
        while (!units.isEmpty()) {
            Unit u = units.removeFirst();
            if (selectedAbility.isMiss() && u != null) {
                Random rand = new Random();
                int hit = rand.nextInt(currUnit.getAttack() - 0 + 1) + 1;
                if (u.getDefense() <= hit) {
                    int damage = ((int) floor((currUnit.getAttack() * selectedAbility.getPowerMod())))
                            + (selectedAbility.getPowerBonus());
                    u.setCurrHp(u.getCurrHp() - damage);
                }

            }
            if (!selectedAbility.isMiss() && u != null) {
                int damage = ((int) floor((currUnit.getAttack() * selectedAbility.getPowerMod())))
                        + (selectedAbility.getPowerBonus());
                u.setCurrHp(u.getCurrHp() - damage);
            }
        }
        currUnit.setAbilitied(true);
        clearUnits();
    }

    /**
     * Method to clear any dead units in the field or player list.
     */
    void clearUnits() {

        for (Tile[] tile : field) {
            for (Tile t : tile) {
                if (t.hasUnit() && t.getUnit().getCurrHp() <= 0) {
                    turnOrder.remove(t.getUnit());
                    t.setUnit(null);
                }
            }
        }
        for (int i = 0; i < playerList.size(); i++) {
            Player p = playerList.get(i);
            boolean flag = true;
            for (int j = 0; j < p.getSize(); j++) {
                if (p.getUnit(j).getCurrHp() <= 0) {
                    p.killUnit(j);
                }
            }
        }
    }

    /**
     * Method to detect if a player has lost the game.
     * @return true if someone has lost.
     */
    public boolean isLoss() {
        for (int i = 0; i < 2; i++) {
            Player p = playerList.get(i);
            if (p.lose()) {
                playerList.remove(p);
                return true;
            }
        }
        return false;
    }

    /**
     * Method to get the winning player/
     * @return the winning player.
     */
    public String getWinner() {
        if (playerList.size() == 1) {
            return "Player " + playerList.getFirst().getPlayer();
        } else {
            return "None";
        }
    }
}
