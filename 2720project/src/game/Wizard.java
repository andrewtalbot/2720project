/**
 * 
 */
package game;

import java.util.ArrayList;

/**
 * @author Andrew
 *
 */
public class Wizard implements Unit {
    private final int maxHp = 15;
    private int currHp;
    private final int attack = 6;
    private final int defense = 3;
    private final int speed = 2;
    private ArrayList<Ability> abilityList;
    private ArrayList<Effect> activeEffectList;
    private String image;
    private boolean moved;
    private boolean abilitied;
    private int[] pos;
    
	public Wizard() {
            currHp = maxHp;
            abilityList = new ArrayList<>();
            abilityList.add(new Ability(3,2,0,0.5,new Area("Cross",1),0,
                    "Arcane Burst",new Effect("None",1.0,0),false));
            abilityList.add(new Ability(2,1,0,1.0,new Area("Square",0),0,
                    "Magic Missile",new Effect("None",1.0,0),false));
            activeEffectList = new ArrayList<>();
            moved = false;
            abilitied = false;
            pos = new int[2];
	}

		/**
	 * @return the maxHp
	 */
    @Override
	public int getMaxHp() {
		return maxHp;
	}

    public void setPos(int x, int y) {
        pos[0] = x;
        pos[1] = y;
    }

    public int[] getPos() {
        return pos;
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
	 * @return the defense
	 */
    @Override
	public int getDefense() {
		return defense;
	}

	/**
	 * @return the speed
	 */
    @Override
	public int getSpeed() {
		return speed;
	}

	/**
	 * @return the abilityList
	 */
    @Override
	public ArrayList<Ability> getAbilityList() {
		return abilityList;
	}

	/**
	 * @return the activeEffectList
	 */
    @Override
	public ArrayList<Effect> getActiveEffectList() {
		return activeEffectList;
	}

    public void setMoved(boolean moved) {
        this.moved = moved;
    }

    public void setAbilitied(boolean abilitied) {
        this.abilitied = abilitied;
    }

    public boolean isMoved() {
        return moved;
    }

    public boolean isAbilitied() {
        return abilitied;
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

    @Override
    public void move() 
    {
        
    }

    @Override
    public void useAbility() {
        
    }

    @Override
    public void setImage(String img) {
        this.image = img;
    }
}
