package entities;

import add_blocked_users.Interface_adapters.AddBlockedUserController;
import add_blocked_users.Interface_adapters.AddBlockedUserPresenter;
import add_blocked_users.application_business_rules.AddBlockedUserInteractor;
import add_blocked_users.application_business_rules.AddBlockedUserOutputBoundary;
import database_classes.ProfileManagerDataAccess;
import database_classes.ProfileRepoInt;
import get_user_sensitiveWordList.application_business_rules.GetUserSensWordListInteractor;
import get_user_sensitiveWordList.application_business_rules.GetUserSensitiveListOutputBoundary;
import get_user_sensitiveWordList.interface_adapters.GetUserSenListController;
import get_user_sensitiveWordList.interface_adapters.GetUserSenListPresenter;

import java.io.IOException;
import java.util.List;

public class GetListAndAddUser {
    String name;


    public GetListAndAddUser(String name){
        this.name = name;

    }
    public String getName(){
        return name;
    }

    public String blockUser(String text,String User) {
        ProfileRepoInt profileData;
        try {
            profileData = new ProfileManagerDataAccess("./src/main/java/databases/profiles.csv");
        } catch (
                IOException e) {
            throw new RuntimeException("Could not create file.");
        }
        GetUserSensitiveListOutputBoundary getUsersensitiveListOutputBoundary = new GetUserSenListPresenter();
        GetUserSensWordListInteractor getUserInteractor = new
                GetUserSensWordListInteractor(getUsersensitiveListOutputBoundary, profileData);
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
            profileData = new ProfileManagerDataAccess("./src/main/java/databases/profiles.csv");
        } catch (
                IOException e) {
            throw new RuntimeException("Could not create file.");
        }
        AddBlockedUserOutputBoundary addBlockedUserOutputBoundary = new AddBlockedUserPresenter();
        AddBlockedUserInteractor blockedUserInteractor = new
                AddBlockedUserInteractor(addBlockedUserOutputBoundary, profileData);
        AddBlockedUserController blockedController =
                new AddBlockedUserController(blockedUserInteractor);
        blockedController.AddBlockedUser(name,blockeduser);
    }
}
