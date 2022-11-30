package Database;

import get_user_sensitiveWordList.application_business_rules.GetUserInteractor;
import get_user_sensitiveWordList.application_business_rules.GetUserSensitiveListOutputBoundary;
import get_user_sensitiveWordList.interface_adapters.GetUserSenListController;
import get_user_sensitiveWordList.interface_adapters.GetUserSenListPresenter;

import java.io.IOException;
import java.util.List;

public class getSenslistDataAccess {
    String name;
    public getSenslistDataAccess(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public String blockUser(String text,String User){
        ProfileRepoInt profileData;
        try {
            profileData = new ProfileManagerDataAccess("profiles.csv");
        } catch (
                IOException e) {
            throw new RuntimeException("Could not create file.");
        }
        GetUserSensitiveListOutputBoundary getUsersensitiveListOutputBoundary = new GetUserSenListPresenter();
        GetUserInteractor getUserInteractor = new
                GetUserInteractor(getUsersensitiveListOutputBoundary, profileData);
        GetUserSenListController getUserSenListController =
                new GetUserSenListController(getUserInteractor);
        List<String> list = getUserSenListController.getUserSensWordList(name).getSensList();

        String newText = text;

        for (String word : list) {
            if (text.toLowerCase().contains(word.toLowerCase())) {
                //addBlockedUsers(User);
                newText = text.replace(word.toLowerCase(), "*".repeat(word.length()));
            }
        }
        return newText;



    }

}
