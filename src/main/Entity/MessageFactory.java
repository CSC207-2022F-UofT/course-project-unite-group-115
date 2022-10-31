package entities;
import User;


public interface MessageFactory{
    Message create(String content, User sender, User receiver);
}


