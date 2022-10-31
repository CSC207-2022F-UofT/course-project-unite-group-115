package MessageUserCase;

import java.time.LocalDateTime;


public class EditMessageDsRequestModel {

    private String content;
    private final LocalDateTime creationTime;

    public UserRegisterDsRequestModel(String content, LocalDateTime creationTime) {
        this.content = content;
        this.creationTime = creationTime;
    }


    public void setContent(String contetn) {this.content = content;}

    public LocalDateTime getCreationTime() {
        return creationTime;
    }


}
