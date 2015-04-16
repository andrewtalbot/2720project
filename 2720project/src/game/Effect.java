/**
 *
 */
package game;

/**
 * @author Andrew Class which keeps track of the modifiers of an effect.
 */
public class Effect {

    private String modifierType;
    private double modifierRate;
    private int modifierValue;

    /**
     * Constructor to initialize an effect.
     *
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
     * Method to get the modifier type.
     * (This would be one of the attributes of the unitm such as attack)
     * @return the modifierType
     */
    public String getModifierType() {
        return modifierType;
    }

    /**
     * Method to set the modifier type.
     * @param modifierType the modifierType to set
     */
    public void setModifierType(String modifierType) {
        this.modifierType = modifierType;
    }

    /**
     * Method to get the multiplier to the attribute.
     * @return the modifierRate
     */
    public double getModifierRate() {
        return modifierRate;
    }

    /**
     * Method to set the multiplier to the attribute.
     * @param modifierRate the modifierRate to set
     */
    public void setModifierRate(double modifierRate) {
        this.modifierRate = modifierRate;
    }

    /**
     * Method to get the bonus to the attribute.
     * @return the modifierValue
     */
    public int getModifierValue() {
        return modifierValue;
    }

    /**
     * Method to set the bonus to the attribute.
     * @param modifierValue the modifierValue to set
     */
    public void setModifierValue(int modifierValue) {
        this.modifierValue = modifierValue;
    }
}
