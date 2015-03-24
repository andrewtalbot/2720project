/**
 * 
 */
package game;

/**
 * @author Andrew
 *
 */
public class Effect {
	private String modifierType;
	private double modifierRate;
	private int modifierValue;

	
	/**
	 * @param modifierType
	 * @param modifierRate
	 * @param modifierValue
	 */
	public Effect(String modifierType, double modifierRate, int modifierValue) {
		super();
		this.modifierType = modifierType;
		this.modifierRate = modifierRate;
		this.modifierValue = modifierValue;
	}

	/**
	 * @return the modifierType
	 */
	public String getModifierType() {
		return modifierType;
	}



	/**
	 * @param modifierType the modifierType to set
	 */
	public void setModifierType(String modifierType) {
		this.modifierType = modifierType;
	}



	/**
	 * @return the modifierRate
	 */
	public double getModifierRate() {
		return modifierRate;
	}



	/**
	 * @param modifierRate the modifierRate to set
	 */
	public void setModifierRate(double modifierRate) {
		this.modifierRate = modifierRate;
	}



	/**
	 * @return the modifierValue
	 */
	public int getModifierValue() {
		return modifierValue;
	}



	/**
	 * @param modifierValue the modifierValue to set
	 */
	public void setModifierValue(int modifierValue) {
		this.modifierValue = modifierValue;
	}



	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
