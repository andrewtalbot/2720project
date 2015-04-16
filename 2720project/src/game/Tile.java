/**
 *
 */
package game;

/**
 * @author Andrew Class which contains the attributes of a Tile object meant to
 * be used as the points on a grid which represents the field.
 */
public class Tile {

    private int x;
    private int y;
    private boolean traversable;
    private Unit unit;
    private final String image = "res/Tile.png";
    private final String rngImg = "res/Tile2.png";
    private boolean inRange;

    /**
     * Constructor to make the tile.
     * @param x
     * @param y
     * @param traversable false if it cannot be moved over/onto.
     */
    public Tile(int x, int y, boolean traversable) {
        super();
        this.x = x;
        this.y = y;
        this.traversable = traversable;
        inRange = false;
    }

    /**
     * Method to get the x coordinate.
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * Method to set the x coordinate.
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Method to determine if the tile is in range.
     * @return true if it is.
     */
    public boolean isInRange() {
        return inRange;
    }

    /**
     * Method to set if the tile is in range.
     * @param inRange 
     */
    public void setInRange(boolean inRange) {
        this.inRange = inRange;
    }

    /**
     * Method to get the y coordinate.
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * Method to set the y coordinate.
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Method to check if a tile is traversable.
     * @return the traversable
     */
    public boolean isTraversable() {
        return traversable;
    }

    /**
     * Method to set if a tile is traversable.
     * @param traversable the traversable to set
     */
    public void setTraversable(boolean traversable) {
        this.traversable = traversable;
    }

    /**
     * Method to get the unit located on the tile.
     * @return the unit
     */
    public Unit getUnit() {
        return unit;
    }

    /**
     * Method to set the unit located on the tile.
     * @param unit the unit to set
     */
    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    /**
     * Method to check if a unit exists on the tile.
     * @return true if it does.
     */
    public boolean hasUnit() {
        if (unit == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Method to get the image of the tile.
     * @return a string containing the file path.
     */
    public String getImage() {
        return image;
    }

    /**
     * Method to get the image of the tile if it is indicated to be in range.
     * @return a string containing the file path.
     */
    public String getRngImg() {
        return rngImg;
    }
}
