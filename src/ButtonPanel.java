import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel
{

	public ButtonPanel(TicTacToeModel model)
	{
		super();
		
		JButton reset = new JButton("New Game");
		reset.addActionListener(e -> model.newGame());
		
		JButton exit = new JButton("Exit");
		exit.addActionListener(e -> System.exit(0));
		
		add(reset);
		add(exit);
	}
}
