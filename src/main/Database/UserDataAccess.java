package Database;
import java.io.*;
import java.util.*;

public class UserDataAccess implements GroupRepoInt {
    private final File csvFile;

    private final Map<String, Integer> headers = new HashMap<>();

    private final Map<String, UserMessageModel> userMessages = new HashMap<>();

    public UserDataAccess(String csvFilePath) throws IOException {
        csvFile = new File(csvFilePath);

        headers.put("messageId", 0);
        headers.put("userId", 1);
        headers.put("message", 2);
        headers.put("reportUserId",3);


        if (csvFile.length() == 0) {
            save();
        } else {
            BufferedReader reader = new BufferedReader(new FileReader(csvFile));
            reader.readLine(); // skip header

            String row;
            while ((row = reader.readLine()) != null) {
                String[] col = row.split(",");
                UUID messageId = UUID.fromString(col[headers.get("messageId")]);
                String userId = String.valueOf(col[headers.get("userId")]);
                String message = String.valueOf(col[headers.get("message")]);
                String reportUserId = String.valueOf(col[headers.get("reportUserId")]);
                UserMessageModel userMessage = new UserMessageModel(messageId,userId,message,reportUserId);
                userMessages.put(String.valueOf(messageId),userMessage);
            }

            reader.close();
        }
    }



    public void save() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (UserMessageModel message : userMessages.values()) {
                String line = String.format("%s,%s,%s,%s", message.getMessageId(), message.getUserId(),
                        message.getMessage(),message.getReportUserId());
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    @Override
    public void adduserModel(UserMessageModel userMessageModel) {
        userMessages.put(String.valueOf(userMessageModel.getMessageId()), userMessageModel);
        this.save();

    }

    @Override
    public void removeUserModel(String userModelID) {
        userMessages.remove(userModelID);
        this.save();

    }

    @Override
    public Map<String, Object> getUserInfo(String userID) {
        UserMessageModel requestModel = userMessages.get(userID);
        Map<String, Object> result = new HashMap<>();
        result.put("messageId", requestModel.getMessageId());
        result.put("userId", requestModel.getUserId());
        result.put("message",requestModel.getMessage());
        result.put("reportUserId",requestModel.getReportUserId());
        return result;
    }

    @Override
    public HashMap<String,Object> getMessageList(String userId, String message) {
         UserMessageModel userMessageModel = userMessages.get(userId);

        return null;
    }

}