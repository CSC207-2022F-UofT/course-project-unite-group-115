package general_group.use_case;

import database_classes.GroupRepoDsRequestModel;
import general_group.entities.Group;
import general_group.entities.GroupFactory;
import general_group.entities.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GeneralGroupCreateInteractor implements GeneralGroupCreateInputBoundary{
    final GroupRepoInt genGroupRepoAccess;
    final GeneralGroupCreateOutputBoundary genGroupOutputBoundary;
    final GroupFactory genGroupFactory;

    final int maxNumberOfFriends = 7;

    public GeneralGroupCreateInteractor(GroupRepoInt genGroupRepoAccess,
                                        GeneralGroupCreateOutputBoundary genGroupOutputBoundary,
                                        GroupFactory genGroupFactory) {
        this.genGroupRepoAccess = genGroupRepoAccess;
        this.genGroupOutputBoundary = genGroupOutputBoundary;
        this.genGroupFactory = genGroupFactory;
    }

    @Override
    public GeneralGroupCreateDsResponseModel create(GeneralGroupCreateDsRequestModel requestModel) {
        String groupName = requestModel.getGroupName();
        List<User> friendsToAdd = requestModel.getFriendsToAdd();
        List<String> interests = new ArrayList<>();

        if (groupName.equals("")) {
            return genGroupOutputBoundary.prepareFailView("The group's name cannot be empty. Enter " +
                    "a group name and try again.");
        } else if (friendsToAdd.isEmpty()) {
            return genGroupOutputBoundary.prepareFailView("You can't create a group by yourself. Select " +
                    "at most 7 friends and try again");
        } else if (friendsToAdd.size() > maxNumberOfFriends) {
            return genGroupOutputBoundary.prepareFailView("You can't add more than 7 friends into a group. " +
                    "Select at most 7 friends and try again.");
        }

        User groupCreator = new User(requestModel.getGroupCreatorName());
        List<String> membersNames = new ArrayList<>();

        for(User user : friendsToAdd) {
            membersNames.add(user.getName());
        }
        membersNames.add(groupCreator.getName());

        Group newGroup = genGroupFactory.createNewGroup(groupName, interests, friendsToAdd);
        GroupRepoDsRequestModel repoDsRequestModel = new GroupRepoDsRequestModel(groupName, interests, newGroup.getId(),
                membersNames, false);
        genGroupRepoAccess.addGroup(repoDsRequestModel);

        LocalDateTime now = LocalDateTime.now();
        GeneralGroupCreateDsResponseModel responseModel = new GeneralGroupCreateDsResponseModel(now.toString(),
                repoDsRequestModel.getID(), groupName);
        return genGroupOutputBoundary.prepareSuccessView(responseModel);
    }
}
