package Reporter_Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.*;

import Reporter_Database.*;
import org.junit.Before;
import org.junit.Test;
public class blockUserTest {
    getSenslistDataAccess a;
    String blockList;
    String fakeList;
    String name;

    @Before
    public void setUp(){//Before the test start,the blocklist in the profile must be empty
        String name = "tejasraghuvanshi";
        a= new getSenslistDataAccess(name);
        blockList = "[Ellen;Helen]";
        fakeList = "[]";
    }


    @Test(timeout = 50)
    public void TestblockUserwithNoBlockedUser() {//when the blocklist in the profile is empty
        assertEquals("waha*****waha", a.blockUser("wahabetawaha" ,"Ellen"));
        assertEquals("waha*****waha", a.blockUser("wahabetawaha" ,"Helen"));

    }

    @Test(timeout = 50)
    public void TestblockUserNoSenWord() {
        assertEquals("wahawhahwaha", a.blockUser("wahawhahwaha" ,"Ellen"));

    }
    @Test(timeout = 50)
    public void TestProfile() throws Exception{
        String csv = "profiles.csv";
        BufferedReader br = null;
        String line = "";
        try {
            br = new BufferedReader(new FileReader(csv));
            String headerLine = br.readLine();
            while ((line = br.readLine()) != null){
                String[] values = line.split(",");
                if(values[0] ==name){
                    assertEquals(values[10],blockList);
                }


            }
        }
        catch (IOException io) {
            System.out.println(io);
        }


    }



    }














