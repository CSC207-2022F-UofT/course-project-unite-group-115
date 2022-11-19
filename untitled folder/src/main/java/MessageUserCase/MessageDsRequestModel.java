package MessageUserCase;

import java.time.LocalDateTime;
import User;

public class MessageDsRequestModel {

    private String content;
    private final User sender;
    private final User receiver;


    public MessageDsRequestModel(String content, User sender, User receiver) {
        this.content = content;
        this.sender = sender.getName();
        this.receiver = receiver.getName();
    }


    public String getContent() {
        return content;
    }
    public void setContent() {
        this.content = content;
    }

    public String getsender(){
        return sender.getName();
    }

    public String getreceiver(){
        return receiver.getName();
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }


}
