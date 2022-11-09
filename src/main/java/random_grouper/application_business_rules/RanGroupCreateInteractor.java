package random_grouper.application_business_rules;

import entities.Group;
import entities.RandomGroupFactory;
import entities.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RanGroupCreateInteractor implements RanGroupCreateInputBoundary {
    final GroupRepoInt groupRepoAccess;
    final RanGroupCreateOutputBoundary groupCreateOutputBoundary;
    final RandomGroupFactory groupFactory;
    // ToDo: for message storage - final MessageRepoInt messageRepoAccess;

    public RanGroupCreateInteractor(GroupRepoInt groupRepoAccess,
                                    RanGroupCreateOutputBoundary groupCreateOutputBoundary,
                                    RandomGroupFactory groupFactory) {
        this.groupRepoAccess = groupRepoAccess;
        this.groupCreateOutputBoundary = groupCreateOutputBoundary;
        this.groupFactory = groupFactory;
    }

    @Override
    public RanGroupCreateResponseModel createRanGroup(RanGroupCreateRequestModel requestModel) {
        String groupName = requestModel.getGroupName();
        List<String> groupInterests = requestModel.getInterests();

        // ToDo: change when can see User class and repo + add check to ensure interests match users interests?
        List<User> members = new ArrayList<>();
        members.add(new User(requestModel.getGroupCreator(), new ArrayList<>()));
        for (String interest : groupInterests) {
            if (!(User.getInterests().contains(interest))) {
                return RanGroupCreateOutputBoundary.prepareFailView("You have not listed " +
                        interest.toString() + " as one of your interests.");
            }
        }

        Group group = groupFactory.createNewGroup(groupName, groupInterests, members);

        // ToDo: start message storage for group once have access to message class?

        // ToDo: update profile when have access to profile class

        List<String> membersString = new ArrayList<>();
        membersString.add(requestModel.getGroupCreator());
        groupRepoAccess.addGroup(groupName, group.getId(), membersString, groupInterests, true);

        LocalDateTime creationTime = LocalDateTime.now();
        RanGroupCreateResponseModel groupCreateResponseModel = new RanGroupCreateResponseModel(group.getName(),
                creationTime.toString());

        return RanGroupCreateOutputBoundary.prepareSuccessView(groupCreateResponseModel);
    }
}
