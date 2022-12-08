package use_cases.general_group.use_case;

import database_classes.GroupRepoRequestModel;
import database_classes.ProfileRepoInt;
import entities.GeneralGroupFactory;
import entities.Group;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GeneralGroupCreateInteractor implements GeneralGroupCreateInputBoundary{
    final GeneralGroupRepoInt genGroupRepoAccess;
    final GeneralGroupCreateOutputBoundary genGroupOutputBoundary;
    final GeneralGroupFactory genGroupFactory;
    final ProfileRepoInt profileRepoAccess;
    final int maxNumberOfFriends = 8;

    public GeneralGroupCreateInteractor(GeneralGroupRepoInt genGroupRepoAccess,
                                        GeneralGroupCreateOutputBoundary genGroupOutputBoundary,
                                        GeneralGroupFactory genGroupFactory, ProfileRepoInt profileRepoAccess) {
        this.genGroupRepoAccess = genGroupRepoAccess;
        this.genGroupOutputBoundary = genGroupOutputBoundary;
        this.genGroupFactory = genGroupFactory;
        this.profileRepoAccess = profileRepoAccess;
    }

    /**
     * Create a new general group and save it to the GroupDatabase.
     * @param requestModel A data structure containing the new group's name, selected friends, and group creator name.
     * @return Returns a data structure containing the group's name, creation time, and group ID, if the
     *         creation was successful. Or returns a data structure containing a failure message,
     *         if the creation was unsuccessful.
     */
    @Override
    public GeneralGroupCreateDsResponseModel create(GeneralGroupCreateDsRequestModel requestModel) {
        String groupName = requestModel.getGroupName();
        List<String> membersToAdd = new ArrayList<>(requestModel.getFriendsToAdd());
        List<String> interests = new ArrayList<>();

        String groupCreatorName = requestModel.getGroupCreatorName();
        membersToAdd.add(groupCreatorName);

        Set<String> duplicateChecker = new HashSet<>(membersToAdd);
        if (groupName.equals("")) {
            return genGroupOutputBoundary.prepareFailView("The group's name cannot be empty. Enter " +
                    "a group name and try again.");
        } else if (membersToAdd.size() == 1) {
            return genGroupOutputBoundary.prepareFailView("You can't create a group by yourself. Select " +
                    "at most 7 friends and try again.");
        } else if (membersToAdd.contains(null)) {
            return genGroupOutputBoundary.prepareFailView("Make sure to click on a friend before adding them, " +
                    "please select at most 7 friends and try again.");
        } else if (membersToAdd.size() > duplicateChecker.size()) {
            return genGroupOutputBoundary.prepareFailView("You can't add the same person more than once to a" +
                    "group. " + "Select at most 7 different friends and try again.");
        } else if (membersToAdd.size() > maxNumberOfFriends) {
            return genGroupOutputBoundary.prepareFailView("You can't add more than 7 friends into a group. " +
                    "Select at most 7 friends and try again.");
        }

        List<String> membersNames = new ArrayList<>(membersToAdd);

        Group newGroup = genGroupFactory.createNewGroup(groupName, interests, membersToAdd);

        profileRepoAccess.addGroupToProfile(requestModel.getGroupCreatorName(), newGroup.getId());


        GroupRepoRequestModel repoRequestModel = new GroupRepoRequestModel(groupName, newGroup.getId(), interests,
                membersNames, false);
        genGroupRepoAccess.addGroup(repoRequestModel);


        LocalDateTime now = LocalDateTime.now();
        GeneralGroupCreateDsResponseModel responseModel = new GeneralGroupCreateDsResponseModel(now.toString(),
                repoRequestModel.getID(), groupName);
        return genGroupOutputBoundary.prepareSuccessView(responseModel);
    }
}
