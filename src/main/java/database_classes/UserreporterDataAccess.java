package database_classes;

import java.io.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;


public class UserreporterDataAccess implements UserReporterInt {
    private final File csvFile;

    private final Map<String, Integer> headers = new HashMap<>();

    private final Map<String, UserReporterRepoRequestModel> userMessages = new HashMap<>();

    public UserreporterDataAccess(String csvFilePath) throws IOException {
        csvFile = new File(csvFilePath);

        headers.put("MessageId",0);
        headers.put("ReportedUserId",1);
        headers.put("Message", 2);
        headers.put("ReportUserId",3);
        headers.put("CreationTime",4);
        headers.put("Reflection by Admin",5);

        /*headers.put("UserId", 1);

        headers.put("Message", 2);

        headers.put("ReportUserId",3);

        headers.put("CreationTime",4);

        headers.put("Reflection by Admin",5);*/


        if (csvFile.length() == 0) {
            save();
        } else {
            BufferedReader reader = new BufferedReader(new FileReader(csvFile));
            reader.readLine(); // skip header

            String row;
            while ((row = reader.readLine()) != null) {
                String[] col = row.split(",");
                String messageId = String.valueOf(col[headers.get("MessageId")]);
                String userId = String.valueOf(col[headers.get("ReportedUserId")]);
                String message = String.valueOf(col[headers.get("Message")]);
                String reportUserId = String.valueOf(col[headers.get("ReportUserId")]);
                String TimeText = String.valueOf(col[headers.get("CreationTime")]);
                LocalDateTime ldt = LocalDateTime.parse(TimeText);

                UserReporterRepoRequestModel userMessage = new UserReporterRepoRequestModel(messageId,userId,message,reportUserId,ldt);
                userMessages.put(messageId,userMessage);
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

            for (UserReporterRepoRequestModel message : userMessages.values()) {
                String line = String.format("%s,%s,%s,%s,%s", message.getMessageId(), message.getUserId(),
                        message.getMessage(),message.getReportUserId(),message.getTime());
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
    public void adduserModel(UserReporterRepoRequestModel userMessageModel) {
        userMessages.put(userMessageModel.getMessageId(), userMessageModel);
        this.save();

    }






    }
