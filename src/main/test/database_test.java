package test;
import Database.UserMessageModel;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
import java.util.ArrayList;
import Database.UserDataAccess;
import Database.GroupRepoInt;

import org.junit.*;
import usecase.Blocker;

import static org.junit.Assert.*;


public class database_test {
    UserMessageModel b;

    @Before
    public void setUp() throws Exception {
        UUID user = UUID.randomUUID();
        UUID message = UUID.randomUUID();
        UUID report = UUID.randomUUID();

        UserMessageModel b = new UserMessageModel(message, user, "makabaka", report);
    }

    @Test(timeout = 50)
    public void testGetNumberOfContentsNonEmpty() throws IOException {
        UserDataAccess userDataAccess = new UserDataAccess("/Users/aurora/IdeaProjects/Repoet/csvfile.csv");
        //Blocker.report(b);
        userDataAccess.save();


    }
}