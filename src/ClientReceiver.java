import java.io.*;

// Gets messages from other clients via the server (by the
// ServerSender thread).

public class ClientReceiver extends Thread {

  private BufferedReader server;
  private TicTacToeGUI game;

  ClientReceiver(BufferedReader server, TicTacToeGUI game) {
    this.server = server;
    this.game = game;
  }

  @SuppressWarnings("unused")
public void run() {
    // Print to the user whatever we get from the server:
    try {
    	System.out.println("Starting to run");
      while (true) {
        String s = server.readLine();
        if(s.substring(0, 1).equals("0") || s.substring(0, 1).equals("1") || s.substring(0, 1).equals("2") || s.substring(0, 1).equals("3") || s.substring(0, 1).equals("4") || s.substring(0, 1).equals("5") || s.substring(0, 1).equals("6") || s.substring(0, 1).equals("7") || s.substring(0, 1).equals("8") || s.substring(0, 1).equals("9")) {
        	System.out.println("Message: " + s);
        	game.setMove(Integer.parseInt(s.substring(0, 1)));
        }
        else if (s != null) {
        	System.out.println("Else message: "+s);
        } 
        else {
          server.close(); // Probably no point.
          throw new IOException("Got null from server"); // Caught below.
        }
      }
    }
    catch (IOException e) {
      System.out.println("Server seems to have died " + e.getMessage());
      System.exit(1); // Give up.
    }
  }
}
