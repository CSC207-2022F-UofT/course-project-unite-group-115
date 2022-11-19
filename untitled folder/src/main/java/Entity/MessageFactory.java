package Entity;
import User;


public class MessageFactory{
    public Message create(String content, User sender, User receiver){
        return new Message(content, sender, receiver);
    }

}


