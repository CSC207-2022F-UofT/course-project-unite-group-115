package database_classes;

import use_cases.general_group.use_case.GeneralGroupRepoInt;
import use_cases.random_grouper_create.application_business_rules.RanGroupCreateDataAccessInt;
import use_cases.random_grouper_request_group.application_business_rules.ReqRanGroupDataAccessInt;

import java.util.List;

public interface GroupRepoInt extends RanGroupCreateDataAccessInt, ReqRanGroupDataAccessInt, GeneralGroupRepoInt {
    /**
     * Remove the group with ID, groupID, from the GroupDatabase file.
     *
     * @param groupID group's ID
     */
    void removeGroup(String groupID);

    /**
     * Update the GroupDatabase by removing User with name, <userName>, from the members of the group with the ID,
     * <groupID>.
     *
     * @param userName name of an existing User
     * @param groupID  group's ID
     */
    void removeUserFromGroup(String userName, String groupID);

    /**
     * Update the GroupDatabase by adding interests, <newInterests>, to the existing interests of the group with the
     * ID, <groupID>.
     *
     * @param newInterests list of interests to be added to the group
     * @param groupID   group's ID
     */
    void addInterestsToGroup(List<String> newInterests, String groupID);

    /**
     * Update the GroupDatabase by removing <interests> from the existing interests of the group with the ID,
     * <groupID>.
     *
     * @param interests list of interests to be removed from the group
     * @param groupID   group's ID
     */
    void removeInterestsFromGroup(List<String> interests, String groupID);

}
