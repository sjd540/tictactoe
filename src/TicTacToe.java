public class TicTacToe
{
	public static final int BLANK = 0;
	public static final int CROSS = 1;
	public static final int NOUGHT = 2;
		
	private boolean crossTurn;
	private int[][] board;
	private int move;
	private boolean isFinished;

/**
Create a new game with empty board
*/
	public TicTacToe()
	{
		board = new int[3][3];
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				board[i][j] = BLANK;
			}
		}
		crossTurn = true;
		this.move = 0;
		this.isFinished = false;
	}


/**
Get symbol at given location
@param i the row
@param j the column
@return the symbol at that location
*/
	public int get(int i, int j)
	{
		return board[i][j];
	}


/**
Is it cross's turn?
@return true if it is cross's turn, false for nought's turn
*/	
	public boolean isCrossTurn()
	{
		return crossTurn;
	}

/**
Let the player whose turn it is play at a particular location
@param i the row
@param j the column
*/
	public void turn(int i, int j)
	{
		if(board[i][j] == BLANK)
		{
			if(crossTurn)
			{
				board[i][j] = CROSS;
			}
			else
			{
				board[i][j] = NOUGHT;
			}
			crossTurn = !crossTurn;
			if(i == 0) {
				if(j == 0) {
					this.move = 1;
				}
				else if(j == 1) {
					this.move = 4;
				}
				else if(j == 2) {
					this.move = 7;
				}
			}
			else if(i == 1) {
				if(j == 0) {
					this.move = 2;
				}
				else if(j == 1) {
					this.move = 5;
				}
				else if(j == 2) {
					this.move = 8;
				}
			}
			else if(i == 2) {
				if(j == 0) {
					this.move = 3;
				}
				else if(j == 1) {
					this.move = 6;
				}
				else if(j == 2) {
					this.move = 9;
				}
			}
		}
		else
		{
			throw new IllegalArgumentException("Board not empty at (" + i + ", " + j + ")");
		}
	}
	
	public int getMove() {
		return this.move;
	}
	
	private boolean winner(int player)
	{
		return
			(board[0][0] == player && board[0][1] == player && board[0][2] == player) ||
			(board[1][0] == player && board[1][1] == player && board[1][2] == player) ||
			(board[2][0] == player && board[2][1] == player && board[2][2] == player) ||
			(board[0][0] == player && board[1][0] == player && board[2][0] == player) ||
			(board[0][1] == player && board[1][1] == player && board[2][1] == player) ||
			(board[0][2] == player && board[1][2] == player && board[2][2] == player) ||
			(board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
			(board[0][2] == player && board[1][1] == player && board[2][0] == player);
	}
				
		
/**
Determine who (if anyone) has won
@return CROSS if cross has won, NOUGHT if nought has won, otherwise BLANK
*/
	public int whoWon()
	{
		if(winner(CROSS))
		{
			this.isFinished = true;
			return CROSS;
		}
		else if(winner(NOUGHT))
		{
			this.isFinished = true;
			return NOUGHT;
		}
		else
		{
			return BLANK;
		}
	}
	
	public boolean hasFinished(){
		if (isFinished) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void setFinished() {
		this.isFinished = true;
	}
	
	
	
/**
Start a new game
*/
	public void newGame()
	{
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				board[i][j] = BLANK;
			}
		}
		crossTurn = true;
		move = 0;
	}

}