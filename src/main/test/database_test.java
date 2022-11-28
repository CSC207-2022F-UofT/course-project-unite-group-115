package test;
import Database.UserMessageModel;

import java.io.IOException;
import java.util.UUID;

import Database.UserDataAccess;

import org.junit.*;


public class database_test {
    UserMessageModel b;

    @Before
    public void setUp() throws Exception {
        String user = "u";
        UUID message = UUID.randomUUID();
        String report = "r";

        UserMessageModel b = new UserMessageModel(message, user, "makabaka", report);
    }

    @Test(timeout = 50)
    public void testGetNumberOfContentsNonEmpty() throws IOException {
        UserDataAccess userDataAccess = new UserDataAccess("/Users/aurora/IdeaProjects/Repoet/csvfile.csv");
        //Blocker.report(b);
        userDataAccess.save();


    }
}