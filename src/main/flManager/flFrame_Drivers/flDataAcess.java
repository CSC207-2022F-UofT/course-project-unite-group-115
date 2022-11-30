package flManager.flFrame_Drivers;

import flManager.application_business_rules.flManRepoInt;
import flManager.application_business_rules.flManRepoRequestModel;

import java.io.*;
import java.util.*;

public class flDataAcess implements flManRepoInt {
    private final File csvFile;
    private final Map<String, Integer> headers = new LinkedHashMap<>();
    private final Map<String, flManRepoRequestModel> friLst = new HashMap<>();

    public flDataAcess(String csvPath) throws IOException {
        csvFile = new File(csvPath);

        headers.put("userName", 0);
        headers.put("profileName", 1);
        headers.put("dob", 2);
        headers.put("description", 3);
        headers.put("socialLinks", 4);
        headers.put("sensitiveWords", 5);
        headers.put("interests", 6);
        headers.put("groups", 7);
        headers.put("friends", 8);
        headers.put("blockedUsers", 9);
        headers.put("creationTime", 10);

//        headers.put("userName", 0);
//        headers.put("friends", 8);

        if (csvFile.length() == 0) {
            save();
        } else {

            BufferedReader reader = new BufferedReader(new FileReader(csvFile));
            reader.readLine(); // skip header

            String row;
            while ((row = reader.readLine()) != null) {
                String[] col = row.split(",");

                String userName = String.valueOf(col[headers.get("userName")]);
                String friends = String.valueOf(col[headers.get("friends")]);
                List<String> friendsList = Arrays.asList(friends.split(";"));
                if (friends.equals("")){
                    friendsList = new ArrayList<>();}

                flManRepoRequestModel fl = new flManRepoRequestModel(userName, friendsList);
                friLst.put(userName, fl);

            }

            reader.close();
        }
    }

    /**
     * Add requestModel to storage.
     * @param requestModel the user information to save.
     */
    @Override
    public void save(flManRepoRequestModel requestModel) {
        friLst.put(requestModel.getOwner(), requestModel);
        this.save();
    }

    private void save() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (flManRepoRequestModel flst : friLst.values()) {
//                String line = String.format("%s,%s", flst.getOwner(),
//                        String.join(";",flst.getFriends()));
                String line = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s",
                        flst.getOwner(),null,null,null,null,null,null,
                        null,flst.getFriends(),null,null);
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//    public flDataAcess(File csvFile) {
//        this.csvFile = csvFile;
//    }


    @Override
    public boolean existsByName(String identifier) {
        return friLst.containsKey(identifier);
    }


    @Override
    public void addFri(String owner, String userName) {
        List<String> lst = new ArrayList<>(friLst.get(owner).getFriends());
        lst.add(userName);
        friLst.get(owner).setFriends(lst);
        this.save();
    }

    @Override
    public void delFri(String owner, String userName) {
        List<String> lst = new ArrayList<>(friLst.get(owner).getFriends());
        lst.remove(userName);
        friLst.get(owner).setFriends(lst);
        this.save();
    }
}
