package random_grouper_request_group.application_business_rules;

import database_classes.GroupRepoInt;

import java.util.List;
import java.util.Map;

public class ReqRanGroupInteractor implements ReqRanGroupInputBoundary {
    final GroupRepoInt groupRepoAccess;
    final ReqRanGroupOutputBoundary reqRanGroupOutputBoundary;
    // ToDo: set after discussing with group
    final int MAX_GROUP_SIZE = 8;

    public ReqRanGroupInteractor(GroupRepoInt groupRepoAccess, ReqRanGroupOutputBoundary reqRanGroupOutputBoundary) {
        this.groupRepoAccess = groupRepoAccess;
        this.reqRanGroupOutputBoundary = reqRanGroupOutputBoundary;
    }

    @Override
    public ReqRanGroupResponseModel requestRanGroup(ReqRanGroupRequestModel requestModel) {
        List<String> randomGroups = groupRepoAccess.getRandomGroups();
        List<String> usersInterests = requestModel.getUserInterests();
        int maxInterestsCommon = 0;
        String bestRanGroupID = null;
        String bestRanGroupName = null;
        for (String randomGroup : randomGroups) {
            Map<String, Object> groupInfo = groupRepoAccess.getGroupInfo(randomGroup);
            if (((List<String>) groupInfo.get("members")).size() >= MAX_GROUP_SIZE) {
                continue;
                // Skips iteration when condition is met (i.e. if the current randomGroup is full,
                // skip to the next randomGroup
            } else if (requestModel.getUserGroups().contains(randomGroup)){
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
            groupRepoAccess.addUserToGroup(requestModel.getUserName(), bestRanGroupID);
            // ToDo: add group to user's profile once have access to code
            requestModel.addToUserGroups(bestRanGroupID);
            ReqRanGroupResponseModel responseModel = new ReqRanGroupResponseModel(bestRanGroupID, bestRanGroupName);
            return  reqRanGroupOutputBoundary.prepareSuccessView(responseModel);
        }
    }
}
