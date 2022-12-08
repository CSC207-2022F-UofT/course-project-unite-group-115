package database_classes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * Data structure to be stored in the data access class containing
 * all information on a message
 * @author  Yi Huang
 * @author Hansel Jia
 */
public class MessageRepoRequestModel {

    private String content;
    private final String sender;
    private final String groupID;

    private final String messageID;
    private final List<String> reaction;
    private final LocalDateTime creationTime;


    public MessageRepoRequestModel(String content, String sender, String groupID, String messageID, List<String> reaction, LocalDateTime creationTime) {
        this.content = content;
        this.sender = sender;
        this.groupID = groupID;
        this.messageID = messageID;
        this.reaction = reaction;
        this.creationTime = creationTime;
    }


    /**
     * Get the content of the message
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * Set the content of the message
     * @param content content to be set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Get the sender of the message
     * @return the sender
     */
    public String getSender(){
        return sender;
    }

    /**
     * Get the groupID associated with the message
     * @return the groupID
     */
    public String getGroupID(){
        return groupID;
    }

    /**
     * Get the messageID associated with the message
     * @return the message ID
     */
    public String getMessageID(){return messageID;}

    /**
     * Get the time the message was created
     * @return the creation time
     */
    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    /**
     * Get the reactions on the message
     * @return the reactions formatted as a list of strings
     */
    public String getReaction(){
        String reactionString = this.reaction.toString();
        reactionString = reactionString.replace(",", "");
        return reactionString;
    }

    /**
     * Add a reaction to the message
     * @param reaction the reaction to be added
     */
    public void addReaction(String reaction){
        this.reaction.add(reaction);
    }

    /**
     * Remove a reaction from a message
     * @param reaction the reaction to be removed
     */
    public void removeReaction(String reaction){
        for (int i = 0; i < this.reaction.size();i++) {
            if (Objects.equals(this.reaction.get(i), reaction)){
                this.reaction.remove(i);
                break;
            }
        }
    }

    /**
     * Check if a reaction exists for the message
     * @param reaction reaction to be checked
     * @return boolean whether exists or not
     */
    public boolean checkReactionExists(String reaction){
        for (String s : this.reaction) {
            if (Objects.equals(s, reaction)) {
                return true;
            }
        }
        return false;
    }

}
