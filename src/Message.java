public class Message {

  private final String sender;
  private final String text;

  Message(String sender, String text) {
    this.sender = sender;
    this.text = text;
  }

  public String getSender() {
    return sender;
  }

  public String getText() {
    return text;
  }

  public String toString() {
    if(text.equals("play")) {
    	return (sender + " has reqested to play.");
    }
    else if(text.equals("accept")) {
    	return (sender + " has accepted your request to play. Please type opponent's name, <enter> and then 'run game'. You will play first.");
    }
    else if(text.equals("reject")) {
    	return (sender + " has rejected your request to play. Please select another player.");
    }
    else if(text.equals("0") || text.equals("1") || text.equals("2") || text.equals("3") || text.equals("4") || text.equals("5") || text.equals("6") || text.equals("7") || text.equals("8") || text.equals("9")) {
    	return text + " " + sender;
    }
    else {
    	return "From " + sender + ": " + text;
    }
  }
}
