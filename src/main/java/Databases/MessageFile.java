package Databases;

import java.io.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MessageFile implements MessageRepoInt {

    private File csvFile;

    private Map<String, Integer> headers = new LinkedHashMap<>();

    private Map<String, MessageDsRequestModel> messages = new HashMap<>();

    public MessageFile(String csvPath) throws IOException {
        csvFile = new File(csvPath);

        headers.put("content", 0);
        headers.put("sender", 1);
        headers.put("receiver", 2);
        headers.put("messageID", 3);
        headers.put("creation_time", 4);

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
                String receiver = String.valueOf(col[headers.get("receiver")]);
                String messageID = String.valueOf(col[headers.get("messageID")]);
                LocalDateTime ldt = LocalDateTime.parse(creationTimeText);
                MessageDsRequestModel message = new MessageDsRequestModel(content, sender, receiver, messageID, ldt);
                messages.put(content, message);
            }

            reader.close();
        }
    }

    /**
     * Add requestModel to storage.
     * @param requestModel the user information to save.
     */
    @Override
    public void save(MessageDsRequestModel requestModel) {
        messages.put(requestModel.getContent(), requestModel);
        this.save();
    }
    private void save() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (MessageDsRequestModel message : messages.values()) {
                String line = String.format("%s,%s,%s,%s,%s",
                        message.getContent(), message.getSender(), message.getReceiver(),message.getID(),message.getCreationTime());
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteMessage(String message_id){
        messages.remove(message_id);
        this.save();
    }

    @Override
    public Map<String, Object> getMessageInfo(String groupID){
        MessageDsRequestModel requestModel = messages.get(groupID);
        Map<String, Object> result = new HashMap<>();
        result.put("message content", requestModel.getContent());
        result.put("sender", requestModel.getSender());
        result.put("receiver",requestModel.getReceiver());
        result.put("messageID", requestModel.getID());
        result.put("creation time", requestModel.getCreationTime());
        return result;
    }

    @Override
    public void editMessage(String ID, String content){
        messages.get(ID).setContent(content);
        this.save();
    }

    //TODO: send message to multiple receiver.
    @Override
    public void addReceiver(String ID, String sender){

        this.save();
    }

}
