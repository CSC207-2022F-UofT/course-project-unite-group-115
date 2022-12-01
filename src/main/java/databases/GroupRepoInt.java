package databases;

import java.util.List;

public interface GroupRepoInt {
    boolean addGroup();

    boolean removeGroup();

    // Return type subject to change
    List<String> getGroupData();

    boolean addRanGroupID();

    boolean removeRanGroupID();

    List<Integer> getRanGroupIDs();



}
