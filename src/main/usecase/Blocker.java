package usecase;

import Database.UserMessageModel;

import java.io.IOException;
import java.util.UUID;
import java.util.ArrayList;
import Database.UserDataAccess;
import Database.GroupRepoInt;

public class Blocker {
    private final UUID ID;
    private ArrayList<String> blockedUsers;
    private ArrayList<String> sensitiveWords;



    public Blocker(ArrayList<String> blockedUsers, ArrayList<String> sensitiveWords){
        this.blockedUsers =blockedUsers;
        this.sensitiveWords = sensitiveWords;
        this.ID = UUID.randomUUID();

    }
    public ArrayList<String> getBlockedUsers() {
        return this.blockedUsers;
    }
    public ArrayList<String> getSensitiveWords() {
        return this.sensitiveWords;
    }
    public UUID getID() {
        return this.ID;
    }

    public void setBlockedUsers(ArrayList<String> blockedUsers){
        this.blockedUsers =blockedUsers;
    }
    public void setSensitiveWords(ArrayList<String> sensitiveWords){
        this.sensitiveWords =sensitiveWords;
    }
    /*
    add users to blocked list
     */
    public void addBlockedUsers(UUID id){
        if(!getBlockedUsers().contains(id)){
            this.blockedUsers.add(String.valueOf(id));
        }

    }

    /* check sensitive words list in chatting,add user to blacklist and replace sensitive word
     */
    public  String blockUser(UUID userid,String text){
        String newText = "";
        for(String word : getSensitiveWords()){
            if(text.toLowerCase().contains(word.toLowerCase())){
                addBlockedUsers(userid);
                newText = text.replace(word,"*"/*.repeat(word.length())*/);
                //delete friend (doesn't finish)
            }
        }
        return newText;
    }


    public void report(UserMessageModel userMessageModel) throws IOException {
        //add two userid and text to databases
        UserDataAccess userDataAccess = new UserDataAccess("");
        UserMessageModel userMessageModels = new UserMessageModel(userMessageModel.getMessageId(),userMessageModel.getUserId(),
                userMessageModel.getMessage(),userMessageModel.getReportUserId());
        addBlockedUsers(userMessageModel.getUserId());
        userDataAccess.adduserModel(userMessageModel);
        userMessageModels.toString();


    }


    public void reflection(String result,UserMessageModel userMessageModel){
        if(result == "Approved"){
            userMessageModel.getMessage().replace
                    (userMessageModel.getMessage(),"*".repeat(userMessageModel.getMessage().length()));


        } else if (result == "Reject") {

        }else{

        }
    }


}
