import java.io.*;
import java.util.Set;

// Gets messages from client and puts them in a queue, for another thread to forward to the appropriate client.

public class ServerReceiver extends Thread {
  private String myClientsName;
  private BufferedReader myClient;
  private ClientTable clientTable;

  public ServerReceiver(String n, BufferedReader c, ClientTable t) {
    myClientsName = n;
    myClient = c;
    clientTable = t;
  }

  public void run() {
    try {
    	System.out.println("Starting to recieve Data");
      while (true) {
        String recipient = myClient.readLine();
        
        if(recipient.equals("players")) {
        	Set playerSet = this.clientTable.keySet();
        	Object[] playerArray = playerSet.toArray();
        	String players = "Players: " + playerArray[0];
        	for(int i = 1; i < playerArray.length; i++) {
        		players = players + ", " + playerArray[i]; 
        	}
        	Message msg = new Message(myClientsName, players);
        	MessageQueue recipientsQueue = clientTable.getQueue(myClientsName);
        	recipientsQueue.offer(msg);
        }
        String text = myClient.readLine();
        
        if (recipient != null && text != null) {
          Message msg = new Message(myClientsName, text);
          MessageQueue recipientsQueue = clientTable.getQueue(recipient);
          if (recipientsQueue != null){
            recipientsQueue.offer(msg);
          }
          else
            System.err.println("Message for unexistent client " 
                              + recipient + ": " + text);
        }
        else {
          myClient.close();
          return;
        }
      }
    }
    catch (IOException e) {
      System.err.println("Something went wrong with the client " 
                       + myClientsName + " " + e.getMessage()); 
      // No point in trying to close sockets. Just give up.
      // We end this thread (we don't do System.exit(1)).
    }
  }
}
