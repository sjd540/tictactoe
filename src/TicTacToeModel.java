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
	
/*	public void setMove(int move) {
		if(move == 1) {
			oxo.turn(0, 0);
		}
		else if(move == 2) {
			oxo.turn(1, 0);
		}
		else if(move == 3) {
			oxo.turn(2, 0);
		}
		else if(move == 4) {
			oxo.turn(0, 1);
		}
		else if(move == 5) {
			oxo.turn(1, 1);
		}
		else if(move == 6) {
			oxo.turn(2, 1);
		}
		else if(move == 7) {
			oxo.turn(0, 2);
		}
		else if(move == 8) {
			oxo.turn(1, 2);
		}
		else if(move == 9) {
			oxo.turn(2, 2);
		}
		setChanged();
		notifyObservers();
	}
*/	
		
/**
Determine who (if anyone) has won
@return CROSS if cross has won, NOUGHT if nought has won, oetherwise BLANK
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