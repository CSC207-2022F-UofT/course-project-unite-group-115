package Entity;


public class MessageFactory{
    public Message create(String content, String sender, String receiver){
        return new Message(content, sender, receiver);
    }

}


