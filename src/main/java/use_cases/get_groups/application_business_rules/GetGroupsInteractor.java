package use_cases.get_groups.application_business_rules;

import database_classes.GroupRepoInt;
import database_classes.ProfileRepoInt;
import use_cases.get_groups.interface_adapters.GetGroupsFailure;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetGroupsInteractor implements GetGroupsInputBoundary {
    final GetGroupsOutputBoundary GET_GROUPS_OUTPUT_BOUNDARY;
    final ProfileRepoInt PROFILE_REPO_ACCESS;
    final GroupRepoInt GROUP_REPO_ACCESS;

    public GetGroupsInteractor(GetGroupsOutputBoundary getUsersGroupsOutputBoundary,
                               ProfileRepoInt profileRepoAccess, GroupRepoInt groupDataAccess) {
        this.GET_GROUPS_OUTPUT_BOUNDARY = getUsersGroupsOutputBoundary;
        this.PROFILE_REPO_ACCESS = profileRepoAccess;
        this.GROUP_REPO_ACCESS = groupDataAccess;
    }

    /**
     * Get a user's current groups, including the groups' name and ID.
     *
     * @param requestModel A data structure containing user's name
     * @return Returns a data structure containing the user's interests.
     */
    @Override
    public GetGroupsResponseModel getUsersGroups(GetGroupsRequestModel requestModel) {
            if (PROFILE_REPO_ACCESS.existsByName(requestModel.getUsername())) {
                List<String> groupIDs = PROFILE_REPO_ACCESS.getGroups(requestModel.getUsername());
                if (groupIDs.isEmpty()){
                    throw new GetGroupsFailure("User is not apart of any groups");
                }
                Map<String, String> groups = new HashMap<>();
                for (String id : groupIDs){
                    String groupName = (String) GROUP_REPO_ACCESS.getGroupInfo(id).get("group name");
                    groups.put(groupName, id);
                }
                return new GetGroupsResponseModel(groups);
            } else {
                throw new GetGroupsFailure("User not found.");
            }
    }
}

