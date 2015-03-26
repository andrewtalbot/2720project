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
	 * @param maxHp the maxHp to set
	 */
	public void setMaxHp(int maxHp);

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
	 * @param attack the attack to set
	 */
	public void setAttack(int attack);

	/**
	 * @return the defense
	 */
	public int getDefense();

	/**
	 * @param defense the defense to set
	 */
	public void setDefense(int defense);

	/**
	 * @return the speed
	 */
	public int getSpeed();

	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(int speed);

	/**
	 * @return the abilityList
	 */
	public ArrayList<Ability> getAbilityList();

	/**
	 * @param abilityList the abilityList to set
	 */
	public void setAbilityList(ArrayList<Ability> abilityList);

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

    public void move();

    public void useAbility();
}
