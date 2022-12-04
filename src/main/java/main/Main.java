package main;

import screens_message.GroupLoggedInScreen;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        String groupName = "Group ID";
        String loginMessageName = "DefaultMessage";

        JFrame application2 = new GroupLoggedInScreen(groupName, loginMessageName); //TODO: LINK to other codes
        application2.pack();    //TODO:  rename the parameter
        application2.setVisible(true);

    }
}

