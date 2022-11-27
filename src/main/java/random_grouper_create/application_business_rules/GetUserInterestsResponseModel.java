package random_grouper_create.application_business_rules;

import java.util.List;

public class GetUserInterestsResponseModel {
    private List<String> interests;

    public GetUserInterestsResponseModel(List<String> interests){
        this.interests = interests;
    }

    /**
     * Return the user's interests.
     */
    public List<String> getInterests() {
        return interests;
    }

    /**
     * Change the stored interests to <interests>.
     */
    public void setInterests(List<String> interests) {
        this.interests = interests;
    }
}
