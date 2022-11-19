package MessageUserCase;

import java.time.LocalDateTime;


public class EditMessageDsRequestModel {

    private String content;
    private final LocalDateTime creationTime;

    public EditMessageDsRequestModel(String content) {
        this.content = content;
        this.creationTime = creationTime;
    }

    public void getContent(String content) {this.content = content;}
    public void setContent(String content) {this.content = content;}

    public LocalDateTime getCreationTime() {
        return creationTime;
    }


}
