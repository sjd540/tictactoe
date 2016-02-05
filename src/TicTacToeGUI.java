import javax.swing.JFrame;

public class TicTacToeGUI 
{
	private TicTacToeComponent comp;
	
	public TicTacToeGUI() {
		TicTacToe game = new TicTacToe();
		
		this.comp = new TicTacToeComponent(game);
	}
	public void createGUI()
	{
		JFrame frame = new JFrame("Noughts and Crosses");
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		frame.add(comp);
		
		frame.setVisible(true);
	}
	
	public int getMove() {
		return comp.getMove();
	}
	
	public void setMove(int move) {
		comp.setMove(move);
	}
	
	public boolean hasFinished() {
		return comp.hasFinished();
	}
	
	public void setFinished() {
		comp.setFinished();
	}
}
