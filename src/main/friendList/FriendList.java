import java.util.ArrayList;
import java.util.StringJoiner;

public class FriendList {
    private String owner;
    private int totalFri = 0;
    private String user;
    private static ArrayList<String> friLst = new ArrayList<String>();
    private static ArrayList<String> bl = new ArrayList<String>();




    FriendList(String owner){
        this.owner = owner;
//        FriendList.totalFri = totalFri;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getTotalFri() {
        return totalFri;
    }

    public void setTotalFri(int totalFri) {
        this.totalFri = totalFri;
    }

    //    public static int getTotalFri() {
//        return friLst.size();
//    }
//
//    public static void setTotalFri(int totalFri) {
//        FriendList.totalFri = totalFri;
//    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public static ArrayList<String> getFriLst() {
        return friLst;
    }

    public static void setFriLst(ArrayList<String> friLst) {
        FriendList.friLst = friLst;
    }

    public static ArrayList<String> getBl() {
        return bl;
    }

    public static void setBl(ArrayList<String> bl) {
        FriendList.bl = bl;
    }

    /*
    ? add & delete 要不要改成普通method，放到main中再return?
    或者要不要return bool
     */

    public void addFr(String userName){
        int len = friLst.size();
        for (int i = 0; i < len; i++) {
//            if (bl.contains(i)){
//                return "Due to privacy and policies, you can not add " +
//                        userName + " as your friend.";
//            }
            if (friLst.get(i) != userName){
                friLst.add(userName);
                len += 1;
            }
        }

    }
    public static String addFri(String userName){
        /*
        The method of adding a friend
        - if you are already friends, print notice
        - else add friend successly
        td:
         1. solve how to determine if you can add a friend that blocked you.
         2. if wrong input the user name
         */
        int len = friLst.size();
        for (int i = 0; i < len; i++) {
//            if (bl.contains(i)){
//                return "Due to privacy and policies, you can not add " +
//                        userName + " as your friend.";
//            }
            if (friLst.get(i) == userName){
                return userName + " is already your friend";
            }
        }
        friLst.add(userName);
        len += 1;
        return "new friend " + userName + " is added! Now you have " + len + " friends.";
    }

    public static String delFri(String userName){
        /*
        The method of deleting a friend
         */
//        for (int i = 0; i < totalFri; i++) {
//            if (friLst.get(i) != userName){
//                System.out.println(userName + " is not in your friend list, " +
//                        "please double check your input and re-enter");
//            }
//        } 在main中写报错和re-input thru sout + input = sc.nextLine();
        friLst.remove(userName);
        return "You just unfriend with " + userName;
    }

    @Override
    public String toString() {
        String delimiter = "\n";

        StringJoiner joiner = new StringJoiner(delimiter);
        friLst.forEach(item -> joiner.add(String.valueOf(item)));
        return owner + " has " + totalFri + " friends: \n" + joiner.toString();
//        return owner + " has " + friLst.size() + " friends. They are: \n" + joiner.toString();
    }

//    @Override
//    public int compareTo(FriendList l) {
////		System.out.println("Comparing");
//        if (this.owner.equals(l.getOwner())) {
//            // if the title to be added has the same title as the original
//            for (String f : friLst) {
//                    if (f.compareTo(episode)==0) {
//                        // if there are the same title
//                        return 0;
//                        // return duplicate
//                    }
//                }
//            }
//        return 1;
//        // there is no duplicate
//
//    }


}
