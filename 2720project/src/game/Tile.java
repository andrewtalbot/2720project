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
        private final String image="res/Tile.png";
        private final String rngImg="res/Tile2.png";
        private boolean inRange;

	
	/**
	 * @param x
	 * @param y
	 * @param traversable
	 */
	public Tile(int x, int y, boolean traversable) {
		super();
		this.x = x;
		this.y = y;
		this.traversable = traversable;
                inRange = false;
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

    public boolean isInRange() {
        return inRange;
    }

    public void setInRange(boolean inRange) {
        this.inRange = inRange;
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
        
        public boolean hasUnit() {
            if (unit==null)
            {
                return false;
            }
            else
            {
                return true;
            }
        }

    public String getImage() {
        return image;
    }

    public String getRngImg() {
        return rngImg;
    }

        /**
	 * @param args
	 */
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub

	}*/

}
