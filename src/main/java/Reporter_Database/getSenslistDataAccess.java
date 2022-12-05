package Reporter_Database;

import add_blocked_Users.Interface.BlockedController;
import add_blocked_Users.Interface.BlockedPresenter;
import add_blocked_Users.application_business_rules.AddBlockedUserOutputBoundary;
import add_blocked_Users.application_business_rules.blockedUserInteractor;
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

    public String blockUser(String text,String User) {
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
        List<String> lists = getUserSenListController.getUserSensWordList(name).getSensList();


        String newText = "";
        for (String word : lists) {
            String a = word.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
            if (text.toLowerCase().contains(a)){
                addBlockedUser(User);
                newText = text.replace(a, "*".repeat(5));
                return newText;
            }
        }
        return text;
    }

    public void addBlockedUser(String blockeduser){
        ProfileRepoInt profileData;
        try {
            profileData = new ProfileManagerDataAccess("profiles.csv");
        } catch (
                IOException e) {
            throw new RuntimeException("Could not create file.");
        }
        AddBlockedUserOutputBoundary addBlockedUserOutputBoundary = new BlockedPresenter();
        blockedUserInteractor blockedUserInteractor = new
                blockedUserInteractor(addBlockedUserOutputBoundary, profileData);
        BlockedController blockedController =
                new BlockedController(blockedUserInteractor);
        blockedController.AddBlockedUser(name,blockeduser);


    }

}
