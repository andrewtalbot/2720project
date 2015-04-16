/**
 *
 */
package game;

/**
 * @author Andrew Class which keeps track of the size and shape of an area.
 */
public class Area {

    private String shape; //square or circle or line.
    private int radius; //width/height for square, width for line.

    /**
     * Constructor to create the area.
     * @param shape
     * @param diameter
     */
    public Area(String shape, int radius) {
        super();
        this.shape = shape;
        this.radius = radius;
    }

    /**
     * Method to get the shape of the area.
     * @return the shape
     */
    public String getShape() {
        return shape;
    }

    /**
     * Method to set the shape of the area.
     * @param shape the shape to set
     */
    public void setShape(String shape) {
        this.shape = shape;
    }

    /**
     * Method to get the radius of the area.
     * @return the radius
     */
    public int getRadius() {
        return radius;
    }

    /**
     * Method to set the radius of the area.
     * @param radius the radius to set
     */
    public void setRadius(int radius) {
        this.radius = radius;
    }
}
