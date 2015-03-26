/**
 * 
 */
package game;

/**
 * @author Andrew
 *
 */
public class GameManager {
	private Team team1;
	private Team team2;
	private TurnManager tm;

	/**
	 * @param team1
	 * @param team2
	 * @param tm
	 */
	public GameManager(Team team1, Team team2, TurnManager tm) {
		super();
		this.team1 = team1;
		this.team2 = team2;
		this.tm = tm;
	}

	/**
	 * @return the team1
	 */
	public Team getTeam1() {
		return team1;
	}

	/**
	 * @param team1 the team1 to set
	 */
	public void setTeam1(Team team1) {
		this.team1 = team1;
	}

	/**
	 * @return the team2
	 */
	public Team getTeam2() {
		return team2;
	}

	/**
	 * @param team2 the team2 to set
	 */
	public void setTeam2(Team team2) {
		this.team2 = team2;
	}

	/**
	 * @return the tm
	 */
	public TurnManager getTm() {
		return tm;
	}

	/**
	 * @param tm the tm to set
	 */
	public void setTm(TurnManager tm) {
		this.tm = tm;
	}

	/**
	 * @param args
	 */
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub

	}*/

}
