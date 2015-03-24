/**
 * 
 */
package game;

/**
 * @author Andrew
 *
 */
public class Tile {
	private int x;
	private int y;
	private boolean traversable;
	private Unit unit;

	
	/**
	 * @param x
	 * @param y
	 * @param traversable
	 * @param unit
	 */
	public Tile(int x, int y, boolean traversable, Unit unit) {
		super();
		this.x = x;
		this.y = y;
		this.traversable = traversable;
		this.unit = unit;
	}


	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}


	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}


	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}


	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}


	/**
	 * @return the traversable
	 */
	public boolean isTraversable() {
		return traversable;
	}


	/**
	 * @param traversable the traversable to set
	 */
	public void setTraversable(boolean traversable) {
		this.traversable = traversable;
	}


	/**
	 * @return the unit
	 */
	public Unit getUnit() {
		return unit;
	}


	/**
	 * @param unit the unit to set
	 */
	public void setUnit(Unit unit) {
		this.unit = unit;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}