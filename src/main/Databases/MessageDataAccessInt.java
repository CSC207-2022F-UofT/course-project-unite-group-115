package Databases;
import entities.Message;

public interface MessageDataAccessInt {
    Message getMessage();

    void storeMessage();

    void updateMessage();

    void deleteMessage();
}
