import Database.ProfileManagerDataAccess;
import Database.ProfileRepoInt;
import Interface.UserReporterController;
import frameworks_and_drivers.LoggedinScreen;
import frameworks_and_drivers.Report_First_Screen;
import frameworks_and_drivers.User_Report_Screen;
import get_user_sensitiveWordList.application_business_rules.GetUserInteractor;
import get_user_sensitiveWordList.application_business_rules.GetUserSensitiveListOutputBoundary;
import get_user_sensitiveWordList.interface_adapters.GetUserSenListController;
import get_user_sensitiveWordList.interface_adapters.GetUserSenListPresenter;

import javax.swing.*;
import java.io.IOException;
import java.util.List;

public class main {
    public static void main(String[] args) {

        JFrame application2 = new LoggedinScreen("Aurora");
        application2.pack();
        application2.setVisible(true);

}}