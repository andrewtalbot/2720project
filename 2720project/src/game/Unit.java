/**
 *
 */
package game;

import java.util.ArrayList;

/**
 * @author Andrew Interface meant to allow a unit to be of multiple types. They
 * will all have the same methods, but may have different behavior.
 */
public interface Unit {

    /**
     * Method to get the max hp of the unit.
     * @return the maxHp
     */
    public int getMaxHp();

    /**
     * Method to get the current hp of the unit.
     * @return the currHp
     */
    public int getCurrHp();

    /**
     * Method to set the current hp of the unit,
     * @param currHp the currHp to set
     */
    public void setCurrHp(int currHp);

    /**
     * Method to get the attack of the unit.
     * @return the attack
     */
    public int getAttack();

    /**
     * Method to get the defense of the unit.
     * @return the defense
     */
    public int getDefense();

    /**
     * Method to get the speed of the unit in tiles.
     * @return the speed
     */
    public int getSpeed();

    /**
     * Method to get the list of abilities a unit has available.
     * @return the abilityList
     */
    public ArrayList<Ability> getAbilityList();

    /**
     * Method to get the list of effects a unit currently has active.
     * @return the activeEffectList
     */
    public ArrayList<Effect> getActiveEffectList();

    /**
     * Method to set the list of effects a unit currently has active.
     * @param activeEffectList the activeEffectList to set
     */
    public void setActiveEffectList(ArrayList<Effect> activeEffectList);

    /**
     * Method to get the image of a unit.
     * @return the image of the unit.
     */
    public String getImage();

    /**
     * Method to set the image of a unit.
     * @param img the image to set.
     */
    public void setImage(String img);

    /**
     * Method to set the coordinates of a unit on the field.
     * @param x the x position.
     * @param y the y position.
     */
    public void setPos(int x, int y);

    /**
     * Method to get the coordinates of a unit on the field.
     * @return an array containing the x and y positions.
     */
    public int[] getPos();

    /**
     * Method to move a unit (Implemented elsewhere)
     */
    public void move();

    /**
     * Method to use one of the units abilities (Implemented elsewhere)
     */
    public void useAbility();

    /**
     * Method to dictate if a unit has moved this turn.
     * @param moved 
     */
    public void setMoved(boolean moved);

    /**
     * Method to determine if a unit has moved this turn.
     * @return true if it has
     */
    public boolean isMoved();

    /**
     * Method to dictate if a unit has acted this turn.
     * @param abilitied 
     */
    public void setAbilitied(boolean abilitied);

    /**
     * Method to determine if a unit has acted this turn.
     * @return true if it has
     */
    public boolean isAbilitied();

    /**
     * Method to get the name of a unit,
     * @return the name of a unit
     */
    public String getName();

    /**
     * Method to get the player who commands the unit,
     * @return the player
     */
    public int getPlayer();
}
