import javax.swing.JPanel;
import javax.swing.JButton;
import java.util.Observer;
import java.util.Observable;
import java.awt.GridLayout;

public class BoardView extends JPanel implements Observer
{
	private TicTacToeModel model;
	private JButton[][] cell;
	
	public BoardView(TicTacToeModel model)
	{
		super();
		
		// initialise model
		this.model = model;
		
		//create array of buttons
		this.cell = new JButton[3][3];
		
		//set layout of panel
		setLayout(new GridLayout(3, 3));
		
		//for each square in grid:create a button; place on panel
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				cell[i][j] = new JButton(" ");
				final int x = i; final int y = j;
				cell[i][j].addActionListener(e->model.turn(x, y));
				add(cell[i][j]);
			}
		}
	}
	
	public int getMove() {
		return model.getMove();
	}
	
	public void setMove(int move) {
		if(move == 0) {
			// do nothing
		}
		else if(move == 1) {
			cell[0][0].doClick();
		}
		else if(move == 2) {
			cell[1][0].doClick();
		}
		else if(move == 3) {
			cell[2][0].doClick();
		}
		else if(move == 4) {
			cell[0][1].doClick();
		}
		else if(move == 5) {
			cell[1][1].doClick();
		}
		else if(move == 6) {
			cell[2][1].doClick();
		}
		else if(move == 7) {
			cell[0][2].doClick();
		}
		else if(move == 8) {
			cell[1][2].doClick();
		}
		else if(move == 9) {
			cell[2][2].doClick();
		}
	}
	
	public boolean hasFinished() {
		return model.hasFinished();
	}
	
	public void setFinished(){
		model.setFinished();
	}
	
	public boolean turnTaken() {
		return model.turnTaken();
	}
	
	public void setTurnTaken(boolean bool) {
		model.setTurnTaken(bool);
	}
	
	public int whoWon() {
		return model.whoWon();
	}
	
	public void update(Observable obs, Object obj)
	{
		// for each square do the following:
		// if it's a NOUGHT, put O on button
		// if it's a CROSS, put X on button
		// else put     on button
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				if(model.get(i, j) == TicTacToe.CROSS)
				{
					cell[i][j].setText("X");
					cell[i][j].setEnabled(false);
				}
				else if(model.get(i, j) == TicTacToe.NOUGHT)
				{
					cell[i][j].setText("O");
					cell[i][j].setEnabled(false);
				}
				else
				{
					cell[i][j].setText(" ");
					boolean notOver = (model.whoWon() ==
						TicTacToe.BLANK);
					cell[i][j].setEnabled(notOver);
				}
			}
		}
		repaint();
	}
}	
					
					
		
		
