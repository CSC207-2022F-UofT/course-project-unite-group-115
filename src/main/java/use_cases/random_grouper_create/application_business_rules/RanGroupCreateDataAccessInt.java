package use_cases.random_grouper_create.application_business_rules;

import database_classes.GroupRepoRequestModel;

public interface RanGroupCreateDataAccessInt {
    /**
     * Add the group information from requestModel into the GroupDatabase file.
     *
     * @param requestModel information about group to save
     */
    void addGroup(GroupRepoRequestModel requestModel);
}
