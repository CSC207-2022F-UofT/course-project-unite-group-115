package general_group.use_case;

import database_classes.GroupRepoDsRequestModel;
import database_classes.ProfileRepoInt;
import general_group.entities.Group;
import general_group.entities.GroupFactory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GeneralGroupCreateInteractor implements GeneralGroupCreateInputBoundary{
    final GroupRepoInt genGroupRepoAccess;
    final GeneralGroupCreateOutputBoundary genGroupOutputBoundary;
    final GroupFactory genGroupFactory;
    final ProfileRepoInt profileRepoAccess;
    final int maxNumberOfFriends = 7;

    public GeneralGroupCreateInteractor(GroupRepoInt genGroupRepoAccess,
                                        GeneralGroupCreateOutputBoundary genGroupOutputBoundary,
                                        GroupFactory genGroupFactory, ProfileRepoInt profileRepoAccess) {
        this.genGroupRepoAccess = genGroupRepoAccess;
        this.genGroupOutputBoundary = genGroupOutputBoundary;
        this.genGroupFactory = genGroupFactory;
        this.profileRepoAccess = profileRepoAccess;
    }

    @Override
    public GeneralGroupCreateDsResponseModel create(GeneralGroupCreateDsRequestModel requestModel) {
        String groupName = requestModel.getGroupName();
        List<String> friendsToAdd = new ArrayList<>(requestModel.getFriendsToAdd());
        List<String> interests = new ArrayList<>();

        Set<String> duplicateChecker = new HashSet<>(friendsToAdd);
        if (groupName.equals("")) {
            return genGroupOutputBoundary.prepareFailView("The group's name cannot be empty. Enter " +
                    "a group name and try again.");
        } else if (friendsToAdd.isEmpty()) {
            return genGroupOutputBoundary.prepareFailView("You can't create a group by yourself. Select " +
                    "at most 7 friends and try again");
        } else if (friendsToAdd.size() >= maxNumberOfFriends) {
            return genGroupOutputBoundary.prepareFailView("You can't add more than 7 friends into a group. " +
                    "Select at most 7 friends and try again.");
        } else if (friendsToAdd.contains(null)) {
            friendsToAdd.clear();
            return genGroupOutputBoundary.prepareFailView("You can't add null into a group. Select at most 7 "
            + "friends and try again.");
        } else if (friendsToAdd.size() > duplicateChecker.size()) {
            friendsToAdd.clear();
            return genGroupOutputBoundary.prepareFailView("You can't add the same person more than once to a" +
                    "group. " + "Select at most 7 different friends and try again.");
        }

        String groupCreatorName = requestModel.getGroupCreatorName();
        List<String> membersNames = new ArrayList<>(friendsToAdd);
        membersNames.add(groupCreatorName);

        Group newGroup = genGroupFactory.createNewGroup(groupName, interests, friendsToAdd);

        profileRepoAccess.addGroupToProfile(requestModel.getGroupCreatorName(), newGroup.getId());


        GroupRepoDsRequestModel repoDsRequestModel = new GroupRepoDsRequestModel(groupName, interests, newGroup.getId(),
                membersNames, false);
        genGroupRepoAccess.addGroup(repoDsRequestModel);


        LocalDateTime now = LocalDateTime.now();
        GeneralGroupCreateDsResponseModel responseModel = new GeneralGroupCreateDsResponseModel(now.toString(),
                repoDsRequestModel.getID(), groupName);
        return genGroupOutputBoundary.prepareSuccessView(responseModel);
    }
}
