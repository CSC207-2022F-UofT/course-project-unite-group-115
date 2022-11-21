package entities;
import User;
import get_friends.entities.User;


public interface MessageFactory{
    Message create(String content, User sender, User receiver);
}


