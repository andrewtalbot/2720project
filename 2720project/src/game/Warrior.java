/**
 *
 */
package game;

import java.util.ArrayList;

/**
 * @author Andrew Class which keeps track of the attributes and abilities of the
 * warrior unit.
 */
public class Warrior implements Unit {

    private final int maxHp = 20;
    private int currHp;
    private final int attack = 10;
    private final int defense = 4;
    private final int speed = 3;
    private ArrayList<Ability> abilityList;
    private ArrayList<Effect> activeEffectList;
    private String image;
    private boolean moved;
    private boolean abilitied;
    private int[] pos;
    private String name;
    private int player;

    /**
     * Method to construct the warrior unit.
     *
     * @param p the player which the warrior will belong to.
     */
    public Warrior(int p) {
        currHp = maxHp;
        abilityList = new ArrayList<>();
        abilityList.add(new Ability(1, 0, 0, 1.0, new Area("Square", 0), 0,
                "Basic Attack", new Effect("None", 1.0, 0), true));
        activeEffectList = new ArrayList<>();
        moved = false;
        abilitied = false;
        pos = new int[2];
        name = "Warrior";
        player = p;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPlayer() {
        return player;
    }

    @Override
    public int getMaxHp() {
        return maxHp;
    }

    @Override
    public void setPos(int x, int y) {
        pos[0] = x;
        pos[1] = y;
    }

    @Override
    public int[] getPos() {
        return pos;
    }

    @Override
    public int getCurrHp() {
        return currHp;
    }

    @Override
    public void setCurrHp(int currHp) {
        this.currHp = currHp;
    }

    @Override
    public int getAttack() {
        return attack;
    }

    @Override
    public int getDefense() {
        return defense;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public ArrayList<Ability> getAbilityList() {
        return abilityList;
    }

    @Override
    public ArrayList<Effect> getActiveEffectList() {
        return activeEffectList;
    }

    @Override
    public void setMoved(boolean moved) {
        this.moved = moved;
    }

    @Override
    public void setAbilitied(boolean abilitied) {
        this.abilitied = abilitied;
    }

    @Override
    public boolean isMoved() {
        return moved;
    }

    @Override
    public boolean isAbilitied() {
        return abilitied;
    }

    @Override
    public void setActiveEffectList(ArrayList<Effect> activeEffectList) {
        this.activeEffectList = activeEffectList;
    }

    @Override
    public String getImage() {
        return image;
    }

    @Override
    public void move() {

    }

    @Override
    public void useAbility() {

    }

    @Override
    public void setImage(String img) {
        this.image = img;
    }

}
