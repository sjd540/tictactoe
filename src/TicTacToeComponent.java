import javax.swing.JPanel;
import java.awt.BorderLayout;

public class TicTacToeComponent extends JPanel
{
	private BoardView board;
	
	public TicTacToeComponent(TicTacToe game)
	{
		super();
		TicTacToeModel model = new TicTacToeModel(game);
		
		this.board = new BoardView(model);
		//ButtonPanel controls = new ButtonPanel(model);
		
		model.addObserver(board);
		
		setLayout(new BorderLayout());
		
		add(board, BorderLayout.CENTER);
		//add(controls, BorderLayout.SOUTH);
	}
	
	public int getMove() {
		return board.getMove();
	}
	
	public void setMove(int move) {
		board.setMove(move);
	}
	
	public boolean hasFinished() {
		return board.hasFinished();
	}
	
	public void setFinished(){
		board.setFinished();
	}
	
	public boolean turnTaken() {
		return board.turnTaken();
	}
	
	public void setTurnTaken(boolean bool) {
		board.setTurnTaken(bool);
	}
	
	public int whoWon() {
		return board.whoWon();
	}
}
