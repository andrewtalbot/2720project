/**
 * 
 */
package game;

/**
 * @author Andrew
 *
 */
public class Area {
	private String shape; //square or circle or line.
	private int radius; //width/height for square, width for line.

	/**
	 * @param shape
	 * @param diameter
	 */
	public Area(String shape, int radius) {
		super();
		this.shape = shape;
		this.radius = radius;
	}

	/**
	 * @return the shape
	 */
	public String getShape() {
		return shape;
	}

	/**
	 * @param shape the shape to set
	 */
	public void setShape(String shape) {
		this.shape = shape;
	}

	/**
	 * @return the radius
	 */
	public int getRadius() {
		return radius;
	}

	/**
	 * @param radius the radius to set
	 */
	public void setRadius(int radius) {
		this.radius = radius;
	}
}
