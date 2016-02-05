// Usage:
//        java Client <user nickname> <port number> <machine name>
//

import java.io.*;
import java.net.*;

class Client {

  public static void main(String[] args) {

    // Check correct usage:
    if (args.length != 3) {
      System.err.println("Usage: java Client <user nickname> <port number> <machine name>");
      System.exit(1); // Give up.
    }

    // Initialise information:
    String nickname = args[0];
    int port = Integer.parseInt(args[1]);
    String machineName = args[2];

    // Open sockets:
    PrintStream toServer = null;
    BufferedReader fromServer = null;
    Socket server = null;

    try {
      server = new Socket(machineName, port);
      toServer = new PrintStream(server.getOutputStream());
      fromServer = new BufferedReader(new InputStreamReader(server.getInputStream()));
    } 
    catch (UnknownHostException e) {
      System.err.println("Unknown host: " + machineName);
      System.exit(1); // Give up.
    } 
    catch (IOException e) {
      System.err.println("The server doesn't seem to be running " + e.getMessage());
      System.exit(1); // Give up.
    }
    
    TicTacToeGUI game = new TicTacToeGUI();

    // Create two client threads:
    ClientSender sender = new ClientSender(nickname,toServer, game);
    ClientReceiver receiver = new ClientReceiver(fromServer, game);

    // Run them in parallel:
    sender.start();
    receiver.start();
    
    // Wait for them to end and close sockets.
    try {
      sender.join();
      toServer.close();
      receiver.join();
      fromServer.close();
      server.close();
    }
    catch (IOException e) {
      System.err.println("Something wrong " + e.getMessage());
      System.exit(1); // Give up.
    }
    catch (InterruptedException e) {
      System.err.println("Unexpected interruption " + e.getMessage());
      System.exit(1); // Give up.
    }
  }
}
