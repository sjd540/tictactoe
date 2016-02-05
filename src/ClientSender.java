import java.io.*;


// Repeatedly reads recipient's nickname and text from the user in two
// separate lines, sending them to the server (read by ServerReceiver
// thread).

public class ClientSender extends Thread {

  private String nickname;
  private PrintStream server;
  private TicTacToeGUI game;

  ClientSender(String nickname, PrintStream server, TicTacToeGUI game) {
    this.nickname = nickname;
    this.server = server;
    this.game = game;
  }

  public void run() {
    // So that we can use the method readLine:
    BufferedReader user = new BufferedReader(new InputStreamReader(System.in));

    try {
      // Tell the server what my nickname is:
      server.println(nickname);
      System.out.println("Client successfully launched");

      // Then loop forever sending messages to recipients via the server:
      while (true) {
        String recipient = user.readLine();
        if(recipient.equals("quit")) {
        	System.out.println("Quitting");
        	System.exit(0);
        	break;
        }
        
        String text = user.readLine();
        
        if(text.equals("accept")) {
        	System.out.println("You have accepted to play against " + recipient + ". Please type opponent's name, <enter> and then 'run game'. " + recipient + " will play first.");
        	server.println(recipient);
        	server.println(text);
        }
        else if(text.equals("run game")) {
        	System.out.println("Creating GUI");
        	game.createGUI();
        	while(game.hasFinished() != true) {
        		//System.out.println("Starting to exchange data");
        		server.println(recipient);
        		server.println(Integer.toString(game.getMove()));
        		if (recipient.equals("quit") || text.equals("quit") || game.hasFinished()){
        			System.out.println("We want to quit");
        			game.setFinished();
        			break;
        		}
        	}
        }
        else {
    		System.out.println("ELse statement");
        	server.println(recipient);
        	server.println(text);
        }
      }
    }
    catch (IOException e) {
      System.err.println("Communication broke in ClientSender" 
                        + e.getMessage());
      System.exit(1);
    }
  }
}

