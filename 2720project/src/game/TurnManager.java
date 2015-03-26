/**
 * 
 */
package game;

import java.util.Queue;

/**
 * @author Andrew
 *
 */
public class TurnManager {
	private Queue turnOrder;
	
	/**
	 * @param turnOrder
	 */
	public TurnManager(Queue turnOrder) {
		super();
		this.turnOrder = turnOrder;
	}

	/**
	 * @return the turnOrder
	 */
	public Queue getTurnOrder() {
		return turnOrder;
	}

	/**
	 * @param turnOrder the turnOrder to set
	 */
	public void setTurnOrder(Queue turnOrder) {
		this.turnOrder = turnOrder;
	}

	/**
	 * @param args
	 */
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub

	}*/

}
