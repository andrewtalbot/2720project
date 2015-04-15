/**
 * 
 */
package game;

import java.util.ArrayList;

/**
 * @author Andrew
 *
 */
public interface Unit {
    
	/**
	 * @return the maxHp
	 */
	public int getMaxHp();

	/**
	 * @return the currHp
	 */
	public int getCurrHp();

	/**
	 * @param currHp the currHp to set
	 */
	public void setCurrHp(int currHp);

	/**
	 * @return the attack
	 */
	public int getAttack();

	/**
	 * @return the defense
	 */
	public int getDefense();

	/**
	 * @return the speed
	 */
	public int getSpeed();

	/**
	 * @return the abilityList
	 */
	public ArrayList<Ability> getAbilityList();

	/**
	 * @return the activeEffectList
	 */
	public ArrayList<Effect> getActiveEffectList();

	/**
	 * @param activeEffectList the activeEffectList to set
	 */
	public void setActiveEffectList(ArrayList<Effect> activeEffectList);
        
        /**
         * @return the image of the unit.
         */
        public String getImage();
        
        /**
         * @param img the image to set.
         */
        public void setImage(String img);
        
        /**
         * @param x the x position.
         * @param y the y position.
         */
        public void setPos(int x, int y);

        /**
         * @return an array containing the x and y positions.
         */
    public int[] getPos();

    public void move();

    public void useAbility();
    
    public void setMoved(boolean moved);
    
    public boolean isMoved();
    
    public void setAbilitied(boolean abilitied);
    
    public boolean isAbilitied();
    
    public String getName();
    
    public int getPlayer();
}
