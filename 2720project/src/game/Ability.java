/**
 *
 */
package game;

/**
 * @author Andrew Class which keeps track of the attributes of an ability.
 */
public class Ability {

    private int maxRange;
    private int minRange;
    private int coolDown;
    private double powerMod;
    private Area area;
    private int powerBonus;
    private String description;
    private Effect effect;
    private boolean miss;

    /**
     * Constructor which initializes an ability.
     *
     * @param maxRange
     * @param minRange
     * @param coolDown
     * @param powerMod
     * @param area
     * @param powerBonus
     * @param description
     * @param effect
     * @param miss
     */
    public Ability(int maxRange, int minRange, int coolDown, double powerMod,
            Area area, int powerBonus, String description, Effect effect, boolean miss) {
        super();
        this.maxRange = maxRange;
        this.minRange = minRange;
        this.coolDown = coolDown;
        this.powerMod = powerMod;
        this.area = area;
        this.powerBonus = powerBonus;
        this.description = description;
        this.effect = effect;
        this.miss = miss;
    }

    /**
     * Method to get the max range of an ability.
     * @return the maxRange
     */
    public int getMaxRange() {
        return maxRange;
    }

    /**
     * Method to set the max range of an ability.
     * @param maxRange the maxRange to set
     */
    public void setMaxRange(int maxRange) {
        this.maxRange = maxRange;
    }

    /**
     * Method to get the min range of an ability.
     * @return the minRange
     */
    public int getMinRange() {
        return minRange;
    }

    /**
     * Method to set the min range of an ability.
     * @param minRange the minRange to set
     */
    public void setMinRange(int minRange) {
        this.minRange = minRange;
    }

    /**
     * Method to get the cooldown of an ability.
     * @return the coolDown
     */
    public int getCoolDown() {
        return coolDown;
    }

    /**
     * Method to set the cooldown of an ability.
     * @param coolDown the coolDown to set
     */
    public void setCoolDown(int coolDown) {
        this.coolDown = coolDown;
    }

    /**
     * Method to get the attack multiplier of the ability.
     * @return the powerMod
     */
    public double getPowerMod() {
        return powerMod;
    }

    /**
     * Method to set the attack multiplier of the ability.
     * @param powerMod the powerMod to set
     */
    public void setPowerMod(double powerMod) {
        this.powerMod = powerMod;
    }

    /**
     * Method to get the area of the ability.
     * @return the area
     */
    public Area getArea() {
        return area;
    }

    /**
     * Method to set the area of the ability.
     * @param area the area to set
     */
    public void setArea(Area area) {
        this.area = area;
    }

    /**
     * Method to get the attack bonus of the ability.
     * @return the powerBonus
     */
    public int getPowerBonus() {
        return powerBonus;
    }

    /**
     * Method to set the attack bonus of the ability.
     * @param powerBonus the powerBonus to set
     */
    public void setPowerBonus(int powerBonus) {
        this.powerBonus = powerBonus;
    }

    /**
     * Method to get the description (name) of the ability.
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Method to set the description of the ability.
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Method to get the effect that the ability may add.
     * @return the effect
     */
    public Effect getEffect() {
        return effect;
    }

    /**
     * Method to set the effect that the ability may add.
     * @param effect the effect to set
     */
    public void setEffect(Effect effect) {
        this.effect = effect;
    }

    /**
     * Method to check if the effect can miss.
     * @return true if it can.
     */
    public boolean isMiss() {
        return miss;
    }
}
