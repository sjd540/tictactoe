// Usage:
//        java Server <port number>


import java.net.*;
import java.io.*;

public class Server {

  public static void main(String [] args) {
	  
	// Check correct usage:
	if (args.length != 1) {
	   System.err.println("Usage: java Server <port number>");
	   System.exit(1); // Give up.
	}
	
	// Initialise information:
	int port = Integer.parseInt(args[0]);

    // This will be shared by the server threads:
    ClientTable clientTable = new ClientTable();

    // Open a server socket:
    ServerSocket serverSocket = null;

    // We must try because it may fail with a checked exception:
    try {
      serverSocket = new ServerSocket(port);
    } 
    catch (IOException e) {
      System.err.println("Couldn't listen on port " + port);
      System.exit(1); // Give up.
    }

    // Good. We succeeded. But we must try again for the same reason:
    try { 
      // We loop for ever, as servers usually do:

      while (true) {
        // Listen to the socket, accepting connections from new clients:
        Socket socket = serverSocket.accept();

        // This is so that we can use readLine():
        BufferedReader fromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        // We ask the client what its name is:
        String clientName = fromClient.readLine();

        // For debugging:
        System.out.println(clientName + " connected");

        // We add the client to the table:
        clientTable.add(clientName);

        // We create and start a new thread to read from the client:
        (new ServerReceiver(clientName, fromClient, clientTable)).start();

        // We create and start a new thread to write to the client:
        PrintStream toClient = new PrintStream(socket.getOutputStream());
        (new ServerSender(clientTable.getQueue(clientName), toClient)).start();
      }
    } 
    catch (IOException e) {
      // Lazy approach:
      System.err.println("IO error " + e.getMessage());
      // A more sophisticated approach could try to establish a new
      // connection. But this is beyond this simple exercise.
    }
  }
}
