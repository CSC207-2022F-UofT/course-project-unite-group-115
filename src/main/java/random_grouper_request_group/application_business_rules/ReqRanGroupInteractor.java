package random_grouper_request_group.application_business_rules;

import databases_classes.GroupRepoInt;
import databases_classes.ProfileRepoInt;

import java.util.List;
import java.util.Map;

public class ReqRanGroupInteractor implements ReqRanGroupInputBoundary {
    final ReqRanGroupDataAccessInt GROUP_REPO_ACCESS;
    final ReqRanGroupOutputBoundary reqRanGroupOutputBoundary;
    final ProfileRepoInt PROFILE_REPO_ACCESS;
    final int MAX_GROUP_SIZE = 8;

    public ReqRanGroupInteractor(ReqRanGroupDataAccessInt groupRepoAccess, ReqRanGroupOutputBoundary reqRanGroupOutputBoundary,
                                 ProfileRepoInt profileRepoAccess) {
        this.GROUP_REPO_ACCESS = groupRepoAccess;
        this.reqRanGroupOutputBoundary = reqRanGroupOutputBoundary;
        this.PROFILE_REPO_ACCESS = profileRepoAccess;
    }

    /**
     * Try to add User to a random group. The User will be added to the random group that has the most interests in
     * common with them. If no existing random groups have any interests in common with the User, the User will not
     * be added to a group.
     * @param requestModel the information required to attempt to add the User to a random group
     * @return the result of trying to add the User to a random group
     */
    @Override
    public ReqRanGroupResponseModel requestRanGroup(ReqRanGroupRequestModel requestModel) {
        List<String> randomGroups = GROUP_REPO_ACCESS.getRandomGroups();
        List<String> usersInterests = PROFILE_REPO_ACCESS.getInterests(requestModel.getUserName());
        List<String> currentGroups = PROFILE_REPO_ACCESS.getGroups(requestModel.getUserName());
        int maxInterestsCommon = 0;
        String bestRanGroupID = null;
        String bestRanGroupName = null;
        for (String randomGroup : randomGroups) {
            Map<String, Object> groupInfo = GROUP_REPO_ACCESS.getGroupInfo(randomGroup);
            if (((List<String>) groupInfo.get("members")).size() >= MAX_GROUP_SIZE) {
                continue;
                // Skips iteration when condition is met (i.e. if the current randomGroup is full,
                // skip to the next randomGroup
            } else if (currentGroups.contains(randomGroup)){
                continue;
            }
            int interestsCommon = 0;
            List<String> groupInterests = (List<String>) groupInfo.get("interests");
            for (String userInterest : usersInterests) {
                if (groupInterests.contains(userInterest)) {
                    interestsCommon = interestsCommon + 1;
                }
            }
            if (interestsCommon > maxInterestsCommon) {
                bestRanGroupID = randomGroup;
                bestRanGroupName = (String) groupInfo.get("group name");
                maxInterestsCommon = interestsCommon;
            }
        }
        if (bestRanGroupID == null){
            return reqRanGroupOutputBoundary.prepareFailView("No appropriate groups were found.");
        }
        else {
            GROUP_REPO_ACCESS.addUserToGroup(requestModel.getUserName(), bestRanGroupID);
            PROFILE_REPO_ACCESS.addGroupToProfile(requestModel.getUserName(), bestRanGroupID);
            ReqRanGroupResponseModel responseModel = new ReqRanGroupResponseModel(bestRanGroupID, bestRanGroupName);
            return  reqRanGroupOutputBoundary.prepareSuccessView(responseModel);
        }
    }
}
