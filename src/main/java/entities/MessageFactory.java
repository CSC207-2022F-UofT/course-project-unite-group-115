package entities;


public class MessageFactory{
    public static Message create(String content, String sender, String groupID) {
        return new Message(content,sender, groupID);
    }


}


