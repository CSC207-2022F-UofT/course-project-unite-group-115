package database_classes;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class MessageDataAccess implements MessageRepoInt {

    private final File csvFile;

    private final Map<String, Integer> headers = new LinkedHashMap<>();

    private final Map<String, MessageRepoRequestModel> messages = new HashMap<>();


    public MessageDataAccess(String csvPath) throws IOException {
        csvFile = new File(csvPath);

        headers.put("content", 0);
        headers.put("sender", 1);
        headers.put("groupID", 2);
        headers.put("messageID", 3);
        headers.put("reaction", 4);
        headers.put("creation_time", 5);

        if (csvFile.length() == 0) {
            save();
        } else {

            BufferedReader reader = new BufferedReader(new FileReader(csvFile));
            reader.readLine(); // skip header

            String row;
            while ((row = reader.readLine()) != null) {
                String[] col = row.split(",");
                String content = String.valueOf(col[headers.get("content")]);
                String sender = String.valueOf(col[headers.get("sender")]);
                String groupID = String.valueOf(col[headers.get("groupID")]);
                String messageID = String.valueOf(col[headers.get("messageID")]);

                String reaction = String.valueOf(col[headers.get("reaction")]);

                reaction = reaction.substring(1, reaction.length() - 1);
                List<String> reactions = new ArrayList<>(Arrays.asList(reaction.split(" ")));

                String creationTimeText = String.valueOf(col[headers.get("creation_time")]);
                LocalDateTime ldt = LocalDateTime.parse(creationTimeText);
                MessageRepoRequestModel message = new MessageRepoRequestModel(content, sender, groupID,
                        messageID, reactions, ldt);
                messages.put(messageID, message);
            }

            reader.close();
        }
    }

    /**
     * Add requestModel to storage.
     *
     * @param requestModel the Message information to save.
     */
    @Override
    public void save(MessageRepoRequestModel requestModel) {
        messages.put(requestModel.getMessageID(), requestModel);
        this.save();
    }

    private void save() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (MessageRepoRequestModel message : messages.values()) {
                String line = String.format("%s,%s,%s,%s,%s,%s",
                        message.getContent(), message.getSender(), message.getGroupID(), message.getMessageID(), message.getReaction(), message.getCreationTime());
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteMessage(String message_id) {
        messages.remove(message_id);
        this.save();
    }

    @Override
    public Map<String, Object> getMessageInfo(String MessageID) {
        MessageRepoRequestModel requestModel = messages.get(MessageID);
        Map<String, Object> result = new HashMap<>();
        result.put("message content", requestModel.getContent());
        result.put("sender", requestModel.getSender());
        result.put("groupID", requestModel.getGroupID());
        result.put("messageID", requestModel.getMessageID());
        result.put("creation time", requestModel.getCreationTime());
        return result;
    }

    @Override
    public void editMessage(String ID, String content) {
        messages.get(ID).setContent(content);
        this.save();
    }


    @Override
    public String getGroupMessageInfo(String GroupID) {
        List<String> allMessages = new ArrayList<>();
        for (String key : messages.keySet()) {
            if (Objects.equals(messages.get(key).getGroupID(), GroupID)) {
                MessageRepoRequestModel model = messages.get(key);
                String messageFormat = model.getSender() + ": " + model.getContent() +
                        " Reactions: " + model.getReaction() + " (Message ID:" + model.getMessageID() + ")" + "\n";
                allMessages.add(messageFormat);
            }
        }
        return allMessages.toString();
    }

    @Override
    public boolean doesGroupExist(String GroupID) {
        for (String key : messages.keySet()) {
            MessageRepoRequestModel model = messages.get(key);
            String id = model.getGroupID();
            if (id.equals(GroupID)) {
                return true;
            }
        }

        return false;
    }

    public boolean messageNotExist(String messageID){
        return !messages.containsKey(messageID);
    }

    public void addReaction(String reaction, String messageID){
        messages.get(messageID).addReaction(reaction);
        this.save();
    }

    public void removeReaction(String reaction, String messageID){
        messages.get(messageID).removeReaction(reaction);
        this.save();
    }

    public boolean reactionExists(String reaction, String messageID){
        return messages.get(messageID).checkReactionExists(reaction);
    }
}



