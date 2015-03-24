/**
 * 
 */
package game;

import java.util.ArrayList;

/**
 * @author Andrew
 *
 */
public class Team {
	private ArrayList<Unit> roster;

	/**
	 * @param roster
	 */
	public Team(ArrayList<Unit> roster) {
		super();
		this.roster = roster;
	}

	/**
	 * @return the roster
	 */
	public ArrayList<Unit> getRoster() {
		return roster;
	}

	/**
	 * @param roster the roster to set
	 */
	public void setRoster(ArrayList<Unit> roster) {
		this.roster = roster;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
