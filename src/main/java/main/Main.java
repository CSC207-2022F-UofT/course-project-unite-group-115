package main;

import screens.GroupLoggedInScreen;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        String groupName = "Group ID";
        String loginUserName = "DefaultUser";

        JFrame application2 = new GroupLoggedInScreen(groupName, loginUserName); //TODO: LINK to other codes
        application2.pack();    //TODO:  rename the parameter
        application2.setVisible(true);

    }
}

