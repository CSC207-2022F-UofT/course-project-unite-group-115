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
        User creator = new User(requestModel.getGroupCreator());
        members.add(creator);
        for (String interest : groupInterests) {
            if (!(creator.getInterests().contains(interest))) {
                return groupCreateOutputBoundary.prepareFailView("You have not listed " +
                        interest + " as one of your interests.");
            }
        }

        Group group = groupFactory.createNewGroup(groupName, groupInterests, members);

        // ToDo: start message storage for group once have access to message class?

        // ToDo: update profile when have access to profile class

        List<String> membersString = new ArrayList<>();
        membersString.add(requestModel.getGroupCreator());
        GroupRepoRequestModel repoRequestModel = new GroupRepoRequestModel(groupName, group.getId(),
                groupInterests, membersString, true);
        groupRepoAccess.addGroup(repoRequestModel);

        LocalDateTime creationTime = LocalDateTime.now();
        RanGroupCreateResponseModel groupCreateResponseModel = new RanGroupCreateResponseModel(group.getName(),
                creationTime.toString());

        return groupCreateOutputBoundary.prepareSuccessView(groupCreateResponseModel);
    }
}
