package random_grouper_create.application_business_rules;

import databases.GroupRepoInt;
import databases.GroupRepoRequestModel;
import databases.ProfileRepoInt;
import entities.Group;
import entities.RandomGroupFactory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RanGroupCreateInteractor implements RanGroupCreateInputBoundary {
    final GroupRepoInt GROUP_REPO_ACCESS;
    final RanGroupCreateOutputBoundary GROUP_CREATE_OUTPUT_BOUNDARY;
    final RandomGroupFactory GROUP_FACTORY;
    final ProfileRepoInt PROFILE_REPO_ACCESS;

    public RanGroupCreateInteractor(GroupRepoInt groupRepoAccess,
                                    RanGroupCreateOutputBoundary groupCreateOutputBoundary,
                                    RandomGroupFactory groupFactory, ProfileRepoInt profileRepoAccess) {
        this.GROUP_REPO_ACCESS = groupRepoAccess;
        this.GROUP_CREATE_OUTPUT_BOUNDARY = groupCreateOutputBoundary;
        this.GROUP_FACTORY = groupFactory;
        this.PROFILE_REPO_ACCESS = profileRepoAccess;
    }

    /**
     * Create a new random group and save it to the GroupDatabase. The User that creates the group will be
     * automatically considered a member.
     * @param requestModel A data structure containing the new group's name and selected interests, as well as the
     *                     name of the group's creator
     * @return Returns a data structure containing the group's name and creation time, if the creation was successful.
     * Or returns a data structure containing a failure message, if the creation was unsuccessful.
     */
    @Override
    public RanGroupCreateResponseModel createRanGroup(RanGroupCreateRequestModel requestModel) {
        String groupName = requestModel.getGroupName();
        if(groupName.equals("")){
            return GROUP_CREATE_OUTPUT_BOUNDARY.prepareFailView("The group's name can't be empty. Please" +
                    " enter a group name and try again.");
        }
        List<String> groupInterests = requestModel.getInterests();

        List<String> members = new ArrayList<>();
        members.add(requestModel.getGroupCreator());

        Group group = GROUP_FACTORY.createNewGroup(groupName, groupInterests, members);

        PROFILE_REPO_ACCESS.addGroupToProfile(requestModel.getGroupCreator(), group.getId());

        GroupRepoRequestModel repoRequestModel = new GroupRepoRequestModel(groupName, group.getId(),
                groupInterests, members, true);
        GROUP_REPO_ACCESS.addGroup(repoRequestModel);

        LocalDateTime creationTime = LocalDateTime.now();
        RanGroupCreateResponseModel groupCreateResponseModel = new RanGroupCreateResponseModel(group.getName(),
                creationTime.toString());

        return GROUP_CREATE_OUTPUT_BOUNDARY.prepareSuccessView(groupCreateResponseModel);
    }
}
