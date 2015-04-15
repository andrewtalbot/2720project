/**
 * 
 */
package game;

/**
 * @author Andrew
 *
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
			Area area, int powerBonus, String description, Effect effect, boolean miss ) {
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
	 * @return the maxRange
	 */
	public int getMaxRange() {
		return maxRange;
	}

	/**
	 * @param maxRange the maxRange to set
	 */
	public void setMaxRange(int maxRange) {
		this.maxRange = maxRange;
	}

	/**
	 * @return the minRange
	 */
	public int getMinRange() {
		return minRange;
	}

	/**
	 * @param minRange the minRange to set
	 */
	public void setMinRange(int minRange) {
		this.minRange = minRange;
	}

	/**
	 * @return the coolDown
	 */
	public int getCoolDown() {
		return coolDown;
	}

	/**
	 * @param coolDown the coolDown to set
	 */
	public void setCoolDown(int coolDown) {
		this.coolDown = coolDown;
	}

	/**
	 * @return the powerMod
	 */
	public double getPowerMod() {
		return powerMod;
	}

	/**
	 * @param powerMod the powerMod to set
	 */
	public void setPowerMod(double powerMod) {
		this.powerMod = powerMod;
	}

	/**
	 * @return the area
	 */
	public Area getArea() {
		return area;
	}

	/**
	 * @param area the area to set
	 */
	public void setArea(Area area) {
		this.area = area;
	}

	/**
	 * @return the powerBonus
	 */
	public int getPowerBonus() {
		return powerBonus;
	}

	/**
	 * @param powerBonus the powerBonus to set
	 */
	public void setPowerBonus(int powerBonus) {
		this.powerBonus = powerBonus;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the effect
	 */
	public Effect getEffect() {
		return effect;
	}

	/**
	 * @param effect the effect to set
	 */
	public void setEffect(Effect effect) {
		this.effect = effect;
	}

        
        public boolean isMiss() {
            return miss;
    }
}
