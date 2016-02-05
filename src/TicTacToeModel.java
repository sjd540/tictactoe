import java.util.Observable;

public class TicTacToeModel extends Observable
{
	private TicTacToe oxo;
	
	public TicTacToeModel(TicTacToe oxo)
	{
		super();
		this.oxo = oxo;
	}
	
/**
Get symbol at given location
@param i the row
@param j the column
@return the symbol at that location
*/
	public int get(int i, int j)
	{
		return oxo.get(i, j);
	}


/**
Is it cross's turn?
@return true if it is cross's turn, false for nought's turn
*/	
	public boolean isCrossTurn()
	{
		return oxo.isCrossTurn();
	}

/**
Let the player whose turn it is play at a particular location
@param i the row
@param j the column
*/
	public void turn(int i, int j)
	{
		oxo.turn(i, j);
		setChanged();
		notifyObservers();
	}
	
	public int getMove() {
		return oxo.getMove();
	}
	

/**
Determine who (if anyone) has won
@return CROSS if cross has won, NOUGHT if nought has won, otherwise BLANK
*/
	public int whoWon()
	{
		return oxo.whoWon();
	}
	
	public boolean hasFinished() {
		return oxo.hasFinished();
	}
	
	public void setFinished() {
		oxo.setFinished();
	}
	
	public boolean turnTaken() {
		return oxo.turnTaken();
	}
	
	public void setTurnTaken(boolean bool) {
		oxo.setTurnTaken(bool);
	}
	
/**
Start a new game
*/
	public void newGame()
	{
		oxo.newGame();
		setChanged();
		notifyObservers();
	}
}