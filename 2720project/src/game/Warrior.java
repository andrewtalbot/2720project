/**
 * 
 */
package game;

import java.util.ArrayList;

/**
 * @author Andrew
 *
 */
public class Warrior implements Unit {
    private int maxHp;
    private int currHp;
    private int attack;
    private int defense;
    private int speed;
    private ArrayList<Ability> abilityList;
    private ArrayList<Effect> activeEffectList;
    private String image;

	public Warrior(int maxHp, int currHp, int attack, int defense, int speed,
			ArrayList<Ability> abilityList, ArrayList<Effect> activeEffectList, String image) {
            
	}

	/**
	 * @return the maxHp
	 */
    @Override
	public int getMaxHp() {
		return maxHp;
	}

	/**
	 * @param maxHp the maxHp to set
	 */
    @Override
	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	/**
	 * @return the currHp
	 */
    @Override
	public int getCurrHp() {
		return currHp;
	}

	/**
	 * @param currHp the currHp to set
	 */
    @Override
	public void setCurrHp(int currHp) {
		this.currHp = currHp;
	}

	/**
	 * @return the attack
	 */
    @Override
	public int getAttack() {
		return attack;
	}

	/**
	 * @param attack the attack to set
	 */
    @Override
	public void setAttack(int attack) {
		this.attack = attack;
	}

	/**
	 * @return the defense
	 */
    @Override
	public int getDefense() {
		return defense;
	}

	/**
	 * @param defense the defense to set
	 */
    @Override
	public void setDefense(int defense) {
		this.defense = defense;
	}

	/**
	 * @return the speed
	 */
    @Override
	public int getSpeed() {
		return speed;
	}

	/**
	 * @param speed the speed to set
	 */
    @Override
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	/**
	 * @return the abilityList
	 */
    @Override
	public ArrayList<Ability> getAbilityList() {
		return abilityList;
	}

	/**
	 * @param abilityList the abilityList to set
	 */
    @Override
	public void setAbilityList(ArrayList<Ability> abilityList) {
		this.abilityList = abilityList;
	}

	/**
	 * @return the activeEffectList
	 */
    @Override
	public ArrayList<Effect> getActiveEffectList() {
		return activeEffectList;
	}

	/**
	 * @param activeEffectList the activeEffectList to set
	 */
    @Override
	public void setActiveEffectList(ArrayList<Effect> activeEffectList) {
		this.activeEffectList = activeEffectList;
	}
        
    @Override
        public String getImage()
        {
            return image;
        }


}
