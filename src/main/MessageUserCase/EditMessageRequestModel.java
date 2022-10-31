package MessageUserCase;


public class EditMessageRequestModel {

    private String content;       //what if pictures are send, how to store it?
    private User sender;        //Grouper?
    private User receiver;
    private LocalDateTime creationTime;
    // record and display time?
    // status of read/unread


    public EditMessageRequestModel(String content, LocalDateTime creationTime) {
        this.content = content;
        this.creationTime = creationTime  //?
    }

    String getContent(){
        return content
    }


}