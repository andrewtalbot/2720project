/**
 * 
 */
package game;

import java.util.ArrayList;

/**
 * @author Andrew
 *
 */
public class Unit {
	private int maxHp;
	private int currHp;
	private int attack;
	private int defense;
	private int speed;
	private ArrayList<Ability> abilityList;
	private ArrayList<Effect> activeEffectList;
	
	/**
	 * @param maxHp
	 * @param currHp
	 * @param attack
	 * @param defense
	 * @param speed
	 * @param abilityList
	 * @param activeEffectList
	 */
	public Unit(int maxHp, int currHp, int attack, int defense, int speed,
			ArrayList<Ability> abilityList, ArrayList<Effect> activeEffectList) {
		super();
		this.maxHp = maxHp;
		this.currHp = currHp;
		this.attack = attack;
		this.defense = defense;
		this.speed = speed;
		this.abilityList = abilityList;
		this.activeEffectList = activeEffectList;
	}

	/**
	 * @return the maxHp
	 */
	public int getMaxHp() {
		return maxHp;
	}

	/**
	 * @param maxHp the maxHp to set
	 */
	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	/**
	 * @return the currHp
	 */
	public int getCurrHp() {
		return currHp;
	}

	/**
	 * @param currHp the currHp to set
	 */
	public void setCurrHp(int currHp) {
		this.currHp = currHp;
	}

	/**
	 * @return the attack
	 */
	public int getAttack() {
		return attack;
	}

	/**
	 * @param attack the attack to set
	 */
	public void setAttack(int attack) {
		this.attack = attack;
	}

	/**
	 * @return the defense
	 */
	public int getDefense() {
		return defense;
	}

	/**
	 * @param defense the defense to set
	 */
	public void setDefense(int defense) {
		this.defense = defense;
	}

	/**
	 * @return the speed
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	/**
	 * @return the abilityList
	 */
	public ArrayList<Ability> getAbilityList() {
		return abilityList;
	}

	/**
	 * @param abilityList the abilityList to set
	 */
	public void setAbilityList(ArrayList<Ability> abilityList) {
		this.abilityList = abilityList;
	}

	/**
	 * @return the activeEffectList
	 */
	public ArrayList<Effect> getActiveEffectList() {
		return activeEffectList;
	}

	/**
	 * @param activeEffectList the activeEffectList to set
	 */
	public void setActiveEffectList(ArrayList<Effect> activeEffectList) {
		this.activeEffectList = activeEffectList;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
