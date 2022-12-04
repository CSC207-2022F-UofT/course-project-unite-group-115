package use_case_message_send;

public class MessageResponseModel {
    String send;    //what's this used for?

    String creationTime;

    public MessageResponseModel(String send, String creationTime) {
        this.send = send;
        this.creationTime = creationTime;
    }


    public String getSend(){return send;}

    public void setSend(String send){this.send = send;}

    public String getCreationTime() {
        return creationTime;
    }
    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }


}