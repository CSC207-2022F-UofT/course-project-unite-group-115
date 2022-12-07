package Reporter_Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

import entities.getListAndAddUser;
import org.junit.Before;
import org.junit.Test;
public class blockUserTest {
    getListAndAddUser a;
    String blockList;
    String fakeList;
    String name = "tejasraghuvanshi";

    @Before
    public void setUp() {//Before the test start,the blocklist in the profile must be empty
        String name = "tejasraghuvanshi";
        a = new getListAndAddUser(name);
        blockList = "Ellen;Helen";
        fakeList = "[]";
    }


    @Test(timeout = 50)
    public void TestblockUserwithNoBlockedUser() {//when the blocklist in the profile is empty
        assertEquals("waha*****waha", a.blockUser("wahabetawaha", "Ellen"));
        assertEquals("waha*****waha", a.blockUser("wahabetawaha", "Helen"));
        String csv = "./src/main/java/databases/profiles.csv";
        BufferedReader br = null;
        String line ;
        String username = "";

        List<List<String>> lines = new ArrayList<>();
        try {
            br = new BufferedReader(new FileReader(csv));
            String headerLine = br.readLine();
            while ((line = br.readLine()) != null) {
                List<String> values = Arrays.asList(line.split(","));
                lines.add(values);
            }
            for(List<String> userInfo : lines){
                username = userInfo.get(0);
                if(username.equals(name)){
                    System.out.print(userInfo.get(9));
                    assertEquals(blockList,userInfo.get(9));
                }
            }
        } catch (IOException io) {
            System.out.println(io);
        }

    }
    @Test(timeout = 50)
    public void TestblockUserNoSenWord() {
        assertEquals("wahawhahwaha", a.blockUser("wahawhahwaha", "Ellen"));
    }
}














