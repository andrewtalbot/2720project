/**
 * 
 */
package game;

/**
 * @author Andrew
 *
 */
public class Area {
	private String shape; //square or circle or line or cross.
	private int diameter; //width/height for square, width for line.

	/**
	 * @param shape
	 * @param diameter
	 */
	public Area(String shape, int diameter) {
		super();
		this.shape = shape;
		this.diameter = diameter;
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
	 * @return the diameter
	 */
	public int getDiameter() {
		return diameter;
	}

	/**
	 * @param diameter the diameter to set
	 */
	public void setDiameter(int diameter) {
		this.diameter = diameter;
	}

	/**
	 * @param args
	 */
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub

	}*/


}
